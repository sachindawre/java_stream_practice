package dsa.revision;

import java.util.Arrays;

public class Rearrange {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,-4,5};
        rearrange_2(arr);
    }

    public static void rearrange(int[] arr) {
        int negativeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeCount++;
            }
        }
        int positiveCount = 0;
        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            }
        }
        System.out.println(negativeCount);
        int[] negativeArray = new int[negativeCount];
        int[] positiveArray = new int[positiveCount];

        int j = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] < 0) {
                negativeArray[j] = arr[i];
                j++;
            }
        }
        int k = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] > 0) {
                positiveArray[k] = arr[i];
                k++;
            }
        }
        int[] mergedArray = new int[arr.length];
        System.arraycopy(negativeArray, 0, mergedArray, 0, negativeArray.length);
        System.arraycopy(positiveArray,0, mergedArray, negativeArray.length, positiveArray.length);
        System.out.println(Arrays.toString(mergedArray));
        // Write your code here
    }


    private static void rearrange_1(int[] arr) {
        int[] newArray = new int[arr.length];
        int index = 0;
        for (int k : arr) {
            if (k < 0) {
                newArray[index] = k;
                index++;
            }
        }

        for (int j : arr) {
            if (j > 0) {
                newArray[index] = j;
                index++;
            }
        }

        for (int i = 0; i<arr.length; i++){
            arr[i] = newArray[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange_2(int[] arr) {
        int leftMostPosEle = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] < 0) {
                if (i != leftMostPosEle) {
                    int temp = arr[i];
                    arr[i] = arr[leftMostPosEle];
                    arr[leftMostPosEle] = temp;
                }
                leftMostPosEle++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
