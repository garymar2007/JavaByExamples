package org.gary.problemSolving;

import java.util.Scanner;
import java.util.Stack;

/**
 * A string containing only parentheses is balanced if the following is true: 1. if it is an empty string
 * * 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
 *
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
 *
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 *
 * Given a string, determine if it is balanced or not.*
 */
public class StackExample {
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(checkBalancedString(input));
        }
    }

    public static String checkBalancedString(String input) {
        Stack<Character> balance = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            switch(currentChar) {
                case ']':
                case ')':
                case '}':
                    if(balance.empty()) {
                        return "false";
                    } else if((currentChar == ')' && balance.peek() == '(')
                            || (currentChar == ']' && balance.peek() == '[')
                            || (currentChar == '}' && balance.peek() == '{')){
                        balance.pop();
                    } else {
                        return "false";
                    }
                    break;
                case '(':
                case '[':
                case '{':
                    balance.push(currentChar);
                    break;
                default:
                    return "false";
            }
        }
        if (balance.empty()) {
            return "true";
        } else {
            return "false";
        }
    }
}
