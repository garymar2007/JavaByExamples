package java8.defaultmethod;

public interface DefaultMethodInterface {

    // default keyword is used only for default method implementation
    default void printName() {
        System.out.println("Welcome to Java 8 - default method interface");
    }

    // This is not allowed because default method cannot override a method from java.lang.Object.
//    default int hashCode() {
//        return 2 * 3;
//    }
}
