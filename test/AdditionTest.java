import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class AdditionTest {
    @Test
    public void additionTest1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "additionTest1.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "30.0";
        assertEquals(expect, res);
    }

    @Test
    public void additionTest2() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "additionTest2.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "0.0";
        assertEquals(expect, res);
    }

    @Test
    public void additionTest3() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        StackCalculator.main(new String[] {" ", "additionTest3.txt"});
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        String expect = "-666.0";
        assertEquals(expect, res);
    }
}
