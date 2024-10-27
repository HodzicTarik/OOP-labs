package org.example.week4.Task4;

/* Napravio sam klasu za Task 3 i Task 4 kako ne bih nadovezivao na Task 1,
jer je malo neuredan pa se ovde bolje vidi */

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        s1.addGrade(4);
        s1.addGrade(2);
        s1.addGrade(3);
        s1.addGrade(5);
        s1.addGrade(1);
        System.out.println("Grades: " + s1.getGrade());
    }
}
