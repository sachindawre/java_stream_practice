package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyWithStreams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> frequencyMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of 'apple': " + frequencyMap.get("apple")); // Output: 3
        System.out.println("Frequency of 'banana': " + frequencyMap.get("banana")); // Output: 2
        System.out.println("Frequency of 'cherry': " + frequencyMap.get("cherry")); // Output: 1

        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 1, 5, 6, 1);
        Map<Integer, Long> map = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        Map<Integer, Long> frequencyMap1 = IntStream.of(1, 2, 3, 1, 2, 1, 5, 6, 1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
