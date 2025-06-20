public class Ohm {

    static double resi = 0;
    static double volt = 0;
    static double ampe = 0;
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        menu();    
    }
    static void menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Ohmsches Gesetz");
        System.out.println("---------------");
        System.out.println("Wide(R)stand berechnen");
        System.out.println("Spann(U)ng berechnen");
        System.out.println("Stromstärke (I) berechnen");
        System.out.print("wähle: ");
        char input = sc.next().toUpperCase().charAt(0);
        if (input != 'R' && input != 'U' && input != 'I' && input != 'B') {
            menu();
        } else {
        switch (input) {
            case 'R':
                System.out.println("Widerstand berechnen:");
                System.out.print("Volt: ");
                volt = sc.nextDouble();
                System.out.printf("\n");
                System.out.print("Ampere: ");
                ampe = sc.nextDouble();
                System.out.printf("\n");
                resi();
                break;
            case 'U':
                System.out.println("Spannung berechnen:");
                System.out.print("Ohm: ");
                resi = sc.nextDouble();
                System.out.printf("\n");
                System.out.print("Ampere: ");
                ampe = sc.nextDouble();
                System.out.printf("\n");
                volt();
                break;
            case 'I':
                System.out.println("Stromstärke berechnen");
                System.out.print("Ohm: ");
                resi = sc.nextDouble();
                System.out.printf("\n");
                System.out.print("Ampere: ");
                ampe = sc.nextDouble();
                System.out.printf("\n");
                curr();
                break;
            case 'B':
                System.out.println("Programm wird beendet...");
                exit();
                break;                
            default:
                throw new AssertionError();
        }}
    }
    static void resi() {
        resi = (volt / ampe);
        System.out.println("Formel: R = U / I");
        System.out.println("Widerstand: " + resi);
    }
    static void volt () {
        volt = (resi / ampe);
        System.out.println("Formel: U = R / I");
        System.out.println("Spannung: " + volt);
    }
    static void curr() {
        ampe = (volt / resi);
        System.out.println("Formel: I = U / R");
        System.out.println("Stromstärke: " + ampe);
    }
    static void exit() {
        System.exit(0);
    }
}
