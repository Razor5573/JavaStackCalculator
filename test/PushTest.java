import exceptions.NumberFormatExpressionException;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions.*;

public class PushTest {
    @Test
    public void pushTest1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "pushTest1.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "";
        assertEquals(expect, res);
    }

    @Test
    public void pushTest2() throws Exception {
        Exception exception = assertDoesNotThrow(NumberFormatExpressionException.class, () -> {
            StackCalculator.main(new String[] {" ", "pushTest2.txt"});
        });
        String expectedMessage = "Invalid argument: not a number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void pushTest3() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "pushTest3.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "a";
        assertEquals(expect, res);
    }

}
