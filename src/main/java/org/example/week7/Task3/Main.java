package org.example.week7.Task3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public record EmployeeRecord(String name, String position, double salary, int employmentYear) {
    }

    public static void main(String[] args) {
        List<EmployeeRecord> employees = new ArrayList<>();
        employees.add(new EmployeeRecord("Alice", "Senior Developer", 90000, 2015));
        employees.add(new EmployeeRecord("Bob", "Intern", 1500, 2023));
        employees.add(new EmployeeRecord("Charlie", "Developer", 60000, 2020));
        employees.add(new EmployeeRecord("Diana", "Senior Developer", 95000, 2012));
        employees.add(new EmployeeRecord("Eve", "Intern", 1500, 2023));

        int currentYear = 2024;

        System.out.println("Employees with more than 5 years of service:");
        for (EmployeeRecord employee : employees) {
            if (currentYear - employee.employmentYear() > 5) {
                System.out.println(employee);
            }
        }

        String department = "Senior Developer";
        double totalSalary = 0;
        int count = 0;
        for (EmployeeRecord employee : employees) {
            if (employee.position().equals(department)) {
                totalSalary += employee.salary();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Average salary for " + department + ": " + (totalSalary / count));
        } else {
            System.out.println("No employees in the department: " + department);
        }

        String role = "Intern";
        System.out.println("Employees with the role: " + role);
        for (EmployeeRecord employee : employees) {
            if (employee.position().equals(role)) {
                System.out.println(employee);
            }
        }
    }
}
