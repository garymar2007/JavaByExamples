package problemSolving;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies.
 * For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
 */
public class Anagram {
    public static void main(String... args) {
        System.out.println("anaGrAm and margaNa are angram? " + isAnagram("anagram","margana"));
        System.out.println("anagramm and marganaa are angram? " + isAnagram("anagramm","marganaa"));

        System.out.println("anaGrAm and margaNa are angram? " + isAnagramInJava8("anagram","margana"));
        System.out.println("anagramm and marganaa are angram? " + isAnagramInJava8("anagramm","marganaa"));
    }

    public static boolean isAnagramInJava8(String a, String b){
        String sortedA = a.chars().map((c) -> Character.toLowerCase(c))
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String sortedB = b.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return sortedA.equalsIgnoreCase(sortedB);
    }

    public static boolean isAnagram(String a, String b) {
        Map<Character, Integer> stringAMap = transformer(a);
        Map<Character, Integer> stringBMap = transformer(b);

        return compareMaps(stringAMap, stringBMap);
    }

    private static Map<Character, Integer> transformer(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if(characterIntegerMap.containsKey(Character.toLowerCase(key))
                    || characterIntegerMap.containsKey(Character.toUpperCase(key))) {
                Integer value = characterIntegerMap.get(key);
                characterIntegerMap.replace(key, value, value + 1);
            } else {
                characterIntegerMap.put(key, 1);
            }
        }

        return characterIntegerMap;
    }

    private static boolean compareMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        AtomicBoolean result = new AtomicBoolean(true);
        map1.forEach((k, v) -> {
            if(map2.get(k) != v) {
                result.set(false);
            }
        });

        return result.get();
    }
}
