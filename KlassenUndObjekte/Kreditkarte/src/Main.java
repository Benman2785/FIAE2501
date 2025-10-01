import java.util.Scanner;

public class Main {
    static Input kartennummer = new Input();
    public static void main(String[] args) {
        inputKartenNummer();
        string2array();
    }
    public static void inputKartenNummer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib die Kartennummer ein:");
        kartennummer.setKartenString(sc.nextLine());
        sc.close();
    }
    public static void berechnungPZ(){

    }
    public static void string2array(){
        String eingabe = kartennummer.getKartenString();
        int[] ziffernArray = new int[eingabe.length()];

        for (int i = 0; i < eingabe.length(); i++) {
            char c = eingabe.charAt(i);
            if (Character.isDigit(c)) {
            ziffernArray[i] = Character.getNumericValue(c);
            } else {
            // Wenn kein Digit, z.B. Leerzeichen oder sonstiges, speichere -1 oder 0
            System.out.println("Kartennummer darf NUR Zahlen enthalten");
            }
        }
        kartennummer.setKartenArray(ziffernArray);
    }
}
