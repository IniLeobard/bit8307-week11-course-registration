package mku.BIT8307.week11.service;

import mku.BIT8307.week11.model.Course;
import mku.BIT8307.week11.model.Registration;
import mku.BIT8307.week11.model.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    public boolean isValidLogin(String username, char[] password) {
        String pwd = new String(password);
        return "admin".equalsIgnoreCase(username.trim()) && "mku123".equals(pwd);
    }

    public String validateStudent(String id, String name, String email, String program) {
        if (id == null || id.trim().isEmpty()) return "Student ID is required.";
        if (name == null || name.trim().isEmpty()) return "Full name is required.";
        if (email == null || !email.contains("@")) return "A valid email address is required.";
        if (program == null || program.trim().isEmpty()) return "Program is required.";
        return "OK";
    }

    public Student createStudent(String id, String name, String email, String program) {
        return new Student(id.trim(), name.trim(), email.trim(), program.trim());
    }

    public String validateCourses(List<Course> selectedCourses) {
        if (selectedCourses == null || selectedCourses.isEmpty()) {
            return "Select at least one course.";
        }
        int totalCredits = selectedCourses.stream().mapToInt(Course::getCredits).sum();
        if (totalCredits > 18) return "Maximum allowed credits is 18.";
        return "OK";
    }

    public Registration buildRegistration(Student student, List<Course> selectedCourses) {
        return new Registration(student, selectedCourses);
    }

    public List<Course> loadAvailableCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("BIT8307", "Object-Oriented Programming", 6));
        courses.add(new Course("MIT9314", "Advanced Database Systems", 6));
        courses.add(new Course("MIT9333", "Decision Support Analytics", 6));
        courses.add(new Course("MIT9311", "Advanced Software Engineering", 6));
        return courses;
    }
}
