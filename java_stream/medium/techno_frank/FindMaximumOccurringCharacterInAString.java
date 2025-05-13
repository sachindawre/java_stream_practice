package java_stream.medium.techno_frank;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class FindMaximumOccurringCharacterInAString {
    public static void main(String[] args) {
        String input = "abbcccddddeeeee";
        Optional<Map.Entry<Character, Long>> map = input
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        if (map.isPresent()) {
            System.out.println("Max occurring character: " + map.get().getKey() + " occurred " + map.get().getValue());
        } else {
            System.out.println("No Characters Found");
        }

    }
}
