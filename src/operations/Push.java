package operations;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import context.ExecutionContext;
import exceptions.ArgumentCountException;
import exceptions.NumberFormatExpressionException;
import org.apache.log4j.Logger;

public class Push implements Command{
    static Logger logger = Logger.getLogger(Push.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws IOException {
        Stack stack = ExecutionContext.getStack();
        boolean definedArg = defines.containsKey(args[1]);

        if(definedArg) {
            logger.info("Pushing an element");
            stack.push(args[1]);
            return;
        }

        try
        {
            Double.parseDouble(args[1]);
        }
        catch (NumberFormatException exception){
            logger.error("Invalid argument: not a number");
            throw new NumberFormatExpressionException("Invalid argument: not a number");
        }

        try
        {
            args[2].isEmpty();
        }
        catch (ArrayIndexOutOfBoundsException exception){
            logger.info("Pushing an element");
            stack.push(args[1]);
        }

        if(stack.peek() != args[1]){
            logger.error("Incorrect number of arguments");
            throw new ArgumentCountException("Incorrect number of arguments");
            }
    }
}
