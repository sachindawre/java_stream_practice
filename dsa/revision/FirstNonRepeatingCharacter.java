package dsa.revision;

import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabbcccddeef";
        System.out.println(usingHashset(s));
    }

    private static char firstNonRepeatingCharacter(String s) {
        char[] char1 = s.toCharArray();
        int[] counts = new int[char1.length];

        for (int i = 0; i < char1.length; i++) {
            int count = 0;
            for (int j = 0 ; j < char1.length; j++) {
                if (char1[i] == char1[j]) {
                    count++;
                }
            }
            counts[i] = count;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) {
                return char1[i];
            }
        }
        return '0';
    }

    private static char usingHashset(String s) {
        char[] chars = s.toCharArray();

        Set<Character> set = new HashSet<>();

        for (Character ch : chars) {
            if (!set.add(ch)) {
                return ch;
            }
        }
        return '0';
    }

}
