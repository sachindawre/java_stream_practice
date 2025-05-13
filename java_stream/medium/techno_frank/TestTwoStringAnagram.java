package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-3-4b1bb1c00f5e
//Check if Two Strings are Anagrams

public class TestTwoStringAnagram {

    private static boolean isAnagram(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        if (char1.length > char2.length ) {
            return false;
        }
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i=0; i < char1.length; i++) {
            if (char1[i] != char2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(isAnagramUsingStream(str1, str2));
    }

    private static boolean isAnagramUsingStream(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() > s2.length()) {
            return false;
        }

        return sortString(s1).equals(sortString(s2));
    }

    private static String sortString(String s1) {
        return s1.chars()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
