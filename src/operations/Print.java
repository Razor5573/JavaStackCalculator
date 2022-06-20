package operations;
import java.util.HashMap;
import java.util.Stack;
import context.ExecutionContext;
import exceptions.NoElementException;
import org.apache.log4j.Logger;

public class Print implements Command {
    static Logger logger = Logger.getLogger(Print.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws NoElementException {
        Stack stack = ExecutionContext.getStack();
        try {
            System.out.println(stack.lastElement());
        }
        catch (RuntimeException empty){
            logger.error("Stack is empty");
            throw new NoElementException("Stack is empty");
        }
    }
}
