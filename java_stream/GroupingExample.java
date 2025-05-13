package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }
}
