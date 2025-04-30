import java.util.*;

public class Metropole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inhabi = 0;
        float tax = 0f;
        float taxt = 0f;
        String name = " ";
        boolean icap = false;
        boolean metro = false;

        /* HS Array */
        ArrayList<String> buHs = new ArrayList<>();
        buHs.add("Berlin");
        buHs.add("Potsdam");
        buHs.add("Bremen");
        buHs.add("Hamburg");
        buHs.add("Magdeburg");
        buHs.add("Kiel");
        buHs.add("Schwerin");
        buHs.add("Erfurt");
        buHs.add("Hannover");
        buHs.add("Dresden");
        buHs.add("Kiel");
        buHs.add("Düsseldorf");
        buHs.add("Mainz");
        buHs.add("Saarbrücken");
        buHs.add("Stuttgart");
        buHs.add("München");

        /* EINGABE */
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        System.out.println("Ihre Eingaben bitte: ");
        System.out.print("Name der Stadt: ");
        name = sc.nextLine();
        System.out.println(" ");
        System.out.print("Einwohnerzahl: ");
        inhabi = sc.nextInt();
        System.out.println(" ");
        System.out.print("Steuern pro Kopf: ");
        tax = sc.nextFloat();


        /* Logik */

        for (String element : buHs) {
            if (element.equals(name)) {
                icap = true;
            }
        }
        taxt = inhabi * tax;
        if (icap == true && inhabi >= 100000) { metro = true;}
        if (inhabi >= 200000 && taxt >= 1000000000) {metro = true;}



        /* Ausgabe */

        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    if (icap == true) {
        System.out.println(name + " ist eine Hauptstadt.");
    } else {
        System.out.println(name + " ist keine Hauptstadt.");
    }
        System.out.println(name + " hat " + inhabi + " Einwohner.");
        System.out.println(name + " veranschlagt " + tax + " Steuern pro Einwohner im Jahr.");
    if (metro == true) {
        System.out.println(name + " ist eine Metropole.");
    } else {
        System.out.println(name + " ist keine Metropole.");
    }

    }
}
