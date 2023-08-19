package org.example.converter.view;

import org.example.converter.controller.LengthConverterCtrl;
import org.example.converter.model.LengthTypes;

import javax.swing.*;

public class LengthConverterUI extends JFrame {
    private JPanel panelMain;
    private JTextField length;
    private JButton calculateBtn;
    private JComboBox<LengthTypes> comboBox1;
    private JComboBox<LengthTypes> comboBox2;

    public LengthConverterUI() {
        calculateBtn.addActionListener(e -> {
            LengthTypes baseTemp = (LengthTypes) comboBox1.getSelectedItem();
            LengthTypes targetTemp = (LengthTypes) comboBox2.getSelectedItem();
            String temp = length.getText();

            LengthConverterCtrl.calculateLength(baseTemp, targetTemp, temp);
        });

        initUI();
    }

    public void initUI () {
        comboBox1.setModel(new DefaultComboBoxModel<>(LengthTypes.values()));
        comboBox2.setModel(new DefaultComboBoxModel<>(LengthTypes.values()));
        this.setContentPane(this.panelMain);
        this.setTitle("Conversor de Longitudes");
        this.setBounds(400,265,560, 230);
        this.setVisible(true);
    }
}
