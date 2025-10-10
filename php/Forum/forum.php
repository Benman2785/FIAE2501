<?php
session_start();

// aktiviere Setup VOR DB init
$dbFile = 'forum.db';
$initialize_forum = !file_exists($dbFile);

// AB HIER DER NORMALE CODE

// Beim Laden generieren
if (!isset($_SESSION['csrf_token'])) {
    $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
}

// CSRF
function validateCsrfToken($token) {
    return isset($_SESSION['csrf_token']) && is_string($token) && hash_equals($_SESSION['csrf_token'], $token);
}

// Anzeige Posts
$slave = $_GET['slave'] ?? '0';
if ($slave === '1' && isset($_GET['view']) && $_GET['view'] === 'posts') {
    header('Content-Type: text/html; charset=UTF-8');
    echo '<!DOCTYPE html>
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
            padding: 0;
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
';

    // DB-Verbindung
    $db = new SQLite3('forum.db');

    // Wähle Beiträge
    if (isset($_GET['date'])) {
        $date = $_GET['date'];
        $stmt = $db->prepare("SELECT posts.id, users.username, posts.content, posts.created_at 
            FROM posts 
            JOIN users ON posts.user_id = users.id 
            WHERE DATE(posts.created_at) = :date 
            ORDER BY created_at DESC");
        $stmt->bindValue(':date', $date, SQLITE3_TEXT);
        $posts = $stmt->execute();
    } else {
        $posts = $db->query("SELECT posts.id, users.username, posts.content, posts.created_at 
            FROM posts 
            JOIN users ON posts.user_id = users.id 
            ORDER BY created_at DESC");
    }

    // Ausgabe der Beiträge
    while ($row = $posts->fetchArray(SQLITE3_ASSOC)) {
        echo '<div class="post">';
        echo '<p><strong>' . htmlspecialchars($row['username']) . '</strong> schrieb am ' . $row['created_at'] . ':</p>';
        echo '<p>' . convertLinks(nl2br(htmlspecialchars($row['content']))) . '</p>';

        // Admin-Löschen
        if (isset($_SESSION['user']) && $_SESSION['user']['role'] === 'admin') {
            echo '<form method="POST" action="forum.php" style="text-align:center;">';
            echo '<input type="hidden" name="delete" value="' . (int)$row['id'] . '">';
            echo '<input type="hidden" name="csrf_token" value="' . htmlspecialchars($_SESSION['csrf_token']) . '">';
            echo '<button type="submit" style="background:red;color:white;height:24px;width:33%;">Löschen</button>';
            echo '</form>';
        }

        echo '</div>';
    }

    echo '</body></html>';
    exit;
}

// Datenbankverbindung
$db = new SQLite3('forum.db');
chmod('forum.db', 0666);

// Benutzer- und Post-Tabellen erstellen, falls nicht vorhanden
$db->exec("CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE,
    password TEXT,
    role TEXT
)");

$db->exec("CREATE TABLE IF NOT EXISTS posts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    content TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(id)
)");

$db->exec("CREATE TABLE IF NOT EXISTS settings (
    name TEXT PRIMARY KEY,
    value TEXT
)");
$db->exec("INSERT OR IGNORE INTO settings (name, value) VALUES ('register_status', '1')");

// Passwort hashen
function hashPassword($password) {
    return password_hash($password, PASSWORD_BCRYPT);
}

// Benutzer aus der Session holen
function getCurrentUser() {
    return isset($_SESSION['user']) ? $_SESSION['user'] : null;
}

// $text = htmlspecialchars($text, ENT_QUOTES, 'UTF-8'); // XSS-Schutz (sicherstellen, dass auch ' und " ersetzt werden)

function convertLinks($text) {
    return preg_replace_callback('/\[(link|img|vid|center|br|spoiler)\](.*?)\[\/\1\]/is', function ($matches) {
        $type = strtolower($matches[1]);
        $content = trim($matches[2]);

        // Content durch htmlspecialchars entschärfen
        $content = htmlspecialchars($content, ENT_QUOTES, 'UTF-8');

        switch ($type) {
            case 'link':
                // Validierung der URL
                if (preg_match('/^https?:\/\/[^\s<>"\'()]+$/i', $content)) {
                    return '<a href="' . $content . '" target="_blank" rel="noopener noreferrer">' . $content . '</a>';
                }
                break;

            case 'img':
                // Validierung der Bild-URL
                if (preg_match('/^https?:\/\/[^\s<>"\'()]+\.(jpg|jpeg|png|gif|webp)$/i', $content)) {
                    return '<img src="' . $content . '" alt="Bild" style="max-width:85%;max-height:400px;height:auto;">';
                }
                break;

	    case 'vid':
	        // Validierung der Video-URL
	        if (preg_match('/^https?:\/\/[^\s<>"\'()]+\.(mp4|mkv|flv|webm)$/i', $content)) {
		    return '<video src="' . htmlspecialchars($content, ENT_QUOTES) . '" controls style="max-width:85%;max-height:400px;height:auto;">Dein Browser unterstützt das Video-Tag nicht.</video>';
		}
	    	break;

            case 'center':
                return '<div style="text-align:center;">' . convertLinks($content) . '</div>';

            case 'spoiler':
                return '<details><summary>Spoiler</summary>' . convertLinks($content) . '</details>';

            case 'br':
                return '<br>';
        }

        // Wenn der Tag nicht erkannt wurde, zurück zum ursprünglichen Text
        return htmlspecialchars($matches[0], ENT_QUOTES, 'UTF-8');
    }, $text);
}

// Login-Verarbeitung
// if (isset($_POST['login'])) {

// Login
if (isset($_POST['login']) && validateCsrfToken($_POST['csrf_token'])) {
    $username = $_POST['username'] ?? '';
    $password = $_POST['password'] ?? '';

    $stmt = $db->prepare("SELECT * FROM users WHERE username = :username");
    $stmt->bindValue(':username', $username, SQLITE3_TEXT);
    $result = $stmt->execute();
    $user = $result->fetchArray(SQLITE3_ASSOC);

    if ($user && password_verify($password, $user['password'])) {
        $_SESSION['user'] = $user;
        header("Location: forum.php");
        exit;
    } else {
        $login_error = "Login fehlgeschlagen.";
    }
}

// Registrierung zulässig?
function isRegistrationEnabled($db) {
    $stmt = $db->prepare("SELECT value FROM settings WHERE name = 'register_status'");
    $result = $stmt->execute()->fetchArray(SQLITE3_ASSOC);
    return isset($result['value']) && $result['value'] === '1';
}

// Registrierung
if (isset($_POST['register']) && validateCsrfToken($_POST['csrf_token'])) {
    if (isRegistrationEnabled($db)) {
        $username = $_POST['reg_username'] ?? '';
        $password = $_POST['reg_password'] ?? '';

        $stmt = $db->prepare("SELECT id FROM users WHERE username = :username");
        $stmt->bindValue(':username', $username, SQLITE3_TEXT);
        $exists = $stmt->execute()->fetchArray();

        if (!$exists) {
            $stmt = $db->prepare("INSERT INTO users (username, password, role) VALUES (:username, :password, 'user')");
            $stmt->bindValue(':username', $username, SQLITE3_TEXT);
            $stmt->bindValue(':password', password_hash($password, PASSWORD_DEFAULT), SQLITE3_TEXT);
            $stmt->execute();
            $register_success = "Registrierung erfolgreich.";
        } else {
            $register_error = "Benutzername bereits vergeben.";
        }
    } else {
        $register_error = "Registrierung ist derzeit deaktiviert.";
    }
}

// Logout
if (isset($_GET['action']) && $_GET['action'] === 'logout') {
    $_SESSION = [];
    session_destroy();
    header("Location: forum.php");
    exit;
}

// Beitrag speichern
// if (isset($_POST['post_content']) && getCurrentUser()) {
if (isset($_POST['post_content'], $_POST['csrf_token']) && validateCsrfToken($_POST['csrf_token']) && getCurrentUser()) {
    $post_content = $_POST['post_content'];

    // Prüfen, ob der Post leer ist
    if (empty(trim($post_content))) {
        $post_error = "Der Beitrag darf nicht leer sein.";
    } else {
        // Lokale Zeitzone setzen
        date_default_timezone_set('Europe/Berlin');
        $created_at = date('Y-m-d H:i:s');

        // Beitrag speichern mit Zeitstempel
        $stmt = $db->prepare("INSERT INTO posts (user_id, content, created_at) VALUES (:user_id, :content, :created_at)");
        $stmt->bindValue(':user_id', getCurrentUser()['id'], SQLITE3_INTEGER);
        $stmt->bindValue(':content', $post_content, SQLITE3_TEXT);
        $stmt->bindValue(':created_at', $created_at, SQLITE3_TEXT);
        $stmt->execute();
    }
}

// Beitrag löschen (einzeln oder alle)
if (getCurrentUser() && getCurrentUser()['role'] === 'admin' && $_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['csrf_token']) && validateCsrfToken($_POST['csrf_token'])) {
        if (isset($_POST['delete']) && is_numeric($_POST['delete'])) {
            $stmt = $db->prepare("DELETE FROM posts WHERE id = :id");
            $stmt->bindValue(':id', $_POST['delete'], SQLITE3_INTEGER);
            $stmt->execute();

            // JavaScript-Umleitung des iframes nach dem Löschen
		echo '<script>
	    if (window.self !== window.top) {
	        // Im iframe → Hauptseite neu laden mit passendem view
	        parent.location.href = "forum.php";
	    } else {
	        // Nicht im iframe → normale Weiterleitung
	        window.location.href = "forum.php";
	    }
	</script>';
	exit;
        }
        if (isset($_POST['delete_all'])) {
            $db->exec("DELETE FROM posts");
        }
    } else {
        echo "Ungültiger CSRF-Token.";
    }
}

// Registrierung aktivieren/deaktivieren

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['toggle_register']) && validateCsrfToken($_POST['csrf_token'])) {
// if (isset($_GET['toggle_register']) && isset($_GET['csrf_token']) && validateCsrfToken($_GET['csrf_token'])) {
// if (isset($_GET['toggle_register'])) {
    $stmt = $db->prepare("SELECT value FROM settings WHERE name = 'register_status'");
    $result = $stmt->execute()->fetchArray(SQLITE3_ASSOC);
    $current_status = isset($result['value']) ? (int)$result['value'] : 1;
    $new_status = $current_status === 1 ? 0 : 1;

    $stmt = $db->prepare("UPDATE settings SET value = :value WHERE name = 'register_status'");
    $stmt->bindValue(':value', $new_status, SQLITE3_TEXT);
    $stmt->execute();
}

// Passwort ändern
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['change_password'])) {
    if (!validateCsrfToken($_POST['csrf_token'])) {
        echo "Ungültiges CSRF-Token!";
        exit;
    }

    $old = $_POST['old_password'] ?? '';
    $new = $_POST['new_password'] ?? '';
    $userId = $_SESSION['user']['id'] ?? null;

    if ($userId) {
        $stmt = $db->prepare("SELECT password FROM users WHERE id = :id");
        $stmt->bindValue(':id', $userId, SQLITE3_INTEGER);
        $result = $stmt->execute()->fetchArray(SQLITE3_ASSOC);

        if ($result && password_verify($old, $result['password'])) {
            $newHash = password_hash($new, PASSWORD_DEFAULT);
            $update = $db->prepare("UPDATE users SET password = :pwd WHERE id = :id");
            $update->bindValue(':pwd', $newHash, SQLITE3_TEXT);
            $update->bindValue(':id', $userId, SQLITE3_INTEGER);
            $update->execute();
            $pwcha_success = "Passwort erfolgreich geändert!";
        } else {
            $pwcha_error = "Altes Passwort falsch!";
        }
    }
}

// Nutzer löschen
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['delete_user'])) {
    if (!validateCsrfToken($_POST['csrf_token'])) {
        echo "Ungültiges CSRF-Token!";
        exit;
    }

    if (isset($_SESSION['user']) && $_SESSION['user']['role'] === 'admin') {
        $uid = (int) $_POST['user'];

        // Optional: Beiträge des Benutzers löschen
        // $db->exec("DELETE FROM posts WHERE user_id = $uid");

        // Benutzer löschen
        $stmt = $db->prepare("DELETE FROM users WHERE id = :id");
        $stmt->bindValue(':id', $uid, SQLITE3_INTEGER);
        $stmt->execute();

        $usdel_success = "Benutzer gelöscht.";
    } else {
        $usdel_error =  "Zugriff verweigert.";
        exit;
    }
}
?>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Forum</title>
    <link rel="stylesheet" href="https://hoffmeister.li/font.css" type="text/css">
    <link rel="stylesheet" href="https://hoffmeister.li/forum.css" type="text/css">
<style>
    html {
        height: 100%;
    }
    body {
        min-height: 100%;
        width: 100%;
        margin: 0;
        padding: 0;
        background: url("bck2.jpg") repeat-y center top;
        background-size: 100% auto;
        background-color: #666666;
        color: #fff;
        font-family: 'Oswald', Arial, sans-serif;
        font-size: 100%;
        overflow-y: auto;
        scrollbar-width: thin;
        scrollbar-color: #888 #444;
    }
</style>
</head>
<body>

<!-- SETUP -->
<?php if ($initialize_forum): ?>
    <div class="grid">
        <!-- Header -->
	<header class="header1"><a href=""></a></header>
	<header class="header2"><a href=""></a></header>
	<header class="header3"><a href=""></a></header>
	<header class="header4"><a href=""></a></header>
	<div style="grid-column:1/4;grid-row:2;height:100%;width:auto;overflow:hidden;margin:0;padding:0;background: url(bck2.jpg) repeat-y;background-size: cover; color: white; display:flex; justify-content:center; align-items:center;" scrolling="no">
	      <button onclick="window.open('forum_init.php', '_blank'); location.reload();" style="padding:1em 2em; font-size:1.2em; background-color:#888; color:white; border:none; border-radius:8px; cursor:pointer;">SETUP</button>
	</div>
        <div class="menu" id="sidebar"></div>
	<div class="postarea"></div>
<?php else: ?>

<!-- NORMAL -->
    <div class="grid">
        <!-- Header -->
        <header class="header1"><a href="forum.php">Übersicht</a></header>
        <header class="header2">
            <?php if (!getCurrentUser()): ?>
                <a href="?action=login">login</a>
            <?php else: ?>
                <a href="?action=logout">logout</a>
            <?php endif; ?>
        </header>
        <header class="header3"><a href="?action=register">registrieren</a></header>
        <header class="header4">
            <?php if (getCurrentUser() && getCurrentUser()['role'] === 'admin' || getCurrentUser()['role'] === 'user'): ?>
                <a href="?action=admin">Verwaltung</a>
            <?php endif; ?>
        </header>

        <!-- Main Content -->
	<div style="grid-column:1/4;grid-row:2;height:100%;width:auto;overflow:hidden;margin:0;padding:0;" scrolling="no">
	    <iframe class="slaveiframe" name="slaveiframe" src="forum.php?slave=1&view=posts" style="height:100%;width:100%;margin:0;padding:0;border:none;"></iframe>
	</div>


        <!-- Sidebar (immer sichtbar) -->
        <div class="menu" id="sidebar">
			<!-- Registrierung anzeigen (für alle sichtbar, auch Admins) -->
			<?php 
			    $register_status = isRegistrationEnabled($db) ? 1 : 0;
			    $status_text = $register_status === 1 ? "Deaktivieren" : "Aktivieren";
			?>
	<?php
	    $user = getCurrentUser();
	    // Gemeinsamer Teil für alle (Registrierungsstatus)
	    echo '<hr style="border-color: white;"/>';
	    echo '<center><p style="color:white;">Registrierung ist ' . ($register_status ? 'aktiv' : 'deaktiviert') . '.</p></center>';
	    echo '<hr style="border-color: white;"/>';

	    if (!$user) {
	        // Nicht eingeloggt
	        echo '<header><center><h3 style="font-family: Oswald, Arial, sans-serif; color: white;">NEWS nach Datum</h3></center></header>';
	        echo '<hr style="border-color: white;"/>';
	    } elseif ($user['role'] !== 'admin') {
		echo '<header><center><h3 style="font-family: Oswald, Arial, sans-serif; color: white;">Willkommen ' . htmlspecialchars($user['username']) . '</h3></center></header>';
	        echo '<hr style="border-color: white;"/>';
	    } elseif ($user['role'] === 'admin') { }; ?>
            <?php if (!(isset($_GET['action']) && $_GET['action'] === 'admin')): ?>
                <ul>
		<li><a href="forum.php?slave=1&view=posts" target="slaveiframe">Alle Beiträge</a></li>
			<?php
			$dates = $db->query("SELECT DISTINCT DATE(created_at) as datum FROM posts ORDER BY datum DESC");
			while ($date = $dates->fetchArray(SQLITE3_ASSOC)) {
			$tag = $date['datum'];
			echo '<li><a href="forum.php?slave=1&view=posts&date=' . $tag . '" target="slaveiframe">' . $tag . '</a></li>';
			}
			?>
                </ul>
            <?php endif; ?>

<!-- Verwaltung -->
<?php 
$user = getCurrentUser();
if ($user && $user['role'] === 'admin'): ?>
    <hr style="border-color: white;"/>
    <h3 style="color: white;text-align: center;">Verwaltung</h3>

    <?php if (isset($_POST['csrf_token']) && !validateCsrfToken($_POST['csrf_token'])) {
        echo '<p style="color: red;">CSRF ungültig</p>';
    } ?>

    <form method="POST">
        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars($_SESSION['csrf_token']) ?>">
        <button type="submit" name="toggle_register"
                style="background:<?= $register_status === 1 ? 'red' : 'green'; ?>;
                       height: 40px; width:100%; margin-bottom: 5px; color:white;">
            Registrierung <?= $status_text ?>
        </button>
    </form>

    <form method="POST">
        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars($_SESSION['csrf_token']) ?>">
        <input type="hidden" name="delete_all" value="1">
        <button type="submit" style="background:red;color:white; height: 40px; width:100%; margin-bottom: 5px;">
            Alle Beiträge löschen
        </button>
    </form>

    <a href="../forum.db" download="forum.db" style="all: unset;"> 
        <button style="background:blue;color:white; height: 40px; width:100%; margin-bottom: 5px;">
            Backup DB
        </button>
    </a>

    <form method="POST" style="text-align: center;">
        <input type="password" name="old_password" placeholder="Altes Passwort" required><br>
        <input type="password" name="new_password" placeholder="Neues Passwort" required><br>
        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars($_SESSION['csrf_token']) ?>">
        <button type="submit" name="change_password">Passwort ändern</button>
    </form>
    <?php if (isset($pwcha_error)) echo '<p style="color:red; font-weight:bold; text-align:center;">'.$pwcha_error.'</p>'; ?>
    <?php if (isset($pwcha_success)) echo '<p style="color:green; font-weight:bold; text-align:center;">'.$pwcha_success.'</p>'; ?>

    <hr style="border-color: white;"/>
    <h3 style="color: white;text-align: center;">Benutzerverwaltung</h3>
    <ul>
    <?php 
    $users = $db->query("SELECT id, username, role FROM users");
    while ($row = $users->fetchArray(SQLITE3_ASSOC)) {
        echo "<li>";
        echo htmlspecialchars($row['username']) . " (" . htmlspecialchars($row['role']) . ")";
        if ($row['id'] != $_SESSION['user']['id']) {
            echo "<form method='POST' style='display:inline; margin-left: 10px;'>
                <input type='hidden' name='user' value='" . $row['id'] . "'>
                <input type='hidden' name='csrf_token' value='" . htmlspecialchars($_SESSION['csrf_token']) . "'>
                <button type='submit' name='delete_user' onclick='return confirm(\"Benutzer wirklich löschen?\")'>Löschen</button>
            </form>";
        }
        echo "</li>";
    }
    ?>
<?php if (isset($usdel_error)) echo '<p style="color:red; font-weight:bold; text-align:center;">'.$usdel_error.'</p>'; ?>
<?php if (isset($usdel_success)) echo '<p style="color:green; font-weight:bold; text-align:center;">'.$usdel_success.'</p>'; ?>
    </ul>
<?php elseif ($user && $user['role'] !== 'admin'): ?>
    <hr style="border-color: white;"/>
    <h3 style="color: white;">Verwaltung</h3>
    <?php if (isset($_POST['csrf_token']) && !validateCsrfToken($_POST['csrf_token'])) {
        echo '<p style="color: red;">CSRF ungültig</p>';
    } ?>
    <form method="POST" style="text-align: center;">
        <input type="password" name="old_password" placeholder="Altes Passwort" required><br>
        <input type="password" name="new_password" placeholder="Neues Passwort" required><br>
        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars($_SESSION['csrf_token']) ?>">
        <button type="submit" name="change_password">Passwort ändern</button>
    </form><br>
    
    <?php if (isset($pwcha_success)) echo '<p style="color:green; font-weight:bold; text-align:center;">'.$pwcha_success.'</p>'; ?>
<?php endif; ?>
</div>

<!-- Post Area (immer sichtbar) -->
<div class="postarea">
    <?php if (isset($_GET['action']) && $_GET['action'] === 'login' && !getCurrentUser()): ?>
        <form method="post">
            <input type="hidden" name="csrf_token" value="<?php echo $_SESSION['csrf_token']; ?>">
            <input type="text" name="username" placeholder="Benutzername" required style="margin: 15px 15px 0px 15px;"><br>
            <input type="password" name="password" placeholder="Passwort" required style="margin: 0px 15px 0px 15px;"><br>
            <button type="submit" name="login" style="margin: 0px 15px 0px 15px;">Login</button>
            <?php if (isset($login_error)) echo '<p style="color:red; font-weight:bold; padding-left:15px;">'.$login_error.'</p>'; ?>
        </form>
    <?php elseif (isset($_GET['action']) && $_GET['action'] === 'register' && !getCurrentUser()): ?>
        <form method="post">
            <input type="hidden" name="csrf_token" value="<?php echo $_SESSION['csrf_token']; ?>">
            <input type="text" name="reg_username" placeholder="Benutzername" required style="margin: 15px 15px 0px 15px;"><br>
            <input type="password" name="reg_password" placeholder="Passwort" required style="margin: 0px 15px 0px 15px;"><br>
            <button type="submit" name="register" style="margin: 0px 15px 0px 15px;">Registrieren</button>
            <?php if (isset($register_error)) echo '<p style="color:red; font-weight:bold; padding-left:15px;">'.$register_error.'</p>'; ?>
            <?php if (isset($register_success)) echo '<p style="color:green; font-weight:bold; padding-left:15px;">'.$register_success.'</p>'; ?>
        </form>
    <?php elseif (getCurrentUser()): ?>
        <form method="post" style="height: 100%; margin: 0;">
	  <input type="hidden" name="csrf_token" value="<?php echo $_SESSION['csrf_token']; ?>">

	  <div style="position: relative; height: 100%;">
	    <textarea id="post_content" name="post_content" placeholder="Was möchtest du sagen?" style="resize: none; width: 100%; height: 100%; font-size: 1rem; box-sizing: border-box;"></textarea>

	    <div style="position: absolute; bottom: 1px; right: 0; z-index: 10; display: flex; gap: 1px;">
	      <button type="button" onclick="insertBBCode('center')" style="background-color:#333; color:white; padding: 3px 8px;">[center]</button>
	      <button type="button" onclick="insertBBCode('spoiler')" style="background-color:#333; color:white; padding: 3px 8px;">[spoiler]</button>
	      <button type="button" onclick="insertBBCode('img')" style="background-color:#333; color:white; padding: 3px 8px;">[img]</button>
	      <button type="button" onclick="insertBBCode('vid')" style="background-color:#333; color:white; padding: 3px 8px;">[vid]</button>
	      <button type="button" onclick="insertBBCode('link')" style="background-color:#333; color:white; padding: 3px 8px;">[link]</button>
	      <button type="submit" style="background-color:#333; color:white; padding: 3px 24px;">Beitrag absenden</button>
	    </div>
	  </div>
	</form>
    <?php elseif (1 == 1): ?>
        <form method="post" style="height: 100%; margin: 0;">
            <textarea id="post_content" name="post_content" placeholder="LOGIN ODER REGISTRIEREN!" style="resize: none; width:100%; height:100%; font-size:1.5rem;"></textarea><br>
        </form>
    <?php endif; ?>
<!-- BBCode Buttons -->
<script>
function insertBBCode(tag) {
    const textarea = document.getElementById('post_content');
    const start = textarea.selectionStart;
    const end = textarea.selectionEnd;
    const selectedText = textarea.value.substring(start, end);
    let insertText, cursorPos;
    if (start === end) {
        // Kein Text ausgewählt – Tag mit Platz dazwischen einfügen
        insertText = `[${tag}][/${tag}]`;
        textarea.setRangeText(insertText, start, end, 'start');
        // Cursor zwischen die Tags setzen
        cursorPos = start + tag.length + 2;
        textarea.selectionStart = textarea.selectionEnd = cursorPos;
    } else {
        // Text ausgewählt – mit BBCode umschließen
        insertText = `[${tag}]${selectedText}[/${tag}]`;
        textarea.setRangeText(insertText, start, end, 'end');
    }
    textarea.focus();
}
</script>
</div>
</div>
<?php endif; ?>
</body>
</html>