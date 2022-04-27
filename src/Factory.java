import operations.Command;
import operations.Push;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class Factory {
    private Properties configFile = new Properties();
    private final String configFilePath = "C:\\Users\\nikit\\IdeaProjects\\StackCalculator\\src\\configFile.properties";
    private final HashMap<String, String> operationsHashMap = new HashMap();

    public void loadConfig(){
        try{
            configFile.load(new FileInputStream(configFilePath));
            for (var i : configFile.stringPropertyNames()){
                operationsHashMap.put(i, configFile.getProperty(i));
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }
    public Command getCommand(String operation){
        try {
            System.out.println(operationsHashMap.get(operation));
            Command command = (Command) Class.forName(operationsHashMap.get(operation)).newInstance();
            return command;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
