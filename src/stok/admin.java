package stok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;

public class admin{
    private String kullanici_adi;
    private String sifre;

    public admin(String kullanici_adi,String sifre) {


        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;


    }

    public admin(){

    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getsifre() {
        return sifre;
    }

    public void setsifre(String sifre) {
        this.sifre = sifre;
    }


    public static String ad_getir(String kullanici_adi){

        String isim = null;
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "select * from admin where kullanici_adi='"+kullanici_adi+"' ";

            ResultSet sor = st.executeQuery(sorgu2);

            if(sor.next()){
                String s_adi = sor.getString("kullanici_adi").toUpperCase();

                isim=s_adi;
            }
            st.close();

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

        return isim;
    }

    public static boolean adminGiris(String kullanici_adi,String sifre)
    {
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "select * from admin where kullanici_adi='"+kullanici_adi+"' and sifre='"+sifre+"' ";
            String sorgu3 = "select kullanici_adi from admin where kullanici_adi='"+kullanici_adi+"' and sifre='"+sifre+"' ";

            ResultSet sor = st.executeQuery(sorgu2);

            if(sor.next()){
                ResultSet sor3 = st.executeQuery(sorgu3);
                if(sor3.next()){
                    String s_adi = sor3.getString("kullanici_adi").toUpperCase();
                    //String s_soyadi = sor3.getString("personel_soyadi").toUpperCase();

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