import java.util.Arrays;

public class Fragezeichen {

    public static void frageZeichenFunktion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;

            // Elemente, die größer als element sind, um eine Position nach rechts schieben
            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j];
                j--;
            }

            // element an der richtigen Stelle einsetzen
            arr[j + 1] = element;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 4, 1, 12};
        frageZeichenFunktion(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
