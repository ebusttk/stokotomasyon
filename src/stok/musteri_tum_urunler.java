package stok;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
public class musteri_tum_urunler {

    private JFrame frame;

    JTextArea textArea;
    JButton btnNewButton;
    private JScrollPane scrollPane;

    public musteri_tum_urunler() {
        initialize();
    }

    public void initialize() {

        frame = new JFrame("Ürün Listesi");
        frame.setBounds(100, 100, 316, 456);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 62, 300, 300);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);


        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String tumu = "SELECT * FROM urun";
            ResultSet rs = st.executeQuery(tumu);

            while(rs.next())
            {

                String u_barkod = rs.getString("barkod");
                String u_marka = rs.getString("marka");
                String u_turu = rs.getString("turu");
                int u_fiyat=rs.getInt("fiyat");
                int u_adet = rs.getInt("adet");




                textArea.append("=====>Barkod : "+u_barkod +"\n"+
                        "=====>Marka : "+u_marka +"\n"+
                        "=====>Türü : "+u_turu +"\n"+
                        "=====>Fiyat : "+u_fiyat +"\n"+
                        "=====>Sayı : "+u_adet+"\n"+"\n"+"\n"

                );


            }

        }
        catch(Exception a){
            System.err.println("Hata ! ");

            System.err.println(a.getMessage());
        }

        JLabel lblNewLabel = new JLabel("T\u00FCm Ürünler listelenmektedir");
        lblNewLabel.setBounds(70, 37, 220, 14);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("MÜŞTERİ MENÜ");
        btnNewButton.setBounds(80, 380, 141, 23);
        frame.getContentPane().add(btnNewButton);
        musteri_tum_urunler.Butonu_dinle bt_dinle = new musteri_tum_urunler.Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);


    }

    public class Butonu_dinle implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton){
                try{
                    musteri_secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
                    frame.dispose();//kitapara penceresini kapattýk.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

        }

    }

}
