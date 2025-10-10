public class Eva {
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    static float bpreis = 0;
    static float npreis = 0;
    static float uppreis = 0;
    static float satz = 0;
    static float upsatz = 0;
    public static void main(String[] args) {
        eingabe();
        verarbeitung();
        ausgabe();
        ausgabe2();
    }
    public static void eingabe() {
        clear();
        System.out.print("Bitte gebe den Preis ein: "); 
        bpreis = sc.nextFloat();
        System.out.println("");
        System.out.print("Bitte gebe den Steuersatz ein: "); 
        satz = sc.nextFloat();
        System.out.println("");
    }
    public static void verarbeitung() {
        float nsatz = (1 + (satz / 100f));     
        npreis = bpreis * nsatz;
    }
    public static void ausgabe() {
        clear();
        System.out.println("************************************************");
        System.out.println("Betrag: " + bpreis + " ==> Netto: " + String.format("%.2f", npreis));
        System.out.println("************************************************");
    }
    public static void ausgabe2() {
        System.out.println("ZUSATZAUFGABE");
        for (int i = 0; i <= satz; i++) {
            upsatz = i;
            uppreis = (bpreis / 100 * i);
            float netto = bpreis + uppreis;
            System.out.println("************************************************");
            System.out.println("Betrag: " + bpreis + " MwSt: " + upsatz + " ==> Netto: " + String.format("%.2f", netto));
        }
        System.out.println("************************************************"); 
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
}