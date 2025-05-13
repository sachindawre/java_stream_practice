package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondHighestNumberInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> secondHighest = numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        if (secondHighest.isPresent()) {
            System.out.println(secondHighest.get());
        } else {
            System.out.println("Not Enough Elements");
        }
    }
}
