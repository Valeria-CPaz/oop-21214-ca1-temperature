package com.val;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        TemperatureConversion temperatureConversion = new TemperatureConversion();
        temperatureConversion.setVisible(true);
        temperatureConversion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temperatureConversion.setSize(350, 350);
        temperatureConversion.setResizable(false);


    }
}
