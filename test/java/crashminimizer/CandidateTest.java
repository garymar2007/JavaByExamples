package java.crashminimizer;

import java.io.*;
import java.nio.file.*;

import main.java.crashminimizer.CrashMinimizer;
import org.junit.Test;
import static org.junit.Assert.*;

/* Note: this file is available for your testing purposes
   and will not be included with your final submission. */

public class CandidateTest {

    @Test
    public void providedExample1() throws IOException {
        String programNameUnderTest = "CaesarCipher";
        String failingInputFilename = "example_input/example_01.txt";
        String expected = "æ";

        /* We can compile once in the first test--the binary
         * will persist for the remainder of the test suite */
        //TestUtilities.runCommand("javac " + programNameUnderTest + ".java");

        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        assertEquals(expected, actual);
    }

    @Test
    public void providedExample2() throws IOException {
        String programNameUnderTest = "CaesarCipher";
        String failingInputFilename = "example_input/example_02.txt";
        String expected = "↑";

        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        assertEquals(expected, actual);
    }

    @Test
    public void myExample3() throws IOException {
        String programNameUnderTest = "CaesarCipher";
        String failingInputFilename = "example_input/example_03.txt";
        String expected = "Ω";

        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        assertEquals(expected, actual);
    }
}
