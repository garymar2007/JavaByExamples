package dataStructure;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Set and Map are interfaces, while HashSet and HashMap are their implementator classes*
 * 1. Set does NOT allow duplicate element.
 * 2. Set does NOT use index
 * 3. HashSet and TreeSet are the same only except TreeSet(natural order) has an ordered elements
 * 4. LinkedHashSet maintains the elements not in natural order, but in insertion order
 * 5. Map: <key, value>, key, value must be Java class(cannot be primitive types) and not care about the order of its elements.
 */
public class HashSetHashMap {
    public static void main(String... arg) {
        Set<String> aSet = new HashSet<>();
        aSet.add("Gary");
        aSet.add("Carol");
        aSet.add("Leo");
        aSet.add("Jerry");
        aSet.add("Nathan");
        aSet.add("");

        System.out.println(aSet);
        aSet.remove(0); //DOES do anything here due to set not working with index
        System.out.println(aSet);

        for(String name : aSet) {
            System.out.println(name);
        }

        aSet.stream().forEach(System.out::println);

        Iterator<String> aNames = aSet.iterator();
        while(aNames.hasNext()) {
            System.out.println(aNames.next());
        }

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(6);
        numberList.add(3);
        numberList.add(2);
        numberList.add(6);
        System.out.println(numberList);

        //Easiest and faster way to remove duplications is to convert the list to set
        Set<Integer> numberSet = new HashSet<>(numberList);
        //numberSet.addAll(numberList);
        System.out.println(numberSet);

        Set<String> orderTreeSet = new TreeSet<>(aSet);
        System.out.println(orderTreeSet);

        Map<Integer, String> empIds = new HashMap<>();
        empIds.put(1, "Gary");
        empIds.put(2, "Dave");
        empIds.put(5, "Carol");
        empIds.put(8, "Leo");
        empIds.put(4, "Jerry");
        empIds.put(7, "Nathan");
        System.out.println(empIds);

        System.out.println(empIds.get(4));
        System.out.println(empIds.containsKey(3));
        System.out.println(empIds.containsValue("Gary"));

        //put vs. replace
        empIds.put(10, "Louis"); // insert a new element if not there
        empIds.replace(11, "Tom"); // won't do anything if no such key
        System.out.println(empIds);

        System.out.println(breakingRecords(Stream.of(10,5,20,20,4,5,2,25,1).collect(Collectors.toList())));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int length = scores.size();
        Integer[] highestScore = new Integer[length];
        highestScore[0] = scores.get(0);
        Integer[] lowestScore = new Integer[length];
        lowestScore[0] = scores.get(0);
        for(int i = 1; i <= length -1; i++) {
            int game = scores.get(i);
            if(game > highestScore[i-1]) {
                highestScore[i] = game;
            } else {
                highestScore[i] = highestScore[i-1];
            }

            if(game < lowestScore[i-1]) {
                lowestScore[i] = game;
            } else {
                lowestScore[i] = lowestScore[i-1];
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> high = new HashSet<Integer>(Arrays.asList(highestScore));
        Set<Integer> low = new HashSet<Integer>(Arrays.asList(lowestScore));
        result.add(high.size() - 1);
        result.add(low.size() - 1);

        return result;
    }
}
