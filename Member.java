import java.util.ArrayList;

public class Member {
    private String memberId;
    private String name;
    private ArrayList<Loan> loans; // A simple list to hold this member's loans

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.loans = new ArrayList<Loan>(); // Initialize the list
    }

    // Methods to add or remove loans for this specific member
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public ArrayList<Loan> getLoans() { return loans; } // Simple beginner getter

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ") | Active Loans: " + loans.size();
    }
}
