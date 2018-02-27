package stok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class giris_ekrani {

    JFrame frame;
    JTextField textField;
    JTextField textField_1;
    JLabel lblKtphaneOtomasyonuGiri;
    JLabel lblKtphaneOtomasyonuGiris;
    JLabel a;




    JButton admin;
    JButton personelgiris;
    JButton musteri;

    String ad = null;


    public giris_ekrani() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame("TETİK TEKNOLOJİ MARKET STOK PROGRAMI");
        frame.setLocationRelativeTo(null);
        frame.setBounds(200, 100, 430, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);


        admin=new JButton("ADMİN");
        admin.setBounds(20, 60, 131, 23);
        frame.getContentPane().add(admin);

        personelgiris=new JButton("PERSONEL");
        personelgiris.setBounds(20, 100, 131, 23);
        frame.getContentPane().add(personelgiris);

        musteri=new JButton("MÜŞTERİ");
        musteri.setBounds(20, 140, 131, 23);

        frame.getContentPane().add(musteri);

        lblKtphaneOtomasyonuGiri = new JLabel();

        lblKtphaneOtomasyonuGiri.setBounds(0, 160, 100, 100);
        frame.getContentPane().add(lblKtphaneOtomasyonuGiri);

        lblKtphaneOtomasyonuGiris = new JLabel(new ImageIcon("C:\\Users\\ebust\\Desktop\\2017-2018 GÜZ\\NYP\\nyp-proje\\cv.jpg"));
        //a=new JLabel(new ImageIcon("C:\\Users\\ebust\\Desktop\\d.png"));

        lblKtphaneOtomasyonuGiris.setBounds(100, 100, 300, 170);
        frame.getContentPane().add(lblKtphaneOtomasyonuGiris);

        this.frame.setVisible(true);

        Butonu_dinle bt_dinle2 = new Butonu_dinle();
        admin.addActionListener(bt_dinle2);

        Butonu_dinle bt_dinle3 = new Butonu_dinle();
        personelgiris.addActionListener(bt_dinle3);

        Butonu_dinle bt_dinle4 = new Butonu_dinle();
        musteri.addActionListener(bt_dinle4);




    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==admin){
                admin_giris yeni=new admin_giris();

            } else if(e.getSource()==personelgiris){
                personel_giris yeni=new personel_giris();

            } else if(e.getSource()==musteri){
                musteri_giris yeni=new musteri_giris();

            }

        }

    }
}