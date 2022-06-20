package operations;
import java.util.HashMap;
import exceptions.ArgumentCountException;
import exceptions.InvalidArgumentException;
import exceptions.NumberFormatExpressionException;
import org.apache.log4j.Logger;

public class Define implements Command{
    static Logger logger = Logger.getLogger(Define.class);
    @Override
    public void work(String[] args, HashMap<String, Double> defines) throws InvalidArgumentException {
        try
        {
            args[3].isEmpty();
        }
        catch (ArrayIndexOutOfBoundsException segfault1) {
            try {
                args[2].isEmpty();
            }
            catch (ArrayIndexOutOfBoundsException segfault2) {
                logger.error("Incorrect number of arguments");
                throw new ArgumentCountException("Incorrect number of arguments");
            }
        }

        String key = args[1];
        double value;
        double control = 0;

        try {
            control = Double.parseDouble(key);
        }
        catch (NumberFormatException ignored) {

        }
        if(control != 0)
        {
            logger.error("Incorrect first argument");
            throw new NumberFormatExpressionException("Incorrect first argument");
        }

        try {
            value = Double.parseDouble(args[2]);
        }
        catch (NumberFormatException NaN) {
            logger.error("Incorrect second argument");
            throw new NumberFormatExpressionException("Incorrect second argument");
        }
        logger.info("Putting a new define to the stack of defines");
        defines.put(key, value);
    }
}
