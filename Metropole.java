import java.util.*;

public class Metropole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inhabi = 0;
        int tax = 0;
        int taxt = 0;
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
        // Europa
        buHs.add("Bern");
        buHs.add("Wien");
        buHs.add("Paris");
        buHs.add("Madrid");
        buHs.add("Warschau");
        buHs.add("Lissabon");
        buHs.add("London");
        buHs.add("Stockholm");
        buHs.add("Helsinki");
        buHs.add("Kopenhagen");
        buHs.add("Athen");
        buHs.add("Rom");
        buHs.add("Oslo");
        buHs.add("Brüssel");
        buHs.add("Amsterdam");
        buHs.add("Riga");
        buHs.add("Tallinn");
        buHs.add("Andorra la Vella");
        buHs.add("Belgrad");
        buHs.add("Bratislava");
        buHs.add("Budapest");
        buHs.add("Bukarest");
        buHs.add("Chisinau");
        buHs.add("Citta di San Marino");
        buHs.add("Dublin");
        buHs.add("Kiew");
        buHs.add("Ljubljana");
        buHs.add("Luxemburg");
        buHs.add("Minsk");
        buHs.add("Nikosia");
        buHs.add("Paris");
        buHs.add("Podgorica");
        buHs.add("Prag");
        buHs.add("Pristina");
        buHs.add("Reykjavik");
        buHs.add("Sarajewo");
        buHs.add("Skopje");
        buHs.add("Sofia");
        buHs.add("Tirana");
        buHs.add("Valetta");
        buHs.add("Vaduz");
        buHs.add("Vilnius");
        buHs.add("Zagreb");

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
