package mku.BIT8307.week11.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class LoginPanel extends JPanel {
    private final JTextField usernameField = new JTextField(18);
    private final JPasswordField passwordField = new JPasswordField(18);
    private final JButton loginButton = new JButton("Login");
    private final JLabel messageLabel = new JLabel("Use username: admin and password: mku123");

    public LoginPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel("BIT8307 Student Course Registration Login");
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        form.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        form.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(loginButton);

        add(form, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        add(messageLabel, BorderLayout.SOUTH);
    }

    public String getUsername() { return usernameField.getText(); }
    public char[] getPassword() { return passwordField.getPassword(); }
    public JButton getLoginButton() { return loginButton; }
    public void setMessage(String message) { messageLabel.setText(message); }
    public void clear() {
        usernameField.setText("");
        passwordField.setText("");
        messageLabel.setText("Use username: admin and password: mku123");
    }
}
