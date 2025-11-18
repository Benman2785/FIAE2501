public class Book {
    private String title;
    private Author author;
    private String isbn;
    private boolean ausgl;
    private String status;

// Constructor
public Book(String title, Author author, String isbn, boolean ausgl){
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.ausgl = ausgl;
}

// setter
public void setTitle(String title){
    this.title = title;
    }
public void setAuthor(Author author){
    this.author = author;
    }
public void setISBN(String isbn){
    this.isbn = isbn;
    }
public void setAusgl(boolean ausgl){
    this.ausgl = ausgl;
    }
// getter
public String getTitle(){
    return title;
    }
public Author getAuthor(){
    return author;
    }
public String getISBN(){
    return isbn;
    }
public String getAusgl(){
        if (ausgl == true){
            return status = "ausgeliehen";
        } else {
            return status = "verfügbar";
        }
    }
}
