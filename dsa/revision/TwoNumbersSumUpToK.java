package dsa.revision;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/// Given an array of integers, nums, and an integer target, k, find two numbers in the array that
/// sum up to the target k.
/// There is exactly one solution for each input, and each element of the array can only be
/// used once in the solution. The order of the returned elements does not matter.
public class TwoNumbersSumUpToK {
    public static void main(String[] args) {
        int k = 10;
        int[] arr = {2, 5, 6, 8, 9};
        System.out.println(Arrays.toString(twoNumbersSumUpToK(arr, k)));
        System.out.println(Arrays.toString(twoNumbersSumUpToK_1(arr, k)));
    }

    /// using brute force approach
    private static int[] twoNumbersSumUpToK(int[] arr, int k) {
        int[] result = new int[2];
        for (int i = 0; i<arr.length; i++) {
            for (int j = i + 1; j<arr.length; j++) {
                if (k == arr[i] + arr[j]) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return result;
    }


    /// Using hashset
    private static int[] twoNumbersSumUpToK_1(int[] arr, int k) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            int n = k - num;
            if (set.contains(n)) {
                result[0] = num;
                result[1] = n;
                return result;
            }
        }
        return result;
    }
}
