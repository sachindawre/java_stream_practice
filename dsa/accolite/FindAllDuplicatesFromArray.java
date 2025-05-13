package dsa.accolite;

import java.util.Arrays;

public class FindAllDuplicatesFromArray {
    public static void main(String[] args) {
        int[] arr = {5, 8, 8, 10, 11, 10, 13, 1, 2, 1};
        int[] result = findAllDuplicates(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findAllDuplicates(int[] arr) {
        int[] duplicates = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                boolean alreadyExists = false;
                for (int k = 0; k < count; k++) {
                    if (duplicates[i] == arr[i]) {
                        alreadyExists = true;
                        break;
                    }
                }
                if (!alreadyExists) {
                    duplicates[count] = arr[i];
                    count++;
                }
            }
        }
        return duplicates;
    }
}
