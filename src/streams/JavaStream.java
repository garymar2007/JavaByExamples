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

        //8. Stream rows from text file, sort, filter, and print
        try{
            Stream<String> lines = Files.lines(Paths.get("bands.txt"));
            lines.sorted().filter(x -> x.length() > 13).forEach(System.out::println);
            lines.close();
        }catch(IOException ioe) {
            System.out.println(ioe);
        }



    }

//    public static void miniMaxSum(List<Integer> arr) {
//        // Write your code here
//        Integer[] orderedArr = Arrays.stream(arr.toArray(new Integer[arr.size()])).sorted().collect();
//        int sum = Arrays.stream(orderedArr).sum();
//    }
}
