package org.gary.java8.defaultmethod;

public class DefaultMethodInterfaceDemo implements DefaultMethodInterface{
    public static void main(String... args) {
        DefaultMethodInterfaceDemo defaultMethodInterfaceDemo = new DefaultMethodInterfaceDemo();
        defaultMethodInterfaceDemo.printName();
    }

    @Override
    public void printName() {
        System.out.println("This is the overridden method!");
    }
}
