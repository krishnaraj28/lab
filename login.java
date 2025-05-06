import javax.swing.*;
import java.awt.event.*;

public class SimpleLoginPage {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Login Page");

        // Create labels
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 30);

        // Create text fields
        JTextField userField = new JTextField();
        userField.setBounds(150, 50, 150, 30);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 30);

        // Create login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);

        // Label to show result
        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(100, 200, 250, 30);

        // Add action listener for login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    resultLabel.setText("Login Successful!");
                } else {
                    resultLabel.setText("Invalid Username or Password");
                }
            }
        });

        // Add components to frame
        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(userField);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(resultLabel);

        // Frame properties
        frame.setSize(400, 300);
        frame.setLayout(null); // Required for setBounds
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
