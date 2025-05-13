package dsa.revision;

public class ThirdMaximum_1 {
    public static void main(String[] args) {
        int[] arr = {4, 10, 10, 9, 9};
        System.out.println(thirdMax(arr));
    }

    private static int thirdMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        ///  lets find out the second max element
        for (int num : arr) {
            if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        /// lets find out third max
        for (int num : arr) {
            if (num > thirdMax && num < secondMax) {
                thirdMax = num;
            }
        }
        return thirdMax;
    }
}
