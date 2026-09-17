import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. View Issued Books");
            System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    System.out.println("\n----- ADD BOOK -----");

                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();

                    if (!Validation.isValidId(bookId)) {
                        System.out.println("Book ID cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    if (Validation.isEmpty(title)) {
                        System.out.println("Book title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();

                    if (Validation.isEmpty(author)) {
                        System.out.println("Author name cannot be empty.");
                        break;
                    }

                    Book book = new Book(bookId, title, author);

                    library.addBook(book);

                    break;

                case "2":

                    library.viewBooks();

                    break;

                case "3":

                    System.out.print("\nEnter Book ID, Title or Author: ");

                    String keyword = scanner.nextLine();

                    library.searchBook(keyword);

                    break;

                case "4":

                    System.out.print("\nEnter Book ID to remove: ");

                    String removeId = scanner.nextLine();

                    library.removeBook(removeId);

                    break;

                case "5":

                    System.out.println("\n----- ADD MEMBER -----");

                    System.out.print("Enter Member ID: ");

                    String memberId = scanner.nextLine();

                    if (!Validation.isValidId(memberId)) {
                        System.out.println("Member ID cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Member Name: ");

                    String memberName = scanner.nextLine();

                    if (Validation.isEmpty(memberName)) {
                        System.out.println("Member name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Phone Number: ");

                    String phone = scanner.nextLine();

                    if (!Validation.isValidPhone(phone)) {
                        System.out.println("Phone number must contain exactly 10 digits.");
                        break;
                    }

                    Member member = new Member(
                            memberId,
                            memberName,
                            phone
                    );

                    library.addMember(member);

                    break;

                case "6":

                    library.viewMembers();

                    break;

                case "7":

                    System.out.println("\n----- ISSUE BOOK -----");

                    System.out.print("Enter Book ID: ");

                    String issueBookId = scanner.nextLine();

                    System.out.print("Enter Member ID: ");

                    String issueMemberId = scanner.nextLine();

                    library.issueBook(
                            issueBookId,
                            issueMemberId
                    );

                    break;

                case "8":

                    System.out.println("\n----- RETURN BOOK -----");

                    System.out.print("Enter Book ID: ");

                    String returnBookId = scanner.nextLine();

                    library.returnBook(returnBookId);

                    break;

                case "9":

                    library.viewIssuedBooks();

                    break;

                case "10":

                    System.out.println("\nThank you for using the Library Management System.");

                    scanner.close();

                    return;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
