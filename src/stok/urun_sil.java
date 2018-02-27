package stok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JButton;

public class urun_sil {

    private JFrame frame;
    private JTextField textField;
    JButton btnNewButton;

    String barkod;
    private JButton btnNewButton_1;

    public urun_sil() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame("Ürün Sil");
        frame.setBounds(100, 100, 330, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Ürün Barkodu:");
        lblNewLabel.setBounds(30, 50, 90, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(120, 50, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        btnNewButton = new JButton("Ürün Sil");
        btnNewButton.setBounds(120, 80, 150, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("PERSONEL MENÜ");
        btnNewButton_1.setBounds(120, 123, 150, 23);
        frame.getContentPane().add(btnNewButton_1);

        urun_sil.Butonu_dinle bt_dinle = new urun_sil.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        urun_sil.Butonu_dinle bt_dinle1 = new urun_sil.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);
    }
        public class Butonu_dinle implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==btnNewButton){
                    try{
                        barkod = textField.getText();
                        urun.urunSil(barkod);

                    }
                    catch(Exception a){
                        JOptionPane.showMessageDialog(null, "Silinirken bir hata meydana geldi", "HATA", 0);

                    }
                }else if(e.getSource()==btnNewButton_1){

                    try{

                        secenekler.frame.setVisible(true);
                        frame.dispose();
                    }
                    catch(Exception a){
                        JOptionPane.showMessageDialog(null, "bir hata meydana geldi", "HATA", 0);

                    }
                }
            }
        }








    }

