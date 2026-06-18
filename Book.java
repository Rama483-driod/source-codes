public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    // Constructor 1: If we only know ISBN and Title
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = "Unknown"; // Default fallback
        this.available = true;   // Available by default
    }

    // Constructor 2: Overloaded to include Author
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (ISBN: " + isbn + ") - Status: " + 
               (available ? "Available" : "On Loan");
    }
}
