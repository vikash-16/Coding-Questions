package JavaExample;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = getEmpList();
        //todo:: filter method example
        empList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("Male")).forEach(e-> System.out.println(e));
        System.out.println();
        //todo:: sort method example
        empList.stream().sorted(Comparator.comparing(Employee::getRating).reversed()).forEach(e-> System.out.println(e));
        boolean b = empList.stream().allMatch(e -> e.getSalary() > 100000);
        System.out.println(b);
        empList.stream().min(Comparator.comparing(employee -> employee.getSalary())).ifPresent(System.out::println);
        System.out.println();
        empList.stream().filter(e->e.getSalary()>100000).max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
        System.out.println();
        Map<String, List<Employee>> employeesBygender = empList.stream().collect(groupingBy(Employee::getGender));
        System.out.println(employeesBygender.toString());
        employeesBygender.forEach(((g,e)->{
            System.out.println(g);
            e.forEach(System.out::println);
        }));
        System.out.println("firstName with e char");
        empList.stream().filter(k->k.getFirstName().contains("e")).collect(Collectors.toList()).forEach(e-> System.out.println(e));

        System.out.println("<----------------average of males and female salary");
        Map<String, Double> collect = empList.stream().collect(groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect);

        System.out.println("Max salary of male and female");
//        empList.stream().collect(groupingBy(Employee::getGender, mapping(Employee::getSalary, toList()))).forEach((k,v)->v.stream().min(Comparator.comparing(Integer::intValue)).isPresent(System.out::println));
        Map<String, Integer> minSalaryByGender = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(Employee::getSalary, Collectors.minBy(Integer::compareTo))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().orElse(0)
                ));
        System.out.println(minSalaryByGender);

        System.out.println("increase all salary by 20%");
        empList.stream().map(employee -> {
            if(employee.getGender().equalsIgnoreCase("Male")) {
                int salary = employee.getSalary();
                employee.setSalary(salary + (salary * 20) / 100);
                return employee;
            }
            return employee;
        }).toList().forEach(employee -> System.out.println(employee));
        System.out.println('A'-0);
    }
    public static List<Employee> getEmpList(){
        return Arrays.asList(
                new Employee("59-385-1088","Zacharias","Schwerin","zchwerin@gmail.com","Male","True",101146,0),
                new Employee("73-274-6476","Kyle","Frudd","kfrudd1@ovh.net","Male","FALSE",29310,2),
                new Employee("85-939-9584","Axe","Gumb","agumb2@twitter.com","Female","FALSE",62291,4),
                new Employee("08-180-8292","Robinet","Batterham","rbatterham3@last.fm","Male","FALSE",142439,4),
                new Employee("21-825-2623","Ulick","Burrel","uburrel4@google.ru","Male","FALSE",128764,5),
                new Employee("66-708-5539","Tailor","Ridding","Ridding","Female","FALSE",152924,4),
                new Employee("81-697-2363","Joete","Braybrooke","jbraybrooke6@prnewswire.com","Male","TRUE",128907,0),
                new Employee("63-019-1110","Elroy","Baverstock","ebaverstock7@ehow.com","Male","TRUE",2510,0)
        );
    }
}
