public class VierGewinnt2D {

    // Spielfeldgröße (6 Reihen, 7 Spalten wie beim echten Vier Gewinnt)
    static final int ZEILEN = 6;
    static final int SPALTEN = 7;
    // Zeichen für die Spieler inklusive ANSI-Farben für farbige Darstellung in der Konsole
    static final String SPIELER1 = "\u001b[38;5;9mO\u001b[0m";  // Spieler 1 = ROT
    static final String SPIELER2 = "\u001b[38;5;12mO\u001b[0m"; // Spieler 2 = BLAU
    // Spielfeld als 2D-Array
    static String[][] feld = new String[ZEILEN][SPALTEN];
    // Scanner wird als statische Variable angelegt, damit alle Methoden darauf zugreifen können
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    // Einstiegspunkt des Programms
    public static void main(String[] args) {
        boolean nochmalSpielen;

        // Spielschleife: Wird wiederholt, solange der Spieler „j“ eingibt
        do {
            spieleRunde();             // Eine Runde spielen
            nochmalSpielen = nochmal(); // Danach fragen, ob man nochmal spielen will
        } while (nochmalSpielen);

        // Programmende
        System.out.println("Danke fürs Spielen!");
    }

    // Führt eine einzelne Spielrunde durch
    static void spieleRunde() {
        boolean spielerWechsel = true; // true = Spieler 1 (ROT) beginnt
        int zug = 0;                   // Zähler für Gesamtzüge
        initFeld();                    // Spielfeld leeren/initialisieren

        while (true) {
            clearScreen();            // Konsole säubern
            zeigeFeld();              // Aktuellen Spielfeldzustand anzeigen

            // Aktueller Spieler (abhängig von spielerWechsel)
            String aktuellerSpieler = spielerWechsel ? SPIELER1 : SPIELER2;

            // Spieleraufforderung mit Farbe
            System.out.print("Spieler " + (spielerWechsel ? "\u001b[38;5;9mROT\u001b[0m" : "\u001b[38;5;12mBLAU\u001b[0m") + ", Spalte (1-7): ");
            int spalte;

            // Eingabe lesen und in Array-Index umwandeln
            try {
                spalte = Integer.parseInt(sc.nextLine()) - 1;
            } catch (Exception e) {
                continue; // Ungültige Eingabe -> Eingabe erneut abfragen
            }

            // Gültigkeit der Spalte prüfen und Stein setzen
            if (spalte < 0 || spalte >= SPALTEN || !setzeStein(spalte, aktuellerSpieler)) {
                System.out.println("Ungültiger Zug!");
                continue;
            }

            // Prüfen, ob aktueller Spieler gewonnen hat
            if (pruefeGewonnen(aktuellerSpieler)) {
                clearScreen();
                zeigeFeld();
                System.out.println("Spieler " + (spielerWechsel ? "\u001b[38;5;9mROT\u001b[0m" : "\u001b[38;5;12mBLAU\u001b[0m") + " gewinnt!");
                break;
            }

            // Zugzähler erhöhen und Unentschieden prüfen
            zug++;
            if (prüfeZug(zug)) {
                clearScreen();
                zeigeFeld();
                System.out.println("Das Spiel endet unentschieden!");
                break;
            }

            // Spieler wechseln
            spielerWechsel = !spielerWechsel;
        }
    }

    // Initialisiert das Spielfeld mit Leerzeichen
    static void initFeld() {
        for (int i = 0; i < ZEILEN; i++)
            for (int j = 0; j < SPALTEN; j++)
                feld[i][j] = " ";
    }

    // Zeigt das Spielfeld schön formatiert in der Konsole an
    static void zeigeFeld() {
        System.out.println("      -=[ Vier Gewinnt ]=-");
        System.out.println(" -----------------------------");
        for (int i = 0; i < ZEILEN; i++) {
            System.out.print(" |");
            for (int j = 0; j < SPALTEN; j++) {
                System.out.print(" " + feld[i][j] + " |");
            }
            System.out.println();
            System.out.println(" -----------------------------");
        }
        System.out.println(" | 1 - 2 - 3 - 4 - 5 - 6 - 7 |");
        System.out.println(" -----------------------------");
        System.out.println("    /_/ \\_\\         /_/ \\_\\");
    }

    // Versucht, den Spielstein in der angegebenen Spalte zu platzieren
    static boolean setzeStein(int spalte, String spieler) {
        for (int i = ZEILEN - 1; i >= 0; i--) {
            if (feld[i][spalte].equals(" ")) {
                feld[i][spalte] = spieler;
                return true;
            }
        }
        return false; // Spalte ist voll
    }

    // Prüft, ob der aktuelle Spieler irgendwo gewonnen hat (4 gleiche in eine Richtung)
    static boolean pruefeGewonnen(String spieler) {
        for (int i = 0; i < ZEILEN; i++) {
            for (int j = 0; j < SPALTEN; j++) {
                if (
                    pruefeRichtung(i, j, 0, 1, spieler) ||  // horizontal
                    pruefeRichtung(i, j, 1, 0, spieler) ||  // vertikal
                    pruefeRichtung(i, j, 1, 1, spieler) ||  // diagonal ↘
                    pruefeRichtung(i, j, 1, -1, spieler)    // diagonal ↙
                )
                    return true;
            }
        }
        return false;
    }

    // Prüft 4 Felder in der angegebenen Richtung auf Übereinstimmung
    static boolean pruefeRichtung(int zeile, int spalte, int dz, int ds, String spieler) {
        for (int k = 0; k < 4; k++) {
            int z = zeile + dz * k;
            int s = spalte + ds * k;

            // Prüfen ob Position im Spielfeld liegt und zum Spieler gehört
            if (z < 0 || z >= ZEILEN || s < 0 || s >= SPALTEN || !feld[z][s].equals(spieler))
                return false;
        }
        return true; // 4 passende Felder gefunden
    }

    // Prüft, ob alle 42 Felder belegt sind -> Unentschieden
    static boolean prüfeZug(int zug) {
        return zug >= ZEILEN * SPALTEN;
    }

    // Löscht den Bildschirm (funktioniert in vielen Konsolen)
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Fragt, ob man noch eine Runde spielen möchte
    static boolean nochmal() {
        while (true) {
            System.out.print("Nochmal spielen? (j/n): ");
            String eingabe = sc.nextLine().trim().toLowerCase();
            if (eingabe.equals("j")) return true;
            if (eingabe.equals("n")) return false;

            // Bei falscher Eingabe Hinweis anzeigen
            System.out.println("Bitte 'j' für Ja oder 'n' für Nein eingeben.");
        }
    }
}