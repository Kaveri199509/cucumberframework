package utility;

public class ConfigFileReaderException extends RuntimeException {
    public ConfigFileReaderException(String message) {
        super(message);
    }

    public ConfigFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}

