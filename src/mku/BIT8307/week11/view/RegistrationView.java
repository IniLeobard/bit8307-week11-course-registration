package mku.BIT8307.week11.view;

import mku.BIT8307.week11.model.Course;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;

public class RegistrationView extends JFrame {
    public static final String LOGIN = "login";
    public static final String STUDENT = "student";
    public static final String COURSES = "courses";
    public static final String SUMMARY = "summary";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);
    private final LoginPanel loginPanel = new LoginPanel();
    private final StudentPanel studentPanel = new StudentPanel();
    private final CoursePanel coursePanel;
    private final SummaryPanel summaryPanel = new SummaryPanel();
    private final JMenuItem exitItem = new JMenuItem("Exit");
    private final JMenuItem aboutItem = new JMenuItem("About");

    public RegistrationView(List<Course> courses) {
        super("BIT8307 MVC Swing Lab - Student Course Registration");
        this.coursePanel = new CoursePanel(courses);

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        cardPanel.add(loginPanel, LOGIN);
        cardPanel.add(studentPanel, STUDENT);
        cardPanel.add(coursePanel, COURSES);
        cardPanel.add(summaryPanel, SUMMARY);

        add(cardPanel, BorderLayout.CENTER);

        setSize(900, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        file.add(exitItem);
        help.add(aboutItem);
        menuBar.add(file);
        menuBar.add(help);
        return menuBar;
    }

    public void showCard(String name) { cardLayout.show(cardPanel, name); }

    public LoginPanel getLoginPanel() { return loginPanel; }
    public StudentPanel getStudentPanel() { return studentPanel; }
    public CoursePanel getCoursePanel() { return coursePanel; }
    public SummaryPanel getSummaryPanel() { return summaryPanel; }
    public JMenuItem getExitItem() { return exitItem; }
    public JMenuItem getAboutItem() { return aboutItem; }
}
