<?php
// Fehlerbehandlung bei Datenbankoperationen
ini_set('display_errors', 1);
error_reporting(E_ALL);

// Datenbankverbindung
$db = new SQLite3('forum.db');
chmod('forum.db', 0666);

// Sicherstellen, dass die users-Tabelle existiert
if ($db->exec("CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE,
    password TEXT,
    role TEXT
)")) {
    $utable_success = "Die users-Tabelle wurde erfolgreich erstellt oder ist bereits vorhanden.";
} else {
    $utable_error = "Fehler beim Erstellen der users-Tabelle: " . $db->lastErrorMsg();
}

// Sicherstellen, dass die posts-Tabelle existiert
if ($db->exec("CREATE TABLE IF NOT EXISTS posts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    content TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(id)
)")) {
    $ptable_success = "Die posts-Tabelle wurde erfolgreich erstellt oder ist bereits vorhanden.";
} else {
    $ptable_error = "Fehler beim Erstellen der posts-Tabelle: " . $db->lastErrorMsg();
}

// Sicherstellen, dass die settings-Tabelle existiert
if ($db->exec("CREATE TABLE IF NOT EXISTS settings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT UNIQUE,
    value TEXT
)")) {
    $stable_success = "Die settings-Tabelle wurde erfolgreich erstellt oder ist bereits vorhanden.";
} else {
    $stable_error = "Fehler beim Erstellen der settings-Tabelle: " . $db->lastErrorMsg();
}

// Registrierungsstatus in settings-Tabelle initialisieren (falls noch nicht gesetzt)
$register_status = $db->query("SELECT value FROM settings WHERE name = 'register_status'")->fetchArray(SQLITE3_ASSOC);
if (!$register_status) {
    $db->exec("INSERT INTO settings (name, value) VALUES ('register_status', '1')");
    $reg_success = "Die Registrierung wurde standardmäßig aktiviert.<br>";
}

// Überprüfen, ob die Spalte 'created_at' in der posts-Tabelle existiert
$columns = $db->query("PRAGMA table_info(posts)");
$column_exists = false;
while ($column = $columns->fetchArray(SQLITE3_ASSOC)) {
    if ($column['name'] === 'created_at') {
        $column_exists = true;
        break;
    }
}

// Falls die Spalte 'created_at' nicht existiert, wird sie hinzugefügt
if (!$column_exists) {
    $db->exec("ALTER TABLE posts ADD COLUMN created_at DATETIME DEFAULT CURRENT_TIMESTAMP");
    $crea_success = "Die Spalte 'created_at' wurde zur posts-Tabelle hinzugefügt.<br>";
}

// Funktion zum sicheren Hashen des Passworts
function hashPassword($password) {
    return password_hash($password, PASSWORD_BCRYPT);
}

// Benutzer einfügen, wenn sie nicht existieren
$users = [
    ['username' => 'admin', 'password' => 'admin', 'role' => 'admin'],
];

foreach ($users as $user) {
    $stmt = $db->prepare("SELECT id FROM users WHERE username = :username");
    $stmt->bindValue(':username', $user['username'], SQLITE3_TEXT);
    $result = $stmt->execute();
    
    if ($result->fetchArray() === false) {
        // Benutzer existiert noch nicht, also wird er eingefügt
        $stmt = $db->prepare("INSERT INTO users (username, password, role) VALUES (:username, :password, :role)");
        $stmt->bindValue(':username', $user['username'], SQLITE3_TEXT);
        $stmt->bindValue(':password', hashPassword($user['password']), SQLITE3_TEXT);
        $stmt->bindValue(':role', $user['role'], SQLITE3_TEXT);
        $stmt->execute();
        $addadmin_success = "Benutzer " . $user['username'] . " wurde erfolgreich hinzugefügt.";
    }
}

// Schließe die Datenbankverbindung
$db->close();

$success_success = "Datenbank und Tabellen wurden erfolgreich erstellt und initialisiert.";
?>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://hoffmeister.li/font.css" type="text/css">
    <title>Beiträge</title>
    <style>
        html, body {
            position: relative;
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 20px 20px 20px 20px;
            border: none;
            font-family: Oswald, Arial, sans-serif;
            background: url(bck2.jpg) repeat-y;
            background-size: cover;
            color: white;
	    scrollbar-width: auto;
	    scrollbar-color: #888 #444;
        }
        body::-webkit-scrollbar {
            width: 7px;
        }
        body::-webkit-scrollbar-track {
            background: #444;
        }
        body::-webkit-scrollbar-thumb {
            background-color: #888;
            border-radius: 6px;
        }
        body::-webkit-scrollbar-thumb:hover {
            background-color: #aaa;
        }
        .post {
            border-bottom: 1px solid grey;
            padding: 10px 20px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>DATENBANK</h1>
<?php if (isset($db_init_error)) echo '<p style="color:red; font-weight:bold;">'.db_init_error.'</p>'; ?>
<?php if (isset($db_init_success)) echo '<p style="color:green; font-weight:bold;">'.$db_init_success.'</p>'; ?>
<h3>Tabellen</h3>
<?php if (isset($utable_success)) echo '<p style="color:green; font-weight:bold;">'.$utable_success.'</p>'; ?>
<?php if (isset($utable_error)) echo '<p style="color:red; font-weight:bold;">'.$utable_error.'</p>'; ?>
<?php if (isset($ptable_success)) echo '<p style="color:green; font-weight:bold;">'.$ptable_success.'</p>'; ?>
<?php if (isset($ptable_error)) echo '<p style="color:red; font-weight:bold;">'.$ptable_error.'</p>'; ?>
<?php if (isset($crea_success)) echo '<p style="color:green; font-weight:bold;">'.$crea_success.'</p>'; ?>
<?php if (isset($stable_success)) echo '<p style="color:green; font-weight:bold;">'.$stable_success.'</p>'; ?>
<?php if (isset($stable_error)) echo '<p style="color:red; font-weight:bold;">'.$stable_error.'</p>'; ?>
<?php if (isset($reg_success)) echo '<p style="color:green; font-weight:bold;">'.$reg_success.'</p>'; ?>
<h3>Ergebnis<h3>
<?php if (isset($success_success)) echo '<p style="color:green; font-weight:bold;">'.$success_success.'</p>'; ?>

<!--
index.html:
<script>
window.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const page = params.get("page");
    if (page) {
        document.getElementById("mainIframe").src = page;
    }
});
</script>
-->
<a href="index.html?page=forum.php" >ZURÜCK</a>
</body>
</html>
