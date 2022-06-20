package exceptions;

import java.io.IOException;

public class SqrtOfNegativeNumberException extends IOException {
    public SqrtOfNegativeNumberException() {
    }

    public SqrtOfNegativeNumberException(String message) {
        super(message);
    }

    public SqrtOfNegativeNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqrtOfNegativeNumberException(Throwable cause) {
        super(cause);
    }

}
