package com.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConversion extends JFrame {

    private final double CELSIUS_TO_FAHRENHEIT = 9 / 5d;
    private final double FAHRENHEIT_TO_CELSIUS = 5 / 9d;
    private final int TEMP_DIFFERENCE = 32;
    private ButtonGroup checkBox;
    private JTextField textFieldInput;
    private JTextField textFieldResult;
    private JCheckBox celsius_CheckBox;
    private JCheckBox fahrenheit_CheckBox;
    private JButton button;
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TemperatureConversion temperatureConversion = new TemperatureConversion();
                    temperatureConversion.frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public TemperatureConversion() {
        start();
    }

    private void start() {

        // frame
        frame = new JFrame();
        frame.setType(Type.UTILITY);
        frame.setBounds(100, 100, 460, 330);
        frame.setSize(460, 330);
        frame.setTitle("Temperature Conversion App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        // Labels
        JLabel lblTitle = new JLabel("Temperature Conversion");
        lblTitle.setBounds(0, 0, 450, 50);
        lblTitle.setOpaque(true);
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setBackground(new Color(255, 128, 44));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblTitle);

        // Checkbox
        celsius_CheckBox = new JCheckBox("Celsius");
        celsius_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        celsius_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        celsius_CheckBox.setBounds(120, 55, 82, 40);
        frame.getContentPane().add(celsius_CheckBox);

        fahrenheit_CheckBox = new JCheckBox("Fahrenheit");
        fahrenheit_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        fahrenheit_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        fahrenheit_CheckBox.setBounds(206, 65, 140, 20);
        frame.getContentPane().add(fahrenheit_CheckBox);

        // CheckBox Group
        checkBox = new ButtonGroup();
        checkBox.add(celsius_CheckBox);
        checkBox.add(fahrenheit_CheckBox);

        // Text Field - INPUT
        textFieldInput = new JTextField();
        textFieldInput.setFont(new Font("Tahoma", Font.BOLD, 15));
        textFieldInput.setBackground(new Color(65, 105, 225));
        textFieldInput.setForeground(new Color(255, 255, 255));
        textFieldInput.setBounds(120, 110, 210, 27);
        textFieldInput.setColumns(10);
        frame.getContentPane().add(textFieldInput);

        // Text Field - RESULT
        textFieldResult = new JTextField();
        textFieldResult.setFont(new Font("Tahoma", Font.BOLD, 15));
        textFieldResult.setBackground(new Color(65,105,225));
        textFieldResult.setForeground(new Color(255,255,255));
        textFieldResult.setBounds(120, 205, 210, 27);
        frame.getContentPane().add(textFieldResult);

        // Button
        button = new JButton("Conversion");
        button.setFont(new Font("Tahoma", Font.PLAIN, 13));
        button.setBounds(160, 155, 130, 27);
        frame.getContentPane().add(button);

        //handler
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                try {
                    if (celsius_CheckBox.isSelected()) {
                        double number = Double.parseDouble(textFieldInput.getText());

                        double celsius = (number - TEMP_DIFFERENCE) * FAHRENHEIT_TO_CELSIUS;
                        textFieldResult.setText(celsius + " °C");
                    } else {
                        double number = Double.parseDouble(textFieldInput.getText());

                        double fahrenheit = (number * CELSIUS_TO_FAHRENHEIT) + TEMP_DIFFERENCE;
                        textFieldResult.setText(fahrenheit + " °F");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Entered value not a number");
                }
            }

        });

    }
}
