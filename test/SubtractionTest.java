import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class SubtractionTest {
    @Test
    public void subtractionTest1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "subtractionTest1.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "10.0";
        assertEquals(expect, res);
    }

    @Test
    public void subtractionTest2() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "subtractionTest2.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "-20.0";
        assertEquals(expect, res);
    }

    @Test
    public void subtractionTest3() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "subtractionTest3.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "46.0";
        assertEquals(expect, res);
    }
}
