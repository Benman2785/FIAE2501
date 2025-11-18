public class VerkaufsSummen {
 
    public static void main(String[] args) {
        int[][] verkaufe = {
            {100, 200, 150}, // Mo.
            {120, 180, 130}, // etc.
            {90, 160, 140},
            {110, 210, 170},
            {130, 220, 160},
            {140, 230, 180},
            {150, 240, 190}
        };
        berechneTagesWochenSumme(verkaufe);
        System.out.println("\n");
        berechneSpaltenSumme(verkaufe);
 
    }
 
    static void berechneTagesWochenSumme(int[][] verkaufe) {
        int summe = 0;
        String[] wochentag = {"Montag", "Dienstag", "Mittoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
        int[] wochenVerkauf = new int[verkaufe.length];
        for (int i = 0; i < verkaufe.length; i++) {
            for (int j = 0; j < verkaufe[i].length; j++) {
                wochenVerkauf[i] += verkaufe[i][j];
            }
            summe += wochenVerkauf[i];
            System.out.println(wochentag[i] + ": " + wochenVerkauf[i] + " Euro");
 
        }
        System.out.println("Gesamt: " + summe);
    }
 
    static void berechneSpaltenSumme(int[][] verkaufe) {
        int summe = 0;
        String[] verkauf = {
            "Erster Verkauf",
            "Zweiter Verkauf",
            "Dritter Verkauf"
        };
        int[] anzahlVerkauf = new int[verkaufe.length];
        for (int i = 0; i < verkaufe[i].length; i++) {
            for (int j = 0; j < verkaufe.length; j++) {
                anzahlVerkauf[i] += verkaufe[j][i];
            }
            summe += anzahlVerkauf[i];
            System.out.println(verkauf[i] + ": " + anzahlVerkauf[i] + " Euro");
 
        }
        System.out.println("Gesamt: " + summe);
    }
}