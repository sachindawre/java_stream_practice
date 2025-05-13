package java_stream.collectors_api;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Employee{
    String name, department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }

}

public class GroupingByExample {
    public static void main(String[] args) {
        /// Collectors.groupingBy syntax and overloaded methods
        /// Collectors.groupingBy(classifier)
        /// Collectors.groupingBy(classifier, downstreamCollector)
        /// Collectors.groupingBy(classifier, mapFactory, downstreamCollector)


        ////Collectors.groupingBy() is a collector function in java's stream API, which
        ////groups elements in a collection by a classifier function and stores them in a map
        ////Syntax - Map<K, List<T>> map = stream.collect(Collectors.groupingBy(classifier))
        ////classifier - A function that extracts the key(grouping criterion)
        ////Result - Map<K, List<T>>  where
        ////k - is the key extracted by classifier
        ////List<T> - contains all the elements belonging to that group
        ////Example - Grouping Strings by length
        List<String> words = Arrays.asList("apple", "banana", "cherry", "dog", "cat", "ant");
        Map<Integer, List<String>> map = words.stream()
                .collect(
                        groupingBy(String::length)
                );
        ////Groups words by their length
        ////The key(Integer) represents word length
        ////The value(List<String>) contains the words of that length
        System.out.println(map);

        ////Example - Using custom classifier
        ////Instead of build-in method like String::length, we can group by custom condition
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT"),
                new Employee("Bob", "HR"),
                new Employee("Charlie", "IT"),
                new Employee("David", "HR"),
                new Employee("Eve", "Finance")
        );
        Map<String, List<Employee>> map2 = employees.stream().collect(groupingBy(e -> e.department));
        System.out.println(map2);

        ////Using a Downstream Collector
        ////Collectors.groupingBy() can combine with other collectors like counting(), mapping() etc.
        ////Syntax - Collectors.groupingBy(classifier, downstreamCollector)
        ////Example - Counting elements in each group
        List<String> words1 = Arrays.asList("apple", "banana", "cherry", "dog", "cat", "ant", "apple", "banana");
        Map<String, Long> map3 = words1.stream()
                .collect(groupingBy(w -> w, Collectors.counting()));
        System.out.println(map3);

        ////Nested Grouping(Multi-Level Grouping)
        ////We can group by multiple levels using nested groupingBy
        ////Example: Group Employees by Department, then by Name Length
        Map<String, Map<Integer, List<Employee>>> map5 = employees.stream()
                .collect(
                        groupingBy(emp -> emp.department,
                                groupingBy(e -> e.name.length())
                            )
                        );
        ////First groups by department
        ////Then groups inside each department by name length
        System.out.println(map5);

        ////Using mapping() with groupingBy()
        ////We can extract only specific values instead of entire objects
        /// Example Group by Department and Store only Names
        Map<String, List<String>> map6 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.department,
                                Collectors.mapping(e -> e.name, Collectors.toList())
                        )
                );
        /// Group employees by department
        /// stores only employees name, not full objects
        System.out.println(map6);

        /// Using TreeMap for sorted grouping
        /// By default, groupingBy() returns HashMap, but we can sort it
        Map<String, List<Employee>> map7 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.department,
                                TreeMap::new,
                                Collectors.toList()
                        )
                );
        /// Uses TreeMap::new to sort keys alphabetically
        /// Now, the result is sorted by department
        System.out.println(map7);


        /// Custom collector in groupingBy()
        /// We can use out own collector instead of build-in ones
        /// Example - Get the Longest name in Each Group
        Map<String, Optional<Employee>> map9 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.department,
                                Collectors.maxBy(Comparator.comparing(e -> e.name.length()))
                        )
                );
        /// Use maxBy() to store only the longest name per department
        System.out.println(map9);
    }
}
