public class FullCapacityException extends RuntimeException {
    public FullCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullCapacityException(String message) {
        super(message);
    }
}
