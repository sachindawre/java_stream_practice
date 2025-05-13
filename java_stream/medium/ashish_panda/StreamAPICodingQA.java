package java_stream.medium.ashish_panda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/// https://medium.com/@asishpanda444/stream-api-coding-qna-8df8682b7e2a
///
public class StreamAPICodingQA {
    public static void main(String[] args) {

        /// 1 Question: Given a list of integers, filter the even numbers.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> filterList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(filterList);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 2 Question: Find the maximum number from a list of integers.
        List<Integer> integerList = Arrays.asList(10, 20, 30, 40, 50);
        int max = integerList.stream().mapToInt(n -> n).max().orElse(0);
        System.out.println(max);
        /// another way
        max = integerList.stream().max(Comparator.comparing(Integer::intValue)).orElseThrow();
        System.out.println(max);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 3 Question: Sort a list of integers in descending order.
        List<Integer> numbers1 = Arrays.asList(3, 5, 1, 4, 2);
        List<Integer> list = numbers1.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .toList();
        System.out.println("Descending order: "+ list);

        /// another way
        list = numbers1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Descending order: "+ list);

        /// another way
        int[] ints = numbers1.stream().mapToInt(n -> n).toArray();
        /// convert Integer ArrayList to Integer[] using
        Integer[] boxed = Arrays.stream(ints).boxed().toArray(Integer[]::new);
        /// Arrays.sort() works with only primitive type in ascending order
        /// primitive types like int[] cannot use custom comparators, so you need to boxed types
        /// Use Collections.reverseOrder() only with object arrays like Integer[], Double[], String[] etc
        Arrays.sort(boxed, Collections.reverseOrder());
        System.out.println(Arrays.toString(boxed));

        /// ------------------------------------------------------------------------------------------------------------------
        /// 4 Question: Count strings starting with a specific prefix, e.g., “A”.
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        long count = names.stream()
                .filter(c -> c.startsWith("A"))
                .count();
        System.out.println(count);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 5 Question: Find the first non-repeated character in a string.
        String input = "swiss";
        Optional<Character> character = input.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(character.get());
        /// another way
        Character ch = input
                .chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst()
                .orElse(null);
        System.out.println(ch);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 6 Question: Convert all strings in a list to uppercase.
        List<String> names1 = Arrays.asList("java", "stream", "api");
        names1 = names1.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(names1);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 7 Question: Calculate the sum of all numbers in a list.
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers2.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum: " + sum);

        /// another way
        int sum1 = numbers2.stream().reduce(0, Integer::sum);
        System.out.println("sum1: " + sum1);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 8 Question: Check if any string in a list contains “API”.
        List<String> strings = Arrays.asList("Java", "Stream API", "Lambda");
        boolean isMatch = strings.stream()
                .anyMatch(s -> s.contains("API"));
        System.out.println(isMatch);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 9 Question: Identify duplicate elements in a list.
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        List<Integer >numbers4 = numbers3.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(numbers4);

        /// another way
        final Set<Integer> unique = new HashSet<>();
        Set<Integer> unique1 = numbers3.stream().filter(n -> !unique.add(n)).collect(Collectors.toSet());
        System.out.println(unique1);


        /// ------------------------------------------------------------------------------------------------------------------
        /// 10 Question: Group a list of strings based on their length.
        List<String> words = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 11 Question: Given a list of lists, flatten it into a single list.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> flattenList = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flattenList);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 12 Question: Concatenate all strings in a list into a single string.
        List<String> words1 = Arrays.asList("Stream", "API", "is", "powerful");
        String concatenatedString = words1.stream()
                .reduce("", (s1, s2) -> s1 + " " + s2).trim();
        System.out.println(concatenatedString);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 13 Question: Find the longest string in a list.
        List<String> words2 = Arrays.asList("Java", "Stream", "API", "Development");
        List<String> maxLengthString = words2.stream()
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
        System.out.println(maxLengthString);

        /// another way
        String longestString = words2.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println(longestString);

        /// another way using reduce()
        String longString = words2.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).orElse(null);
        System.out.println(longString);

        /// ------------------------------------------------------------------------------------------------------------------
        /// 14 Question: Count the frequency of each character in a string.
        String input1 = "success";
        Map<Character, Long> map7 = input1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map7);
    }
}
