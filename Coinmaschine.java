
import java.util.Scanner;

public class Coinmaschine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Wieviel gibi Gelt?: ");
        double geld = sc.nextDouble();
        int cent = (int)(geld * 100);
        
        System.out.println("2 Euro: " + (cent/200));
        cent = cent % 200;
        System.out.println("1 Euro: " + (cent/100));
        cent = cent % 100;
        System.out.println("50 Cent: " + (cent/50));
        cent = cent % 50;
        System.out.println("20 Cent: " + (cent/20));
        cent = cent % 20;
        System.out.println("10 Cent: " + (cent/10));
        cent = cent % 10;
        System.out.println("5 Cent: " + (cent/5));
        cent = cent % 5;
        System.out.println("2 Cent: " + (cent/2));
        cent = cent % 2;
        System.out.println("1 Cent: " + (cent));
    }
}
