import java.util.Scanner;

public class TannenbaumZwei {
    public static void main(String[] args) {
        int height = 5;
        Scanner sc = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush();
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

        // Baum zeichnen (eine Schleife)
        for (int i = 0; i < height; i++) {
            String sp = " ".repeat(height - i - 1);
            String st = "*".repeat(2 * i + 1);
            System.out.println(sp + st);
        }
        // Stamm zeichnen (eine Schleife)
        String bs = " ".repeat(height - 1);
        for (int i = 0; i < height / 2; i++) {
            System.out.println(bs + "*");
        }
    }
}
