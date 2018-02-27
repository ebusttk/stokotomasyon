package stok;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class musteri_sil {
    private JFrame frame;
    private JTextField textField;

    JButton btnNewButton;
    JButton btnNewButton_1;
    String tc;
    private JLabel lblNewLabel_1;

    public musteri_sil(){
        initialize();
    }

    private void initialize(){

        frame = new JFrame("Müşteri Sil");
        frame.setBounds(100, 100, 330, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);



        lblNewLabel_1 = new JLabel("Tc no:");
        lblNewLabel_1.setBounds(50, 60, 40, 20);
        frame.getContentPane().add(lblNewLabel_1);


        textField = new JTextField();
        textField.setBounds(90, 60, 150, 20);
        frame.getContentPane().add(textField);


        btnNewButton = new JButton("Müşteri Sil");
        btnNewButton.setBounds(90, 100, 150, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("PERSONEL MENÜ");
        btnNewButton_1.setBounds(90, 143, 150, 23);
        frame.getContentPane().add(btnNewButton_1);

        musteri_sil.Butonu_dinle bt_dinle = new musteri_sil.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        musteri_sil.Butonu_dinle bt_dinle1 = new musteri_sil.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

    }

    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getSource()==btnNewButton){
                try{
                    tc=textField.getText();
                    musteri.musteriSil(tc);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);
                }


            }    else if(e.getSource()==btnNewButton_1){
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

