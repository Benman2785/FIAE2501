
import java.util.*;
public class HashMapWort {
    public static void main(String[] args) {
        HashMap<String, Integer> wortcount = new HashMap<>();
        HashMap<Integer, String[]> countwort = new HashMap<>();
        ArrayList<String> liste = new ArrayList<>();
        String text = """
                Heuste ist ein wunderschöner Tag. Heute scheint die Sonne und der Tag ist wirklich wunderschön.
                """;
        String[] woerter = text.toLowerCase().replaceAll("[.,]", "").split(" ");
        for (String wort : woerter){
            liste.add(wort);
            if (wortcount.containsKey(wort)){
               wortcount.put(wort, wortcount.get(wort) + 1);
            } else {
                wortcount.put(wort, 1);
            }
        }
        for (HashMap.Entry<String, Integer> eintrag : wortcount.entrySet()){
            countwort.put(eintrag.getValue(), liste[]);
        }
        System.out.println(liste);
        System.out.println(wortcount);
        System.out.println(countwort);
    }   
}