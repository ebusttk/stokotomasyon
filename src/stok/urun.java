package stok;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JTextArea;

import javax.swing.JOptionPane;

public class urun {

    public String barkod;
    public String marka;
    public String turu;
    public int fiyat;
    public int adet;

    public static String urunbarkodAra(String ara){


        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String ara_sorgusu = "SELECT * FROM urun WHERE barkod='"+ara+"'";
            ResultSet rs = st.executeQuery(ara_sorgusu);

            boolean deneme=rs.next();
            if(deneme==true)
            {
                String s_barkod = rs.getString("barkod");
                String s_marka = rs.getString("marka");
                String s_turu = rs.getString("turu");
                int s_fiyat = rs.getInt("fiyat" );
                int s_adet = rs.getInt("adet" );


                String sonuc = "Barkod : "+s_barkod +"\n"+
                        "Marka : "+s_marka +"\n"+
                        "Türü : "+s_turu +"\n"+
                        "Fiyat : "+s_fiyat+"\n"+
                        "Adet : "+s_adet+"\n"
                        ;

                if(s_adet==3){
                    sonuc = sonuc + "SON 3 ÜRÜN!";
                } else if(s_adet==2){
                    sonuc = sonuc + "SON 2 ÜRÜN!";
                } else if(s_adet==1){
                    sonuc = sonuc + "SON 1 ÜRÜN!";
                }else if(s_adet==0){
                    sonuc = sonuc + "ÜRÜN TÜKENDİ!";
                }
                else{
                    sonuc = sonuc + "Stok Mevcut";
                }

                return sonuc;

            }
            else{

                String sonuc = "Ürün bulunamadı.";
                return sonuc;
            }




        }

        catch(Exception a){
            String sonuc = "hata";
            return sonuc;

        }




    }



    public static void urunKayit(String barkod,String marka,String turu,int fiyat,int adet){

        urun temp=new urun();

        temp.barkod=barkod;
        temp.marka=marka;
        temp.turu=turu;
        temp.fiyat=fiyat;
        temp.adet=adet;

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String sorgu3 = "SELECT barkod FROM urun WHERE barkod='"+temp.barkod+"'";

            ResultSet rs = st.executeQuery(sorgu3);


            String sorgu2 =  "INSERT INTO urun(barkod,marka,turu,fiyat,adet)"
                    + "VALUES ('"+temp.barkod+"','"+temp.marka+"','"+temp.turu+"','"+temp.fiyat+"',"+temp.adet+")";

            int sor = st.executeUpdate(sorgu2);

            st.close();
        }

        catch(Exception a){
            JOptionPane.showMessageDialog(null, "Bir hata meydana geldi!!", "Hata", 0);

        }
    }
    public static void urunSil(String barkod){
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String tumu = "delete from urun where barkod='"+barkod+"' ORDER BY adet DESC LIMIT 1 ";
            int sor = st.executeUpdate(tumu);
            if(sor==1){
                JOptionPane.showMessageDialog(null, "Ürün Silindi!", "Bilgi", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Girdiğiniz barkod bulunamadı!","Bilgi", 0);
            }

        }

        catch(Exception a){
            JOptionPane.showMessageDialog(null, "Hata meydana geldi","Bilgi", -1);
        }

    }


    public urun(String barkod,String marka,String turu,int fiyat,int adet) {

        this.barkod=barkod;
        this.marka=marka;
        this.turu=turu;
        this.fiyat=fiyat;
        this.adet=adet;

    }

    public urun(){
    }


}
