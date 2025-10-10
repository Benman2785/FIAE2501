<?php
$vorname = "";
$name = "";
$geburtstag = "";

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $vorname = $_POST["vn"] ?? "";
    $name = $_POST["na"] ?? "";
    $geburtstag = $_POST["bday"] ?? "";
}
?>
<!DOCTYPE html>
<html>
<head>
<title>Arrays in PHP</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<title>Arrays in PHP</title>
</head>
<body>
    <center><h1>Hier basteln wir mit einem dynamischen Array</h1><center>
	<form method="POST" action="phparray.php" id="eingabe">
	    <center><label for="vorname">VORNAME:</label>
	    <input type=text id="vorname" name="vn"></input></center><br>
	    <center><label for="name">NACHNAME:</label>
	    <input type=text id="name" name="na"></input></center><br>
	    <center><label for="bday">Geburtstag:</label>
	    <input type=text id="bday" name="bday"></input></center><br>
	    <center><button type=submit>Sub-M.I.T.</button><center><br>
	</from>
    <center><h3>AUSGABE:</h3></center>
    <center><?php echo ("Vorname: " . $vorname)?></center>
    <center><?php echo ("Nachname: " . $name)?></center>
    <center><?php echo ("Geburtstag: " . $geburtstag)?></center>
</body>
</html>