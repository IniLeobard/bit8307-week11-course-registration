package mku.BIT8307.week11.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class StudentPanel extends JPanel {
    private final JTextField idField = new JTextField(20);
    private final JTextField nameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JComboBox<String> programBox = new JComboBox<>(new String[]{
            "MSc Information Technology",
            "MSc Data Analytics",
            "MSc Software Engineering"
    });
    private final JButton saveButton = new JButton("Save Student and Continue");
    private final JButton backButton = new JButton("Back");
    private final JLabel messageLabel = new JLabel("Enter student details.");

    public StudentPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(25, 30, 25, 30));
        add(new JLabel("Student Registration"), BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addRow(form, gbc, 0, "Student ID:", idField);
        addRow(form, gbc, 1, "Full name:", nameField);
        addRow(form, gbc, 2, "Email:", emailField);
        addRow(form, gbc, 3, "Program:", programBox);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(backButton);
        buttons.add(saveButton);

        add(form, BorderLayout.CENTER);
        add(buttons, BorderLayout.EAST);
        add(messageLabel, BorderLayout.SOUTH);
    }

    private void addRow(JPanel form, GridBagConstraints gbc, int row, String label, java.awt.Component input) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        form.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(input, gbc);
    }

    public String getStudentId() { return idField.getText(); }
    public String getFullName() { return nameField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getProgram() { return (String) programBox.getSelectedItem(); }
    public JButton getSaveButton() { return saveButton; }
    public JButton getBackButton() { return backButton; }
    public void setMessage(String message) { messageLabel.setText(message); }
    public void clear() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        programBox.setSelectedIndex(0);
        messageLabel.setText("Enter student details.");
    }
}
