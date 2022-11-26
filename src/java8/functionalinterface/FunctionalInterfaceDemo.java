package java8.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
    // Only one abstract method
    void singleAbstractMethod();

    // Multiple default or static methods
    default void printName(){
        System.out.println("Welcome to Java 8");
    }

    default void printName2(){
        System.out.println("Welcome to Java 8");
    }
}
