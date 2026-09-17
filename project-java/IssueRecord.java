public class IssueRecord {
    private String bookId;
    private String memberId;

    public IssueRecord(String bookId, String memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                " | Member ID: " + memberId;
    }

    public String toFileString() {
        return bookId + "|" + memberId;
    }
}