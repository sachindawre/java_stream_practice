package dsa.longest_consecutive;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        //int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {9, 1, 4, 7, 3, 2, 8, 5, 6, 0};
        System.out.println(longestConsecutiveLength(nums));
    }

    public static int longestConsecutiveLength(int[] array) {
        Set<Integer> set = new HashSet<>(array.length);
        for (int num : array) {
            set.add(num);
        }

        int maxLength = 0;

        for (int i = 0; i< array.length; i++) {

            //only check if num is the start of the sequence
            if (!set.contains(array[i] - 1)) {
                int currentNum = array[i];
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                maxLength = Math.max(maxLength, currentStreak);
            }
        }
        return maxLength;
    }
}
