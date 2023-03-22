package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList Vs. ArrayList
 * Similarities:
 * 1. implements the same List interface
 * 2. all the methods are the same
 *
 * Differences:
 * 1. For add/delete/insert method, LinkedList has more complexity than ArrayList
 * 2. More static data, meaning not change a lot - using linkedlist
 */
public class LinkedListArrayList {
    public static void main(String... args) {
        List<String> aLinkedList = new LinkedList<>();
        aLinkedList.add("Gary");
        aLinkedList.add("Carol");
        aLinkedList.add("Jerry");
        aLinkedList.add("Leo");
        aLinkedList.add("Gary");
        aLinkedList.add("Gary");

        aLinkedList.remove(1);
        aLinkedList.add(2, "Nathan");

        List<String> aArrayList = new ArrayList<>();
        aArrayList.add("Gary");
        aArrayList.add("Carol");
        aArrayList.add("Jerry");
        aArrayList.add("Leo");
        aArrayList.add("Gary");
        aArrayList.add("Gary");

        aArrayList.remove(1);
        aArrayList.add(2, "Nathan");
    }
}
