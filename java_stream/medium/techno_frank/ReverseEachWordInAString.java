package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class ReverseEachWordInAString {
    public static void main(String[] args) {
        String sentence = "Hello World Java";
        String reversed = Arrays.stream(sentence.split(" "))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Reversed words: " + reversed);
    }
}
