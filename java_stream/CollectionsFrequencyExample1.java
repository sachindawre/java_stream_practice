package java_stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsFrequencyExample1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        int frequency = Collections.frequency(list, "apple");
        System.out.println("Frequency of 'apple': " + frequency);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 1, 2, 1, 5, 6, 1);
        int count = Collections.frequency(numbers, 1);
        System.out.println("Frequency of 1: " + count);
    }
}
