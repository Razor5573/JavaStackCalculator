package exceptions;

import java.util.EmptyStackException;

public class NoElementException extends RuntimeException {
    public NoElementException() {
    }

    public NoElementException(String message) {
        super(message);
    }

    public NoElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoElementException(Throwable cause) {
        super(cause);
    }

    public NoElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
