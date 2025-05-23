<?php
// assoziatives Array erstellen
$asoray = array("name" => "Hoffmeister", "vorname" => "Benjamin", "bday" => "2-Jul-1985");
// Ausgabe konkatiniert
    echo '<center><h1>Assoziatives Array</h1></center>';
    echo '<br>';
    echo '<center>Vorname: ' . $asoray["vorname"] . '</center>';
    echo '<center>Name: ' . $asoray["name"] . '</center>';
    echo '<center>Geburtstag: ' . $asoray["bday"] . '</center>';
// Mehrdimensionales Array
$personen = array(
    array("name" => "Hoffmeister", "vorname" => "Benjamin", "bday" => "2-Jul-1985"),
    array("name" => "Stromer", "vorname" => "Pascal", "bday" => "21-Dez-1989"),
    array("name" => "McWuff", "vorname" => "Pudel", "bday" => "14-Feb-2025")
);
// Ausgabe aller Personen
    echo '<center><h1>Assoziatives Array</h1></center>';
foreach ($personen as $person) {
    echo "<center>Vorname: {$person['vorname']}</center>";
    echo "<center>Name: {$person['name']}</center>";
    echo "<center>Geburtstag: {$person['bday']}</center><br>";
}
    echo '<br>';
?>