package org.gary.problemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DivisibleSumPairs {

    public static void main(String... args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println(divisibleSumPairs(n, k, ar));
    }

    public static int divisibleSumPairs(int size, int divisor, List<Integer> ar) {
        int counter = 0;
        for(int i = 0; i < size; i++){
            for(int j = i +1; j < size; j++){
                if ((ar.get(i) + ar.get(j)) % divisor == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
