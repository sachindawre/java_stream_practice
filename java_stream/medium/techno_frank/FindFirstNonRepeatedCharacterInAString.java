package java_stream.medium.techno_frank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea
public class FindFirstNonRepeatedCharacterInAString {
    public static void main(String[] args) {
        String input = "aabbcdeff";
        Optional<Character> result = input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        if (result.isPresent()) {
            System.out.println("First Non-repeated character: " + result.get());
        } else {
            System.out.println("No Non-repeated character");
        }
    }
}
