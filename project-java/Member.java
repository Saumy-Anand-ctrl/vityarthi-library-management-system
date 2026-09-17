public class Member {
    private String memberId;
    private String name;
    private String phone;

    public Member(String memberId, String name, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId +
                " | Name: " + name +
                " | Phone: " + phone;
    }

    public String toFileString() {
        return memberId + "|" + name + "|" + phone;
    }
}