package org.example.week11.Task1;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private String university;
    private String department;
    private double gpa;

    public Student(int id, String name, String university, String department, double gpa) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name;
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class InvalidStudentDataException extends Exception {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}

class StudentSystem {
    private List<Student> students;

    public StudentSystem(String filename) throws IOException, InvalidStudentDataException {
        this.students = readStudents(filename);
        validateStudentData(students);
    }

    public StudentSystem(List<Student> students) throws InvalidStudentDataException {
        validateStudentData(students);
        this.students = students;
    }

    public static List<Student> readStudents(String filename) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) continue;
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String university = parts[2].trim();
                String department = parts[3].trim();
                double gpa = Double.parseDouble(parts[4].trim());
                students.add(new Student(id, name, university, department, gpa));
            }
        }
        return students;
    }

    public int noOfStudents() {
        return students.size();
    }

    public Student getStudentById(int id) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }

    public Student getHighestGPAStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        Student highestGpaStudent = students.get(0);
        for (Student student : students) {
            if (student.getGpa() > highestGpaStudent.getGpa()) {
                highestGpaStudent = student;
            }
        }
        return highestGpaStudent;
    }

    public Student getLongestNameStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        Student longestNameStudent = students.get(0);
        for (Student student : students) {
            if (student.getName().length() > longestNameStudent.getName().length()) {
                longestNameStudent = student;
            }
        }
        return longestNameStudent;
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException {
        for (Student student : students) {
            if (student.getGpa() < 6.0 || student.getGpa() > 10.0) {
                throw new InvalidStudentDataException("Read data has invalid rows.");
            }
        }
    }
}
