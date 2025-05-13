package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class FindPalindromicStringsInAList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("madam", "racecar", "apple", "level", "banana");
        List<String> palindromeWords = words
                .stream()
                .filter(w -> new StringBuilder(w).reverse().toString().equals(w))
                .collect(Collectors.toList());
        System.out.println(palindromeWords);
    }
}
