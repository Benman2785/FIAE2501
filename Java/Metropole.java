import java.util.*;

public class Metropole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inhabi = 0;
        int tax = 0;
        int taxt = 0;
        String name = " ";
        boolean dcap = false;
        boolean ecap = false;
        boolean metro = false;
        boolean ber = false;

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
        // Europa
        ArrayList<String> euroHs = new ArrayList<>();
        euroHs.add("Bern");
        euroHs.add("Wien");
        euroHs.add("Paris");
        euroHs.add("Madrid");
        euroHs.add("Warschau");
        euroHs.add("Lissabon");
        euroHs.add("London");
        euroHs.add("Stockholm");
        euroHs.add("Helsinki");
        euroHs.add("Kopenhagen");
        euroHs.add("Athen");
        euroHs.add("Rom");
        euroHs.add("Oslo");
        euroHs.add("Brüssel");
        euroHs.add("Amsterdam");
        euroHs.add("Riga");
        euroHs.add("Tallinn");
        euroHs.add("Andorra la Vella");
        euroHs.add("Belgrad");
        euroHs.add("Bratislava");
        euroHs.add("Budapest");
        euroHs.add("Bukarest");
        euroHs.add("Chisinau");
        euroHs.add("Citta di San Marino");
        euroHs.add("Dublin");
        euroHs.add("Kiew");
        euroHs.add("Ljubljana");
        euroHs.add("Luxemburg");
        euroHs.add("Minsk");
        euroHs.add("Nikosia");
        euroHs.add("Paris");
        euroHs.add("Podgorica");
        euroHs.add("Prag");
        euroHs.add("Pristina");
        euroHs.add("Reykjavik");
        euroHs.add("Sarajewo");
        euroHs.add("Skopje");
        euroHs.add("Sofia");
        euroHs.add("Tirana");
        euroHs.add("Valetta");
        euroHs.add("Vaduz");
        euroHs.add("Vilnius");
        euroHs.add("Zagreb");

        /* EINGABE */
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        System.out.println("Ihre Eingaben bitte: ");
        System.out.print("Name der europäische Stadt: ");
        name = sc.nextLine();
        // System.out.println(" ");
        System.out.print("Einwohnerzahl: ");
        inhabi = sc.nextInt();
        // System.out.println(" ");
        System.out.print("Steuern pro Kopf: ");
        tax = sc.nextInt();

        /* Logik */
        for (String element : buHs) {
            if (element.equals(name)) {
                dcap = true;
            }
        }
        for (String element2 : euroHs) {
            if (element2.equals(name)) {
                ecap = true;
            }
        }
        if (name.equals("Berlin")) {
                ber = true;
            }

        taxt = inhabi * tax;
        if (dcap == true && inhabi >= 100000) { metro = true;}
        if (ecap == true && inhabi >= 100000) { metro = true;}
        if (inhabi >= 200000 && taxt >= 1000000000) {metro = true;}

        /* Ausgabe */
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    if (ber == true) {
        System.out.println(name + " ist eine europäische und Landeshauptstadt.");
        dcap = false;
    }
    if (dcap == true) {
        System.out.println(name + " ist eine Landeshauptstadt.");
    } else if (ecap == true) {
        System.out.println(name + " ist eine europäische Hauptstadt.");
    } else if (ber == false) {
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
