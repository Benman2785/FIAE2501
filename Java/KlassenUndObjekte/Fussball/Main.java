package Fussball;

public class Main {
    public static void main(String[] args) {
        Trainer t1 = new Trainer("Berti Vukks", 72, 19);
        Trainer t2 = new Trainer("Wuergen Kloppi", 57, 15);
        Spieler s01 = new Spieler("Bruno Ballermann", 28, "Sturm", 0, 45, t1);
        Spieler s02 = new Spieler("Carlo Clausewitz", 29, "Mittelfeld", 0, 33, t1);
        Spieler s03 = new Spieler("Dario Dallermann", 21, "Verteidigung", 0, 12, t1);
        Spieler s04 = new Spieler("Emil Einreisser", 40, "Libero", 0, 85, t1);
        Spieler s05 = new Spieler("Friedrich Friedvoll", 19, "Verteidigung", 0, 2, t1);
        Spieler s06 = new Spieler("Zetti Zitterer", 27, "Sturm", 0, 52, t2);
        Spieler s07 = new Spieler("Yeti Yps", 22, "Verteidigung", 0, 12, t2);
        Spieler s08 = new Spieler("Otto Rehhirschkles", 33, "Sturm", 0, 38, t2);
        Spieler s09 = new Spieler("Klaus Klemmer", 32, "Verteidigung", 0, 1, t2);
        Spieler s10 = new Spieler("Frivoler Fauster", 40, "Mittelfeld", 0, 88, t2);

        
        // System.out.println(t1);
        // System.out.println(t2);
        // System.out.println(s01);
        // System.out.println(s02);
        // System.out.println(s03);
        // System.out.println(s04);
        // System.out.println(s05);
        // System.out.println(s06);
        // System.out.println(s07);
        // System.out.println(s08);
        // System.out.println(s09);
        // System.out.println(s10);

        s05.versucheTor(s05.getTrefferQuote());
        System.out.println(s05.getTrefferQuote());
        System.out.println(s05);

        s10.versucheTor(s10.getTrefferQuote());
        System.out.println(s10.getTrefferQuote());
        System.out.println(s10);
    }
}
