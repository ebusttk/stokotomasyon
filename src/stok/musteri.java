package stok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;
public class musteri{
    private int tcNo;
    private String sifre;
    public String adi;
    public String soyAdi;

    public musteri(int tcNo,String sifre,String adi,String soyAdi){
        this.tcNo = tcNo;
        this.sifre = sifre;
        this.adi = adi;
        this.soyAdi = soyAdi;

    } public musteri(){

    }public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public static void musteriKayit(String ad,String soyad,int tcNo,String sifre){
        musteri temp=new musteri();

        temp.adi=ad;
        temp.soyAdi=soyad;
        temp.tcNo=tcNo;
        temp.sifre=sifre;

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String sorgu3 = "SELECT tck FROM musteri WHERE tck='"+temp.tcNo+"'";

            ResultSet rs = st.executeQuery(sorgu3);


            String sorgu2 =  "INSERT INTO musteri(tck,adi,soyadi,sifre)"
                    + "VALUES ('"+temp.tcNo+"','"+temp.adi+"','"+temp.soyAdi+"','"+temp.getSifre()+"')";
            int sor = st.executeUpdate(sorgu2);
            st.close();
        } catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }
    }
    public static void musteriSil(String sil){

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String tumu = "delete from musteri where tck='"+sil+"'";

            int sor = st.executeUpdate(tumu);
            if(sor==1){
                JOptionPane.showMessageDialog(null, "Müşteri silindi!", "Bilgi", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Silinecek kişi bulunamadı", "Hata", 0);
            }

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

    }
    public static String ad_getir(String tck){

        String isim = null;
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "select * from musteri where tck='"+tck+"' ";

            ResultSet sor = st.executeQuery(sorgu2);

            if(sor.next()){
                String s_adi = sor.getString("adi").toUpperCase();
                String s_soyadi = sor.getString("soyadi").toUpperCase();
                isim=s_adi+" "+s_soyadi;
            }
            st.close();

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

        return isim;
    }

    public static boolean musteriGiris(String tck,String sifre)
    {
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "select * from musteri where tck='"+tck+"' and sifre='"+sifre+"' ";
            String sorgu3 = "select adi , soyadi from musteri where tck='"+tck+"' and sifre='"+sifre+"' ";

            ResultSet sor = st.executeQuery(sorgu2);

            if(sor.next()){
                ResultSet sor3 = st.executeQuery(sorgu3);
                if(sor3.next()){
                    String s_adi = sor3.getString("adi").toUpperCase();
                    String s_soyadi = sor3.getString("soyadi").toUpperCase();

                }
                st.close();

                return true;
            }

            else{
                st.close();	return false;
            }

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

        return false;
    }
}