import java.util.Scanner;

public class Pruefziffer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte 16-stellige Nummer eingeben: ");
      
        String[] numbers = scanner.nextLine().split("");

        int summe = 0;

        for (int i = 0; i < numbers.length-1; i++) {
            int zahl = toInt(numbers[i]);

            if (i % 2 == 0){
                zahl = zahl *2;
            }

            summe = summe + querSumme(zahl);
        }

        int pz = 10 - (summe % 10);

        if (pz == 10){
            pz = 0;
        }

        if (pz == toInt(numbers[15])){
            System.out.println("Gueltig");
        }
        else{
            System.out.println("Ungueltig");
        }



    }// Ende main

    public static int querSumme(int zahl) {
        int summe = 0;
        while (zahl > 0) {
            summe += zahl % 10;
            zahl /= 10;
        }
        return summe;
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}
