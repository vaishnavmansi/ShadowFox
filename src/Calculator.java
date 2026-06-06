import javax.swing.*;
import java.awt.*;

public class Calculator {

    static JTextField text1;
    static JTextField text2;
    static JLabel result;

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Negative number");
        }
        return Math.sqrt(a);
    }

    public static double usdToInr(double usd) {
        double rate = 95.34;
        return usd * rate;
    }

    public static double inrToUsd(double inr) {
        double rate = 95.34;
        return inr / rate;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9.0;
    }

    public static JPanel inputPanel() {

        JPanel panel = new JPanel();

        panel.add(new JLabel("Number 1"));
        text1 = new JTextField(10);
        panel.add(text1);

        panel.add(new JLabel("Number 2"));
        text2 = new JTextField(10);
        panel.add(text2);

        return panel;
    }

    public static JPanel resultPanel() {

        JPanel panel = new JPanel();

        result = new JLabel("Result : ");
        panel.add(result);

        return panel;
    }

    public static JPanel buttonPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 5, 5));

        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton mulBtn = new JButton("*");
        JButton divBtn = new JButton("/");
        JButton sqrtBtn = new JButton("Sqrt");
        JButton usdBtn = new JButton("USD->INR");
        JButton inrBtn = new JButton("INR->USD");
        JButton cBtn = new JButton("C->F");
        JButton fBtn = new JButton("F->C");

        addBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                double b = Double.parseDouble(text2.getText());
                result.setText("Result : " + add(a, b));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        subBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                double b = Double.parseDouble(text2.getText());
                result.setText("Result : " + subtract(a, b));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        mulBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                double b = Double.parseDouble(text2.getText());
                result.setText("Result : " + multiply(a, b));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        divBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                double b = Double.parseDouble(text2.getText());
                result.setText("Result : " + divide(a, b));
            } catch (Exception ex) {
                result.setText(ex.getMessage());
            }
        });

        sqrtBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                result.setText("Result : " + squareRoot(a));
            } catch (Exception ex) {
                result.setText(ex.getMessage());
            }
        });

        usdBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                result.setText("Result : " + usdToInr(a));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        inrBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                result.setText("Result : " + inrToUsd(a));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        cBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                result.setText("Result : " + celsiusToFahrenheit(a));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        fBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(text1.getText());
                result.setText("Result : " + fahrenheitToCelsius(a));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);
        panel.add(sqrtBtn);
        panel.add(usdBtn);
        panel.add(inrBtn);
        panel.add(cBtn);
        panel.add(fBtn);

        return panel;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        frame.add(inputPanel(), BorderLayout.NORTH);
        frame.add(buttonPanel(), BorderLayout.CENTER);
        frame.add(resultPanel(), BorderLayout.SOUTH);

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
