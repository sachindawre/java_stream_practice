package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class GroupingByDepartment {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "IT"),
                new Employee("David", "HR"),
                new Employee("Eve", "Finance")
        );
        Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(emp -> emp.department));
        System.out.println(map);

        //by default groupingBy() collects elements into a List<T>, but we can change the collector to
        //1) toSet() Store unique values
        //2) counting() - Count occurrences
        //3) summarizingInt(), summingInt() etc - Perform aggregations
        Map<String, Long> map1 = employees.stream().collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));
        System.out.println(map1);

        //If we want only unique elements(e.g. unique names per department), we can use toSet()
        //Example - Unique Employee Names per Deparment
        Map<String, Set<String>> map2 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> emp.department,
                                mapping(emp-> emp.name, Collectors.toSet())
                        )
                );
        System.out.println(map2);

    }
}
