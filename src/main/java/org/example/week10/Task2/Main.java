package org.example.week10.Task2;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int ID;
    private List<Integer> grades;

    public Student(String name, int ID, List<Integer> grades) {
        this.name = name;
        this.ID = ID;
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
    }
}

class GradeAnalyzer {
    List<Integer> grades;

    public GradeAnalyzer(List<Integer> grades) {
        this.grades = grades;
    }

    public void printSummary() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = (double) sum / grades.size();
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + average);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Student student = new Student("John Doe", 12345, Arrays.asList(85, 90, 78, 92));
        GradeAnalyzer analyzer = new GradeAnalyzer(Arrays.asList(85, 90, 78, 92));

        System.out.println("--- Student Fields ---");
        Field[] studentFields = Student.class.getDeclaredFields();
        for (Field field : studentFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(student));
        }

        System.out.println("\n--- GradeAnalyzer Fields ---");
        Field[] analyzerFields = GradeAnalyzer.class.getDeclaredFields();
        for (Field field : analyzerFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(analyzer));
        }

        System.out.println("\n--- Invoking Student Methods ---");
        Method[] studentMethods = Student.class.getDeclaredMethods();
        for (Method method : studentMethods) {
            method.invoke(student);
        }

        System.out.println("\n--- Invoking GradeAnalyzer Methods ---");
        Method[] analyzerMethods = GradeAnalyzer.class.getDeclaredMethods();
        for (Method method : analyzerMethods) {
            method.invoke(analyzer);
        }
    }
}
