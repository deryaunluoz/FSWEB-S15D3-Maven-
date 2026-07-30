package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        Set<Integer> seenIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (!seenIds.add(employee.getId())) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) continue;
            uniqueMap.put(employee.getId(), employee);
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) continue;
            countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (countMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }
        return result;
    }
}