package mku.BIT8307.week11.controller;

import mku.BIT8307.week11.model.Course;
import mku.BIT8307.week11.model.Registration;
import mku.BIT8307.week11.model.Student;
import mku.BIT8307.week11.service.RegistrationService;
import mku.BIT8307.week11.view.RegistrationView;

import javax.swing.JOptionPane;
import java.util.List;

public class RegistrationController {
    private final RegistrationView view;
    private final RegistrationService service;
    private Student currentStudent;

    public RegistrationController(RegistrationView view, RegistrationService service) {
        this.view = view;
        this.service = service;
        registerListeners();
    }

    private void registerListeners() {
        view.getLoginPanel().getLoginButton().addActionListener(e -> login());
        view.getStudentPanel().getSaveButton().addActionListener(e -> saveStudent());
        view.getStudentPanel().getBackButton().addActionListener(e -> view.showCard(RegistrationView.LOGIN));
        view.getCoursePanel().getSummaryButton().addActionListener(e -> generateSummary());
        view.getCoursePanel().getBackButton().addActionListener(e -> view.showCard(RegistrationView.STUDENT));
        view.getSummaryPanel().getBackButton().addActionListener(e -> view.showCard(RegistrationView.COURSES));
        view.getSummaryPanel().getResetButton().addActionListener(e -> resetApplication());
        view.getExitItem().addActionListener(e -> view.dispose());
        view.getAboutItem().addActionListener(e -> JOptionPane.showMessageDialog(view,
                "BIT8307 Week 11 Swing MVC Lab\nMount Kigali University"));
    }

    private void login() {
        if (service.isValidLogin(view.getLoginPanel().getUsername(), view.getLoginPanel().getPassword())) {
            view.getLoginPanel().setMessage("Login successful. Continue to student registration.");
            view.showCard(RegistrationView.STUDENT);
        } else {
            view.getLoginPanel().setMessage("Invalid login. Try admin / mku123.");
        }
    }

    private void saveStudent() {
        String id = view.getStudentPanel().getStudentId();
        String name = view.getStudentPanel().getFullName();
        String email = view.getStudentPanel().getEmail();
        String program = view.getStudentPanel().getProgram();

        String validation = service.validateStudent(id, name, email, program);
        if (!"OK".equals(validation)) {
            view.getStudentPanel().setMessage("Error: " + validation);
            return;
        }

        currentStudent = service.createStudent(id, name, email, program);
        view.getStudentPanel().setMessage("Student saved. Select courses.");
        view.showCard(RegistrationView.COURSES);
    }

    private void generateSummary() {
        List<Course> selectedCourses = view.getCoursePanel().getSelectedCourses();
        String validation = service.validateCourses(selectedCourses);
        if (!"OK".equals(validation)) {
            view.getCoursePanel().setMessage("Error: " + validation);
            return;
        }

        Registration registration = service.buildRegistration(currentStudent, selectedCourses);
        view.getSummaryPanel().displayRegistration(registration);
        view.showCard(RegistrationView.SUMMARY);
    }

    private void resetApplication() {
        currentStudent = null;
        view.getLoginPanel().clear();
        view.getStudentPanel().clear();
        view.getCoursePanel().clearSelections();
        view.getSummaryPanel().clear();
        view.showCard(RegistrationView.LOGIN);
    }
}
