package java8.staticmethod;

public class StaticMethodInterfaceDemo implements StaticMethodInterface{

    public static void main(String... args) {

        // NB: static method of an interface is not available to its implementation class.
//        StaticMethodInterfaceDemo staticMethodInterfaceDemo = new StaticMethodInterfaceDemo();
//        staticMethodInterfaceDemo.staticMethod();

        StaticMethodInterface.staticMethod();
    }
}
