public class LibraryDemo {
  public static void main(String[] args) {
    Library library = new Library();

    Member alice = new Member("M001", "Alice Nakato");
    Member bob   = new Member("M002", "Bob Ssekandi");
    library.registerMember(alice);
    library.registerMember(bob);

    Book b1 = new Book("ISBN-001", "Things Fall Apart");
    Book b2 = new Book("ISBN-002", "Weep Not, Child", "Ngugi wa Thiong'o");
    Book b3 = new Book("ISBN-003", "Arrow of God",    "Chinua Achebe");
    library.addBook(b1); library.addBook(b2); library.addBook(b3);

    System.out.println(library);  // State BEFORE

    library.lendBook("ISBN-001", "M001");  // OK
    library.lendBook("ISBN-002", "M002");  // OK
    library.lendBook("ISBN-003", "M001");  // OK
    library.lendBook("ISBN-001", "M002");  // REJECTED – already on loan

    System.out.println(library);  // State AFTER

    library.returnBook("ISBN-001");          // Return
    library.lendBook("ISBN-001", "M002");   // Now succeeds
  }
}