package stok;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class personel_kayit {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JPasswordField passwordField;
    public JButton btnNewButton;
    public JButton btnNewButton_1;

    String ad;
    String soyAd;
    String bolum;
    int tcNo;
    String sifre;


    public personel_kayit() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Personel Ekle");
        frame.setBounds(100, 100, 300, 360);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(120, 60, 100, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(120, 90, 100, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(120, 120, 100, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(120, 150, 100, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 180, 100, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Adı");
        lblNewLabel.setBounds(50, 60, 50, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Soyadı");
        lblNewLabel_1.setBounds(50, 90, 50, 20);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Bölümü");
        lblNewLabel_2.setBounds(50, 120, 50, 20);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Tc No");
        lblNewLabel_3.setBounds(50, 150, 50, 20);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Şifre");
        lblNewLabel_4.setBounds(50, 180, 50, 20);
        frame.getContentPane().add(lblNewLabel_4);

        btnNewButton = new JButton("Personel Ekle");
        btnNewButton.setBounds(120, 220, 130, 20);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("ADMİN MENÜ");
        btnNewButton_1.setBounds(120, 250, 130, 20);
        frame.getContentPane().add(btnNewButton_1);


        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);


    }


    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton){
                try{
                    ad=textField.getText();
                    soyAd=textField_1.getText();
                    bolum=textField_2.getText();
                    tcNo=Integer.parseInt(textField_3.getText());
                    sifre=passwordField.getText();
                    personel.personelKayit(ad, soyAd, bolum, tcNo, sifre);
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

            else if(e.getSource()==btnNewButton_1){
                try{
                    admin_secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
                    frame.dispose();//kitapara penceresini kapattýk.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

        }
    }



}