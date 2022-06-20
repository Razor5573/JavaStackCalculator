package exceptions;

import java.io.IOException;

public class DivNullException extends IOException {
    public DivNullException() {
    }

    public DivNullException(String message) {
        super(message);
    }

    public DivNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivNullException(Throwable cause) {
        super(cause);
    }

}
