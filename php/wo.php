<?php
echo("über der Seite - nicht im html-body");
?>
<!DOCTYPE html>
<html>
<head>
<title>Wo wird PHP angezeigt</title>
<style>
body {
	margin: 0;
	height: 100%;
	width: 100%;
	overflow: hidden;
}
.grid {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	grid-template-rows: 33% 33% 33%;
	height: 100%;
	width: 100%;
}
</style>
</head>
<body>
<div class="grid" style="border:2px solid grey">
	<div style="grid-column:2;grid-row:2;border:2px solid grey">
		<?php echo("hier ist die Mitte"); ?>
	</div>
	<div style="grid-column:3;grid-row:3;border:2px solid grey">
		<?php echo("hier ist rechts unten"); ?>
	</div>
</div>
</body>
</html>
