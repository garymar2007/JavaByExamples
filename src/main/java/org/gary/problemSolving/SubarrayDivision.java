package org.gary.problemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SubarrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = birthday(s, d, m);
        System.out.println(result);
        bufferedReader.close();
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int counter = 0;
        for(int i = 0; i + m <= s.size(); i++){
            int sum = s.get(i);
            for(int j = 1; j < m; j++) {
                sum += s.get(i + j);
            }
            if(sum % d == 0) {
                counter++;
            }
        }
        return counter;
    }
}
