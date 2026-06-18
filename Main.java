import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Library and Scanner
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // 2. Load some sample initial data so the system isn't blank
        library.addBook(new Book("111", "Java Programming", "John Smith"));
        library.addBook(new Book("222", "Data Structures", "Jane Doe"));
        library.addBook(new Book("333", "The Hobbit")); // Uses the overloaded 2-parameter constructor
        
        library.registerMember(new Member("M01", "Alice"));
        library.registerMember(new Member("M02", "Bob"));

        boolean running = true;

        // 3. Start the text menu loop
        while (running) {
            System.out.println("\n===== COMMUNITY LIBRARY SYSTEM =====");
            System.out.println("1. Add a New Book");
            System.out.println("2. Register a New Member");
            System.out.println("3. Search for a Book by Title");
            System.out.println("4. Lend a Book (Check Out)");
            System.out.println("5. Return a Book");
            System.out.println("6. Print Library Status");
            System.out.println("7. Exit Application");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the text buffer after reading an integer number

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    
                    library.addBook(new Book(isbn, title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    
                    library.registerMember(new Member(memId, name));
                    System.out.println("Member registered successfully!");
                    break;

                case 3:
                    System.out.print("Enter search keyword/title: ");
                    String searchKeyword = scanner.nextLine();
                    library.searchByTitle(searchKeyword);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    String borrowerId = scanner.nextLine();
                    System.out.print("Enter Book ISBN to lend: ");
                    String lendIsbn = scanner.nextLine();
                    
                    library.lendBook(borrowerId, lendIsbn);
                    break;

                case 5:
                    System.out.print("Enter Book ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    
                    library.returnBook(returnIsbn);
                    break;

                case 6:
                    // Prints out the state using the class toString() configurations
                    System.out.println(library.toString());
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection option. Please pick a number from 1 to 7.");
            }
        }
        
        scanner.close(); // Cleanly shutdown the system input utility stream
    }
}
