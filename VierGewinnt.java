import java.util.Scanner;

public class VierGewinnt {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean spielen = true;

        // Bildschirm leeren
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Starte Spiel
        while (spielen) {
            String player1 = "\u001b[38;5;9mO\u001b[0m", player2 = "\u001b[38;5;12mO\u001b[0m";
            String g1 = "a", g2 = "b", g3 = "c", g4 = "d", g5 = "e", g6 = "f", g7 = "g", 
                    g8 = "h", g9 = "i", g10 = "j", g11 = "k", g12 = "l", g13 = "m", g14 = "n", 
                    g15 = "o", g16 = "p", g17 = "q", g18 = "r", g19 = "s", g20 = "t", g21 = "u", 
                    g22 = "v", g23 = "w", g24 = "x", g25 = "y", g26 = "z", g27 = "1", g28 = "2", 
                    g29 = "3", g30 = "4", g31 = "5", g32 = "6", g33 = "7", g34 = "8", g35 = "9";
            boolean gameOver = false;
            boolean changeplayer = true;

            do {
                // Spielfeld anzeigen
                System.out.println("       -=[ Vier Gewinnt ]=-");
                System.out.println("  -----------------------------");
                System.out.println(" " + " | " + g1 + " | " + g2 + " | " + g3 + " | " + g4 + " | " + g5 + " | " + g6 + " | " + g7 + " | ");
                System.out.println("  -----------------------------");
                System.out.println(" " + " | " + g8 + " | " + g9 + " | " + g10 + " | " + g11 + " | " + g12 + " | " + g13 + " | " + g14 + " | ");
                System.out.println("  -----------------------------");
                System.out.println(" " + " | " + g15 + " | " + g16 + " | " + g17 + " | " + g18 + " | " + g19 + " | " + g20 + " | " + g21 + " | ");
                System.out.println("  -----------------------------");
                System.out.println(" " + " | " + g22 + " | " + g23 + " | " + g24 + " | " + g25 + " | " + g26 + " | " + g27 + " | " + g28 + " | ");
                System.out.println("  -----------------------------");
                System.out.println(" " + " | " + g29 + " | " + g30 + " | " + g31 + " | " + g32 + " | " + g33 + " | " + g34 + " | " + g35 + " | ");
                System.out.println("  -----------------------------");

                System.out.print("Spieler " + (changeplayer ? "ROT" : "BLAU") + " -> Welche Matrix? (1-9): ");
                String input = sc.nextLine();
                
                boolean gueltigerZug = false;
                String aktuellerSpieler = changeplayer ? player1 : player2;
                if (input.equals(g1)) { g1 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g2)) { g2 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g3)) { g3 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g4)) { g4 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g5)) { g5 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g6)) { g6 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g7)) { g7 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g8)) { g8 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g9)) { g9 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g10)) { g10 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g11)) { g11 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g12)) { g12 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g13)) { g13 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g14)) { g14 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g15)) { g15 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g16)) { g16 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g17)) { g17 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g18)) { g18 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g19)) { g19 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g20)) { g20 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g21)) { g21 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g22)) { g22 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g23)) { g23 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g24)) { g24 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g25)) { g25 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g26)) { g26 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g27)) { g27 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g28)) { g28 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g29)) { g29 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g30)) { g30 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g31)) { g31 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g32)) { g32 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g33)) { g33 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g34)) { g34 = aktuellerSpieler; gueltigerZug = true; }
                else if (input.equals(g35)) { g35 = aktuellerSpieler; gueltigerZug = true; }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("-=[ Ungültiger Zug! Wählen ein unbelegtes Feld ]=-");
                    continue;
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
                if (
                // Reihe 1
                (g1.equals(aktuellerSpieler) && g2.equals(aktuellerSpieler) && g3.equals(aktuellerSpieler) && g4.equals(aktuellerSpieler)) ||
                (g2.equals(aktuellerSpieler) && g3.equals(aktuellerSpieler) && g4.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler)) ||
                (g3.equals(aktuellerSpieler) && g4.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler) && g6.equals(aktuellerSpieler)) ||
                (g4.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler) && g6.equals(aktuellerSpieler) && g7.equals(aktuellerSpieler)) ||
                // Reihe 2
                (g8.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler)) ||
                (g9.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler)) ||
                (g10.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler) && g13.equals(aktuellerSpieler)) ||
                (g11.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler) && g13.equals(aktuellerSpieler) && g14.equals(aktuellerSpieler)) ||
                // Reihe 3
                (g15.equals(aktuellerSpieler) && g16.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler)) ||
                (g16.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler)) ||
                (g17.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler)) ||
                (g18.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler) && g21.equals(aktuellerSpieler)) ||
                // Reihe 4
                (g22.equals(aktuellerSpieler) && g23.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler)) ||
                (g23.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler)) ||
                (g24.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler)) ||
                (g25.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler) && g28.equals(aktuellerSpieler)) ||
                // Reihe 5
                (g29.equals(aktuellerSpieler) && g30.equals(aktuellerSpieler) && g31.equals(aktuellerSpieler) && g32.equals(aktuellerSpieler)) ||
                (g30.equals(aktuellerSpieler) && g31.equals(aktuellerSpieler) && g32.equals(aktuellerSpieler) && g33.equals(aktuellerSpieler)) ||
                (g31.equals(aktuellerSpieler) && g32.equals(aktuellerSpieler) && g33.equals(aktuellerSpieler) && g34.equals(aktuellerSpieler)) ||
                (g32.equals(aktuellerSpieler) && g33.equals(aktuellerSpieler) && g34.equals(aktuellerSpieler) && g35.equals(aktuellerSpieler)) ||
                // Vertikal
                (g1.equals(aktuellerSpieler) && g8.equals(aktuellerSpieler) && g15.equals(aktuellerSpieler) && g22.equals(aktuellerSpieler)) ||
                (g8.equals(aktuellerSpieler) && g15.equals(aktuellerSpieler) && g22.equals(aktuellerSpieler) && g29.equals(aktuellerSpieler)) ||
                (g2.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler) && g16.equals(aktuellerSpieler) && g23.equals(aktuellerSpieler)) ||
                (g9.equals(aktuellerSpieler) && g16.equals(aktuellerSpieler) && g23.equals(aktuellerSpieler) && g30.equals(aktuellerSpieler)) ||
                (g3.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler)) ||
                (g10.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler) && g31.equals(aktuellerSpieler)) ||
                (g4.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler)) ||
                (g11.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler) && g32.equals(aktuellerSpieler)) ||
                (g5.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler)) ||
                (g12.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler) && g33.equals(aktuellerSpieler)) ||
                (g6.equals(aktuellerSpieler) && g13.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler)) ||
                (g13.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler) && g34.equals(aktuellerSpieler)) ||
                (g7.equals(aktuellerSpieler) && g14.equals(aktuellerSpieler) && g21.equals(aktuellerSpieler) && g28.equals(aktuellerSpieler)) ||
                (g14.equals(aktuellerSpieler) && g21.equals(aktuellerSpieler) && g28.equals(aktuellerSpieler) && g35.equals(aktuellerSpieler)) ||
                // Diagonal runter
                (g1.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler)) ||
                (g2.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler)) ||
                (g3.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler)) ||
                (g4.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler) && g28.equals(aktuellerSpieler)) ||
                // Diagonal runter 2
                (g8.equals(aktuellerSpieler) && g16.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler) && g32.equals(aktuellerSpieler)) ||
                (g9.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler) && g33.equals(aktuellerSpieler)) ||
                (g10.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler) && g34.equals(aktuellerSpieler)) ||
                (g11.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler) && g35.equals(aktuellerSpieler)) ||
                // Diagonal hoch 1
                (g22.equals(aktuellerSpieler) && g16.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler) && g4.equals(aktuellerSpieler)) ||
                (g23.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler) && g5.equals(aktuellerSpieler)) ||
                (g24.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler) && g6.equals(aktuellerSpieler)) ||
                (g25.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g13.equals(aktuellerSpieler) && g7.equals(aktuellerSpieler)) ||
                // Diagonal hoch 2
                (g29.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler)) ||
                (g30.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g13.equals(aktuellerSpieler)) ||
                (g31.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler) && g14.equals(aktuellerSpieler)) ||
                (g32.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler) && g21.equals(aktuellerSpieler) && g15.equals(aktuellerSpieler)) ||
                // Diagonal hoch rückwärts 2
                (g28.equals(aktuellerSpieler) && g20.equals(aktuellerSpieler) && g12.equals(aktuellerSpieler) && g4.equals(aktuellerSpieler)) ||
                (g27.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler) && g3.equals(aktuellerSpieler)) ||
                (g26.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler) && g2.equals(aktuellerSpieler)) ||
                (g25.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler) && g1.equals(aktuellerSpieler)) ||
                // Diagonal hoch rückwärts 1
                (g35.equals(aktuellerSpieler) && g27.equals(aktuellerSpieler) && g19.equals(aktuellerSpieler) && g11.equals(aktuellerSpieler)) ||
                (g34.equals(aktuellerSpieler) && g26.equals(aktuellerSpieler) && g18.equals(aktuellerSpieler) && g10.equals(aktuellerSpieler)) ||
                (g33.equals(aktuellerSpieler) && g25.equals(aktuellerSpieler) && g17.equals(aktuellerSpieler) && g9.equals(aktuellerSpieler)) ||
                (g32.equals(aktuellerSpieler) && g24.equals(aktuellerSpieler) && g16.equals(aktuellerSpieler) && g8.equals(aktuellerSpieler))) {

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    // Spielfeld anzeigen
                    System.out.println("       -=[ Vier Gewinnt ]=-");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g1 + " | " + g2 + " | " + g3 + " | " + g4 + " | " + g5 + " | " + g6 + " | " + g7 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g8 + " | " + g9 + " | " + g10 + " | " + g11 + " | " + g12 + " | " + g13 + " | " + g14 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g15 + " | " + g16 + " | " + g17 + " | " + g18 + " | " + g19 + " | " + g20 + " | " + g21 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g22 + " | " + g23 + " | " + g24 + " | " + g25 + " | " + g26 + " | " + g27 + " | " + g28 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g29 + " | " + g30 + " | " + g31 + " | " + g32 + " | " + g33 + " | " + g34 + " | " + g35 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println("-=[ Spieler " + aktuellerSpieler + " hat gewonnen! ]=-");
                    gameOver = true;
                } else if(1 == 1) {                           
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Spielfeld anzeigen
                    System.out.println("       -=[ Vier Gewinnt ]=-");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g1 + " | " + g2 + " | " + g3 + " | " + g4 + " | " + g5 + " | " + g6 + " | " + g7 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g8 + " | " + g9 + " | " + g10 + " | " + g11 + " | " + g12 + " | " + g13 + " | " + g14 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g15 + " | " + g16 + " | " + g17 + " | " + g18 + " | " + g19 + " | " + g20 + " | " + g21 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g22 + " | " + g23 + " | " + g24 + " | " + g25 + " | " + g26 + " | " + g27 + " | " + g28 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println(" " + " | " + g29 + " | " + g30 + " | " + g31 + " | " + g32 + " | " + g33 + " | " + g34 + " | " + g35 + " | ");
                    System.out.println("  -----------------------------");
                    System.out.println("-=[ Unentschieden! ]=-");
                    gameOver = true;
                    if (gueltigerZug) {
                        changeplayer = !changeplayer; // Spieler wechseln
                    } 
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
            sc.close();
            System.out.println("-=[ Das Spiel ist vorbei. Vielen Dank fürs Spielen! ]=-");
        }
    }
}