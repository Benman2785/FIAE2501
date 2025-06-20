import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean spielen = true;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (spielen) {
            String g1 = "1", g2 = "2", g3 = "3", g4 = "4", g5 = "5", g6 = "6", g7 = "7", g8 = "8", g9 = "9";
            String playerX = "\u001b[38;5;9mX\u001b[0m", playerY = "\u001b[38;5;12mO\u001b[0m";
            boolean gameOver = false;
            boolean changeplayer = true; // true = Spieler X, false = Spieler O
            do {
                System.out.println("-=[ TicTacToe ]=-");
                System.out.println("    " + g1 + " | " + g2 + " | " + g3);
                System.out.println("   -----------");
                System.out.println("    " + g4 + " | " + g5 + " | " + g6);
                System.out.println("   -----------");
                System.out.println("    " + g7 + " | " + g8 + " | " + g9);
                System.out.print("Spieler " + (changeplayer ? "X" : "O") + " -> Welche Matrix? (1-9): ");
                String input = sc.nextLine();
                boolean gueltigerZug = false;
                String aktuellerSpieler = changeplayer ? playerX : playerY;
                if (input.equals(g1)) { g1 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g2)) { g2 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g3)) { g3 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g4)) { g4 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g5)) { g5 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g6)) { g6 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g7)) { g7 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g8)) { g8 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g9)) { g9 = aktuellerSpieler; gueltigerZug = true; }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("-=[ Ungültiger Zug! Wählen ein unbelegtes Feld ]=-");
                    continue;
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
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
                        // Spielfeld anzeigen
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
                            // Spielfeld anzeigen
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
                    changeplayer = !changeplayer; // Spieler wechseln
                } 
            } while (!gameOver);

            System.out.print("-=[ Nochmal spielen? (j/n): ");
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("n")) {
                // Bildschirm leeren
                System.out.print("\033[H\033[2J");
                System.out.flush();
                spielen = true;
            } else {
                spielen = false;
                    }
        }
        sc.close();
        System.out.println("-=[ Das Spiel ist vorbei. Vielen Dank fürs Spielen! ]=-");
    }
}