package org.airtribe.services;

import java.util.ArrayList;
import java.util.List;

import org.airtribe.entity.Student;
import org.airtribe.exception.EntityNotFoundException;
import org.airtribe.util.IdGenerator;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        students.add(student);
        System.out.println("Student added with ID: " + id);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(
                    s.getId() + " | " + s.getDisplayName() +
                            " | Batch: " + s.getBatch() +
                            " | Active: " + s.isActive()
            );
        }
    }

    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setActive(false);
        System.out.println("Student deactivated successfully.");
    }
}

