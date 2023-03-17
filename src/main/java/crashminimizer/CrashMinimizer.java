package main.java.crashminimizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrashMinimizer {
    public static final String ONE_LINE_FILE = "oneLineFile.txt";
    public static final String ONE_CHAR_FILE = "oneCharFile.txt";
    /**
     * This function minimizes a crashing test case to
     * a single character that still causes the crash.
     *
     * @param command - the command to execute the
     *                         program under test.
     *
     * @param  - the path
     *                to the file causing a crash in the
     *                target program. The contents of
     *                this file are to be minimized by
     *                this function.
     *
     * @return String - the final, minimized version of the
     *                failing test input file which still
     *                causes a crash.
     */
    public static String minimize(
            String command,
            String failingInputFilename
    ) throws FileNotFoundException, IOException {
        List<String> lines = Utilities.readFile(failingInputFilename);
        if(lines != null && lines.size() != 0) {
            String foundedLine = "";
            for(String s : lines) {
                s = s.replaceAll("[A-Za-z0-9\\s]","").replaceAll("\\pP","");
                String error = checkLine(s, command);
                if(error != null && error.length() != 0) {
                    foundedLine = s;
                    System.out.println(s);
                    break;
                }
            }

            for(int i = 0; i < foundedLine.length(); i++) {
                String error = checkChar(foundedLine, i, command);
                if(error != null && error.length() != 0) {
                    cleanupFiles();
                    return foundedLine.substring(i, i + 1);
                }
            }
        }

        cleanupFiles();
        return "";
    }

    /**
     * To remove the temp files
     *
     * @throws IOException
     */
    private static void cleanupFiles() throws IOException{
        Utilities.deleteFile(ONE_LINE_FILE);
        Utilities.deleteFile(ONE_CHAR_FILE);
    }

    /**
     * Check crash character within a line
     *
     * @param line  - a line to be checked
     * @param command - the command to execute the program under test.
     * @return
     * @throws IOException
     */
    private static String checkLine(String line, String command) throws IOException{
        List<String> tempLine = new ArrayList<>();
        tempLine.add(line);
        String tempFile = ONE_LINE_FILE;
        Utilities.writeToFile(tempFile, tempLine);
        return Utilities.runCommand(command + " " + tempFile);
    }

    /**
     * Check crash character on a given index within a line
     *
     * @param line - a line to be checked
     * @param index - a given index
     * @param command - the command to execute the program under test.
     * @return
     * @throws IOException
     */
    private static String checkChar(String line, int index, String command) throws IOException {
        List<String> tempChar = new ArrayList<>();
        tempChar.add(line.substring(index, index + 1));
        String tempFile = ONE_CHAR_FILE;
        Utilities.writeToFile(tempFile, tempChar);
        return Utilities.runCommand(command + " " + tempFile);
    }

    public static void main(String args[]) throws Exception {
        String programNameUnderTest = "main.java.crashminimizer.CaesarCipher";
        String failingInputFilename = "C:\\workspaces\\JavaByExamples\\example_input\\inputFile03.txt";
        String expected = "Ω";

        String actual = CrashMinimizer.minimize(
                "java -classpath C:\\workspaces\\JavaByExamples\\out\\production\\JavaByExamples " + programNameUnderTest, failingInputFilename
        );

        System.out.println(actual);
    }
}
