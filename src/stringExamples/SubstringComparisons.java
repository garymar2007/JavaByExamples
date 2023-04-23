package stringExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest
 * * and largest substrings of length k.*
 */
public class SubstringComparisons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        for (int i = 1; i < s.length() - k; i++) {
            String e = s.substring(i, k + i);
            if(e.compareTo(largest) > 0) {
                largest = e;
            }
            if(e.compareTo(smallest) < 0) {
                smallest = e;
            }
        }

        return smallest + "\n" + largest;
    }
}
