import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String BOOK_FILE = "books.txt";
    private static final String MEMBER_FILE = "members.txt";
    private static final String ISSUE_FILE = "issue_records.txt";

    // ---------------- BOOKS ----------------

    public static void saveBooks(List<Book> books) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {

            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public static List<Book> loadBooks() {

        List<Book> books = new ArrayList<>();

        File file = new File(BOOK_FILE);

        if (!file.exists()) {
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    String bookId = data[0];
                    String title = data[1];
                    String author = data[2];
                    boolean available = Boolean.parseBoolean(data[3]);

                    books.add(
                            new Book(bookId, title, author, available)
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }

        return books;
    }

    // ---------------- MEMBERS ----------------

    public static void saveMembers(List<Member> members) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_FILE))) {

            for (Member member : members) {
                writer.write(member.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }

    public static List<Member> loadMembers() {

        List<Member> members = new ArrayList<>();

        File file = new File(MEMBER_FILE);

        if (!file.exists()) {
            return members;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 3) {

                    members.add(
                            new Member(
                                    data[0],
                                    data[1],
                                    data[2]
                            )
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading members: " + e.getMessage());
        }

        return members;
    }

    // ---------------- ISSUE RECORDS ----------------

    public static void saveIssueRecords(List<IssueRecord> records) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ISSUE_FILE))) {

            for (IssueRecord record : records) {
                writer.write(record.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving issue records: " + e.getMessage());
        }
    }

    public static List<IssueRecord> loadIssueRecords() {

        List<IssueRecord> records = new ArrayList<>();

        File file = new File(ISSUE_FILE);

        if (!file.exists()) {
            return records;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 2) {

                    records.add(
                            new IssueRecord(
                                    data[0],
                                    data[1]
                            )
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading issue records: " + e.getMessage());
        }

        return records;
    }
}