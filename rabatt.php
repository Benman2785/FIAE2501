<?php
session_start();

$preis = '';
$rabatt = '';
$rabattbetrag = '';
$neupreis = '';

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $preis = str_replace(',', '.', $_POST['preis'] ?? "");
    $rabatt = str_replace(',', '.', $_POST['rabatt'] ?? "");
    $rabattbetrag = $preis * ($rabatt / 100);
    $neupreis = $preis - $rabattbetrag;
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Rabatt-Rechner</title>
</head>
<body>
    <center><h1>Rabatt-Rechner</h1></center>
    <form method="POST" action="rabatt.php" id="eingabe">
        <center>
            <label for="preis">Preis:</label>
            <input type="text" id="preis" name="preis" value="<?= htmlspecialchars($preis) ?>" placeholder="in € -> zB 13.37"><br>

            <label for="rabatt">Rabatt:</label>
            <input type="text" id="rabatt" name="rabatt" value="<?= htmlspecialchars($rabatt) ?>" placeholder="in % -> zb 20"><br>

            <button type="submit">Eingabe</button>
        </center>
    </form><br><br>

    <center><h3>Ausgabe:</h3></center>
    <center><?php if ($preis) echo "Preis: " . htmlspecialchars($preis) . "€"; ?></center>
    <center><?php if ($rabatt) echo "Rabatt: " . htmlspecialchars($rabatt) . "%"; ?></center>
    <center><?php if ($rabattbetrag !== '') echo "Rabattbetrag: " . $rabattbetrag . "€"; ?></center>
    <center><?php if ($neupreis) echo "Neupreis: " . $neupreis . "€"; ?></center>
</body>
</html>