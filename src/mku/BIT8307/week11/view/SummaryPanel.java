package mku.BIT8307.week11.view;

import mku.BIT8307.week11.model.Course;
import mku.BIT8307.week11.model.Registration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class SummaryPanel extends JPanel {
    private final DefaultTableModel tableModel = new DefaultTableModel(
            new Object[]{"Code", "Course Title", "Credits"}, 0);
    private final JTable courseTable = new JTable(tableModel);
    private final JTextArea summaryArea = new JTextArea(5, 40);
    private final JButton resetButton = new JButton("Start New Registration");
    private final JButton backButton = new JButton("Back");

    public SummaryPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(25, 30, 25, 30));
        add(new JLabel("Registration Summary"), BorderLayout.NORTH);

        summaryArea.setEditable(false);
        add(new JScrollPane(summaryArea), BorderLayout.WEST);
        add(new JScrollPane(courseTable), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(backButton);
        buttons.add(resetButton);
        add(buttons, BorderLayout.SOUTH);
    }

    public void displayRegistration(Registration registration) {
        tableModel.setRowCount(0);
        for (Course course : registration.getSelectedCourses()) {
            tableModel.addRow(new Object[]{course.getCode(), course.getTitle(), course.getCredits()});
        }
        summaryArea.setText("Student: " + registration.getStudent().toString()
                + "\nEmail: " + registration.getStudent().getEmail()
                + "\nSelected courses: " + registration.getSelectedCourses().size()
                + "\nTotal credits: " + registration.getTotalCredits());
    }

    public void clear() {
        tableModel.setRowCount(0);
        summaryArea.setText("");
    }

    public JButton getResetButton() { return resetButton; }
    public JButton getBackButton() { return backButton; }
}
