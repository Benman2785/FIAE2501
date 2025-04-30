import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.print("Bitte PW eingeben. Min 8 Zeichen ");
            input = sc.nextLine();
            
            if (input.length() < 8){
                System.out.println("PW zu kurz");
            }
           
          

        } while (input.length() < 8);

        System.out.println("Glueckwunsch! Super Password!");
    }
}