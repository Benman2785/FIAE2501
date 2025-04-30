import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int value = random.nextInt(1,11);
        System.out.println("Ich habe eine Zahl gewaehlt. Errate sie!");

        boolean treffer = false;

        do {
            System.out.print("Zahl raten ");
            int guess = sc.nextInt();
            if (guess == value){
                treffer = true;
            }
        } while (treffer == false);

        System.out.println("Treffer! Zahl war die " + value);
    }
}
