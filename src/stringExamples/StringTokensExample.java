package stringExamples;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. We define a token
 * * to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each
 * * token on a new line.*
 */

public class StringTokensExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        StringTokenizer st = new StringTokenizer(s, " !,?._'@");
        System.out.println(st.countTokens());
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        scan.close();
    }
}
