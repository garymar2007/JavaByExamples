package java8.lambdaexpression;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda Expression:
 * 1. (o1, o2) -> Integer.compare(o1, o2);
 * 2. format:
 *          ->: lambda operator or arrow operator;
 *      ->left: lambda parameter list (parameter list of abstract method in an interface)
 *      ->right: lambda body (overriding abstract method)
 *
 * 3. How to use (6 formats)
 *
 */
public class LambdaTest1 {
    //Format 1:  no parameter, no return
    @Test
    public void test1(){
        //pre-version 8:
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love Java");
            }
        };

        //post-version 8:
        // An instance of an interface
        Runnable r1 = () -> {
            System.out.println("I love Java");
        };
    }

    //Format 2: parameter is required, but no return
    @Test
    public void test2(){
        //pre-version 8:
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("I love Java");

        //post-version 8:
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("I love Java");
    }

    @Test
    //Format 3:Type inference
    public void test3() {
        //post-version 8:
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("I love Java");
    }

    @Test
    //Format 4: only one parameter is required, the brackets should be omitted.
    public void test4() {
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("I love Java");
    }

    @Test
    //Format 5: two or more parameters are required, and return
    public void test5() {
        //pre-version 8:
        Comparator<Integer> com1 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        //post-version 8:
        Comparator<Integer> com2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(23, 56));
    }

    @Test
    //Format 6: If the lambda body has only one statement, then the return and curly brackets may be omitted
    public void test6(){
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(23, 56));
    }
}
