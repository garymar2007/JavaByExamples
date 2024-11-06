package org.gary.problemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * This is to practise Collectors.groupingBy and Collectors.counting to convert an array to
 * a hashMap and counting the duplications: [array_element, duplication_number]
 */
public class MigratoryBirds {
    public static void main(String... args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println(migratoryBirds(arr));
    }

    public static int migratoryBirds(List<Integer> ar) {
        Map<Integer, Long> birdTypes = ar.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //birdTypes.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " - "  + entry.getValue()));
        List<Long> occurences = birdTypes.values().stream()
                .max(Comparator.comparing(Long::valueOf))
                .stream().collect(Collectors.toList());
        Long maxOccurence = occurences.get(0);
        List<Integer> birds = new ArrayList<>();
        for(Map.Entry<Integer, Long> entry : birdTypes.entrySet()) {
            if(entry.getValue().longValue() == maxOccurence.longValue()) {
                birds.add(entry.getKey());
            }
        }
        return birds.stream().sorted().collect(toList()).get(0);
    }
}
