package stok;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class personel_sil {
    private JFrame frame;
    private JTextField textField;

    JButton btnNewButton;
    JButton btnNewButton_1;
    String sicil;
    private JLabel lblNewLabel_1;
    int a=JOptionPane.YES_NO_OPTION;

    public personel_sil() {
        initialize();
    }

    private void initialize(){
        frame = new JFrame("Personel Sil");
        frame.setBounds(100, 100, 350, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(100, 26, 150, 14);
        frame.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Sicil no :");
        lblNewLabel_1.setBounds(50, 60, 60, 14);
        frame.getContentPane().add(lblNewLabel_1);


        textField = new JTextField();
        textField.setBounds(110, 60, 125, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Personel Sil");
        btnNewButton.setBounds(110, 100, 115, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("ADMİN MENÜ");
        btnNewButton_1.setBounds(110, 143, 115, 23);
        frame.getContentPane().add(btnNewButton_1);


        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);



    }
    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnNewButton){
                try{
                    sicil=textField.getText();
                    personel.personelSil(sicil);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);
                }



            }    else if(e.getSource()==btnNewButton_1){
                try{
                    admin_secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
                    frame.dispose();//kitapara penceresini kapattýk.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }
        }
    }}


