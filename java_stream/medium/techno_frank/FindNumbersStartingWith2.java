package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Find Numbers Starting With 2
public class FindNumbersStartingWith2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(21, 32, 25, 42, 29, 12);
        List<Integer> list = numbers.stream().filter(n -> String.valueOf(n).startsWith("2"))
                .toList();
        System.out.println(list);
    }
}
