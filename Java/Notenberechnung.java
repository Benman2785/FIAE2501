
import java.util.Scanner;

public class Notenberechnung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Bitte gib Noti ein (1-6): ");
        int eingabe = sc.nextInt();
        
        if (eingabe == 1) {
            System.out.println("Sehr guti!");
        }
        if (eingabe == 2) {
            System.out.println("Gut!");
        }
        if (eingabe == 3) {
            System.out.println("Befriedigend!");
        }
        if (eingabe == 4) {
            System.out.println("Ausreichend!");
        }
        if (eingabe == 5) {
            System.out.println("Mangelhaft!");
        }
        if (eingabe == 6) {
            System.out.println("Ungenuegend!");
        }
        if (eingabe > 6) {  
        System.out.println("So schlecht war noch keiner!");
        } else if (eingabe <= 0){
            System.out.println("So gut war noch keiner!");
        }
    }
}