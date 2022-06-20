import exceptions.DivNullException;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DefineTest {
    @Test
    public void defineTest1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "defineTest1.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "28.0";
        assertEquals(expect, res);
    }
    @Test
    public void defineTest2() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "defineTest2.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "3.0";
        assertEquals(expect, res);
    }
}
