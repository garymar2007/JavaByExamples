package java8.lambdaexpression;

import org.junit.Test;

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
}
