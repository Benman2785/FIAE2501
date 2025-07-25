import java.util.Scanner;

public class Pruefziffer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte 16-stellige Nummer eingeben: ");
        String[] numbers = scanner.nextLine().split("");
    
        // if (numbers.length != 16) {
        //     System.out.println("Fehler: Die Nummer muss genau 16 Stellen haben.");
        //     return;
        // }
        if (pruefeKarte(numbers)) {
            System.out.println("Nummer gültig");
        } else {
            System.out.println("Nummer nicht gültig");
        }
    }
    // Quersumme berechnen
    public static int querSumme(int zahl) {
        int summe = 0;
        while (zahl > 0) {
            summe += zahl % 10;
            zahl /= 10;
        }
        return summe;
    }
    // String in int umwandeln
    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
    // Schritt 1: jede zweite Ziffer (von rechts, also bei geraden Index von links) verdoppeln
    public static int[] verdoppeln(String[] numbers) {
        int[] summe = new int[numbers.length];
        for (int i = 0; i < numbers.length-1; i++) {
            int zahl = toInt(numbers[i]);
            // Jede zweite Ziffer
            if (i % 2 == 0) {
                zahl *= 2;
            }
            summe[i] = zahl;
        }
        return summe;
    }
    // Schritt 2: Quersummen der Zahlen + aufsummieren
    public static int queraufsumme(int[] werte) {
        int summe = 0;
        for (int wert : werte) {
            summe += querSumme(wert);
        }
        return summe;
    }
    // Schritt 3: Differenz zur nächsten durch 10 teilbaren Zahl
    public static int difften(int summe) {
        return (10 - (summe % 10)) % 10;
    }
    // Prüfung der Prüfziffer (Schritt 4)
    public static boolean pruefeKarte(String[] numbers) {
        int[] werte = verdoppeln(numbers);
        int summe = queraufsumme(werte);
        int pruefziffer = difften(summe);
        int letzteZiffer = toInt(numbers[numbers.length-1]);
        return pruefziffer == letzteZiffer;
    }

}
