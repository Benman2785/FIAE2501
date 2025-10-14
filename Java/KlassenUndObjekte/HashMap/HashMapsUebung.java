import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class HashMapsUebung {
    public static void main(String[] args) {
        // Aufgabe 1
        HashMap<String, Integer> map = new HashMap<>();
            map.put("Annelie", 21);
            map.put("Benni", 40);
            map.put("Caro", 34);
            map.put("Daniel", 93);
            map.put("Erin", 41);
        //Aufgabe 2
        System.out.println("Key: " + map.containsKey("Benni"));
        System.out.println("Value: " + map.containsValue(21));
        // Aufgabe 3
        map.put("Caro", 39);
        System.out.println(map);
        // Aufgabe 4
        for (String k : map.keySet()){
            System.out.println(k);
        }
        for (Integer v : map.values()){
            System.out.println(v);
        }
        // Aufgabe 5
        for (HashMap.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Name ist " + entry.getKey() + ", Alter: " + entry.getValue() + " Jahre alt");
            // System.out.println("Name ist Alter Jahre alt");
        }
        // Aufgabe 6
        map.remove("Erin");
        System.out.println("Map Groesse: " + map.size());
        // Aufgabe 7
        HashMap<String, Integer> count = new HashMap<>();
        String[] wortListe = {"Aachen", "Berlin", "Aachen", "Berlin", "Berlin", "Cottbus", "Dresden", "Eisenhuettenstadt"};
        for (String wort : wortListe){
            if (count.containsKey(wort)){
                // Integer v = count.get(wort);
                // v++;
                // count.put(wort, v);
                count.put(wort, count.get(wort) + 1);
            } else {
                count.put(wort, 1);
            }
        }
        System.out.println(count);
        // Aufgabe 8
        HashMap<String, String> countcap = new HashMap<>();
        HashMap<String, String> capcount = new HashMap<>();
        countcap.put("Deutschland", "Berlin");
        countcap.put("England", "London");
        countcap.put("Griechenland", "Athen");
        countcap.put("Malta", "Valetta");
        countcap.put("Malediven", "Male");
        System.out.println(countcap);
        // for (HashMap.Entry<String, String> eintrag : countcap.entrySet()){
        //     String switch1;
        //     String switch2;
        //     switch1 = eintrag.getKey();
        //     switch2 = eintrag.getValue();
        //     capcount.put(switch2, switch1);
        // }
        for (HashMap.Entry<String, String> eintrag : countcap.entrySet()){
            capcount.put(eintrag.getValue(), eintrag.getKey());
        }
        System.out.println(capcount);
        // System.out.println("Anzahl der Key-Value-Paare: " + countcap.size());
        // Aufgabe 9
        HashMap<Character, Integer> zaehler = new HashMap<>();
        String text = """
                Bedecke deinen Himmel, Zeus,
                Mit Wolkendunst!
                Und übe, dem Knaben gleich,
                der Disteln köpft,
                an Eichen dich und Bergeshöhn!
                Mußt mir meine Erde
                doch lassen stehn.
                Und meine Hütte,
                die du nicht gebaut,
                Und meinen Herd,
                um dessen Glut
                du mich beneidest.

                Ich kenne nichts ärmeres
                unter der Sonn als euch, Götter.
                Ihr nähret kümmerlich
                von Opfersteuern und Gebetshauch
                eure Majestät und darbtet, wären
                nicht Kinder und Bettler
                hoffnungsvolle Toren.

                Da ich ein Kind war
                nicht wußte, wo aus noch ein,
                kehrt ich mein verirrtes Auge
                zur Sonne, als wenn drüber war
                ein Ohr, zu hören meine Klage,
                ein Herz wie meins,
                sich des Bedrängten zu erbarmen.

                Wer half mir wider
                der Titanen Übermut
                Wer rettete vom Tode mich
                von Sklaverei?
                Hast du nicht alles selbst vollendet,
                heilig glühend Herz?
                Und glühtest jung und gut,
                Betrogen, Rettungsdank
                dem Schlafenden da droben?

                Ich dich ehren? Wofür?
                Hast du die Schmerzen gelindert
                je des Beladenen
                Hast du die Tränen gestillet
                je des Geängsteten

                Hat nicht mich zum Manne geschmiedet
                die allmächtige Zeit
                Und das ewige Schicksal
                meine Herrn und deine?

                Wähntest du etwa,
                ich sollte das Leben hassen,
                in Wüsten fliehen,
                weil nicht alle Knabenmorgen-
                blütenträume reiften?

                Hier sitz ich, forme Menschen
                nach meinem Bilde,
                Ein Geschlecht das mir gleich sei
                Zu leiden zu weinen,
                zu genießen und zu freuen sich,
                und dein nicht zu achten
                wie ich! 
                """;
        text = text.toLowerCase();
        text = text.replaceAll("[^a-zäöüß]", "");
        for (char c : text.toCharArray()) {
            zaehler.put(c, zaehler.getOrDefault(c, 0) + 1);
        }
        for (var entry : zaehler.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
        int max = Collections.max(zaehler.values());
        for (var entry : zaehler.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("Buchstabe '" + entry.getKey() + "' mit der Haeufigkeit: " + entry.getValue());
            }
        }
        int zaehle = 0;
        Character stabi = ' ';
        for (var entry : zaehler.entrySet()){
            if (entry.getValue() > zaehle){
                zaehle = entry.getValue();
                stabi = entry.getKey();
            }
        }
        System.out.println("Buchstabe '" + stabi  + "' mit der Haeufigkeit: " + zaehle);
        // System.out.println("groeßte Haeufigkeit: " + Collections.max(zaehler.values()));
        // Aufgabe 10
        HashMap<String, String> telefonbuch = new HashMap<>();
        telefonbuch.put("Polizei", "110");
        telefonbuch.put("Feuerwehr", "112");
        telefonbuch.put("Benni", "01705155609");
        Scanner sc = new Scanner(System.in);
        System.out.println("Suche Nummer: ");
        String number = sc.nextLine();
        findNumber(telefonbuch, number);
        sc.close();
               
    }
    public static void findNumber(HashMap<String, String> telefonbuch, String number){
        boolean gefunden = false;
        for (HashMap.Entry<String, String> geil : telefonbuch.entrySet()){
            if(geil.getValue().equals(number)){
                gefunden = true;
                System.out.println("Name: " + geil.getKey() + ", Nummer: " + geil.getValue());
                break;
            }
        }
        if (!gefunden) {
            System.out.println("Nicht gefunden");
        }
    }
}