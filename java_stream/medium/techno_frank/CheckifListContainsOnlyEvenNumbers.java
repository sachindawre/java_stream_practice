package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;
//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-3-4b1bb1c00f5e
public class CheckifListContainsOnlyEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("All numbers are even: " + allEven);
    }
}
