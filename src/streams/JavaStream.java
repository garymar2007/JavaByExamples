package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class JavaStream {
    public static void main(String... args) {
        //1. Integer stream
        IntStream.range(1,10).forEach(System.out::print);
        System.out.println();

        //2. Integer stream with skip
        IntStream.range(1,10).skip(5).forEach(x->System.out.println(x));
        System.out.println();

        //3. Integer stream with sum
        System.out.println(IntStream.range(1,10).sum());
        System.out.println();

        //4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
        System.out.println();

        //5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sara", "Gary", "Venky", "Craig", "Greg"};
        Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);
        System.out.println();

        //6. average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10}).map(x -> x * x).average().ifPresent(System.out::println);
        System.out.println();

        //7. Stream from list, filter and print
        List<String> people = Arrays.asList("AL", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sara", "Gary", "Venky", "Craig", "Greg");
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
        System.out.println();

        //8. Stream rows from text file, sort, filter, and print
        try{
            Stream<String> lines = Files.lines(Paths.get("C:\\workspaces\\JavaByExamples\\src\\streams\\bands.txt"));
            lines.sorted().filter(x -> x.length() > 13).forEach(System.out::println);
            lines.close();
        }catch(IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println();

        //9. Stream rows from text file and save to List
        try{
            List<String> lines2 = Files.lines(Paths.get("C:\\workspaces\\JavaByExamples\\src\\streams\\bands.txt"))
                    .sorted().filter(x -> x.contains("US")).collect(Collectors.toList());
            lines2.forEach(System.out::println);
        }catch(IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println();

        //10. Stream rows from CSV file and count the good rows
        try{
            Stream<String> lines = Files.lines(Paths.get("C:\\workspaces\\JavaByExamples\\src\\streams\\bands1.txt"));
            int rowCount = (int)lines.map(x -> x.split(",")).filter(x -> x.length == 3).count();
            System.out.println(rowCount + " good rows.");
            lines.close();
        }catch(IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println();

        //11. Stream rows from CSV file and parse data from the good rows
        try{
            Stream<String> lines = Files.lines(Paths.get("C:\\workspaces\\JavaByExamples\\src\\streams\\bands1.txt"));
            lines.map(x -> x.split(","))
                    .filter(x -> x.length == 3)
                    .filter(x -> Integer.parseInt(x[1]) > 15)
                    .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
            lines.close();
        }catch(IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println();

        //12. Stream rows from CSV file and store fields in HashMap
        try{
            Stream<String> lines = Files.lines(Paths.get("C:\\workspaces\\JavaByExamples\\src\\streams\\bands1.txt"));
            Map<String, Integer> map = new HashMap<>();
            map = lines.map(x -> x.split(","))
                    .filter(x -> x.length == 3)
                    .filter(x -> Integer.parseInt(x[1]) > 15)
                    .collect(Collectors.toMap(
                            x->x[0],
                            x->Integer.parseInt(x[1])));
            for(String key: map.keySet()) {
                System.out.println(key + " " + map.get(key));

            }
            lines.close();
        }catch(IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println();

        //13: reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        //14. reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
                .summaryStatistics();
        System.out.println(summary);

        JavaStream.minMaxSum(Stream.of(7, 69,2,221,8974).collect(Collectors.toList()));

        System.out.println("The sum from 1 up to 10 is:" + JavaStream.sumAll(10));

        testMaxValue();
    }

    public static void minMaxSum(List<Integer> arr) {
        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        int sum = sorted.stream().reduce(0, (Integer a, Integer b) -> a + b);
        int minSum = sum - sorted.get(4);
        int maxSum = sum - sorted.get(0);
        System.out.println( minSum + " " + maxSum);
    }

    public static int sumAll(int num) {
        return IntStream.range(1, num + 1).sum();
    }

    public static void testMaxValue() {
        List<Integer> maxNums = Stream.of(3,2,1,3).max(Comparator.comparing(Integer::valueOf)).stream().collect(Collectors.toList());
        System.out.println("The number of max number is " + maxNums.size());
    }
}
