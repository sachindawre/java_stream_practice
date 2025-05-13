package java_stream.medium.techno_frank;

import java.util.*;
import java.util.stream.Collectors;

public class FindElementOccurringMostTimes {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4);
        Optional<Map.Entry<Integer, Long>> map = numbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        if (map.isPresent()) {
            System.out.println("Most frequent Element: " + map.get().getKey() + " (Occurred " + map.get().getValue() + " times)");
        } else {
            System.out.println("List is empty");
        }
    }
}
