import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Tier> tiere = new ArrayList<>();

        System.out.print("Anzahl Tiere? ");
        int anzahlEntries = sc.nextInt();
        sc.nextLine(); // Rest der Zeile "weglesen"

        for (int i = 0; i < anzahlEntries; i++) {
            System.out.println("\nNeues Tier");
            System.out.print("Gib Tierart an (Loewe/Elefant): ");
            String tierArt = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gattung: ");
            String gattung = sc.nextLine();

            System.out.print("Gewicht: ");
            int gewicht = sc.nextInt();
            sc.nextLine(); // Rest der Zeile weglesen

            if (tierArt.equalsIgnoreCase("loewe")) {
                tiere.add(new Loewe(name, gattung, gewicht));

            } else if (tierArt.equalsIgnoreCase("elefant")) {
                System.out.print("Stosszahnlaenge: ");
                double stossZahnLaenge = sc.nextDouble();

                System.out.print("Ruessellaenge: ");
                double ruesselLaenge = sc.nextDouble();
                sc.nextLine(); // Rest der Zeile weglesen

                tiere.add(new Elefant(name, gattung, gewicht, stossZahnLaenge, ruesselLaenge));

            } else {
                System.out.println("Unbekannte Tierart – überspringe...");
            }
        }

        // Ausgabe & Aktionen
        for (Tier t : tiere) {
            if (t instanceof Loewe) {
                Loewe L = (Loewe) t;
                System.out.println("Loewe " + L.getName() + ", der Gattung " + L.getGattung() + 
                                   " mit einem Gewicht von " + L.getGewicht() + "kg -> du bist dran!");

                L.gehen();
                L.bruellen();
                L.fressen();
                L.jagen();

                System.out.println("genug " + L.getName() + " - zurueck in die finstere Einzelzelle!\n");
            } 
            else if (t instanceof Elefant) {
                Elefant E = (Elefant) t;
                System.out.println(E.getName() + " der Gattung " + E.getGattung() + 
                                   " mit einem Stampfgewicht von " + E.getGewicht() + "kg!");
                System.out.println(E.getName() + " hat einen riesigen Ruessel mit einer Laenge von " + E.getRuesselLaenge() + "cm");
                System.out.println(E.getName() + " hat sogar Stosszaehne mit einer Laenge von " + E.getStossZahnLaenge() + "cm - aber zum Glueck frisst er nur Pflanzis");

                E.fressen();
                E.gehen();

                System.out.println();
            }
        }

        System.out.println("Der Zoo muss nun leider dauerhaft schliessen");
        sc.close();
    }
}