package dsa.revision.sorting_algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 30, 15, 1, 3, 1, 40, 8, 7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIdx = partition(arr, start, end);
            quickSort(arr, start, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int idx = start-1;
        int pivot = arr[end];

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                idx++;
                swap(arr, idx, j);
            }
        }

        idx++;
        swap(arr, idx, end);
        return idx;
    }

    private static void swap(int[] arr, int i, int j) {
        //System.out.println(" arr: " + Arrays.toString(arr) + " idx: " + i + " j: " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
