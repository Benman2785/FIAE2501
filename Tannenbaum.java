
import java.util.Scanner;

public class Tannenbaum {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        String op = "*";
        int anzahl = 0;

        System.out.println("wieviele Zeilen?");
        anzahl = sc.nextInt();

        for (int i = 0; i <= anzahl; i++){
            System.out.println(op);
        }

    }
}
