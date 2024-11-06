package org.gary.problemSolving;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindFactors {
    public static int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    public static int findLCM(List<Integer> arr, int index) {
        if(index == arr.size() -1) {
            return arr.get(index);
        }
        int a = arr.get(index);
        int b = findLCM(arr, index+1);

        return (a * b / findGCD(a,b));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int counter = 0;
        int lcm = findLCM(a, 0);

        List<Integer> orderedB = b.stream().sorted().collect(Collectors.toList());
        for(int factor = lcm, multiple = 1;
            factor <= orderedB.get(0).intValue();
            multiple++, factor = lcm * multiple) {
            boolean isDivisibleForAll = true;
            for(int ele : orderedB) {
                if(ele % factor != 0) {
                    isDivisibleForAll = false;
                }
            }
            if(isDivisibleForAll) {
                counter++;

            }
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
