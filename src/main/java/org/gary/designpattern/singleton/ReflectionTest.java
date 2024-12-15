package org.gary.designpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectionTest {
    public static void main(String... args) {
        Singleton singleton1 = Singleton.INSTANCE;

        try {
            Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                Singleton singleton2 = (Singleton) constructor.newInstance();
                singleton2.perform();
                System.out.println(singleton1.hashCode() == singleton2.hashCode());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        singleton1.perform();
    }
}
