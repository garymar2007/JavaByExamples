package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
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
 *
 * Array
 * 1. fixed size, lacking elastic sizing - can't do add a new element/remove an old element
 * 2. printing is not convenient
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

        //Initialization is different between Array and ArrayList
        String[] friends = {"Gary", "Carol", "Leo", "Jerry"};
        List<String> friendsList = new ArrayList<>(Arrays.asList(friends));

        //size() in ArrayList or length attribute in Array
        System.out.println(friends.length);
        System.out.println(friendsList.size());

        //Set element to change element
        friends[0] = "Carl";
        friendsList.set(0, "Carl");

        //Print each element - array won't show each element, but only the address of the object
        System.out.println(friends); //[Ljava.lang.Object;@7a0ac6e3
        System.out.println(friendsList);
    }
}
