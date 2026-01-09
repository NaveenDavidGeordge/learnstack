package org.airtribe;

import java.util.Scanner;

import org.airtribe.exception.EntityNotFoundException;
import org.airtribe.services.CourseService;
import org.airtribe.services.EnrollmentService;
import org.airtribe.services.StudentService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {
            System.out.println("\n--- LearnTrack - from Airtribe ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Deactivate Student");
            System.out.println("4. Add Course");
            System.out.println("5. View Courses");
            System.out.println("6. Enroll Student");
            System.out.println("7. View Student Enrollments");
            System.out.println("0. Exit");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("First Name: ");
                        String fn = scanner.nextLine();
                        System.out.print("Last Name: ");
                        String ln = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Batch: ");
                        String batch = scanner.nextLine();
                        studentService.addStudent(fn, ln, email, batch);
                        break;

                    case 2:
                        studentService.listStudents();
                        break;

                    case 3:
                        System.out.print("Student ID: ");
                        int sid = Integer.parseInt(scanner.nextLine());
                        studentService.deactivateStudent(sid);
                        break;

                    case 4:
                        System.out.print("Course Name: ");
                        String cname = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Duration (weeks): ");
                        int dur = Integer.parseInt(scanner.nextLine());
                        courseService.addCourse(cname, desc, dur);
                        break;

                    case 5:
                        courseService.listCourses();
                        break;

                    case 6:
                        System.out.print("Student ID: ");
                        int sId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Course ID: ");
                        int cId = Integer.parseInt(scanner.nextLine());
                        enrollmentService.enrollStudent(sId, cId);
                        break;

                    case 7:
                        System.out.print("Student ID: ");
                        int stId = Integer.parseInt(scanner.nextLine());
                        enrollmentService.listEnrollmentsByStudent(stId);
                        break;

                    case 0:
                        System.out.println("Exiting LearnTrack.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only.");
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
