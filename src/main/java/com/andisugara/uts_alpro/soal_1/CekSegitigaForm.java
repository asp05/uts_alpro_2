/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andisugara.uts_alpro.soal_1;

/**
 *
 * @author andi
 */
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CekSegitigaForm extends JFrame {

    private JLabel labelSisi1, labelSisi2, labelSisi3, labelHasil;
    private JTextField sisi1Field, sisi2Field, sisi3Field;
    private JButton cekButton;

    public CekSegitigaForm() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        labelSisi1 = new JLabel("Sisi 1");
        labelSisi1.setBounds(50, 50, 50, 20);
        panel.add(labelSisi1);

        sisi1Field = new JTextField();
        sisi1Field.setBounds(110, 50, 200, 25);
        panel.add(sisi1Field);

        labelSisi2 = new JLabel("Sisi 2");
        labelSisi2.setBounds(50, 90, 50, 20);
        panel.add(labelSisi2);

        sisi2Field = new JTextField();
        sisi2Field.setBounds(110, 90, 200, 25);
        panel.add(sisi2Field);

        labelSisi3 = new JLabel("Sisi 3");
        labelSisi3.setBounds(50, 130, 50, 20);
        panel.add(labelSisi3);

        sisi3Field = new JTextField();
        sisi3Field.setBounds(110, 130, 200, 25);
        panel.add(sisi3Field);

        cekButton = new JButton("Cek");
        cekButton.setBounds(160, 180, 80, 30);
        panel.add(cekButton);

        labelHasil = new JLabel("Jenis Segitiga: ");
        labelHasil.setBounds(50, 220, 500, 20);
        panel.add(labelHasil);

        add(panel);
        setTitle("Jenis Segitiga");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        cekButton.addActionListener(e -> {
            int sisi1 = Integer.parseInt(sisi1Field.getText());
            int sisi2 = Integer.parseInt(sisi2Field.getText());
            int sisi3 = Integer.parseInt(sisi3Field.getText());

            Segitiga segitiga = new Segitiga(sisi1, sisi2, sisi3);
            labelHasil.setText("Jenis Segitiga: " + segitiga.getJenisSegigita());
        });
    }

    public static void main() {
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
