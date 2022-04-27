import operations.Command;
import java.util.*;

public class StackCalculator {
    public static void main(String[] args) {
        if (args != null) {
            Scanner input = new Scanner(System.in);
            Factory factory = new Factory();
            factory.loadConfig();
            String[] commAndValue = new String[] {" ", " "};

            Stack stack = new Stack();
            System.out.println("Write a command: ");
            Command command = factory.getCommand(input.nextLine()); //mby split?
            command.work(stack);
        }
    }
}
