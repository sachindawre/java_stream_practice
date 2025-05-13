package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class FindSumOfAllEvenNumbersInList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);
        int sum = list.
                stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n.intValue())
                .sum();
        System.out.println(sum);
    }
}
