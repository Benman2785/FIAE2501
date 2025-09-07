import java.util.ArrayList;
import java.util.Scanner;

public class main {
     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        ArrayList<Loewe> loewen = new ArrayList<>();
        ArrayList<Elefant> elefanten = new ArrayList<>();

        System.out.println("Will kommen im Zooh!");
        System.out.println("Wir haben nur Loewen und Elefanten");
        System.out.println("");

        System.out.println("Wieviele Loewen zaehlst du?");
        int anzahlLoewen = sc.nextInt();
        System.out.println("Und wieviele Elefanten kannst du sehen?");
        int anzahlElefanten = sc.nextInt();

        System.out.println("Eingabe des/der Loewen");
        int i = 0;
        while (i < anzahlLoewen) {
            if (i = 0){
                System.out.println("Name für den Loewe:");
                String nameLoewe = sc.next();
                System.out.println("Gattung des Loewen:");
                String gattungLoewe = sc.next();
                System.out.println("Gewicht des Loewen in kg:");
                double gewichtLoewe = sc.nextDouble(); 
                loewen.add(new Loewe(nameLoewe, gattungLoewe, gewichtLoewe));
                i++;
            } else {
                System.out.println("Name für den nächsten Loewen:");
                String nameLoewe = sc.next();
                System.out.println("Gattung des Loewen:");
                String gattungLoewe = sc.next();
                System.out.println("Gewicht des Loewen in kg:");
                double gewichtLoewe = sc.nextDouble(); 
                loewen.add(new Loewe(nameLoewe, gattungLoewe, gewichtLoewe));
                i++;
        }
        System.out.println("");
        System.out.println("Eingabe des/der Elefanten");
        int j = 0;
        while (j < anzahlElefanten) {
            if (j = 0){
                System.out.println("Name für den Elefanten:");
                String nameElefant = sc.next();
                System.out.println("Gattung des Elefanten:");
                String gattungElefant = sc.next();
                System.out.println("Gewicht des Elefanten in kg:");
                double gewichtElefant = sc.nextDouble(); 
                System.out.println("Laenge des Rüssels in cm:");
                int ruesselLaenge = sc.nextInt();
                System.out.println("Laenge der Stoßzähne in cm:");
                int stossZahnLaenge = sc.nextInt();
                elefanten.add(new Elefant(nameElefant, gattungElefant, gewichtElefant, stossZahnLaenge, ruesselLaenge));
                j++;
            } else {
                System.out.println("Name für den nächsten Elefanten:");
                String nameElefant = sc.next();
                System.out.println("Gattung des Elefanten:");
                String gattungElefant = sc.next();
                System.out.println("Gewicht des Elefanten in kg:");
                double gewichtElefant = sc.nextDouble(); 
                System.out.println("Laenge des Rüssels in cm:");
                int ruesselLaenge = sc.nextInt();
                System.out.println("Laenge der Stoßzähne in cm:");
                int stossZahnLaenge = sc.nextInt();
                elefanten.add(new Elefant(nameElefant, gattungElefant, gewichtElefant, stossZahnLaenge, ruesselLaenge));
                j++;
            }
        }

        System.out.println("So, jetzt geht die Show los!");
        System.out.println("");

        for (Loewe l : loewen) {
            System.out.println("Loewe " + l.getName() + ", der Gattung " + l.getGattung() + " mit einem Gewicht von " + l.getGewicht() + "kg -> du bist dran!");
        
            l.gehen();
            l.bruellen();
            l.fressen();
            l.jagen();

            System.out.println("genug " + l.getName() + " - zurueck in die finstere Einzelzelle!");
            System.out.println("");
        }
        System.out.println("Jetzt kommt die Zeit der Elefanten - angefangen mit "); 

        for (int z = 0; z < elefanten.size(); z++){

            Elefant e = elefanten.get(z);
            System.out.print(e.getName() + " der Gattung " + e.getGattung() + " mit einem Stampfgewicht von " + e.getGewicht() + "kg! \n");
            System.out.println(e.getName() + " hat einen riesigen Ruessel mit einer Laenge von " + e.getRuesselLaenge() + "cm");
            System.out.println(e.getName() + " hat sogar Stosszaehne mit einer Laenge von " + e.getStossZahnLaenge() + "cm - aber zum Glueck frisst er nur Pflanzis");
        
            e.fressen();
            e.gehen();
            
            System.out.println("");
            if (elefanten.size() > 1 && z < elefanten.size() - 1){
            System.out.println("sehe ich da etwa ");
            }
        }
        System.out.println("Der Zoo muss nun leider dauerhaft schliessen");
    }
}