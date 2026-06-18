import java.time.LocalDate;

public class Loan {
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public Loan(Member member, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    // Getters (Needed by the Library class to manage returns)
    public Book getBook() { return book; }

    @Override
    public String toString() {
        return "Loan Record -> Member: " + member.getName() + " | Book: " + book.getTitle() + " | Due Date: " + dueDate;
    }
}
