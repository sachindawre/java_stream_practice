package java_stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromArray {
    public static void main(String[] args) {
        String[] array = {"Apple", "Banana", "Cherry"};

        Stream<String> stream = Arrays.stream(array);
        stream.forEach(System.out::println);

        Stream<String> stream1 =  Stream.of(array);
        stream1.forEach(System.out::println);
    }
}
