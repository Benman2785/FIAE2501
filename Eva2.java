import java.util.Scanner;
 
public class eva2 {
 
    public static void main(String[] args) {
        int preis;
        eingabe(preis);
        verarbeitung();
        ausgabe();
    }
   
    public static int eingabe(int preis) {
        Scanner sc = new Scanner(System.in);
        preis = sc.nextInt();
        return preis;
    }
    static void verarbeitung( ) {
        int preis2;
        int mws;
        int endpreis;
        preis2 = eingabe(preis);
 
        mws = preis2 / 100 * 19;
        endpreis = preis2
    }
 
 
    static void ausgabe() {
        System.out.println("Der betrag ist: " + eingabe(preis) + " Netto :  "verarbeitung(0, 0));
       
 
    }
}