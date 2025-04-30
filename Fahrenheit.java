import java.util.Scanner;

    public class Fahrenheit {
        public static void main(String[] args) {
            // Scanner für Dateneingabe + Vars
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Scanner sc = new Scanner(System.in);
            System.out.print("Temperatur in Celsius: ");
            double celsius = sc.nextDouble();
            double Fahrenheit = (celsius * 9 / 5 + 32);
            System.out.println("Temperatur in Fahrenheit: " + Fahrenheit);
            sc.close();
        }
}
