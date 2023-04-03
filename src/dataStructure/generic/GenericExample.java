package dataStructure.generic;

/**
 *
 */
public class GenericExample {
    public static void main(String... args) {
        ThingToPrinter<Integer> intPrinter = new ThingToPrinter<>(23);
        intPrinter.print();

        ThingToPrinter<Double> doublePrinter = new ThingToPrinter<>(23.23);
        doublePrinter.print();

        ThingToPrinter<String> stringPrinter = new ThingToPrinter<>("I love Java");
        stringPrinter.print();

    }
}
