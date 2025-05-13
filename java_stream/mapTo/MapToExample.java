package java_stream.mapTo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToExample {
    /// Definition
    /// IntStream mapToInt(ToIntFunction<? super T> mapper)
    /// mapToInt() is a specialized mapping function used in Stream<T>, which converts objects(T) into
    /// primitive int values
    /// It returns an IntStream(not a normal Stream<T>)
    /// Why use mapToInt()?
    /// Avoids unboxing overhead (which happens when converting between Integer and int)
    /// Improves performance for numerical operations like sum,average,min, max etc
    /// Allows working directly with primitive operations like .sum(), .average(), .max() etc


    /// mapToObject in Java Streams
    /// Definition
    /// <R> Stream<R> mapToObj(IntFunction<? extends R> mapper)
    /// Used with primitive streams (IntStream, LongStream, DoubleStream) to convert primitive
    /// values into Objects(Stream<T>)
    /// Why use mapToObj()?
    /// When we want to convert primitive values back into objects
    /// Useful for converting numerical values into meaningful objects

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /// Feature                     mapToInt()                          mapToObject()
    /// -----------------------------------------------------------------------------------------------------------
    /// Input Stream                Stream<T>(ObjectStream)             IntStream, LongStream, DoubleStream(Primitive Stream)
    /// Output Stream               IntStream(Primitive int)            Stream<R>(Object Stream)
    /// Purpose                     Extract int values from objects     Convert primitive into Objects
    /// Used for                    Sum, max, min, filtering numbers    Wrapping numbers, mapping to meaningful objects

    public static void main(String[] args) {
        /// Example Extracting length of Strings
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        IntStream length =  words.stream().mapToInt(String::length);
        System.out.println(Arrays.toString(length.toArray()));

        /// Example sum of square of even Numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n*n).sum();
        System.out.println(sum);

        /// Example IntStream to Stream<String>
        IntStream numbers1 = IntStream.range(1, 6);
        Stream<String> words1 =  numbers1.mapToObj(n -> "Number: " + n);
        words1.forEach(System.out::println);

        /// Example Convert ASCII values to Characters
        IntStream asciiCodes = IntStream.of(65, 66, 67, 68);
        Stream<Character> characterStream = asciiCodes.mapToObj(c -> (char) c);
        characterStream.forEach(System.out::println);

        /// Example mapToInt() convert Objects to Primitives
        List<String> names = Arrays.asList("John", "David", "Lisa");
        /// convert names into their length (primitive int)
        IntStream intStream = names.stream().mapToInt(String::length);
        int[] lengthArray = intStream.toArray();
        System.out.println(Arrays.toString(lengthArray));

        /// mapToObj() Convert Primitives to Objects
        IntStream intStream1 = IntStream.of(1, 4);
        /// Convert IntStream to Stream<Integer>
        List<Integer> list = intStream1.mapToObj(n -> n).collect(Collectors.toList());
        System.out.println(list);
    }
}
