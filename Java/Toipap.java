public class Toipap {
    public static void main(String[] args) {
        double breite = 120;
        double laenge = 98; 
        int pack = 10;
        int lagen = 3;
        int blatt = 250;
        int rollen = 8;
        double pagew = (16.5);
        double flaeche = breite / 1000 * laenge / 1000;
        double gewpack = flaeche * blatt * rollen;
        double gew = gewpack * pack * pagew / 1000 * lagen;
        System.out.println(gew);    
    }
}
