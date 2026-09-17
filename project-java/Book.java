public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public Book(String bookId, String title, String author, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                " | Title: " + title +
                " | Author: " + author +
                " | Status: " + (available ? "Available" : "Issued");
    }

    public String toFileString() {
        return bookId + "|" + title + "|" + author + "|" + available;
    }
}