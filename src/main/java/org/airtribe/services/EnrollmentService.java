package org.airtribe.services;

import java.util.ArrayList;
import java.util.List;

import org.airtribe.entity.Enrollment;
import org.airtribe.util.IdGenerator;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId);
        enrollments.add(enrollment);
        System.out.println("Enrollment successful. Enrollment ID: " + id);
    }

    public void listEnrollmentsByStudent(int studentId) {
        boolean found = false;
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                System.out.println(
                        "Enrollment ID: " + e.getId() +
                                " | Course ID: " + e.getCourseId() +
                                " | Status: " + e.getStatus()
                );
                found = true;
            }
        }
        if (!found) {
            System.out.println("No enrollments found for student.");
        }
    }
}

