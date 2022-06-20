package operations;
import java.util.HashMap;
import java.util.Stack;

public interface Command{
    public void work(String[] args, HashMap<String, Double> defines) throws Exception;
}
