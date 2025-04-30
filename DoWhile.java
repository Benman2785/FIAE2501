import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eingabe = 0;
        
        do {
            System.out.println("Aufstehen:      Push (1)");
            System.out.println("Kaffee trinken: Push (2)");
            System.out.println("Schlafen        Push (3)");
            System.out.println("Ende            Push (4)");

            System.out.print("Ihre Eingabe bitte ");
            eingabe = sc.nextInt();  
        } 
        while (eingabe > 0 && eingabe < 4);
    }
}
