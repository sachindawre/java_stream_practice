package java_stream.medium.techno_frank;

//https://medium.com/@tecnoflank/java-stream-most-asked-coding-problems-part-2-74bf9bf40aea

public class SumOfAllDigitsInANumber {
    public static void main(String[] args) {
        int number = 12345;
        int sum = String.valueOf(number).chars().map(c -> Character.getNumericValue(c)).sum();
        System.out.println(sum);
    }
}
