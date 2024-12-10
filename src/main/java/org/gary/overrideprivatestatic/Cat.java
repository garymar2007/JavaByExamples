package org.gary.overrideprivatestatic;

public class Cat extends Animal {
    //@Override - Illegal here as static methods cannot be overriddens
    private static void whoAmI() {
        System.out.println("I am a cat");
    }
}
