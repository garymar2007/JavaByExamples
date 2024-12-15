package org.gary.designpattern.singleton;

/**
 * This test is to verify that the instance is the only one created and shared.
 */
public class Test {
    public static void main(String... args) {

        Singleton singleton1 = Singleton.INSTANCE;
        singleton1.perform();

        Singleton singleton2 = Singleton.INSTANCE;
        singleton2.perform();

        System.out.println(singleton1.hashCode() == singleton2.hashCode());
    }
}
