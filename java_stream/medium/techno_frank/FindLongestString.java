package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindLongestString {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "springboot", "hibernate", "api");
        String longest = words.stream().max(Comparator.comparing(String::length)).orElse("");
        System.out.println(longest);
    }
}
