import java.util.Arrays;
public class BubbleStringSort {
    public static int compareByChars(String a, String b) {
        String s1 = a.toLowerCase();
        String s2 = b.toLowerCase();
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 < c2) return -1;
            if (c1 > c2) return 1;
        }
        // Wenn alle Zeichen bis zur minLength gleich sind, dann nach Länge entscheiden
        if (s1.length() < s2.length()) return -1;
        if (s1.length() > s2.length()) return 1;
        return 0; // komplett gleich
    }
    public static void bubbleSort(String[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (compareByChars(array[j], array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void main(String[] args) {
        String[] words = { "banane", "Apfel", "orange", "KiWiii", "Kiwi" };
        System.out.println("Array ungeordnet: " + Arrays.toString(words));
        bubbleSort(words);
        System.out.println("Array geordnet:   " + Arrays.toString(words));
    }
}