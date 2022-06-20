package operations;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import context.ExecutionContext;
import exceptions.NoElementException;
import exceptions.SqrtOfNegativeNumberException;
import org.apache.log4j.Logger;

public class SquareRoot implements Command{
    static Logger logger = Logger.getLogger(SquareRoot.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws NoElementException, SqrtOfNegativeNumberException {
        Stack stack = ExecutionContext.getStack();
        String v1;
        logger.info("Getting an argument from a stack");
        try {
            v1 = stack.pop().toString();
        }
        catch(EmptyStackException empty) {
            logger.error("Stack is empty");
            throw new NoElementException("Stack is empty");
        }

        boolean definedV1 = defines.containsKey(v1);

        logger.info("Square root calculation is performed");
        if (definedV1) {
            double result = Math.sqrt(defines.get(v1));
            if(!Double.isNaN(result))
                stack.push(Math.sqrt(defines.get(v1)));
            else {
                logger.error("Trying to calculate the square root of a negative number");
                throw new SqrtOfNegativeNumberException("Trying to calculate the square root of a negative number");
            }
        }
        else
        {
            double result = Math.sqrt(Double.parseDouble(v1));
            if(!Double.isNaN(result))
                stack.push(Math.sqrt(Double.parseDouble(v1)));
            else {
                logger.error("Trying to calculate the square root of a negative number");
                throw new SqrtOfNegativeNumberException("Trying to calculate the square root of a negative number");
            }
        }
    }
}