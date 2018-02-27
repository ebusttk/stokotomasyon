package stok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class musteri_kayit {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JPasswordField passwordField;
    public JButton btnNewButton;
    public JButton btnNewButton_1;

    String ad;
    String soyAd;
    int tcNo;
    String sifre;

    public musteri_kayit() {
        initialize();
    }

    private void initialize(){
        frame = new JFrame("Müşteri Ekle");
        frame.setBounds(100, 100, 340, 360);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(120, 60, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        textField_1 = new JTextField();
        textField_1.setBounds(120, 90, 150, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);


        textField_3 = new JTextField();
        textField_3.setBounds(120, 150, 150, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);


        passwordField = new JPasswordField();
        passwordField.setBounds(120, 180, 150, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);


        JLabel lblNewLabel = new JLabel("Adı");
        lblNewLabel.setBounds(50, 60, 50, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Soyadı");
        lblNewLabel_1.setBounds(50, 90, 50, 20);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Tc No");
        lblNewLabel_3.setBounds(50, 150, 50, 20);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Şifre");
        lblNewLabel_4.setBounds(50, 180, 50, 20);
        frame.getContentPane().add(lblNewLabel_4);

        btnNewButton = new JButton("Müşteri Ekle");
        btnNewButton.setBounds(120, 220, 150, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("PERSONEL MENÜ");
        btnNewButton_1.setBounds(120, 253, 150, 23);
        frame.getContentPane().add(btnNewButton_1);

        musteri_kayit.Butonu_dinle bt_dinle = new musteri_kayit.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        musteri_kayit.Butonu_dinle bt_dinle1 = new musteri_kayit.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

    }
    public class Butonu_dinle implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnNewButton){
                try{
                    ad=textField.getText();
                    soyAd=textField_1.getText();
                    tcNo=Integer.parseInt(textField_3.getText());
                    sifre=passwordField.getText();
                    musteri.musteriKayit(ad, soyAd, tcNo, sifre);
                    JOptionPane.showMessageDialog(null, "Müşteri Eklendi!", "BİLGİ", 1);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            } else if(e.getSource()==btnNewButton_1){
                try{
                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
                    frame.dispose();//kitapara penceresini kapattýk.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }
        }
    }
}
