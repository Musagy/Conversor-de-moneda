package org.example.converter.view;

import javax.swing.*;

public class MainUI extends JFrame {

    private JPanel panelMain;
    private JButton currencyConverterBtn;
    private JButton temperatureConverterBtn;
    private JButton LengthConverterBtn;

    public MainUI() {
        currencyConverterBtn.addActionListener(e -> new CurrencyConverterUI());
        temperatureConverterBtn.addActionListener(e -> new TemperatureConverterUI());
        LengthConverterBtn.addActionListener(e -> new LengthConverterUI());
    }

    public void initUI () {
        this.setContentPane(this.panelMain);
        this.setTitle("App");
        this.setBounds(500,280,360, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
