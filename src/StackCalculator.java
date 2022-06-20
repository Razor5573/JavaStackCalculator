import context.ExecutionContext;
import operations.Addition;
import operations.Command;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class StackCalculator {
    static Logger logger = Logger.getLogger(Addition.class);
    public static void main(String[] args) throws Exception {
        Factory factory = new Factory();
        factory.loadConfig();
        String[] commAndValues;
        if (args.length == 1) {
            Scanner input = new Scanner(System.in);
            while(true){
                System.out.println("Write a command: ");
                commAndValues = input.nextLine().split(" ");
                Command command = factory.getCommand(commAndValues[0]);
                logger.info("Command is called");
                command.work(commAndValues, ExecutionContext.getDefines());
            }
        }
        else{
            try{
                File file = new File("C:\\Users\\nikit\\IdeaProjects\\StackCalculator\\src\\" + args[1]);
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while (line != null) {
                    commAndValues = line.split(" ");
                    Command command = factory.getCommand(commAndValues[0]);
                    logger.info("Command is called");
                    command.work(commAndValues, ExecutionContext.getDefines());
                    line = reader.readLine();
                }
            }
            catch(IOException ex) {
                logger.error("Input/Output exception");
                ex.printStackTrace();
            }
        }
    }
}
