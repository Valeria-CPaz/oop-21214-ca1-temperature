package com.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class TemperatureConversion extends JFrame {

    private final double CELSIUS_TO_FAHRENHEIT = 9 / 5d;
    private final double FAHRENHEIT_TO_CELSIUS = 5 / 9d;
    private final int TEMP_DIFFERENCE = 32;
    private ConverterHandler handler;
    private ButtonGroup checkBox;
    private JTextField textFieldInput;
    private JTextField textFieldResult;
    private JCheckBox celsius_CheckBox;
    private JCheckBox fahrenheit_CheckBox;
    private JButton button;

    public TemperatureConversion() {
        super("Temperature Conversion");
        setLayout(new FlowLayout());

        // Labels
        JLabel lblTitle = new JLabel("Temperature Conversion");
        lblTitle.setOpaque(true);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBackground(Color.ORANGE);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(lblTitle);

        JLabel emptySpace = new JLabel("-------------------");
        add(emptySpace); // I'm still confused with the layout manipulation

        celsius_CheckBox = new JCheckBox("Celsius");
        fahrenheit_CheckBox = new JCheckBox("Fahrenheit");
        add(celsius_CheckBox);
        add(fahrenheit_CheckBox);

        // Text Field - INPUT
        JLabel emptySpace2 = new JLabel("-------------------");
        add(emptySpace2);
        JLabel inputText = new JLabel("Insert a number:    ");
        add(inputText);
        textFieldInput = new JTextField( 15);
        textFieldInput.setFont(new Font("Tahoma", Font.BOLD, 14));
        textFieldInput.setBackground(Color.GRAY);
        textFieldInput.setForeground(Color.WHITE);
        add(textFieldInput);

        // Text Field - RESULT
        JLabel resultText = new JLabel("Conversion Result:");
        add(resultText);
        textFieldResult = new JTextField(15);
        textFieldResult.setFont(new Font("Tahoma", Font.BOLD, 14));
        textFieldResult.setBackground(Color.GRAY);
        textFieldResult.setForeground(Color.WHITE);
        textFieldResult.setEditable(false);
        add(textFieldResult);
        textFieldResult.setEditable(false);

        // Button
        button = new JButton("Conversion");
        add(button);
        handler = new ConverterHandler();
        button.addActionListener(handler);

        // CheckBox Group
        checkBox = new ButtonGroup();
        checkBox.add(celsius_CheckBox);
        checkBox.add(fahrenheit_CheckBox);

    }

    private class ConverterHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            double celsius = Double.parseDouble(textFieldInput.getText());
            double fahrenheit = Double.parseDouble(textFieldInput.getText());


            try {
                if (celsius_CheckBox.isSelected()) {
                    celsius = (fahrenheit - TEMP_DIFFERENCE) * FAHRENHEIT_TO_CELSIUS;
                    textFieldResult.setText("" + celsius);
                } else {
                    fahrenheit = (celsius * CELSIUS_TO_FAHRENHEIT) + TEMP_DIFFERENCE;
                    textFieldResult.setText("" + fahrenheit);
                }

            } catch (InputMismatchException exception){
                System.err.println("Entered value not a number");
            }
        }
    }
}
