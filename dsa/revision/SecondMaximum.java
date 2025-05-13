package dsa.revision;

public class SecondMaximum {
    public static void main(String[] args) {
        int[] arr = {4,10,10,8,9};
        System.out.println(secondMaximum(arr));
    }

    private static int secondMaximum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num != max && num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}
