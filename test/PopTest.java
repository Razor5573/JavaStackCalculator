import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions.*;

public class PopTest {
    @Test
    public void popTest1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "popTest1.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "";
        assertEquals(expect, res);
    }

    @Test
    public void popTest2() throws Exception {
        Exception exception = assertDoesNotThrow(NumberFormatExpressionException.class, () -> {
            StackCalculator.main(new String[] {" ", "popTest2.txt"});
        });
        String expectedMessage = "No element on a stack";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
