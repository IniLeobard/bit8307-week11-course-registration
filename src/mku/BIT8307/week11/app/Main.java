package mku.BIT8307.week11.app;

import mku.BIT8307.week11.controller.RegistrationController;
import mku.BIT8307.week11.service.RegistrationService;
import mku.BIT8307.week11.view.RegistrationView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationService service = new RegistrationService();
            RegistrationView view = new RegistrationView(service.loadAvailableCourses());
            new RegistrationController(view, service);
            view.setVisible(true);
        });
    }
}
