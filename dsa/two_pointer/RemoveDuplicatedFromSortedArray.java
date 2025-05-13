package dsa.two_pointer;

import java.util.Arrays;

public class RemoveDuplicatedFromSortedArray {
    public static void main(String[] args) {
        int[] a = {1,1,2};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] a) {
        if (a.length < 2) {
            return a.length;
        }

        int i = 1;
        int j = 0;

        while (i < a.length) {
            if (a[i] != a[j]) {
                j++;
                a[j] = a[i];
            }
            i++;
        }
        System.out.println(Arrays.toString(a));
        return j + 1;

    }
}
