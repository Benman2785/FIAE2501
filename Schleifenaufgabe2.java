import java.util.ArrayList;
import java.util.Scanner;
public class Schleifenaufgabe2 {
    public static void main(String[] args) {
        ArrayList<Integer> zahlen = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int min = 0;
        int max = 0;
        System.out.print("\033[H\033[2J");
        System.out.flush();

        do {
            if (min == max) {
            System.out.println("bitti unterschiedlichi Zahli eingebi");
            System.out.print("min: ");
            min = sc.nextInt();
            System.out.print("max: ");
            max = sc.nextInt();
        }} while (max == min);
        if (min > max) {
            System.out.println("min groessi als max - Korrekturi");
            int min2 = min;
            int max2 = max;
            max = min2;
            min = max2;            
        }
        for (int i = min; i <= max; i++) {
            zahlen.add(i);
        }
        int summe = 0;    
        for (int y = 0; y < zahlen.size(); y++) {
            summe = zahlen.get(y) % 3;
            if (summe == 0) {
           System.out.print(zahlen.get(y) + " ");
        }}
        sc.close();
    }
}