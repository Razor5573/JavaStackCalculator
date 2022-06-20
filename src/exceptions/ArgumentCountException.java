package exceptions;

public class ArgumentCountException extends InvalidArgumentException{
    public ArgumentCountException() {
    }

    public ArgumentCountException(String message) {
        super(message);
    }

    public ArgumentCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentCountException(Throwable cause) {
        super(cause);
    }
}
