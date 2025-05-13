package java_stream.medium.techno_frank;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeparatePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, 2, -1, 3, -4, 6, -7);
        Map<Boolean, List<Integer>> map = numbers.stream().collect(Collectors.partitioningBy(n -> n > 0));
        System.out.println("Positive Numbers: " + map.get(true));
        System.out.println("Negative Numbers: " + map.get(false));
    }
}
