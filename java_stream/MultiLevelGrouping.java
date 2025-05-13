package java_stream;

import java.util.*;
import java.util.stream.Collectors;

class Employee1 {
    String name;
    String department;
    String experienceLevel; // Junior, Mid, Senior

    Employee1(String name, String department, String experienceLevel) {
        this.name = name;
        this.department = department;
        this.experienceLevel = experienceLevel;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class MultiLevelGrouping {
    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1("Alice", "IT", "Senior"),
                new Employee1("Bob", "IT", "Mid"),
                new Employee1("Charlie", "IT", "Senior"),
                new Employee1("David", "HR", "Junior"),
                new Employee1("Eve", "HR", "Mid"),
                new Employee1("Frank", "Finance", "Senior")
        );
        Map<String, Map<String, List<Employee1>>> map = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> emp.department,
                                Collectors.groupingBy(emp -> emp.experienceLevel)
                        )
                );

        System.out.println(map);

        //Example : Oldest Employee per Department
        Map<String, Optional<Employee1>> map1 = employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> emp.department,
                                Collectors.maxBy(Comparator.comparing(emp -> emp.experienceLevel))
                        )
                );
        System.out.println(map1);

        //Sorting groups by key(Department Name)
        Map<String, List<Employee1>> map3 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> emp.department, TreeMap::new, Collectors.toList()
                        )
                );
        System.out.println(map3);

        //Sorting groups by value(Number of Employees per Department)
        //Departments are sorted by the number of employees(descending order)

        Map<String, List<Employee1>> map4 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> emp.department, Collectors.toList()
                        )
                )
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> -e.getValue().size())) //sort by list size(descending)
                .collect(
                        Collectors.toMap(
                                Map.Entry :: getKey,
                                Map.Entry :: getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        )
                );

        System.out.println(map4);

        //sorting employee within each group
        //by default, groupingBY() does not sort elements inside each group. If we need employees sorted within
        //each department, we can sort them before collecting.

        Map<String, List<Employee1>> map5 = employees.stream()
                .sorted(Comparator.comparing(emp -> emp.name))
                .collect(
                        Collectors.groupingBy(
                                emp -> emp.department, LinkedHashMap::new, Collectors.toList()
                        )
                );
        System.out.println(map5);

        //custom sorting: Sorting by Experience Level First, Then name
        Map<String, List<Employee1>> map6 = employees.stream()
                .sorted(Comparator.comparing((Employee1 e) -> e.experienceLevel).thenComparing(e -> e.name))
                .collect(Collectors.groupingBy(emp -> emp.department, LinkedHashMap::new, Collectors.toList()));
        System.out.println(map6);
    }
}
