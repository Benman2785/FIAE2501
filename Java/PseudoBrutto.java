import java.util.Scanner;

public class PseudoBrutto {
    public static void main(String[] args) {
        double umsatz = 0;
        double gehalt = 0;
        double bruttogehalt = 0.0;
        int zeit = 0;
        double prozent = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Zeit: ");
        zeit = sc.nextInt();

        System.out.println("Umsatz: ");
        umsatz = sc.nextDouble();
        
        if (zeit < 5) {
            gehalt = 1700.00;
        }
        if (zeit >= 5 && zeit < 10) {
            gehalt = 2100.00;
        }
        if (zeit >= 10) {
            gehalt = 2700.00;
        }
        
        if (umsatz <= 5000) {
            prozent = 10;
            bruttogehalt = gehalt * (1 + (prozent / 100));
        }
        if (umsatz > 5000 && umsatz <= 10000) {
            prozent = 15;
            bruttogehalt = gehalt * (1 + (prozent / 100));
        }
        if (umsatz > 10000) {
            prozent = 23;
            bruttogehalt = gehalt * (1 + (prozent / 100));
        }

        System.out.println(bruttogehalt);
    }
}
