package exceptions;

public class NumberFormatExpressionException extends InvalidArgumentException{
    public NumberFormatExpressionException() {
    }

    public NumberFormatExpressionException(String message) {
        super(message);
    }

    public NumberFormatExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberFormatExpressionException(Throwable cause) {
        super(cause);
    }
}
