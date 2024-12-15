package org.example.week11.Task1;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private StudentSystem studentSystem;

    @BeforeEach
    void setUp() throws IOException, InvalidStudentDataException {
        studentSystem = new StudentSystem("students.csv");
    }

    @Test
    void testIfStudentIsPresent() {
        assertTrue(studentSystem.noOfStudents() > 0, "Student list should not be empty.");
    }

    @Test
    void testStudentWithId100() {
        assertThrows(StudentNotFoundException.class, () -> studentSystem.getStudentById(100),
                "Should throw StudentNotFoundException for non-existent ID.");
    }

    @Test
    void testHighestGPAStudent() {
        assertEquals(9.8, studentSystem.getHighestGPAStudent().getGpa(), "Highest GPA should be 9.8.");
    }

    @Test
    void testExceptionForEmptyStudentList() throws InvalidStudentDataException {
        StudentSystem emptySystem = new StudentSystem(new ArrayList<>());
        assertThrows(EmptyStudentListException.class, emptySystem::getHighestGPAStudent,
                "Should throw EmptyStudentListException for an empty list.");
    }

    @Test
    void testExceptionMessageForEmptyStudentList() throws InvalidStudentDataException {
        StudentSystem emptySystem = new StudentSystem(new ArrayList<>());
        Exception exception = assertThrows(EmptyStudentListException.class, emptySystem::getHighestGPAStudent);
        assertEquals("List of students is empty.", exception.getMessage(),
                "Exception message should match.");
    }

    @Test
    void testNamesArray() throws IOException {
        List<Student> students = StudentSystem.readStudents("students.csv");
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 5 && i < students.size(); i++) {
            names.add(students.get(i).getName());
        }
        List<String> expectedNames = Arrays.asList("Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson");
        assertEquals(expectedNames, names, "First five names should match the expected values.");
    }

    @Test
    void testSameStudent() throws StudentNotFoundException {
        Student highestGpaStudent = studentSystem.getHighestGPAStudent();
        Student id12Student = studentSystem.getStudentById(12);
        assertSame(highestGpaStudent, id12Student, "Student with highest GPA should be the same as student with ID 12.");
    }

    @Test
    void testValidateStudentDataThrowsException() {
        List<Student> invalidStudents = List.of(
                new Student(1, "John Doe", "Uni1", "CS", 5.5),
                new Student(2, "Jane Doe", "Uni2", "CS", 7.5)
        );
        assertThrows(InvalidStudentDataException.class, () -> new StudentSystem(invalidStudents),
                "Should throw InvalidStudentDataException for invalid GPA.");
    }

    @Test
    void testNoOfStudents() {
        assertEquals(10, studentSystem.noOfStudents(), "Number of students should be 10.");
    }
}
