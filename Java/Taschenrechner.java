
public class Taschenrechner {
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    static double Zahl1 = 0;
    static int Zahl1int = 0;
    static double Zahl2 = 0;
    static int Zahl2int = 0;
    static double Ergebnis = 0;
    static int Ergebnisint = 0;
    public static void main(String[] args) {
        cls();
        menu();
    }
    public static void menu() {
        String Wahl = "a";
        System.out.println("""
        Mein Taschenrechner
        -------WÄHLE-------
        (A)ddition
        (S)ubtraktion
        (M)ultiplikation
        (D)ivision
        (E)nde
        """);
        Wahl = sc.nextLine();
        if (Wahl.equalsIgnoreCase("a")){
            cls();
            addition();
        } else if (Wahl.equalsIgnoreCase("s")) {
            cls();
            subtraction();
        } else if (Wahl.equalsIgnoreCase("m")) {
            cls();
            multiplication();
        } else if (Wahl.equalsIgnoreCase("d")) {
            cls();
            division();
        } else if (Wahl.equalsIgnoreCase("e")) {
            cls();
            exit();
        } else {
            cls();
            menu();
        }

            }
    public static void input() {
        System.out.print("Bitte gebe Zahl 1 ein: "); 
        Zahl1 = sc.nextDouble();
        System.out.println("");
        System.out.print("Bitte gebe Zahl 2 ein: "); 
        Zahl2 = sc.nextDouble();
        System.out.println("");
    }
    public static void addition() {
        input();
        if (Zahl1 == Math.floor(Zahl1) && Zahl2 == Math.floor(Zahl2)) {
            Zahl1int = (int) Zahl1;
            Zahl2int = (int) Zahl2;
            Ergebnisint = Zahl1int + Zahl2int;
            System.out.println(Zahl1int + " + " + Zahl2int + " = " + Ergebnisint);
        } else {
            Ergebnis = Zahl1 + Zahl2;
            System.out.println(Zahl1 + " + " + Zahl2 + " = " + Ergebnis);
        }      
    }
        public static void subtraction() {
        input();
        if (Zahl1 == Math.floor(Zahl1) && Zahl2 == Math.floor(Zahl2)) {
            Zahl1int = (int) Zahl1;
            Zahl2int = (int) Zahl2;
            Ergebnisint = Zahl1int - Zahl2int;
            System.out.println(Zahl1int + " - " + Zahl2int + " = " + Ergebnisint);
        } else {
            Ergebnis = Zahl1 - Zahl2;
            System.out.println(Zahl1 + " - " + Zahl2 + " = " + Ergebnis);
        }  

    }
    public static void multiplication() {
        input();
        if (Zahl1 == Math.floor(Zahl1) && Zahl2 == Math.floor(Zahl2)) {
            Zahl1int = (int) Zahl1;
            Zahl2int = (int) Zahl2;
            Ergebnisint = Zahl1int * Zahl2int;
            System.out.println(Zahl1int + " * " + Zahl2int + " = " + Ergebnisint);
        } else {
            Ergebnis = Zahl1 + Zahl2;
            System.out.println(Zahl1 + " * " + Zahl2 + " = " + Ergebnis);
        }  
    }
    public static void division() {
        input();
        if (Zahl2 == 0) {
            System.out.println("Division durch 0 nicht erlaubt");
        }
        if (Zahl1int == Math.floor(Zahl1) && Zahl2int == Math.floor(Zahl2)) {
            Zahl1 = (int) Zahl1int;
            Zahl2 = (int) Zahl2int;
        }
        Ergebnis = Zahl1 / Zahl2;
        System.out.println(Zahl1 + " / " + Zahl2 + " = " + Ergebnis);
    }
    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void exit() {
        System.out.println("Programm wird beendet");
        sc.close();
        System.exit(0);
        }

}
