package org.example.converter.controller;

import org.example.converter.model.TemperaturesTypes;

import javax.swing.*;
import java.text.DecimalFormat;

public class TemperatureConverterCtrl {
    private static double converter (TemperaturesTypes baseTemp, TemperaturesTypes targetTemp, double temp) {
        if (baseTemp == targetTemp) {
            return temp;
        }
        switch (baseTemp) {
            case CELSIUS -> {
                switch (targetTemp) {
                    case FAHRENHEIT: return (temp * 9 / 5) + 32;
                    case KELVIN: return temp + 273.15;
                }
            }
            case FAHRENHEIT -> {
                switch (targetTemp) {
                    case CELSIUS: return (temp - 32) * 5 / 9;
                    case KELVIN: return (temp + 459.67) * 5 / 9;
                }
            }
            case KELVIN -> {
                switch (targetTemp) {
                    case CELSIUS: return temp - 273.15;
                    case FAHRENHEIT: return (temp * 9 / 5) - 459.67;
                }
            }
        }
        throw new IllegalArgumentException("Conversion not supported.");
    }

    public static void calculateTemperature(TemperaturesTypes baseTemp, TemperaturesTypes targetTemp, String tempString) {
        double temp;
        DecimalFormat df = new DecimalFormat("#.00");

        try {
            temp = Double.parseDouble(tempString);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(
                    null,
                    "El monto no es un numero"
            );
            return;
        }

        double result = converter(baseTemp, targetTemp, temp);

        JOptionPane.showMessageDialog(
                null,
                String.format("%s %s son: %s %s", df.format(temp), baseTemp, df.format(result), targetTemp)
        );
    }
}
