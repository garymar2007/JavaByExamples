package org.gary.anagramstring;

public class AnagramString {

    public static void main(String... args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(str1 + " and " + str2 +
                (isAnagram(str1, str2) ? " are anagrams" : " are not anagrams"));
    }

    public static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replace("\\s", "");
        String s2 = str2.replace("\\s", "");
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] str1Array = s1.toLowerCase().toCharArray();
            char[] str2Array = s2.toLowerCase().toCharArray();
            java.util.Arrays.sort(str1Array);
            java.util.Arrays.sort(str2Array);
            return java.util.Arrays.equals(str1Array, str2Array);
        }
    }
}
