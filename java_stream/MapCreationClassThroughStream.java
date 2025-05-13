package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapCreationClassThroughStream {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", null, "banana", "cherry", "date","apple", "grape", null, "banana");

        Map<String, Integer> map = stringList.stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toMap(e -> e, String::length));

        System.out.println(map);
    }
}
