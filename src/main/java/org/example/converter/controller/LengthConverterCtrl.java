package org.example.converter.controller;

import org.example.converter.model.LengthTypes;

import javax.swing.*;
import java.text.DecimalFormat;

public class LengthConverterCtrl {
    public static double converter(LengthTypes fromUnit, LengthTypes toUnit, double value) {
        if (fromUnit == toUnit) return value;

        // Definir relaciones de conversión entre unidades
        double metersPerCentimeter = 0.01;
        double metersPerFoot = 0.3048;
        double metersPerInch = 0.0254;

        // Convertir el valor a metros
        double valueInMeter = switch (fromUnit) {
            case METERS -> value;
            case CENTIMETERS -> value * metersPerCentimeter;
            case FEET -> value * metersPerFoot;
            case INCHES -> value * metersPerInch;
        };

        // Convertir el valor en metros al tipo requerido
        return switch (toUnit) {
            case METERS -> valueInMeter;
            case CENTIMETERS -> valueInMeter / metersPerCentimeter;
            case FEET -> valueInMeter / metersPerFoot;
            case INCHES -> valueInMeter / metersPerInch;
        };
    }

    public static void calculateLength(LengthTypes baseTemp, LengthTypes targetTemp, String tempString) {
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
