package java_stream.medium.lets_learn_now;

//https://blog.stackademic.com/java-streams-patterns-every-developer-should-master-streams-all-in-one-cac1ac4e0331

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllStreamPattern {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> namesStream = names.stream();
        String[] arr = {"John", "Jane", "Jake"};
        Stream<String> arrayStream = Arrays.stream(arr);

        //Using Stream.of
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
        //InfiniteStream
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2).limit(10);
        infiniteStream.forEach(System.out::println);

        //Intermediate Operation
        //filter(predicate)
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

        //Transform each Element
        //map(Function)
        List<String> uppercaseNames = names.stream().map(String::toUpperCase).toList();
        System.out.println(uppercaseNames);

        //sorted
        //sort the elements
        names.stream().sorted().forEach(System.out::println);

        //distinct
        //remove the duplicates
        Stream.of(1, 2, 2, 3, 3, 4).distinct().forEach(System.out::println);

        //limit(n) and skip(n)
        //Limits or skips elements.
        Stream.iterate(1, n -> n + 1).limit(5).forEach(System.out::println);

        /// Terminal Operations

        //Terminal operations trigger the stream pipeline.
        //collect() - Collects the elements into a collection.
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 3)
                .toList();
        System.out.println(filteredNames);

        //forEach() Performs an action on each element.
        names.forEach(System.out::println);

        // reduce() - Reduces the stream to a single value.
        Optional<Integer> sum = Stream.of(1, 2, 3, 4, 5)
                .reduce((a, b) -> a + b);
        System.out.println(sum);

        //count() - Counts the elements.
        long count = names.stream().count();
        System.out.println(count);

        //findFirst() and findAny() - Finds an element.
        Optional<String> firstName = names.stream().findFirst();
        System.out.println(firstName.get());

        //anyMatch, allMatch, noneMatch - Checks conditions.
        boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("A"));
        boolean allMatch = names.stream().allMatch(name -> name.length() > 1);
        boolean noneMatch = names.stream().noneMatch(name -> name.isEmpty());
        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);
    }
}
