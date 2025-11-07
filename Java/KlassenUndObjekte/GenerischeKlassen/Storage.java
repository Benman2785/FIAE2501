import java.util.ArrayList;
public class Storage<T> {
    private ArrayList<T> items;
    private static final int MAX_SIZE = 5;
    // Konstruktor
    public Storage() {
        items = new ArrayList<>();
    }
    // Element hinzufügen
    public void addItem(T item) {
        if (items.size() < MAX_SIZE) {
            items.add(item);
        } else {
            System.out.println("Speicher ist voll");
        }
    }
    // Element abrufen
    public T getItem(int index) {
        if (index >= 0 && index < MAX_SIZE) {
            return items.get(index);
        } else {
            return null;
        }
    }
    // Alle Elemente ausgeben
    public void printAll() {
        for (T i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}