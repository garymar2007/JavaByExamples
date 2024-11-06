package org.gary.java8.methodreference;

import org.gary.java8.functionalinterface.FunctionalInterfaceDemo;

public class MethodReferenceDemo {
    public static void main(String... args) {
        // this is the method reference: abstract method singleAbstractMethod maps to the specific existing method
        // testImplementation
        FunctionalInterfaceDemo functionalInterfaceDemo = Test::testImplementation;
        functionalInterfaceDemo.singleAbstractMethod();

        // Using lambda expression to implement the abstract method
        FunctionalInterfaceDemo f = () -> System.out.println("This is the instance object of FunctionalInterfaceDemo");
        f.singleAbstractMethod();
    }
}

class Test {
    public static void testImplementation() {
        System.out.println("This is test implementation of your abstract method");
    }
}
