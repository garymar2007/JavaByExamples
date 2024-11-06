package org.gary.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExChecker {
    public static void main(String[] args){
        List<String> result = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases > 0){
            String pattern = in.nextLine();
            result.add(verifyRegEx(pattern));
            testCases--;
        }

        result.forEach(System.out::println);
    }

    public static String verifyRegEx(String pattern) {
        try {
            Pattern p = Pattern.compile(pattern);
            return "Valid";
        } catch (Exception e) {
            return "Invalid";
        }
    }
}
