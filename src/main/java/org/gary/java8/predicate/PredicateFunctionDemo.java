package org.gary.java8.predicate;

import java.util.function.Predicate;

public class PredicateFunctionDemo {
    public static void main(String... args){
        Predicate<String> checkLength = s -> s.length() >= 5;
        System.out.println("The length of string is greater than 5 : " + checkLength.test("code decode"));
    }
}
