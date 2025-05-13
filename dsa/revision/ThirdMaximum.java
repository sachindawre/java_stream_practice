package dsa.revision;

public class ThirdMaximum {
    public static void main(String[] args) {
        int[] arr = {4,10,10,8,9};
        System.out.println(thirdMax(arr));
    }

    private static int thirdMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num != max && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num != secondMax && num > thirdMax) {
                thirdMax = num;
            }
        }
        return thirdMax;
    }
}
