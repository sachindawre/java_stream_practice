package java_stream.medium.techno_frank;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class FindAverageOfListOfIntegers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        OptionalDouble optionalDouble = numbers.stream().mapToInt(i -> i).average();
        //System.out.println(optionalDouble.getAsDouble());
        if (optionalDouble.isPresent()) {
            System.out.println(optionalDouble.getAsDouble());
        } else {
            System.out.println("List is empty");
        }
    }
}
