
import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        // Scanner erstellen
        Scanner sc = new Scanner(System.in);
        // cls
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-=]/°\\[=- BMI Rechner -=]/°\\[=-");
        // Datenabfrage
        System.out.print("Gib dein Groesse in m (zB 1,81) an: ");
        float groesse = sc.nextFloat();
        System.out.print("Gib dein Gewicht in kg (zB 79,5) an: ");
        float gewicht = sc.nextFloat();
        // Rechnung
        float BMI = (gewicht / (groesse * groesse));
        // Ausgabe
        if (BMI >= 30) {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Asi-Podi-das! %n", BMI);
        } else if (BMI >= 25.4) {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Uebergewicht! %n", BMI);
        } else if (BMI >= 18.5) {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Normalgewicht! %n", BMI);
        } else {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Untergewicht! %n", BMI);
        }
        // Scanner schliessen
        sc.close();
    }
}
