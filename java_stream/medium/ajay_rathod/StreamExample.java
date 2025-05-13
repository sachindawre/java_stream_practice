package java_stream.medium.ajay_rathod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    String firstName;
    int age;
    double salary;
    public Employee(String firstName, int age, double salary) {
        this.firstName = firstName;
        this.age = age;
        this.salary = salary;
    }
    public String toString() {
        return firstName + " " + age + " " + salary;
    }
}
public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees1 = new ArrayList<>();
        Employee e1 = new Employee("Ajay",35, 123123.12);
        Employee e2 = new Employee("Vijay",5, 2344234.10);
        Employee e3 = new Employee("Zack",30, 123123.90);

        List<Employee> employees2 = new ArrayList<>();
        Employee e4 = new Employee("David",51, 233232.10);
        Employee e5 = new Employee("Alice",30, 32344.50);
        Employee e6 = new Employee("Bob",51, 343434.60);

        employees1.add(e1);
        employees1.add(e2);
        employees1.add(e3);
        employees2.add(e4);
        employees2.add(e5);
        employees2.add(e6);

        /// Find employees name starting with Alphabet
        String ch = "A";
        List<Employee> emp = employees1.stream().filter(e -> e.firstName.startsWith(ch)).toList();
        System.out.println(emp);

        /// Merge two employee list and sort by age

        List<Employee> emps = Stream
                .concat(
                        employees1.stream(), employees2.stream()
                )
                .sorted(
                        Comparator.comparingInt(e -> e.age)
                )
                .collect(Collectors.toList());
        System.out.println(emps);

        /// Find even number from ArrayList and find the sum of all numbers

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int sum = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        /// Sort Employee by name and salary

        List<Employee> emps1 = employees1.stream()
                .sorted(
                        Comparator.comparing(
                                (Employee e) -> e.firstName)
                                .thenComparingDouble(e -> e.salary))
                .toList();
        System.out.println(emps1);

        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        Object[] arr = nums.toArray();
        System.out.println(arr);
    }



}
