package stok;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

//import stok.personel_giris_yap.Butonu_dinle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class secenekler extends JFrame {

    JButton btnNewButton_8;
    JButton btnNewButton_7;
    JButton btnNewButton_6;
    JButton btnNewButton_5;
    JButton btnNewButton_4;
    JButton btnNewButton_3;
    JButton btnNewButton_2;
    JButton btnNewButton_1;
    JButton btnNewButton;

    public static JFrame frame;
    JLabel lblNewLabel = new JLabel();
    private String ad;

    public secenekler(String ad) {
        initialize(ad);

    }

    public void initialize(String ad) {
        frame = new JFrame("Personel Menü");
        frame.setBounds(100, 100, 430, 325);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null); frame.getContentPane().setBackground(Color.WHITE);


        lblNewLabel.setBounds(31, 20, 410, 14);
        lblNewLabel.setText("Personel : "+ad);


        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Ürün Ara");
        btnNewButton.setBounds(50, 60, 130, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Müşteri Ekle");
        btnNewButton_1.setBounds(230, 60, 130, 23);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("Ürün Ekle");
        btnNewButton_2.setBounds(50, 113, 130, 23);
        frame.getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("Müşteri Sil");
        btnNewButton_3.setBounds(230, 113, 130, 23);
        frame.getContentPane().add(btnNewButton_3);

        btnNewButton_4 = new JButton("Ürün Listele");
        btnNewButton_4.setBounds(50, 166, 130, 23);
        frame.getContentPane().add(btnNewButton_4);

        btnNewButton_5 = new JButton("Müşteri Listele");
        btnNewButton_5.setBounds(230, 166, 130, 23);
        frame.getContentPane().add(btnNewButton_5);

        btnNewButton_6 = new JButton("Ürün Sil");
        btnNewButton_6.setBounds(50, 222, 130, 23);
        frame.getContentPane().add(btnNewButton_6);

        btnNewButton_7 = new JButton("ANA MENÜ");
        btnNewButton_7.setBounds(230, 222, 130, 23);
        frame.getContentPane().add(btnNewButton_7);


        Butonu_dinle bt_dinle7 = new Butonu_dinle();
        btnNewButton_7.addActionListener(bt_dinle7);

        Butonu_dinle bt_dinle6 = new Butonu_dinle();
        btnNewButton_6.addActionListener(bt_dinle6);

        Butonu_dinle bt_dinle5 = new Butonu_dinle();
        btnNewButton_5.addActionListener(bt_dinle5);

        Butonu_dinle bt_dinle4 = new Butonu_dinle();
        btnNewButton_4.addActionListener(bt_dinle4);

        Butonu_dinle bt_dinle3 = new Butonu_dinle();
        btnNewButton_3.addActionListener(bt_dinle3);

        Butonu_dinle bt_dinle2 = new Butonu_dinle();
        btnNewButton_2.addActionListener(bt_dinle2);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);
    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==btnNewButton_7){
                frame.setVisible(false);
                giris_ekrani yeni=new giris_ekrani();
                frame.dispose();

            }
            else if(e.getSource()==btnNewButton_6){
                frame.setVisible(false);
                urun_sil yeni=new urun_sil();

            }
            else if(e.getSource()==btnNewButton_5){
                frame.setVisible(false);
                tum_musteri yeni=new tum_musteri();

            }
            else if(e.getSource()==btnNewButton_4){
                frame.setVisible(false);
                tum_urunler yeni=new tum_urunler();


            }
            else if(e.getSource()==btnNewButton_3){
                frame.setVisible(false);
                musteri_sil yeni = new musteri_sil();


            }
            else if(e.getSource()==btnNewButton_2){
                frame.setVisible(false);
                urun_ekle yeni = new urun_ekle();


            }
            else if(e.getSource()==btnNewButton_1){
                frame.setVisible(false);
                musteri_kayit yeni=new musteri_kayit();


            }
            else if(e.getSource()==btnNewButton){
                frame.setVisible(false);
                urun_ara yeni = new urun_ara();


            }
        }
    }

}