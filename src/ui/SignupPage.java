package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignupPage extends JFrame {

    JTextField nameField, emailField, phoneField;
    JPasswordField passwordField;
    JButton signupBtn;

    public SignupPage() {
        setTitle("Signup");
        setSize(400, 400);
        setLayout(new GridLayout(6, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        signupBtn = new JButton("Signup");
        add(signupBtn);

        signupBtn.addActionListener((ActionEvent e) -> registerUser());

        setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String phone = phoneField.getText();

        User user = new User(name, email, password, phone);
        UserDAO dao = new UserDAO();

        if (dao.registerUser(user)) {
    JOptionPane.showMessageDialog(this, "Signup Successful");

    // close signup page
    this.dispose();

    // open login page
    new LoginPage();

} else {
    JOptionPane.showMessageDialog(this, "Signup Failed");
}
    }

    public static void main(String[] args) {
        new SignupPage();
    }
}
