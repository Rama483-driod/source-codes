import java.util.ArrayList;
import java.time.LocalDate;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<Book>();
        this.members = new ArrayList<Member>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void searchByTitle(String title) {
        System.out.println("--- Search Results for '" + title + "' ---");
        boolean foundAny = false;
        
        for (Book b : books) {
            // Converts text to lowercase to make search case-insensitive and beginner-friendly
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(b.toString());
                foundAny = true;
            }
        }
        
        if (!foundAny) {
            System.out.println("No matching books found in our catalog.");
        }
    }

    private Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b; // Found it! Exit loop early
            }
        }
        return null; // Book does not exist in our library list
    }

    private Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getMemberId().equals(id)) {
                return m; // Found them! Exit loop early
            }
        }
        return null; // Member does not exist in our system list
    }

    public boolean lendBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("[REJECTED] Book not found."); 
            return false;
        }
        if (member == null) {
            System.out.println("[REJECTED] Member not found."); 
            return false;
        }
        if (!book.isAvailable()) {          // <-- Strict business rule enforced
            System.out.println("[REJECTED] '" + book.getTitle() + "' is already on loan.");
            return false;
        }

        LocalDate today = LocalDate.now();
        Loan loan = new Loan(member, book, today, today.plusWeeks(2)); // Standard 2-week loan time
        
        book.setAvailable(false); // Flip flag to protect the book from dual checkout attempts
        member.addLoan(loan);     // Register the transaction entry to the user profile
        
        System.out.println("[OK] Lent: " + book.getTitle() + " to " + member.getName());
        return true;
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        
        // Edge Case Protection: Check if book is missing or not even checked out
        if (book == null || book.isAvailable()) { 
            System.out.println("[REJECTED] Book is already available or not found in system.");
            return false; 
        }

        for (Member m : members) {
            // Creating a temporary list copy ensures we can loop and delete entries without errors
            ArrayList<Loan> temporaryListCopy = new ArrayList<Loan>(m.getLoans());
            for (Loan l : temporaryListCopy) {
                if (l.getBook().getIsbn().equals(isbn)) {
                    m.removeLoan(l);          // Clear from customer tracking record
                    book.setAvailable(true);  // Reset database lock state
                    System.out.println("[OK] Returned: " + book.getTitle());
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Library Status: " + books.size() + " total books, " + members.size() + " total members.";
    }
}
