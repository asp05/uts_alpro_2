/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andisugara.uts_alpro.soal_1;

/**
 *
 * @author andi
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CekSegitigaForm extends JFrame {

    private JLabel labelSisi1, labelSisi2, labelSisi3, labelHasil;
    private JTextField sisi1Field, sisi2Field, sisi3Field;
    private JButton cekButton;

    private JPanel panel;

    public CekSegitigaForm() {
        labelSisi1 = new JLabel("Sisi 1:");
        labelSisi2 = new JLabel("Sisi 2:");
        labelSisi3 = new JLabel("Sisi 3:");
        labelHasil = new JLabel("Hasil:");
        sisi1Field = new JTextField(10);
        sisi2Field = new JTextField(10);
        sisi3Field = new JTextField(10);
        cekButton = new JButton("Cek");
        panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelSisi1, constraints);

        constraints.gridx = 1;
        panel.add(sisi1Field, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelSisi2, constraints);

        constraints.gridx = 1;
        panel.add(sisi2Field, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelSisi3, constraints);

        constraints.gridx = 1;
        panel.add(sisi3Field, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelHasil, constraints);

        constraints.gridx = 1;
        panel.add(cekButton, constraints);

        // add the panel to the frame
        add(panel);
        setTitle("Cek Jenis Segitiga");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sisi1 = Integer.parseInt(sisi1Field.getText());
                int sisi2 = Integer.parseInt(sisi2Field.getText());
                int sisi3 = Integer.parseInt(sisi3Field.getText());

                Segitiga segitiga = new Segitiga(sisi1, sisi2, sisi3);
                labelHasil.setText("Hasil: " + segitiga.getJenisSegigita());
            }
        });
    }

    public static void main(String[] args) {
        new CekSegitigaForm();
    }
}

class Segitiga extends SegitigaAbstrak {

    public Segitiga(int sisi1, int sisi2, int sisi3) {
        super(sisi1, sisi2, sisi3);
    }

    @Override
    boolean isSegitigaSamaSisi() {
        return (getSisi1() == getSisi2() && getSisi2() == getSisi3());
    }

    @Override
    boolean isSegitiaSamaKaki() {
        return (getSisi1() == getSisi2() || getSisi2() == getSisi3() || getSisi1() == getSisi3());
    }

    @Override
    boolean isSegitiaSikuSiku() {
        int sisiTerpanjang = Math.max(Math.max(getSisi1(), getSisi2()), getSisi3());
        return (Math.pow(sisiTerpanjang, 2) == Math.pow(getSisi1(), 2) + Math.pow(getSisi2(), 2) + Math.pow(getSisi3(), 2) - Math.pow(sisiTerpanjang, 2));
    }
}
