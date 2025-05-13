package dsa.revision;

public class SecondMaximum_1 {
    public static void main(String[] args) {
        int[] arr = {4, 10, 10, 8, 9};
        System.out.println(secondMaximum(arr));
    }

    private static int secondMaximum(int[] arr) {
        /// lets find out the max element first

        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int secondMax = Integer.MIN_VALUE;
        /// lets find out the second max
        for (int num : arr) {
            if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}
