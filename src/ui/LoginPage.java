package ui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

    JTextField emailField;
    JPasswordField passwordField;
    JButton loginBtn, signupBtn;

    public LoginPage() {
        setTitle("Login");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginBtn = new JButton("Login");
        signupBtn = new JButton("Go to Signup");

        add(loginBtn);
        add(signupBtn);

        loginBtn.addActionListener((ActionEvent e) -> loginUser());
        signupBtn.addActionListener(e -> new SignupPage());

        setVisible(true);
    }

    private void loginUser() {
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());

        UserDAO dao = new UserDAO();

        if (dao.loginUser(email, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}