package stok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class musteri_giris {

    JFrame frame;
    JTextField textField;
    JPasswordField passwordField;
    JLabel musterigirisekrani;
    JButton giris;
    String ad = null;

    String tc,sifre;

    public musteri_giris(){
        initialize();
    }

    public void initialize(){

        frame=new JFrame("Müşteri Giriş");
        frame.setBounds(100, 100, 250, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);



        JLabel kullanici_adi = new JLabel("Tc No:");
        kullanici_adi.setBounds(40, 40, 50, 20);
        frame.getContentPane().add(kullanici_adi);

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


        musterigirisekrani = new JLabel("");
        musterigirisekrani.setBounds(130, 26, 370, 14);
        frame.getContentPane().add(musterigirisekrani);
        this.frame.setVisible(true);

        musteri_giris.Butonu_dinle bt_dinle1 = new musteri_giris.Butonu_dinle();
        giris.addActionListener(bt_dinle1);


    }
    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == giris) {
                tc = textField.getText();
                sifre = passwordField.getText();


                if (musteri.musteriGiris(tc, sifre) == false) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız! Lütfen kullanıcı adı ve şifreyi kontrol ediniz ", "HATA", 0);//hata mesajý
                } else {
                    ad = musteri.ad_getir(tc);
                    System.out.println(ad);
                    musteri_secenekler yeni = new musteri_secenekler(ad);


                    frame.dispose();
                }

            }

        }

    }
}
