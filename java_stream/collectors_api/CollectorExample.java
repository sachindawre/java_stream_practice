package java_stream.collectors_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {
    public static void main(String[] args) {
        //keep duplicates, maintains order, do not remove duplicates
        List<String> fruits = Stream.of("Apple", "Banana", "Mango", "Apple").toList();
        System.out.println(fruits);

        //toSet() - Collecting Elements into a Set
        //Remove duplicates, order is not guaranteed
        List<String> lists = Arrays.asList("Apple", "Banana", "Mango", "Apple");
        Set<String> set = lists.stream().collect(Collectors.toSet());
        System.out.println(set);

        //toMap() - Collecting Elements into a Map
        //keys must be unique(use merge function for duplicate keys)
        //can specify key-mapper, value-mapper, and merge function
        List<String> lists1 = Arrays.asList("Apple", "Banana", "Mango");
        Map<String, Integer> map =  lists1.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        //handle duplicate keys using merge function
        //Flexible, allows key-value transformation
        //Duplicate keys cause errors(need merge function)
        List<String> lists2 = Arrays.asList("Apple", "Banana", "Mango", "Apple");
        Map<String, Long> map1 = lists2.stream()
                .collect(Collectors.toMap(Function.identity(), w -> 1L, Long::sum));
        System.out.println(map1);
    }
}
