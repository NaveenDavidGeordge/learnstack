package org.airtribe.services;

import java.util.ArrayList;
import java.util.List;

import org.airtribe.entity.Course;
import org.airtribe.exception.EntityNotFoundException;
import org.airtribe.util.IdGenerator;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(String name, String description, int duration) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, name, description, duration);
        courses.add(course);
        System.out.println("Course added with ID: " + id);
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println(
                    c.getId() + " | " + c.getCourseName() +
                            " | Duration: " + c.getDurationInWeeks() +
                            " weeks | Active: " + c.isActive()
            );
        }
    }

    public Course findCourseById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + id);
    }

    public void deactivateCourse(int id) throws EntityNotFoundException {
        Course course = findCourseById(id);
        course.setActive(false);
        System.out.println("Course deactivated.");
    }
}

