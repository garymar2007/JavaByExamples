package java8.lambdaexpression;

import java.util.function.BiConsumer;

public class LambdaDemo {
    public static void main(String[] args) {
        // pre-version 8
        System.out.println("Pre Java 8");
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.add(4, 6);

        // post-versin 8
        System.out.println("Post Java 8");
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept(4, 6);
    }

    public void add(int a, int b) {
        System.out.println(a + b);
    }
}
