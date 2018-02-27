package stok;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_secenekler extends JFrame{

    JButton btnNewButton_3;
    JButton btnNewButton_2;
    JButton btnNewButton_1;
    JButton btnNewButton;

    public static JFrame frame;
    JLabel lblNewLabel = new JLabel("New label");
    private String ad;

    public admin_secenekler(String ad) {
        initialize(ad);

    }
    public void initialize(String ad){

        frame = new JFrame("Admin Menü");
        frame.setBounds(100, 100, 480, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);

        lblNewLabel.setBounds(31, 35, 207, 14);
        lblNewLabel.setText("Admin : "+ad);

        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Personel Ekle");
        btnNewButton.setBounds(60, 88, 160, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Personel Sil");
        btnNewButton_1.setBounds(260, 88, 160, 23);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("Personelleri Listele");
        btnNewButton_2.setBounds(60, 141, 160, 23);
        frame.getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("ANA MENÜ");
        btnNewButton_3.setBounds(260, 141, 160, 23);
        frame.getContentPane().add(btnNewButton_3);


        admin_secenekler.Butonu_dinle bt_dinle1 = new admin_secenekler.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

        admin_secenekler.Butonu_dinle bt_dinle2 = new admin_secenekler.Butonu_dinle();
        btnNewButton_2.addActionListener(bt_dinle2);

        admin_secenekler.Butonu_dinle bt_dinle3 = new admin_secenekler.Butonu_dinle();
        btnNewButton_3.addActionListener(bt_dinle3);

        admin_secenekler.Butonu_dinle bt_dinle = new admin_secenekler.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

    }
    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getSource()==btnNewButton_1){
                frame.setVisible(false);
                personel_sil yeni=new personel_sil();
                frame.dispose();
            } else if(e.getSource()==btnNewButton_2){
                frame.setVisible(false);
                tum_personel yeni=new tum_personel();
                frame.dispose();
            } else if(e.getSource()==btnNewButton_3){
                giris_ekrani yeni=new giris_ekrani();
                frame.dispose();
            }
            else if(e.getSource()==btnNewButton){
                frame.setVisible(false);
                personel_kayit yeni = new personel_kayit();
                frame.dispose();

            }

        }


    }


}
