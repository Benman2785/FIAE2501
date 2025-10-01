public class Book {
    // Eigenschaften, Instanzvariablen, Attribute
    private String title;
    private Author author;
    private String isbnNr;
    private boolean borrowed;

    // eigener Konstruktor
    public Book(String title, Author author, String isbnNr, boolean borrowed){
        this.title = title;
        this.author = author;
        this.isbnNr = isbnNr;
        this.borrowed = borrowed;
    }

    // Default-Constructor
    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbnNr() {
        return isbnNr;
    }

    public void setIsbnNr(String isbnNr) {
        this.isbnNr = isbnNr;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
