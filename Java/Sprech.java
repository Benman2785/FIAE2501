import java.util.Scanner;

public class Sprech {
    public static void main(String[] args) {
        
        boolean Ausgabe = true;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitti gibi Texti: ");
        String Txt = sc.nextLine();
        
        if (Txt.length() < 1) {
            Ausgabe = false;
        } else if (Txt.length() > 10) {
                Txt = Txt.substring(0, 10);
        } else {
                Txt = String.format("%-10s", Txt);
        }
        if (Ausgabe == false) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Java fetzt");
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("   *************   ");
            System.out.println(" *               * ");
            System.out.println("*   " + Txt + "   *");
            System.out.println(" *              *  ");
            System.out.println("  *     *******    ");
            System.out.println("    * *            ");
            System.out.println("     *             ");
            }
    }    
}
