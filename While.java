import java.util.*;
public class While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int eingabe = 1;

        while (eingabe <= 3 && eingabe > 0){
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
            } else if (eingabe <= 0) {
                System.out.println("zu dumm das Menue zu verstehen?");
                eingabe = 1;
            } else if (eingabe > 4) {
                System.out.println("zu dumm das Menue zu verstehen?");
                eingabe = 1;
            }
        }
    }
}
