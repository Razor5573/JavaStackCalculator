import exceptions.DivNullException;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class DivisionTest {
    @Test
    public void divisionTest1() throws Exception {
        Exception exception = assertDoesNotThrow(DivNullException.class, () -> {
            StackCalculator.main(new String[]{" ", "divisionTest1.txt"});
        });
        String expectedMessage = "Division by zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void divisionTest2() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "divisionTest2.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "0.5";
        assertEquals(expect, res);
    }

    @Test
    public void divisionTest3() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "divisionTest3.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "0.25";
        assertEquals(expect, res);
    }
}
