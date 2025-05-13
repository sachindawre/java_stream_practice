package java_stream.collectors_api;

import java.util.*;
import java.util.stream.Collectors;

public class ToMapExample {
    public static void main(String[] args) {

        //Syntax - Collectors.toMap(keyMapper, valueMapper)
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(k -> k, String::length));
        System.out.println(map);

        //Using a Merge Function to Resolve Duplicate Keys
        //syntax - toMap(keyMapper, valueMapper, mergeFunction)
        //mergeFunction → Determines how to handle duplicates.
        //merge function
        List<String> list1 = Arrays.asList("apple", "banana", "orange", "apple");
        Map<String, Integer> map2 = list1.stream().collect(Collectors.toMap(k -> k, v -> v.length(), Integer::sum));
        System.out.println(map2);

        //Using a Merge Function to Resolve Duplicate Keys
        //syntax - toMap(keyMapper, valueMapper, mergeFunction)
        //mergeFunction → Determines how to handle duplicates.
        //merge function
        List<String> names = Arrays.asList("John", "Jane", "John");
        Map<String, Integer> map3 = names.stream()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        System.out.println(map3);

        //Print duplicate elements
        List<String> names1 = Arrays.asList("John", "Jane", "John", "Bob", "Alice", "Bob");
        List<String> list3 = names1.stream()
                .collect(
                        Collectors.toMap(k -> k, v -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list3);

        //Using custom merge function
        //Lambda - (oldValue, newValue) -> oldValue >= newValue ? oldValue : newValue
        //keeps the longest value when duplicates exist.
        List<String> names2 = Arrays.asList("John", "Jane", "John", "Bob", "Alice", "Bob");
        Map<String, String> map5 = names2.stream()
                .collect(
                        Collectors.toMap(
                                k -> k.substring(0, 1),
                                v -> v,
                                (oldValue, newValue) -> oldValue.length() >= newValue.length() ? oldValue : newValue
                        )
                );
        System.out.println(map5);

        //Using a Custom Map Implementation
        //By default, Collectors.toMap() returns a HashMap, but you can specify another map type.
        //Syntax - toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)
        //mapSupplier → Defines which Map implementation to use.
        Map<String, Integer> map8 = names2.stream()
                .collect(Collectors.toMap(
                        k -> k,
                        v -> 1,
                              Integer::sum,
                        TreeMap::new
                ));
        System.out.println(map8);
    }
}
