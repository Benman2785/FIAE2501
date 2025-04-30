import java.util.Random;
import java.util.Scanner;

public class Zahlenrate2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int value = random.nextInt(1,11);
        System.out.println("Ich habe eine Zahl gewaehlt. Errate sie!");


        /*
        WICHTIG: 
        - Variable guess muss VOR der do-while deklariert werden. 
        - innerhalb von do ist nicht ausreichend
        - dann ist guess fuer die while bedingung nicht bekannt
        */
        int guess; 

        do {
            System.out.print("Zahl raten ");
            guess = sc.nextInt();
    
        } while (value != guess);

        System.out.println("Treffer! Zahl war die " + value);
    }
}