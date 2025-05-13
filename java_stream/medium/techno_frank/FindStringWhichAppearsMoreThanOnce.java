package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindStringWhichAppearsMoreThanOnce {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana");

        Set<String> set = new HashSet<>();
        Set<String> duplicateWords = words.stream().filter(w -> !set.add(w)).collect(Collectors.toSet());
        System.out.println(duplicateWords);
    }
}
