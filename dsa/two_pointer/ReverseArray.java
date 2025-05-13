package dsa.two_pointer;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arrToReverse = {10, 20, 30, 40, 50};
        reverseArray(arrToReverse);
        System.out.println(Arrays.toString(arrToReverse));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while(left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
