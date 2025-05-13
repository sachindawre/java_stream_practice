package dsa.accolite;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String sortedStr = "aaabbbbccdd";
        char target = 'b';

        System.out.println(findFrequency(sortedStr, target));
    }

    //for sorted
    private static int findFrequency(String str, char ch) {
        int count = 0;
        char[] ch1 = str.toCharArray();

        for (char c : ch1) {
            if (ch == c) {
                count++;
            } else if (ch < c) {
                break;
            }
        }
        return count;
    }

    //for unsorted
    private static int findFrequency_1(String str, char ch) {
        int count = 0;
        char[] ch2 = str.toCharArray();

        for (char c : ch2) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    //using stream
    private static long find_frequency_2(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }

    /// Find the Most Frequent Character in a String (Java 8 Streams)
    private static void findMostFrequentCharacterInString(String str) {
        Optional<Map.Entry<Character, Long>> map =  str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                ).entrySet().stream().max(Map.Entry.comparingByValue());
        map.ifPresent(e -> System.out.println("Most Frequent: "  + e.getKey() + " appears" + e.getValue()));
    }

    /// Get Frequency Map of All Characters (Java 8 Streams)
    private static void getFrequencyOfAllCharacters(String str) {
        Map<Character, Long> map =  str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    ///  sort the frequency map by count descending,
    private static void getSortedFrequencyMap(String str) {
        Map<Character, Long> map = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e2,
                                LinkedHashMap::new)
                );
    }
}
