package org.example.converter.controller;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import javax.swing.*;
import java.text.DecimalFormat;

public class CurrencyConverterCtrl {
    private static boolean isStringInvalidate(String currency) {
        if (currency == null) {
            JOptionPane.showMessageDialog(null, "Error: Este valor es nulo.");
            return true;
        }

        if (currency.equals("")) {
            JOptionPane.showMessageDialog(null, "Error: Este valor esta vació.");
            return true;
        }
        return false;
    }

    private static double converter(String base, String target, double amount) {
        // Flujo
        // base -> EUR -> target

        JSONObject rates;
        double amountInEUR, amountInTarget;

        HttpResponse<JsonNode> response = Unirest.get(
                "http://data.fixer.io/api/latest?access_key=3494e6c081ebdfd80966e38d02dd2326&symbols="
                        + base + "," + target
        ).asJson();
        rates = response.getBody()
                .getObject()
                .getJSONObject("rates");

        double aBaseInEUR = rates.getDouble(base);
        amountInEUR = amount / aBaseInEUR;

        double aTargetInEUR = rates.getDouble(target);
        amountInTarget = amountInEUR * aTargetInEUR;

        return amountInTarget;
    }

    public static void calculateConversion(String currencyBase, String currencyTarget, String amountString) {
        double amount, convertedAmount;
        DecimalFormat df = new DecimalFormat("#.00");

        if (isStringInvalidate(currencyBase) || isStringInvalidate(currencyTarget)) return;

        try {
            amount = Double.parseDouble(amountString);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(
                    null,
                    "El monto no es un numero"
            );
            return;
        }

        try {
            convertedAmount = converter(currencyBase, currencyTarget, amount);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: Alguna de las 2 divisas No Existe."
            );
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                String.format("%s %s son: %s %s", df.format(amount), currencyBase, df.format(convertedAmount), currencyTarget)
        );

    }
}
