package operations;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import context.ExecutionContext;
import exceptions.DivNullException;
import exceptions.NoElementException;
import org.apache.log4j.Logger;

public class Division implements Command{
    static Logger logger = Logger.getLogger(Division.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws NoElementException, DivNullException {
        Stack stack = ExecutionContext.getStack();
        String v1;
        String v2;

        logger.info("Getting an arguments from a stack");
        try{
            v1 = stack.pop().toString();
            v2 = stack.pop().toString();
        }
        catch(EmptyStackException empty){
            logger.error("Stack is empty");
            throw new NoElementException("Stack is empty");
        }

        boolean definedV1 = defines.containsKey(v1);
        boolean definedV2 = defines.containsKey(v2);
        double secondArg;
        logger.info("Division is performed");
        if (definedV1 && definedV2) {
            secondArg = defines.get(v2);
            if(secondArg != 0)
                stack.push(defines.get(v1) / secondArg);
            else {
                logger.error("Division by zero");
                throw new DivNullException("Division by zero");
            }
        }
        else if (definedV1) {
            secondArg = Double.parseDouble(v2);
            if(secondArg != 0)
                stack.push(defines.get(v1) / secondArg);
            else {
                logger.error("Division by zero");
                throw new DivNullException("Division by zero");
            }
        }

        else if (definedV2) {
            secondArg = defines.get(v1);
            if(secondArg != 0)
                stack.push(Double.parseDouble(v1) / secondArg);
            else {
                logger.error("Division by zero");
                throw new DivNullException("Division by zero");
            }
        }

        else {
            secondArg = Double.parseDouble(v2);
            if(secondArg != 0)
                stack.push(Double.parseDouble(v1) / secondArg);
            else {
                logger.error("Division by zero");
                throw new DivNullException("Division by zero");
            }
        }
    }
}
