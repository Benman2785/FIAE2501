public class Quersumme {
    static int zahl = 0;
    static int qsum = 0;
    static int mod = 0;
    static String input = "";
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Gib eine Zahl ein: ");
        Input();
        Quersumme();
        System.out.println("Eingegebene Zahl: " + Integer.parseInt(input));
        System.out.println("Quersumme: " + qsum);
        System.out.println("ZMod: " + mod);
    }
    static void Input() {
        while (true) {
        input = sc.nextLine();
        try {
            zahl = Integer.parseInt(input);
            break;
        } catch (NumberFormatException e) {
            System.out.println("Gib eine ZAHL ein: ");
        }
        }
    }
    static void Quersumme() {
        int zahl2 = zahl;
        for (int i = 0; i < input.length(); i++) {
            if (input.matches("[0-9]+")) {
            mod = zahl % 10;
            zahl = zahl / 10;
            qsum += mod;
            } else {
            qsum = zahl;
            }
        }
        mod = zahl2 % 10 + zahl2;
    }
}
