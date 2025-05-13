package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class PartitionNumbersIntoEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> map = list
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers: " + map.get(true));
        System.out.println("Odd Numbers: " + map.get(false));
    }
}
