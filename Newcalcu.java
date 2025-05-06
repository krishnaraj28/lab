import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Newcalcu extends JFrame implements ActionListener {
    JTextField numField1, numField2, resultField;
    JComboBox<String> operationBox;
    JButton calcButton, clearButton;

    public Newcalcu() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Components
        add(new JLabel("Enter first number:"));
        numField1 = new JTextField();
        add(numField1);

        add(new JLabel("Enter second number:"));
        numField2 = new JTextField();
        add(numField2);

        add(new JLabel("Choose Operation:"));
        String[] operations = {"+", "-", "*", "/"};
        operationBox = new JComboBox<>(operations);
        add(operationBox);

        calcButton = new JButton("Calculate");
        calcButton.addActionListener(this);
        add(calcButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcButton) {
            try {
                double num1 = Double.parseDouble(numField1.getText());
                double num2 = Double.parseDouble(numField2.getText());
                String op = (String) operationBox.getSelectedItem();
                double result = 0;

                switch (op) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            resultField.setText("Error: Division by zero");
                            return;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input!");
            }
        }

        if (e.getSource() == clearButton) {
            numField1.setText("");
            numField2.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        new Newcalcu();  // <-- fixed this line
    }
}
