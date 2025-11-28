import java.util.Arrays;
public class BubbleStringSortPseudo {
    public static int vergleicheZeichenweise(String a, String b) {
        int minLaenge = Math.min(a.length(), b.length());
        for (int i = 0; i < minLaenge; i++) {
            char c1 = a.toLowerCase().charAt(i);
            char c2 = b.toLowerCase().charAt(i);
            if (c1 < c2) {
                return -1;
            }
            if (c1 > c2) {
                return 1;
            }
        }
        if (a.length() < b.length()) {
            return -1;
        }
        if (a.length() > b.length()) {
            return 1;
        }
        return 0;
    }
    public static void bubbleSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean tausch = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (vergleicheZeichenweise(array[j], array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    tausch = true;
                }
            }
            if (!tausch) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        String[] woerter = { "banane", "Apfel", "orange", "KiWiii", "Kiwi" };
        System.out.println("Array ungeordnet: " + Arrays.toString(woerter));
        bubbleSort(woerter);
        System.out.println("Array geordnet:   " + Arrays.toString(woerter));
    }
}