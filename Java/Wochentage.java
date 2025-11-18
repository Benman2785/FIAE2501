import java.util.ArrayList;

public class Wochentage {
    public static void main(String[] args) {
        ArrayList<String> wotaArray = new ArrayList<>();

        wotaArray.add( "Montag");
        wotaArray.add("Dienstag");
        wotaArray.add("Mittwoch");
        wotaArray.add("Donnerstag");
        wotaArray.add("Freitag");
        wotaArray.add("Samstag");
        wotaArray.add("Sonntag");

        System.out.println(wotaArray.get(0) + ", " + wotaArray.get(1) + ", " + wotaArray.get(2) + ", " + wotaArray.get(3) + ", " + wotaArray.get(4) + ", " + wotaArray.get(5) + ", " + wotaArray.get(6)); 

        for (int i = 0; i < wotaArray.size() -1; i++) {
            System.out.print(wotaArray.get(i) + ", ");
        }
        System.out.print(wotaArray.get(wotaArray.size() -1));
    }
}
