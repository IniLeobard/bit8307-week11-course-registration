package mku.BIT8307.week11.view;

import mku.BIT8307.week11.model.Course;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class CoursePanel extends JPanel {
    private final List<JCheckBox> courseBoxes = new ArrayList<>();
    private final JButton summaryButton = new JButton("Generate Summary");
    private final JButton backButton = new JButton("Back");
    private final JLabel messageLabel = new JLabel("Select one or more courses.");

    public CoursePanel(List<Course> courses) {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(25, 30, 25, 30));
        add(new JLabel("Course Selection"), BorderLayout.NORTH);

        JPanel listPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        for (Course course : courses) {
            JCheckBox box = new JCheckBox(course.toDisplayText());
            box.putClientProperty("course", course);
            courseBoxes.add(box);
            listPanel.add(box);
        }
        add(new JScrollPane(listPanel), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(backButton);
        buttons.add(summaryButton);
        add(buttons, BorderLayout.EAST);
        add(messageLabel, BorderLayout.SOUTH);
    }

    public List<Course> getSelectedCourses() {
        List<Course> selected = new ArrayList<>();
        for (JCheckBox box : courseBoxes) {
            if (box.isSelected()) {
                selected.add((Course) box.getClientProperty("course"));
            }
        }
        return selected;
    }

    public void clearSelections() {
        for (JCheckBox box : courseBoxes) box.setSelected(false);
        messageLabel.setText("Select one or more courses.");
    }

    public JButton getSummaryButton() { return summaryButton; }
    public JButton getBackButton() { return backButton; }
    public void setMessage(String message) { messageLabel.setText(message); }
}
