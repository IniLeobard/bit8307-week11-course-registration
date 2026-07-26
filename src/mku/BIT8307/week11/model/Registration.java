package mku.BIT8307.week11.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registration {
    private final Student student;
    private final List<Course> selectedCourses;

    public Registration(Student student, List<Course> selectedCourses) {
        this.student = student;
        this.selectedCourses = new ArrayList<>(selectedCourses);
    }

    public Student getStudent() { return student; }

    public List<Course> getSelectedCourses() {
        return Collections.unmodifiableList(selectedCourses);
    }

    public int getTotalCredits() {
        int total = 0;
        for (Course course : selectedCourses) {
            total += course.getCredits();
        }
        return total;
    }
}
