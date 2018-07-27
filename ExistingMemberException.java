public class ExistingMemberException extends RuntimeException{
    public ExistingMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingMemberException(String message) {
        super(message);
    }
}
