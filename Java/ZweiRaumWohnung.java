
import java.util.*;

public class ZweiRaumWohnung {
    public static void main(String[] args) {
    // Scanner für Dateneingabe
        Scanner sc = new Scanner(System.in);
    // CLS in Console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    // Programm gestartet und Datenabfrage
        System.out.println("-=[  ZweiRaumWohnung gestartet   ]=-");
        System.out.print("Breite des Wohnzimmers (zB 6,3): ");
    // Dateneingabe via scanner als Double in var
        double WZ = sc.nextDouble();
        System.out.print("Länge des Wohnzimmers (zB 4,0): ");
        double LWZ = sc.nextDouble();
        System.out.print("Breite des Schlafzimmers (zB 3,4): ");
        double SZ = sc.nextDouble();
        System.out.print("Länge des Schlafzimmers (zB 4,0): ");
        double LSZ = sc.nextDouble(); 

    // Berechnungen der Werte durch Variablen
        double WZF = WZ * LWZ;
        double SZF = SZ * LSZ;
        double WF = ((WZ * LWZ) + (SZ * LSZ));
    // Strings um Code zu minimieren
        String einheit = "m²";
        String fl = "Flaeche";

    // Ausgabe}{}
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-=[  Berechnung der Wohnflaeche  ]=-");
    // %.2f = double mit 2 Stellen ; %s = String nach Reihnenfolge der Variablen ; %n = neue Zeile
        System.out.printf("   %s Wohnzimmer:    %.2f%s%n", fl, WZF, einheit);
        System.out.printf("   %s Schlafzimmer:  %.2f%s%n", fl, SZF, einheit);
        System.out.printf("   %s der Wohnung:   %.2f%s%n", fl, WF, einheit);
        System.out.println("-=[       Programm beendet       ]=-");
    }
}