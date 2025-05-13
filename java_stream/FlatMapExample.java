package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(Arrays.asList("Hello", "World"),
                Arrays.asList("Java", "Streams"),
                Arrays.asList("FlatMap", "Example"));

        List<String> listOfWords = list.stream().flatMap(l -> l.stream())
                .collect(Collectors.toList());
        System.out.println(listOfWords);
    }
}
