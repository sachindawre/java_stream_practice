package dsa.revision;

import java.util.Arrays;

public class FirstNonRepeatingInteger {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4, 1, 0};
        //int[] arr = {4, 5, 4, 5, 3};
        System.out.println(firstNonRepeatingInteger_1(arr));
    }


    private static int firstNonRepeatingInteger(int[] arr) {
        int[] elements = new int[arr.length];
        int[] count = new int[arr.length];
        int uniqueCount = 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (elements[j] == arr[i]) {
                    count[j]++;
                    found = true;
                    break;
                }
            }
            if(!found) {
                elements[uniqueCount] = arr[i];
                count[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < elements.length; i++) {
            if (count[i] == 1) {
                return elements[i];
            }
        }
        return -1;
    }

    private static int firstNonRepeatingInteger_1(int[] arr) {
        int[] counts = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int k : arr) {
                if (arr[i] == k) {
                    count++;
                }
            }
            counts[i] = count;
        }
        System.out.println(Arrays.toString(counts));
        for (int i = 0; i<counts.length; i++) {
            if (counts[i] == 1) {
                return arr[i];
            }
        }
        return -1;
    }
}
