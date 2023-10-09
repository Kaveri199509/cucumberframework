package dataBaseOperation.exception;

public class DataBaseQueryException extends RuntimeException {
    public DataBaseQueryException(String message) {
        super(message);
    }

    public DataBaseQueryException(String message, Throwable cause) {
        super(message, cause);
    }
}
