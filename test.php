<?php // Starttag
// ausgabe mit echo
echo("<center>");
echo("<h1> Hello World! </h1>");
$name = 'Martin';
echo("Mein Name ist " . $name);

// User gibt Alter und Name ein un wird folgendermaßen begrüst;
$vorname = "Klaus";
$alter = 46;
echo("<br><br>");
echo("Mein Name ist " . $vorname . " und ich bin " . $alter . " Jahre alt.");
echo("<br><br><br><br>");

// User gibt Alter Name, wenn jünger als 19 dann "Hey Digga, name" & wenn älter "Jutn Tach, name"
$vorname1 = "Beni";
$vorname2 = "Benji";
$alta1 = 17;
$alta2 = 22;

if ($alta1 >= 18) {echo("Jutn Tach, " . $vorname1);} else {echo("Hey Digga, " . $vorname1);};
echo("<br><br>");
if ($alta2 >= 18) {echo("Jutn Tach, " . $vorname2);} else {echo("Hey Digga, " . $vorname2);};
echo("<br><br>");

// Arrays in PHP
$wochentage = array("Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag","Sonntag","Dienst für Benni Tag");
echo("Heudde üst " . $wochentage[2]);
echo("<br><br>");

for ($i = 0; $i < sizeof($wochentage); $i++) {
    echo $wochentage[$i] . "<br>";
}

echo("</center>");
?>