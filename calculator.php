<?php
session_start();

// Initialisieren
if (!isset($_SESSION['display'])) $_SESSION['display'] = '';
if (!isset($_SESSION['operator'])) $_SESSION['operator'] = '';
if (!isset($_SESSION['wert1'])) $_SESSION['wert1'] = null;
if (!isset($_SESSION['memory'])) $_SESSION['memory'] = null;
if (!isset($_SESSION['check'])) $_SESSION['check'] = false;

// Eingabe verarbeiten
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['btn'])) {
    $btn = $_POST['btn'];

    // Wenn Zahl oder Punkt
if (is_numeric($btn) && $_SESSION['check'] === true && $_SESSION['wert1'] !== null || $btn === '.') {
    $_SESSION['display'] = '';
    $_SESSION['display'] .= $btn;
    $_SESSION['check'] = false;
} elseif (is_numeric($btn) || $btn === '.') {
    $_SESSION['display'] .= $btn;
}

    // Quadratwurzel direkt berechnen
    elseif ($btn === '√') {
        if ($_SESSION['display'] !== '') {
            $wert = floatval($_SESSION['display']);
            if ($wert >= 0) {
                $ergebnis = sqrt($wert);
                $_SESSION['display'] = (string)$ergebnis;
                $_SESSION['operator'] = '√';
                $_SESSION['wert1'] = $ergebnis;
            } else {
                $_SESSION['display'] = 'Fehler';
                $_SESSION['operator'] = '';
                $_SESSION['wert1'] = null;
            }
        }
    }

    // Operator gedrückt
    elseif (in_array($btn, ['+', '-', '*', '/'])) {
        if ($_SESSION['display'] !== '') {
            if ($_SESSION['operator'] !== '' && $_SESSION['wert1'] !== null) {
                // Zwischenberechnung
                $wert2 = floatval($_SESSION['display']);
                $wert1 = $_SESSION['wert1'];
                $op = $_SESSION['operator'];

                if ($op === '+') $wert1 += $wert2;
                elseif ($op === '-') $wert1 -= $wert2;
                elseif ($op === '*') $wert1 *= $wert2;
                elseif ($op === '/') $wert1 = ($wert2 != 0) ? $wert1 / $wert2 : 'Fehler';

                $_SESSION['wert1'] = $wert1;
            } else {
                $_SESSION['wert1'] = floatval($_SESSION['display']);
            }
            $_SESSION['display'] = '';
        }
        $_SESSION['operator'] = $btn;
    }

    elseif ($btn === '=' & $_SESSION['operator'] === '√') {
        $_SESSION['display'] = '';
        $_SESSION['operator'] = '';
        $_SESSION['check'] = false;
    } elseif ($btn === '=') {
        $_SESSION['check'] = true;
        $wert2 = floatval($_SESSION['display']);
        $wert1 = $_SESSION['wert1'];
        $op = $_SESSION['operator'];

        if ($op === '+') $ergebnis = $wert1 + $wert2;
        elseif ($op === '-') $ergebnis = $wert1 - $wert2;
        elseif ($op === '*') $ergebnis = $wert1 * $wert2;
        elseif ($op === '/') $ergebnis = ($wert2 != 0) ? $wert1 / $wert2 : 'Fehler';
        else $ergebnis = 'Fehler';

        $_SESSION['display'] = (string)$ergebnis;
        $_SESSION['operator'] = '=';
        $_SESSION['wert1'] = $ergebnis;
    }
    // Löschen
    elseif ($btn === 'C') {
        $_SESSION['check'] = false;
        $_SESSION['display'] = '';
        $_SESSION['operator'] = '';
    }

    // Speicherfunktionen
    elseif ($btn === 'MS') {
        $_SESSION['memory'] = $_SESSION['display'];
    } elseif ($btn === 'MR') {
        $_SESSION['display'] = $_SESSION['memory'];
    } elseif ($btn === 'MC') {
        $_SESSION['memory'] = null;
        $_SESSION['display'] = '';
    }
    }
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PHP-Rechner</title>
    <style>
        body {
            font-family: sans-serif;
            text-align: center;
            background-color: #eee;
            margin-top: 40px;
        }
        .display-wrapper {
            display: flex;
            justify-content: center;
            margin-bottom: 10px;
        }
        #operator {
            width: 40px;
            height: 40px;
            font-size: 20px;
            text-align: center;
            border: none;
        }
        #display {
            width: 209px;
            height: 40px;
            font-size: 20px;
            text-align: right;
            border: none;
        }
        button {
            width: 60px;
            height: 50px;
            font-size: 18px;
            margin: 3px;
        }
    </style>

    <!-- hier Tastendrücke -->
    <script>
    document.addEventListener('keydown', function(event) {
    const taste = event.key;

    // Unterstützte Tasten: 0-9, +, -, *, /, Enter (=), Komma oder Punkt (.)
    const erlaubteTasten = ['0','1','2','3','4','5','6','7','8','9','.','+','-','*','/','Enter'];

    if (erlaubteTasten.includes(taste)) {
        // Sonderfall: Enter-Taste wird zu =
        const btnWert = (taste === 'Enter') ? '=' : taste;

        // Den passenden Button finden
        const button = document.querySelector(`button[value="${btnWert}"]`);
        if (button) {
            button.click();
        }
    }
});
</script>

</head>
<body>
    <h1>PHP-Rechner</h1>
    <h6>einfach</h6>
    <form method="post">
        <div class="display-wrapper">
            <input id="operator" type="text" name="operator" value="<?= htmlspecialchars($_SESSION['operator']) ?>" readonly>
            <input id="display" type="text" name="display" value="<?= htmlspecialchars($_SESSION['display']) ?>" readonly>
        </div>
        <?php
        $buttons = [
            ['7', '8', '9', '/'],
            ['4', '5', '6', '*'],
            ['1', '2', '3', '-'],
            ['.', '0', '√', '+'],
            ['MS', 'MR', 'MC', 'C'],
            ['=']
        ];
        foreach ($buttons as $row) {
            foreach ($row as $btn) {
                echo "<button type='submit' name='btn' value='$btn'>$btn</button>";
            }
            echo "<br>";
        }
        ?>
    </form>
</body>
</html>