package java_stream.medium.techno_frank;

import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class RemoveDuplicatesFromAString {
    public static void main(String[] args) {
        String input = "banana";

        String result = input.chars()
                .mapToObj(c -> (char)c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
