package org.example.converter.view;

import org.example.converter.controller.CurrencyConverterCtrl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterUI extends JFrame {
    private JTextField currencyTarget;
    private JTextField currencyBase;
    private JPanel panelMain;
    private JTextField amount;
    private JButton calculateBtn;

    public CurrencyConverterUI() {
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currencyBaseValue = currencyBase.getText().trim().toUpperCase();
                String currencyTargetValue = currencyTarget.getText().trim().toUpperCase();
                String amountValue = amount.getText().trim().toUpperCase();

                CurrencyConverterCtrl.calculateConversion(currencyBaseValue, currencyTargetValue, amountValue);
            }
        });

        initUI();
    }

    public void initUI () {
        this.setContentPane(this.panelMain);
        this.setTitle("Conversor de Divisas");
        this.setBounds(380,230,600, 300);
        this.setVisible(true);
    }
}
