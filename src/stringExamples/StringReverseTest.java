package stringExamples;

import java.util.Scanner;

public class StringReverseTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a string: ");
        String readInStr = sc.nextLine();
        System.out.println(reverse(readInStr));
    }

    static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        else if(s.length() == 2) {
            return "" + s.charAt(1) + s.charAt(0);
        } else {
            return "" + s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
        }
    }
}
