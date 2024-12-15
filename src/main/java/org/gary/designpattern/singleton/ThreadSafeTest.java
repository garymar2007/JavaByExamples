package org.gary.designpattern.singleton;

public class ThreadSafeTest {
    public static void main(String... args) {
        Thread thread1 = new Thread(() -> {
            Singleton singleton1 = Singleton.INSTANCE;
            singleton1.perform();
        });

        Thread thread2 = new Thread(() -> {
            Singleton singleton2 = Singleton.INSTANCE;
            singleton2.perform();
        });

        Thread thread3 = new Thread(() -> {
            Singleton singleton3 = Singleton.INSTANCE;
            singleton3.perform();
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
