import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcunew extends JFrame implements ActionListener {
    JTextField numField1, numField2, resultField;
    JButton addButton, subButton, mulButton, divButton, clrButton;

    Font font = new Font("Arial", Font.PLAIN, 18);

    public Calcunew() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label1 = new JLabel("Number 1:");
        label1.setBounds(30, 20, 100, 30);
        add(label1);

        numField1 = new JTextField();
        numField1.setBounds(130, 20, 200, 30);
        numField1.setFont(font);
        add(numField1);

        JLabel label2 = new JLabel("Number 2:");
        label2.setBounds(30, 60, 100, 30);
        add(label2);

        numField2 = new JTextField();
        numField2.setBounds(130, 60, 200, 30);
        numField2.setFont(font);
        add(numField2);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("Clear");

        int btnY = 110;
        addButton.setBounds(30, btnY, 60, 40);
        subButton.setBounds(100, btnY, 60, 40);
        mulButton.setBounds(170, btnY, 60, 40);
        divButton.setBounds(240, btnY, 60, 40);
        clrButton.setBounds(310, btnY, 60, 40);

        JButton[] buttons = {addButton, subButton, mulButton, divButton, clrButton};
        for (JButton btn : buttons) {
            btn.setFont(font);
            btn.addActionListener(this);
            add(btn);
        }

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(30, 180, 100, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(130, 180, 200, 30);
        resultField.setFont(font);
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0;

            if (e.getSource() == addButton) result = num1 + num2;
            if (e.getSource() == subButton) result = num1 - num2;
            if (e.getSource() == mulButton) result = num1 * num2;
            if (e.getSource() == divButton) result = (num2 != 0) ? num1 / num2 : 0;

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }

        if (e.getSource() == clrButton) {
            numField1.setText("");
            numField2.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calcunew();
    }
}
