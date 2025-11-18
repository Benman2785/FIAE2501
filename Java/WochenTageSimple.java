public class WochenTageSimple {
    public static void main(String[] args) {
        // Array mit den Wochentagen
        String[] wochenTage = {"Samstag", "Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"};
        // Scanner für Benutzereingabe
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // Variablen
        int q, m, k, j, h = 0; // Tag des Monats
        // Benutzereingabe für Tag, Monat und Jahr
        System.out.print("Geben Sie den Tag des Monats ein (1-31): ");
        q = scanner.nextInt();
        System.out.print("Geben Sie den Monat ein (1-12): ");
        m = scanner.nextInt();
        System.out.print("Geben Sie das Jahr ein (z.B. 2025): ");
        int jahr = scanner.nextInt();
        scanner.close();
        // Jahr in k und j aufteilen
        k = jahr % 100; // Letzte zwei Ziffern des Jahres
        j = jahr / 100; // Erste zwei Ziffern des Jahres
        // Anpassung des Monats und des Tages für Januar und Februar
        if (m < 3) {
            m += 12; // Januar und Februar als 13. bzw. 14. Monat behandeln
            k--; // Jahr um 1 verringern
        }
        // Rechnung
        h = ((q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7);
        // Ausgabe des Wochentags
        System.out.println("Der Wochentag für den " + q + "." + m + "." + jahr + " : " + wochenTage[h]);        
    }
}