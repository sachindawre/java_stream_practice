package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class FindCommonElementsBetweenTwoLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        List<Integer> commonElements = list1.stream().filter(list2::contains).toList();
        System.out.println(commonElements);
    }
}
