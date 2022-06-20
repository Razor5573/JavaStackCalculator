package exceptions;

public class UndefinedArgumentException extends InvalidArgumentException{
    public UndefinedArgumentException() {
    }

    public UndefinedArgumentException(String message) {
        super(message);
    }

    public UndefinedArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public UndefinedArgumentException(Throwable cause) {
        super(cause);
    }

}
