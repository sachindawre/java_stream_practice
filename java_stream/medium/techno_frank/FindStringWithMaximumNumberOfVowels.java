package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindStringWithMaximumNumberOfVowels {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "education", "java");
        String maxVowelWord  = words
                .stream()
                .max(Comparator.comparing(FindStringWithMaximumNumberOfVowels::countVowels))
                .orElse("");
        System.out.println("Words with Maximum vowels: " + maxVowelWord);
    }

    private static int countVowels(String word) {
        return (int)word.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count();
    }
}
