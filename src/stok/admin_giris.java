package stok;


import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JFrame;


public class admin_giris {

    JFrame frame;
    JTextField textField;
    JPasswordField passwordField;
    JButton giris;
    String ad = null;

    String kullanici_adi,sifre;

    public admin_giris(){
        initialize();
    }
    public void initialize(){
        frame=new JFrame("Admin Girişi");
        frame.setBounds(100, 100, 270, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);


        JLabel kullanici_adi = new JLabel("Kullanıcı Adı:");
        kullanici_adi.setBounds(40, 40, 80, 20);
        frame.getContentPane().add(kullanici_adi);
        //kullanici_adi.setFont(new Font("times new roman", Font.BOLD,12 ));

        textField = new JTextField();
        textField.setBounds(120, 40, 100, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);



        JLabel sifre = new JLabel("Şifre:");
        sifre.setBounds(40, 80, 80, 20);
        frame.getContentPane().add(sifre);


        passwordField= new JPasswordField();
        passwordField.setBounds(120, 80, 100, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);


        giris = new JButton("Giriş");
        giris.setBounds(120, 120, 80, 23);
        frame.getContentPane().add(giris);

        frame.getContentPane();
        this.frame.setVisible(true);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        giris.addActionListener(bt_dinle1);


    }

    public class Butonu_dinle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == giris) {
                kullanici_adi = textField.getText();
                sifre = passwordField.getText();


                if (admin.adminGiris(kullanici_adi, sifre) == false) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız! Lütfen kullanıcı adı ve şifreyi kontrol ediniz ", "HATA", 0);//hata mesajý

                } else {
                    ad = admin.ad_getir(kullanici_adi);
                    System.out.println(ad);
                    admin_secenekler yeni = new admin_secenekler(ad);


                    frame.dispose();
                }

            }

        }

    }}




