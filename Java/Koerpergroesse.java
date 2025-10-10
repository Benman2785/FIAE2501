import java.util.Scanner;

public class Koerpergroesse {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        Scanner sc = new Scanner(System.in);
        int KoGro = 0; // muss deklariert und definiert werden
        
        while (true) {
            System.out.print("Gib deine Koerpergroesse in cm an: ");
            
            // Lese die Eingabe als String damit der "nur ENTER Fall" berücksichtigt werden kann
            String eingabe = sc.nextLine();
            
            // Überprüfen, ob die Eingabe leer ist
            if (eingabe.isEmpty()) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                continue; // Frage erneut stellen, wenn keine Eingabe gemacht wurde
            }
            
            try {
                KoGro = Integer.parseInt(eingabe); // Eingabe als Integer zu parsen
                
                if (KoGro <= 0) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Koerpergroeße ist IMMER positiv - sonst IST man nicht...");
                } else {
                    break; // Gültige Eingabe, also Schleife verlassen
                }
            } catch (NumberFormatException e) {
                // Fehler, falls die Eingabe keine Zahl war
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Ungueltigi Eingabi.");
            }
        }
        
        if (KoGro >= 190) {
            System.out.println("Sie sind mit " + KoGro + "cm sehr groß.");
        } else if (KoGro < 160) {
            System.out.println("Sie sind mit " + KoGro + "cm SEHR kleini.");
        } else if (KoGro >= 160 && KoGro <= 190) {
            System.out.println("Mit der Koerpergroesse von " + KoGro + "cm haben Sie eine Durchschnittsgroesse.");
        }
        
        sc.close();
    }
}
