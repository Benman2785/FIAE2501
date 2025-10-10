import java.util.Random;

public class SumAverageArray {
    public static void main(String[] args) {
        Random random = new Random();

        int[] zahlen = new int[10];
        int summe = 0;

        for (int i = 0; i < zahlen.length; i++) {
            int zufall = random.nextInt(1, 101);
            zahlen[i] = zufall;
            summe = summe + zufall;
            System.out.print(zahlen[i] + " ");
        }

        double durchschnitt = (double) summe / zahlen.length;

        System.out.println("Summe: " + summe);
        System.out.println("Durchschnitt: " + durchschnitt);

    }
}
