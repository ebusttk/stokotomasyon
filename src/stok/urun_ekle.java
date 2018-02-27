package stok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class urun_ekle {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;

    JButton btnNewButton ;
    JButton btnNewButton_1;

    String barkod;
    String marka;
    String turu;
    int fiyat;
    int adet;


    public urun_ekle() {
        initialize();
    }

    private void initialize(){

        frame = new JFrame("Ürün Ekle");
        frame.setBounds(0, 100, 330, 390);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Barkod:");
        lblNewLabel.setBounds(50, 50, 50, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(110, 50, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Marka:");
        lblNewLabel_1.setBounds(50, 90, 50, 20);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(110, 90, 150, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel_2 = new JLabel("Türü:");
        lblNewLabel_2.setBounds(50, 130, 50, 20);
        frame.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(110, 130, 150, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        lblNewLabel_3 = new JLabel("Fiyat:");
        lblNewLabel_3.setBounds(50, 170, 50, 20);
        frame.getContentPane().add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setBounds(110, 170, 150, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        lblNewLabel_4 = new JLabel("Adet:");
        lblNewLabel_4.setBounds(50, 210, 50, 20);
        frame.getContentPane().add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setBounds(110, 210, 150, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        btnNewButton_1 = new JButton("Ürün Ekle");
        btnNewButton_1.setBounds(110, 250, 150, 20);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton = new JButton("PERSONEL MENÜ");
        btnNewButton.setBounds(110, 290, 150, 20);
        frame.getContentPane().add(btnNewButton);

        urun_ekle.Butonu_dinle bt_dinle1 = new urun_ekle.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

        urun_ekle.Butonu_dinle bt_dinle = new urun_ekle.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);


    }
    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton_1){
                try{
                    barkod = textField.getText();
                    marka = textField_1.getText();
                    turu = textField_2.getText();
                    fiyat = Integer.parseInt(textField_3.getText());
                    adet = Integer.parseInt(textField_4.getText());



                    urun.urunKayit(barkod,marka,turu,fiyat,adet);
                    JOptionPane.showMessageDialog(null, "Ürün Eklendi!", "BİLGİ", 1);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Eklenirken bir hata meydana geldi", "HATA", 0);

                }
            }
            else if(e.getSource()==btnNewButton){
                try{

                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
                    frame.dispose();//kitapara penceresini kapattýk.

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "bir hata meydana geldi", "HATA", 0);

                }
            }
        }






    }






}
