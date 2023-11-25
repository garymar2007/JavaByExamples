package generic;

import diamondProblem.A;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureTest {
    public static void main(String... args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        System.out.println(stringList.getClass());
        System.out.println(intList.getClass());

        System.out.println(stringList.getClass() == intList.getClass());
    }
}
