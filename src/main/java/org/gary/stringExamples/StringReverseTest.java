package org.gary.stringExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * These examples are interviewed questions for Vendasta
 */
public class StringReverseTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a string: ");
        String readInStr = sc.nextLine();
        System.out.println("1. The reverse of this string is: " + reverse(readInStr));
        System.out.println("========================================================");
        System.out.println("2. The abbreviation of this string is: " + wordAbbreviation(readInStr));
        System.out.println("========================================================");
        System.out.println("3. The replacement of this string is: " + replaceEachBy1(readInStr));
        System.out.println("========================================================");
        System.out.println("4. The number replacement of this string is: " + replaceByNumbers(readInStr));
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

    /**
     * input: java
     * output: j2a
     * @param s
     * @return
     */
    static String wordAbbreviation(String s) {
        return "" + s.charAt(0) + s.substring(1, s.length() -1).length() + s.charAt(s.length() -1);
    }

    /**
     * input:  Java
     * output: {1ava, j1va, ja1a, jav1}
     * @param s
     * @return
     */
    static List<String> replaceEachBy1(String s) {
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++) {
            result.add(s.substring(0, i) + "1" + s.substring(i + 1));
        }
        return result;
    }

    /**
     * input: java
     * output: {1ava, j1va, ja1a, jav1, 2va, j2a, ja2, 3a, j3, 4}
     * @param s
     * @return
     */
    static List<String> replaceByNumbers(String s) {
        List<String> result = new ArrayList<String>();
        int j = 1;
        for(; j < s.length(); j++){

            for(int i = 0; i < s.length(); i++) {
                if ((i + j) > s.length()) {
                    break;
                }
                if((i + j) == s.length()) {
                    result.add(s.substring(0, i) + j);
                } else {
                    result.add(s.substring(0, i) + j + s.substring(i + j));
                }
            }
        }
        if(j == s.length()) {
            result.add("" + j);
        }
        return result;
    }
}
