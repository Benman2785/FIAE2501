
import java.util.Scanner;

public class Strich_Stern_Eingabe {
    public static Scanner sc = new Scanner(System.in); 
    public static int Linenumber = 0;
    public static int counter = 0;
    public static int xe = 0;
    public static void main(String[] args) {
        System.out.println("Striche oder Sterne?");
        String auswahl = sc.nextLine().toLowerCase();
        
        System.out.println("Was soll ausgeben werden?: ");
        String input = sc.next().toLowerCase();
        Linenumber = (input.length() * 2);
        if (input.length() % 2 == 0){
            xe = 0;    
        } else {
            xe = 1;
        }
        if (auswahl.equals("sterne")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(stern().repeat((Linenumber * 2)));
                System.out.println(stern().repeat((Linenumber * 2)));
                System.out.println(stern().repeat((Linenumber - ((input.length()/2)+xe))) + input + stern().repeat((Linenumber - ((input.length()/2)))));
                System.out.println(stern().repeat((Linenumber * 2)));
                System.out.println(stern().repeat((Linenumber * 2)));
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(strich().repeat((Linenumber * 2)));
                System.out.println(strich().repeat((Linenumber * 2)));
                System.out.println(strich().repeat((Linenumber - ((input.length()/2)+xe))) + input + strich().repeat((Linenumber - ((input.length()/2)))));
                System.out.println(strich().repeat((Linenumber * 2)));
                System.out.println(strich().repeat((Linenumber * 2)));
            }
    }
    public static String stern () {
        return "*";
    }
    public static String strich () {
        return "-";
    }
}
