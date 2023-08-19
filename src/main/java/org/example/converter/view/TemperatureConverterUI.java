package org.example.converter.view;

import org.example.converter.controller.TemperatureConverterCtrl;
import org.example.converter.model.TemperaturesTypes;

import javax.swing.*;

public class TemperatureConverterUI extends JFrame {
    private JPanel panelMain;
    private JTextField temperature;
    private JButton calculateBtn;
    private JComboBox<TemperaturesTypes> comboBox1;
    private JComboBox<TemperaturesTypes> comboBox2;



    public TemperatureConverterUI() {
        calculateBtn.addActionListener(e -> {
            TemperaturesTypes baseTemp = (TemperaturesTypes) comboBox1.getSelectedItem();
            TemperaturesTypes targetTemp = (TemperaturesTypes) comboBox2.getSelectedItem();
            String temp = temperature.getText();

            TemperatureConverterCtrl.calculateTemperature(baseTemp, targetTemp, temp);
        });

        initUI();
    }

    public void initUI () {
        comboBox1.setModel(new DefaultComboBoxModel<>(TemperaturesTypes.values()));
        comboBox2.setModel(new DefaultComboBoxModel<>(TemperaturesTypes.values()));
        this.setContentPane(this.panelMain);
        this.setTitle("Conversor de Temperaturas");
        this.setBounds(400,265,560, 230);
        this.setVisible(true);
    }
}
