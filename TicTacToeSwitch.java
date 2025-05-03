import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean spielen = true;

        // Bildschirm leeren
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Starte Spiel
        while (spielen) {
            String g1 = "1", g2 = "2", g3 = "3", g4 = "4", g5 = "5", g6 = "6", g7 = "7", g8 = "8", g9 = "9";
            boolean gameOver = false;
            boolean changeplayer = true;

            do {
                // Spielfeld anzeigen
                System.out.println("-=[ TicTacToe ]=-");
                System.out.println("    " + g1 + " | " + g2 + " | " + g3);
                System.out.println("   -----------");
                System.out.println("    " + g4 + " | " + g5 + " | " + g6);
                System.out.println("   -----------");
                System.out.println("    " + g7 + " | " + g8 + " | " + g9);
                System.out.print("Spieler " + (changeplayer ? "X" : "O") + " -> Welche Matrix? (1-9): ");
                String input = sc.nextLine();

                // Überprüfen, ob die Eingabe gültig ist
                // und den aktuellen Spieler setzen
                // und Eingabe in Spielfeld setzen
                boolean gueltigerZug = false;
                String aktuellerSpieler = changeplayer ? "X" : "O";

                switch (input) {
                    case "1":
                        if (g1.equals("1")) { g1 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "2":
                        if (g2.equals("2")) { g2 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "3":
                        if (g3.equals("3")) { g3 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "4":
                        if (g4.equals("4")) { g4 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "5":
                        if (g5.equals("5")) { g5 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "6":
                        if (g6.equals("6")) { g6 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "7":
                        if (g7.equals("7")) { g7 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "8":
                        if (g8.equals("8")) { g8 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    case "9":
                        if (g9.equals("9")) { g9 = aktuellerSpieler; gueltigerZug = true; }
                        break;
                    default:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("-=[ Ungültiger Zug! Wählen ein unbelegtes Feld ]=-");
                        continue;
                }
                // Anzeige Ungültiger Zug
                if (!gueltigerZug) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("-=[ Ungültiger Zug! Wählen ein unbelegtes Feld ]=-");
                    continue;
                }

                // Bildschirm leeren
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Logik und letzten Zug anzeigen
                if ((g1.equals(aktuellerSpieler) && g2.equals(aktuellerSpieler) && g3.equals(aktuellerSpieler)) ||
                    (g4.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler) && g6.equals(aktuellerSpieler)) ||
                    (g7.equals(aktuellerSpieler) && g8.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler)) ||
                    (g1.equals(aktuellerSpieler) && g4.equals(aktuellerSpieler) && g7.equals(aktuellerSpieler)) ||
                    (g2.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler) && g8.equals(aktuellerSpieler)) ||
                    (g3.equals(aktuellerSpieler) && g6.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler)) ||
                    (g1.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler)) ||
                    (g3.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler) && g7.equals(aktuellerSpieler))) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("-=[ TicTacToe ]=-");
                        System.out.println("    " + g1 + " | " + g2 + " | " + g3);
                        System.out.println("   -----------");
                        System.out.println("    " + g4 + " | " + g5 + " | " + g6);
                        System.out.println("   -----------");
                        System.out.println("    " + g7 + " | " + g8 + " | " + g9);
                        System.out.println("-=[ Spieler " + aktuellerSpieler + " hat gewonnen! ]=-");
                        gameOver = true;
                } else if (!g1.matches("[0-9]") && !g2.matches("[0-9]") && !g3.matches("[0-9]") &&
                           !g4.matches("[0-9]") && !g5.matches("[0-9]") && !g6.matches("[0-9]") &&
                           !g7.matches("[0-9]") && !g8.matches("[0-9]") && !g9.matches("[0-9]")) {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("-=[ TicTacToe ]=-");
                            System.out.println("    " + g1 + " | " + g2 + " | " + g3);
                            System.out.println("   -----------");
                            System.out.println("    " + g4 + " | " + g5 + " | " + g6);
                            System.out.println("   -----------");
                            System.out.println("    " + g7 + " | " + g8 + " | " + g9);
                            System.out.println("-=[ Das Spiel endet unentschieden! ]=-");
                            gameOver = true;
                }

                if (gueltigerZug) {
                    changeplayer = !changeplayer;
                }
            // Ende der Spielschleife
            } while (!gameOver);
            // Abfrage ob erneut gespielt werden soll
            System.out.print("-=[ Nochmals spielen? (j/n): ");
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("n")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                spielen = true;
            } else {
                spielen = false;
            }
        }
        // exit
        sc.close();
        System.out.println("-=[ Das Spiel ist vorbei. Vielen Dank fürs Spielen! ]=-");
    }
}