package operations;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import context.ExecutionContext;
import exceptions.NoElementException;
import org.apache.log4j.Logger;

public class Multiplication implements Command{
    static Logger logger = Logger.getLogger(Multiplication.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws NoElementException{
        Stack stack = ExecutionContext.getStack();
        String v1;
        String v2;
        logger.info("Getting an arguments from a stack");
        try {
            v1 = stack.pop().toString();
            v2 = stack.pop().toString();
        }
        catch(EmptyStackException empty){
            logger.error("Stack is empty");
            throw new NoElementException("Stack is empty");
        }

        boolean definedV1 = defines.containsKey(v1);
        boolean definedV2 = defines.containsKey(v2);

        logger.info("Multiplication is performed");
        if (definedV1 && definedV2)
            stack.push(defines.get(v1) * defines.get(v2));

        else if (definedV1)
            stack.push(defines.get(v1) * Double.parseDouble(v2));

        else if (definedV2)
            stack.push(Double.parseDouble(v1) * defines.get(v1));

        else
            stack.push(Double.parseDouble(v1) * Double.parseDouble(v2));
    }
}
