//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Author-Object erzeugen
        // Author a1 = new Author("Heinrich", "Berlin");

        Book b1 = new Book("Schuld und Sühne", new Author("Fjodor M.", "Dostojewski", new BirthPlace("Moskau", "119021", 275000)), "ISBN-978-3-7466-3875-1", true);

        // Buch 1 nach Erzeugung
        System.out.println("Buch 1 nach Objekterzeugung:");
        System.out.println( "Titel: " + b1.getTitle() );
        System.out.println( "Autor: " + b1.getAuthor().getName() + " " + b1.getAuthor().getLastName() + ", " + b1.getAuthor().getBirthPlace().getPlz() + " " + b1.getAuthor().getBirthPlace().getOrtsname());
        System.out.println( "ISBN: " + b1.getIsbnNr() );
        System.out.println( "Ausgeliehen:" + b1.getBorrowed() );

   }
}