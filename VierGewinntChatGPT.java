public class VierGewinntChatGPT {
    static final int ZEILEN = 6;
    static final int SPALTEN = 7;
    static final String SPIELER1 = "\u001b[38;5;9mO\u001b[0m";  // ROT
    static final String SPIELER2 = "\u001b[38;5;12mO\u001b[0m"; // BLAU
    static String[][] feld = new String[ZEILEN][SPALTEN];

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        boolean spielerWechsel = true;
        int zug = 0;
        initFeld();

        while (true) {
            clearScreen();
            zeigeFeld();
            String aktuellerSpieler = spielerWechsel ? SPIELER1 : SPIELER2;
            System.out.print("Spieler " + (spielerWechsel ? "\u001b[38;5;9mROT\u001b[0m" : "\u001b[38;5;12mBLAU\u001b[0m") + ", Spalte (1-7): ");
            int spalte;
            try {
                spalte = Integer.parseInt(sc.nextLine()) - 1;
            } catch (Exception e) {
                continue;
            }

            if (spalte < 0 || spalte >= SPALTEN || !setzeStein(spalte, aktuellerSpieler)) {
                System.out.println("Ungültiger Zug!");
                continue;
            }

            if (pruefeGewonnen(aktuellerSpieler)) {
                clearScreen();
                zeigeFeld();
                System.out.println("Spieler " + (spielerWechsel ? "\u001b[38;5;9mROT\u001b[0m" : "\u001b[38;5;12mBLAU\u001b[0m") + " gewinnt!");
                break;
            }
            zug++;
            if (prüfeZug(zug)) {
                clearScreen();
                zeigeFeld();
                System.out.println("Das Spiel endet unentschieden!");
                break;
            }
            spielerWechsel = !spielerWechsel;
        }
    }

    static void initFeld() {
        for (int i = 0; i < ZEILEN; i++)
            for (int j = 0; j < SPALTEN; j++)
                feld[i][j] = " ";
    }

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
        System.out.println("   1   2   3   4   5   6   7");
    }

    static boolean setzeStein(int spalte, String spieler) {
        for (int i = ZEILEN - 1; i >= 0; i--) {
            if (feld[i][spalte].equals(" ")) {
                feld[i][spalte] = spieler;
                return true;
            }
        }
        return false;
    }

    static boolean pruefeGewonnen(String spieler) {
        // Horizontal, Vertikal, Diagonal prüfen
        for (int i = 0; i < ZEILEN; i++) {
            for (int j = 0; j < SPALTEN; j++) {
                if (pruefeRichtung(i, j, 0, 1, spieler) || // Rechts
                    pruefeRichtung(i, j, 1, 0, spieler) || // Unten
                    pruefeRichtung(i, j, 1, 1, spieler) || // Diagonal rechts unten
                    pruefeRichtung(i, j, 1, -1, spieler))  // Diagonal links unten
                    return true;
            }
        }
        return false;
    }

    static boolean pruefeRichtung(int zeile, int spalte, int dz, int ds, String spieler) {
        for (int k = 0; k < 4; k++) {
            int z = zeile + dz * k;
            int s = spalte + ds * k;
            if (z < 0 || z >= ZEILEN || s < 0 || s >= SPALTEN || !feld[z][s].equals(spieler))
                return false;
        }
        return true;
    }

    static boolean prüfeZug(int Zug) {
        if (Zug < 42) {
            return false;
        } else  {
            return true;
        }
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}