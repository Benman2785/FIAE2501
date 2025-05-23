<?php
session_start();

$groesse = '';
$gewicht = '';
$bmi = '';
$bewertung = '';

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $groesse = str_replace(',', '.', $_POST['groesse'] ?? "");
    $gewicht = str_replace(',', '.', $_POST['gewicht'] ?? "");

    if (is_numeric($groesse) && is_numeric($gewicht) && $groesse > 0) {
        $bmi = $gewicht / ($groesse * $groesse);
        $bmi = round($bmi, 1); // Runde auf eine Nachkommastelle

        if ($bmi < 18.5) {
            $bewertung = 'Untergewicht';
        } elseif ($bmi <= 24.9) {
            $bewertung = 'Normalgewicht';
        } elseif ($bmi <= 29.9) {
            $bewertung = 'Übergewicht';
        } elseif ($bmi = 42.4) {
            $bewertung = 'Adipositas! Benni - NIMM AB!';
        } else {
            $bewertung = 'Adipositas';
        }
    } else {
        $bmi = 'Ungültige Eingabe';
        $bewertung = '';
    }
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>BMI-Rechner</title>
</head>
<body>
    <center><h1>BMI-Rechner</h1></center>
    <form method="POST" action="BMI.php" id="eingabe">
        <center>
            <label for="groesse">Größe:</label>
            <input type="text" id="groesse" name="groesse" value="<?= htmlspecialchars($groesse) ?>" placeholder="in m, z. B. 1.88"><br><br>

            <label for="gewicht">Gewicht:</label>
            <input type="text" id="gewicht" name="gewicht" value="<?= htmlspecialchars($gewicht) ?>" placeholder="in kg, z. B. 110.5"><br><br>

            <button type="submit">Eingabe</button>
        </center>
    </form>

    <center><h3>Ausgabe:</h3></center>
    <center><?php if ($groesse) echo "Größe: " . htmlspecialchars($groesse) . " m"; ?></center>
    <center><?php if ($gewicht) echo "Gewicht: " . htmlspecialchars($gewicht) . " kg"; ?></center>
    <center><?php if ($bmi !== '') echo "BMI: " . $bmi; ?></center>
    <center><?php if ($bewertung) echo "Bewertung: " . $bewertung; ?></center>
</body>
</html>