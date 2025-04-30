import java.util.*;

public class Altersausgabe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alter = 0;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true){
        System.out.print("Bitti gibi Alter an: ");
        
        String eingabe = sc.nextLine();
            if (eingabe.isEmpty()) {
                continue; // Frage erneut stellen, wenn keine Eingabe gemacht wurde
            }
            try {
            alter = Integer.parseInt(eingabe);
            break;
            }
            catch (NumberFormatException exception){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Gibi Alter als Ganzzahli eini!");
            }
        }
    
        if (alter >= 66) {
            System.out.println("Rentner");
        } else if (alter >= 18) {
            System.out.println("Erwachsener");
        } else if (alter >= 13) {
            System.out.println("Teenie");
        } else {
            System.out.println("Kind");
        }
        sc.close();        
    }
}
