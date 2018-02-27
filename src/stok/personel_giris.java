package stok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class personel_giris {

    JFrame frame;
    JTextField textField;
    JPasswordField passwordField;
    JLabel personelgirisekrani;
    JButton giris;
    String ad = null;


    String sicil_no,sifre;

    public personel_giris(){
        initialize();
    }
    public void initialize(){
        frame=new JFrame("Personel Giriş");
        frame.setBounds(100, 100, 260, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);


        JLabel sicil_no = new JLabel("Sicil No:");
        sicil_no.setBounds(40, 40, 50, 20);
        frame.getContentPane().add(sicil_no);

        textField = new JTextField();
        textField.setBounds(90, 40, 100, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        JLabel sifre = new JLabel("Şifre:");
        sifre.setBounds(40, 80, 50, 20);
        frame.getContentPane().add(sifre);


        passwordField= new JPasswordField();
        passwordField.setBounds(90, 80, 100, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        giris = new JButton("Giriş");
        giris.setBounds(90, 120, 80, 23);
        frame.getContentPane().add(giris);


        personelgirisekrani = new JLabel("");
        personelgirisekrani.setBounds(130, 26, 370, 14);
        frame.getContentPane().add(personelgirisekrani);
        this.frame.setVisible(true);

        personel_giris.Butonu_dinle bt_dinle1 = new personel_giris.Butonu_dinle();
        giris.addActionListener(bt_dinle1);
    }
    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == giris) {
                sicil_no = textField.getText();
                sifre = passwordField.getText();


                if (personel.personelGiris(sicil_no, sifre) == false) {

                    JOptionPane.showMessageDialog(null, "Giriş Başarısız! Lütfen kullanıcı adı ve şifreyi kontrol ediniz ", "HATA", 0);//hata mesajý
                    //frame.dispose();
                } else {
                    ad = personel.ad_getir(sicil_no);
                    System.out.println(ad);
                    secenekler yeni = new secenekler(ad);

                    frame.dispose();
                }

            }



        }
    }
}