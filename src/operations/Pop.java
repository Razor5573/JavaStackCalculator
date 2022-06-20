package operations;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import context.ExecutionContext;
import exceptions.NoElementException;
import org.apache.log4j.Logger;

public class Pop implements Command {
    static Logger logger = Logger.getLogger(Pop.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws NoElementException {
        Stack stack = ExecutionContext.getStack();
        logger.info("Popping an element");
        try{
            stack.pop();
        }
        catch (EmptyStackException er){
            logger.error("No element on a stack");
            throw new NoElementException("No element on a stack");
        }
    }
}
