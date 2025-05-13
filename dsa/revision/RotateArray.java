package dsa.revision;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {-1, 90, -90, 4, 6};
        int[] rotatedArray = rotateArray_1(arr, 3);
        System.out.println(Arrays.toString(rotatedArray));
    }

    private static int[] rotateArray(int[] arr, int k) {
        if (arr.length == 0) {
            k = 0;
        } else {
            k = k % arr.length;
        }
        int[] rotatedArray = new int[arr.length];
        System.arraycopy(arr, arr.length - k , rotatedArray, 0, k);
        System.arraycopy(arr, 0, rotatedArray, k, arr.length - k);
        return rotatedArray;
    }

    private static int[] rotateArray_1(int[] arr, int k) {
        if (arr.length == 0) {
            k = 0;
        } else {
            k = k % arr.length;
        }

        int[] rotatedArray = new int[arr.length];

        for (int i = 0; i < k;i++) {
            rotatedArray[i] = arr[arr.length - k + i];
        }

        for (int i = k; i < arr.length; i++) {
            rotatedArray[i] = arr[i - k];
        }
        return rotatedArray;
    }
}
