package dsa.two_pointer;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(sortedArray);
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(sortedArray, newLength)));
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        return uniqueIndex + 1;
    }
}
