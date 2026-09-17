import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;
    private List<IssueRecord> issueRecords;

    public Library() {

        books = FileManager.loadBooks();
        members = FileManager.loadMembers();
        issueRecords = FileManager.loadIssueRecords();
    }

    // ================= BOOK MANAGEMENT =================

    public void addBook(Book book) {

        if (findBook(book.getBookId()) != null) {
            System.out.println("Book ID already exists.");
            return;
        }

        books.add(book);

        FileManager.saveBooks(books);

        System.out.println("Book added successfully.");
    }

    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n========== BOOK LIST ==========");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(keyword)
                    || book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found.");
        }
    }

    public void removeBook(String bookId) {

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Cannot remove an issued book.");
            return;
        }

        books.remove(book);

        FileManager.saveBooks(books);

        System.out.println("Book removed successfully.");
    }

    // ================= MEMBER MANAGEMENT =================

    public void addMember(Member member) {

        if (findMember(member.getMemberId()) != null) {
            System.out.println("Member ID already exists.");
            return;
        }

        members.add(member);

        FileManager.saveMembers(members);

        System.out.println("Member registered successfully.");
    }

    public void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        System.out.println("\n========== MEMBER LIST ==========");

        for (Member member : members) {
            System.out.println(member);
        }
    }

    // ================= ISSUE BOOK =================

    public void issueBook(String bookId, String memberId) {

        Book book = findBook(bookId);
        Member member = findMember(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.setAvailable(false);

        IssueRecord record = new IssueRecord(bookId, memberId);

        issueRecords.add(record);

        FileManager.saveBooks(books);
        FileManager.saveIssueRecords(issueRecords);

        System.out.println("Book issued successfully.");
    }

    // ================= RETURN BOOK =================

    public void returnBook(String bookId) {

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("This book is not currently issued.");
            return;
        }

        IssueRecord recordToRemove = null;

        for (IssueRecord record : issueRecords) {

            if (record.getBookId().equalsIgnoreCase(bookId)) {
                recordToRemove = record;
                break;
            }
        }

        if (recordToRemove != null) {

            issueRecords.remove(recordToRemove);

            book.setAvailable(true);

            FileManager.saveBooks(books);
            FileManager.saveIssueRecords(issueRecords);

            System.out.println("Book returned successfully.");

        } else {

            System.out.println("Issue record not found.");
        }
    }

    // ================= VIEW ISSUE RECORDS =================

    public void viewIssuedBooks() {

        if (issueRecords.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }

        System.out.println("\n========== ISSUED BOOKS ==========");

        for (IssueRecord record : issueRecords) {

            Book book = findBook(record.getBookId());
            Member member = findMember(record.getMemberId());

            System.out.println(
                    "Book: " + book.getTitle()
                            + " | Member: " + member.getName()
                            + " | Book ID: " + record.getBookId()
                            + " | Member ID: " + record.getMemberId()
            );
        }
    }

    // ================= SEARCH METHODS =================

    private Book findBook(String bookId) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }

        return null;
    }

    private Member findMember(String memberId) {

        for (Member member : members) {

            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }

        return null;
    }
}
