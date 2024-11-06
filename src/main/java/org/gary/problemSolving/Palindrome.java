package org.gary.problemSolving;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        System.out.println(palindromeChecker(A));
    }

    public static String palindromeChecker(String s) {
        for(int i = 0, j = s.length()-1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return "No";
            }
        }
        return "Yes";
    }
}
