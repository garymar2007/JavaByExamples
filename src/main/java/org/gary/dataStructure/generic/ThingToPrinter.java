package org.gary.dataStructure.generic;

public class ThingToPrinter<T> {
    T thingToPrint;

    public ThingToPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;

    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
