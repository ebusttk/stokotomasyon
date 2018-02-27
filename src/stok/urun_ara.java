package stok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JTextArea;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class urun_ara {
    private JFrame frame;
    private JTextField textField;


    JButton btnNewButton;
    String barkod;
    String marka;
    JTextArea textArea;
    JButton btnNewButton_1;


    public urun_ara() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Ürün Ara");
        frame.setBounds(100, 100, 360, 320);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Ürün Barkodu");
        lblNewLabel.setBounds(50, 50, 80, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(140, 50, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Ürün Ara");
        btnNewButton.setBounds(140, 80, 150, 23);
        frame.getContentPane().add(btnNewButton);


        textArea = new JTextArea();
        textArea.setBounds(140, 113, 150, 100);
        frame.getContentPane().add(textArea);
        textArea.setEditable(false);

        btnNewButton_1 = new JButton("PERSONEL MENÜ");
        btnNewButton_1.setBounds(140, 220, 150, 23);
        frame.getContentPane().add(btnNewButton_1);


        urun_ara.Butonu_dinle bt_dinle = new urun_ara.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        urun_ara.Butonu_dinle bt_dinle2 = new urun_ara.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle2);



    }
    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton){
                try{
                    barkod = textField.getText();
                    String don = urun.urunbarkodAra(barkod);
                    textArea.setText(don);


                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Aranırken bir hata meydana geldi", "HATA", 0);
                    frame.dispose();

                }
            }

            else if(e.getSource()==btnNewButton_1){
                try{

                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
                    frame.dispose();//kitapara penceresini kapattýk.

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "bir hata meydana geldi", "HATA", 0);
                    frame.dispose();

                }
            }
        }


    }




}
