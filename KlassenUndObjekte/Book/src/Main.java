

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Der Fänger im Roggen",new Author("J.D. Salinger","Buch"),"978-3-499-23539-9",true);
        Book b2 = new Book("Der Zauberberg",new Author("Thomas Mann","Berlin"),"978-3-596-29433-6",false);
        Book b3 = new Book("Im Westen nichts Neues",new Author("Erich Maria Remarque","Potsdam"),"978-3-596-29433-6",true);

        System.out.println("Buch 1: " + b1.getTitle() + ", " + b1.getAuthor().getName() + ", " + b1.getISBN() + ", " + b1.getAusgl());
        System.out.println("Buch 2: " + b2.getTitle() + ", " + b2.getAuthor().getName() + ", " + b2.getISBN() + ", " + b2.getAusgl());
        System.out.println("Buch 3: " + b3.getTitle() + ", " + b3.getAuthor().getName() + ", " + b3.getISBN() + ", " + b3.getAusgl());
    }
}