import operations.Command;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class Factory {
    private Properties configFile = new Properties();
    private final String configFilePath = "C:\\Users\\nikit\\IdeaProjects\\StackCalculator\\src\\configFile.properties";
    private final HashMap<String, Command> operationsHashMap = new HashMap();

    public void loadConfig(){
        try{
            configFile.load(new FileInputStream(configFilePath));
            for (var i : configFile.stringPropertyNames()){
                operationsHashMap.put(i, (Command) Class.forName(configFile.getProperty(i)).newInstance());
            }
        }
        catch(IOException | IllegalAccessException | InstantiationException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    public Command getCommand(String operation){
        Command command = operationsHashMap.get(operation);
        return command;
    }
}
