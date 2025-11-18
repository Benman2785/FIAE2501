
import java.util.ArrayList;
import java.util.Scanner;

public class MainOld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Tier> tiere = new ArrayList<>();

        System.out.print("Anzahl Tiere? ");
        int anzahlEntries = sc.nextInt();
        sc.nextLine(); // Rest der Zeile "weglesen"
        
        for (int i = 0; i < anzahlEntries; i++){
            System.out.println("Neues Tier");
            System.out.println("Gib Tierart an: ");
            String tierArt = sc.nextLine();
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Gattung: ");
            String gattung = sc.nextLine();
            System.out.println("Gewicht: ");
            double gewicht = sc.nextInt();
            sc.nextLine(); // Rest der Zeile "weglesen"

            if (tierArt.equalsIgnoreCase("loewe")){
                tiere.add(new Loewe(name, gattung, gewicht));
            } else if (tierArt.equalsIgnoreCase("elefant") || tierArt.equalsIgnoreCase("elephant")) {
                double stossZahnLaenge;
                double ruesselLaenge;
                System.out.println("Stosszahnlaenge: ");
                stossZahnLaenge = sc.nextDouble();
                sc.nextLine(); // Rest der Zeile "weglesen"
                System.out.println("Ruessellaenge: ");
                ruesselLaenge = sc.nextDouble();
                sc.nextLine(); // Rest der Zeile "weglesen"
                tiere.add(new Elefant(name, gattung, gewicht, stossZahnLaenge, ruesselLaenge));
            } else {
                System.out.println("Kagge!");
                i--;
            }
        }
        // for (Tier t : tiere) {
        //     if (t instanceof Loewe) {
        //         Loewe L = (Loewe) t;
        //         System.out.println("Loewe " + L.getName() + ", der Gattung " + L.getGattung() + " mit einem Gewicht von " + L.getGewicht() + "kg -> du bist dran!");

        //         L.gehen();
        //         L.bruellen();
        //         L.fressen();
        //         L.jagen();

        //         System.out.println("genug " + L.getName() + " - zurueck in die finstere Einzelzelle!");
        //         System.out.println("");
        //     }
        //     else if (t instanceof Elefant) {
        //         Elefant E = (Elefant) t;

        //         System.out.print(E.getName() + " der Gattung " + E.getGattung() + " mit einem Stampfgewicht von " + E.getGewicht() + "kg! \n");
        //         System.out.println(E.getName() + " hat einen riesigen Ruessel mit einer Laenge von " + E.getRuesselLaenge() + "cm");
        //         System.out.println(E.getName() + " hat sogar Stosszaehne mit einer Laenge von " + E.getStossZahnLaenge() + "cm - aber zum Glueck frisst er nur Pflanzen");
            
        //         E.fressen();
        //         E.gehen();
                
        //         System.out.println("");
        //     }
        // }
    // System.out.println("Der Zoo muss nun leider dauerhaft schliessen");

    // System.out.println("");

    for (int i = 0; i < tiere.size(); i++) {
        System.out.println(tiere.get(i).toString());    
        }
    }
}