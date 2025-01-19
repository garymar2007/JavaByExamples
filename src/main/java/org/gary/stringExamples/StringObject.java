package org.gary.stringExamples;

public class StringObject {
    public static void main(String[] args) {
        String str1 = new String("Hello");  // 1. create a new object in the heap memory
                                                   // 2. create another object of literal in the String Constant Pool
        String str2 = "Hello";  // This won't create a new object as it is already in the String Constant Pool

        System.out.println(str1 == str2);  // false
        System.out.println(str1.equals(str2));  // true
        System.out.println(str1.intern().hashCode() == str2.hashCode());  // true

    }
}
