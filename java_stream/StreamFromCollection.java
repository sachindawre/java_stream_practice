package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFromCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
    }
}
