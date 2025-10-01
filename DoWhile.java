import java.util.*;
public class Dowhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eingabe = 0;

        do {
        System.out.println("1 - Aufstehen");
        System.out.println("2 - Kaffee trinken");
        System.out.println("3 - Schlafen");
        System.out.println("4 - Ende");

        System.out.print("Ihre Eingabe: ");
        eingabe = sc.nextInt();
        if (eingabe == 1) {
            System.out.println("KIKERIKI!!!");
            // break;
        } else if (eingabe == 2) {
            System.out.println("ECHT JETZT! SO RICHTIG HEISSER SCHWARZER KAFFEE JUNGE!");
            // break;
        } else if (eingabe == 3) {
            System.out.println("Schaefchen zaehlen! JETZT!");
            // break;
        }
        } while (eingabe > 0 && eingabe < 4);
    }
}
