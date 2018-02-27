package stok;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class musteri_secenekler extends JFrame {

    JButton btnNewButton_2;
    JButton btnNewButton_1;
    JButton btnNewButton;

    public static JFrame frame;
    JLabel lblNewLabel = new JLabel();
    private String ad;

    public musteri_secenekler(String ad) {
        initialize(ad);

    }
    public void initialize(String ad){
        frame = new JFrame("Müşteri Menü");
        frame.setBounds(100, 100, 410, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);

        lblNewLabel.setBounds(31, 35, 207, 14);
        lblNewLabel.setText("Müşteri: "+ad);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Ürün Ara");
        btnNewButton.setBounds(50, 60, 130, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Ürün Listele");
        btnNewButton_1.setBounds(230, 60, 130, 23);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("ANA MENÜ");
        btnNewButton_2.setBounds(140, 103, 130, 23);
        frame.getContentPane().add(btnNewButton_2);

        musteri_secenekler.Butonu_dinle bt_dinle2 = new musteri_secenekler.Butonu_dinle();
        btnNewButton_2.addActionListener(bt_dinle2);

        musteri_secenekler.Butonu_dinle bt_dinle1 = new musteri_secenekler.Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

        musteri_secenekler.Butonu_dinle bt_dinle = new musteri_secenekler.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);



    }
    public class Butonu_dinle implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnNewButton){
                frame.setVisible(false);
                musteri_urun_ara yeni = new musteri_urun_ara();


            }else  if(e.getSource()==btnNewButton_1){
                frame.setVisible(false);
                musteri_tum_urunler yeni = new musteri_tum_urunler();


            }else  if(e.getSource()==btnNewButton_2){
                frame.setVisible(false);
                giris_ekrani yeni = new giris_ekrani();


            }
        }
    }
}
