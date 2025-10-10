import java.util.ArrayList;
import java.util.Random;

public class BiggestSmallestArray {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        Random random = new Random();
        ArrayList<Integer> zahlen = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int zahl = random.nextInt(100)+1;
            zahlen.add(zahl);
            System.out.print(zahl + " ");
            }

        int min = zahlen.get(0);
        int max = zahlen.get(0);

        for (int vergleich : zahlen){
            if (vergleich > max) {
                max = vergleich;
            }
            if (vergleich < min) {
                min = vergleich;
            }
        }
        System.out.println(" ");
        System.out.println("kleinste Zahl: " + min);
        System.out.println("groeßte Zahl: " + max);
    }
}