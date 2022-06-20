package context;

import java.util.*;
public class ExecutionContext {
    static Stack<Double> stack = new Stack<>();
    static HashMap<String, Double> defines = new HashMap<>();

    public static Stack<Double> getStack(){
        return stack;
    }

    public static HashMap<String, Double> getDefines() {
        return defines;
    }
}