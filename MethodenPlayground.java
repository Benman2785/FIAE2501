
import java.util.Scanner;

public class MethodenPlayground {
    public static Scanner sc = new Scanner(System.in); 
    public static int Linenumber = 0;
    public static int counter = 0;
    // public static String helloWorld(String s, String s2) {
    //     return "**"+s+" "+s2+"**" ;
    // }

    // public static void helloMond() {
    //     System.out.println("Hello Mond");
    // }

    public static void main(String[] args) {
        // helloMond();
        // String bold = helloWorld("Bierchen", "schmeckt lecki");
        // System.out.println(bold);
        System.out.println("Striche oder Sterne?");
        String auswahl = sc.nextLine().toLowerCase();
        
        System.out.println("Was soll ausgeben werden?: ");
        String input = sc.next().toLowerCase();
        Linenumber = input.length() * 3;
        
        if (auswahl.equals("sterne")) {
                System.out.println(stern().repeat((Linenumber * 2)));
                System.out.println(stern().repeat((Linenumber * 2)));
                System.out.println(stern().repeat((Linenumber - ((input.length()/2)))) + input + stern().repeat((Linenumber - ((input.length()/2)))));
                System.out.println(stern().repeat((Linenumber * 2)));
                System.out.println(stern().repeat((Linenumber * 2)));
            } else {
                System.out.println(strich().repeat((Linenumber * 2)));
                System.out.println(strich().repeat((Linenumber * 2)));
                System.out.println(strich().repeat((Linenumber - ((input.length()/2)))) + input + strich().repeat((Linenumber - ((input.length()/2)))));
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


