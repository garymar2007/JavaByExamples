package problemSolving;

import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.hasNext() ? sc.nextLine() : "";
        int counter = 1;
        while(line != "") {
            System.out.println(counter + " " + line);
            counter++;
            if (line.contains("end-of-file")) {
                line = "";
            } else {
                line = sc.hasNext() ? sc.nextLine() : "";
            }
        }
    }
}
