import java.util.*;

public class Alter{
    public static void main(String[] args) {
            // Scanner für Dateneingabe + Vars
            int aktjahr = 2025;
            Scanner sc = new Scanner(System.in);
            // CLS in Console
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // Programm gestartet und Datenabfrage
            System.out.println("-=[ ^o^ ]=-");
            System.out.print("Geburtsjahr: ");
            // Dateneingabe via scanner als int in var
            int gebjahr = sc.nextInt();
            // Berechnungen der Werte durch Variablen
            int alter = aktjahr - gebjahr;
            // Ausgabe}{}
            System.out.println("Alter in Jahren: " + alter);
            System.out.println("-=[ Programm beendet ]=-");
            sc.close();
    }
}

 