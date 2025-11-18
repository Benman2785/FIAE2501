import java.util.Scanner;

public class StorageTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 = String | 2 = Integer | 3 = beides");
        int tuWas = sc.nextInt();

        switch (tuWas) {
            case 1 -> testStringStorage();
            case 2 -> testIntegerStorage();
            case 3 -> { testStringStorage(); testIntegerStorage(); }
            default -> System.out.println("Falsche Eingabe");
        }
        sc.close();
    }
    public static void testStringStorage() {
        Storage<String> names = new Storage<>();
        names.addItem("Apfel");
        names.addItem("Banane");
        names.addItem("Kirsche");
        names.addItem("Pflaume");
        names.addItem("Birne");
        names.addItem("Erdbleere");
        names.printAll(); // Ausgabe: Apfel Banane Kirsche 
        System.out.println(names.getItem(1)); // Ausgabe: Banane
        System.out.println(names.getItem(5)); // Ausgabe: null
    }
    public static void testIntegerStorage() {
        Storage<Integer> numbers = new Storage<>();
        numbers.addItem(1);
        numbers.addItem(2);
        numbers.addItem(1337);
        numbers.printAll(); // Ausgabe: 1 2 1337
        System.out.println(numbers.getItem(2)); // Ausgabe: 1337
    }
}