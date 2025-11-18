import java.util.ArrayList;
import java.util.Random;

public class SumAverage {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        ArrayList<Integer> zahlen = new ArrayList<>();
        int sum = 0;
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int zahl = random.nextInt(100)+1;
            zahlen.add(zahl);
            System.out.print(zahl + " ");
            sum = sum + zahl;
            }

        double avg = (double)sum / 10;
        System.err.println(" ");
        System.out.println("Summe: " + sum);
        System.out.println("Durschnitt: " + avg);
        }}