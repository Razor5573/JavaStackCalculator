import exceptions.SqrtOfNegativeNumberException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions.*;

public class SquareRootTest {
    @Test
    public void squareRootTest1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "squareRootTest1.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "4.0";
        assertEquals(expect, res);
    }

    @Test
    public void squareRootTest2() throws Exception {
        Exception exception = assertDoesNotThrow(SqrtOfNegativeNumberException.class, () -> {
            StackCalculator.main(new String[]{" ", "squareRootTest2.txt"});
        });
        String expectedMessage = "Trying to calculate the square root of a negative number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
