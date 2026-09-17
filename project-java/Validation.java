public class Validation {

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    public static boolean isValidId(String id) {
        return !isEmpty(id);
    }
}