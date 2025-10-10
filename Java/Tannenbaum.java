import java.util.Scanner;

public class Tannenbaum {
    public static void main(String[] args) {
        int height = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Eingabe der Höhe des Baumes
        System.out.println("Willkommen zum Tannenbaum-Generator!");
        System.out.print("Geben Sie die Höhe des Baumes ein (Standard ist 5): ");
        String input = sc.nextLine();
        if (!input.isEmpty()) {
            try {
                height = Integer.parseInt(input);
                if (height < 1) {
                    System.out.println("Die Höhe muss größer als 0 sein. Standardwert 5 wird verwendet.");
                    height = 5;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Standardwert 5 wird verwendet.");
                height = 5;
            }
        }
        sc.close();

        // Baum zeichnen
        for (int i = 0; i < height; i++) {
            // Leerzeichen vor dem Baum
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            // Baumsterne
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Stamm zeichnen
        for (int i = 0; i < height / 4; i++) {
            for (int j = 0; j < height - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}