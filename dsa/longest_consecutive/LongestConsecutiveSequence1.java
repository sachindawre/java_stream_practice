package dsa.longest_consecutive;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence1 {
    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 7, 3, 2, 8, 5, 6, 0};
        System.out.println(calculateLongestConsecutiveSequence(nums));
    }

    public static int calculateLongestConsecutiveSequence(int[] array) {
        Set<Integer> set = new HashSet<>(array.length);
        for (int num : array) {
            set.add(num);
        }

        int maxLength = 0;

        for(Integer num : set) {
            //ony check if num is a start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
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
