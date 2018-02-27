package stok;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;

public class personel {

    private int tcNo;
    private String sicilNo;
    private String sifre;
    public String adi;
    public String soyAdi;
    public String unvan;

    public personel(int tcNo, String sicilNo , String sifre , String adi, String soyAdi, String unvan) {

        this.tcNo = tcNo;
        this.sicilNo = sicilNo;
        this.sifre = sifre;
        this.adi = adi;
        this.soyAdi = soyAdi;
        this.unvan = unvan;

    }

    public personel(){

    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public static void personelKayit(String ad,String soyad,String unvan,int tcNo,String sifre){

        personel temp = new personel();

        temp.adi=ad;
        temp.soyAdi=soyad;
        temp.unvan=unvan;
        temp.tcNo=tcNo;
        temp.sifre=sifre;

        temp.sicilNo = temp.tcNo +"00";


        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu3 = "SELECT TC_no FROM personel WHERE TC_no='"+temp.tcNo+"'";

            ResultSet rs = st.executeQuery(sorgu3);

            String sorgu2 =  "INSERT INTO personel(TC_no , sicil_no , personel_adi , personel_soyadi , personel_unvani , personel_sifre)"
                    + "VALUES ('"+temp.tcNo+"','"+temp.sicilNo+"','"+temp.adi+"','"+temp.soyAdi+"','"+temp.unvan+"','"+temp.getSifre()+"')";
            int sor = st.executeUpdate(sorgu2);
            st.close();
            JOptionPane.showMessageDialog(null, "Sicil nonuz başarıyla oluşturulmuştur!", "Bilgi", 1);

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            JOptionPane.showMessageDialog(null, "Eklenirken bir hata meydana geldi", "HATA", 0);
            System.err.println(a.getMessage());
        }
    }
    public static void personelSil(String sil){

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String tumu = "delete from personel where sicil_no='"+sil+"'";

            int sor = st.executeUpdate(tumu);
            if(sor==1){
                JOptionPane.showMessageDialog(null, "Personel silme işlemi başarıyla gerçekleştirildi", "Bilgi", 1);
            }
            else if(sor==0){
                JOptionPane.showMessageDialog(null, "Silme İşlemi İptal Edildi", "Hata", 0);
            }

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

    }
    public static String ad_getir(String sicil){

        String isim = null;
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "select * from personel where sicil_no='"+sicil+"' ";

            ResultSet sor = st.executeQuery(sorgu2);

            if(sor.next()){
                String s_adi = sor.getString("personel_adi").toUpperCase();
                String s_soyadi = sor.getString("personel_soyadi").toUpperCase();
                String s_bolum = sor.getString("personel_unvani").toUpperCase();
                isim=s_adi+" "+s_soyadi+"   "+"Bölüm:"+""+s_bolum;
            }
            st.close();

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

        return isim;
    }

    public static boolean personelGiris(String sicil,String sifre)
    {
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "select * from personel where sicil_no='"+sicil+"' and personel_sifre='"+sifre+"' ";
            String sorgu3 = "select personel_adi , personel_soyadi from personel where sicil_no='"+sicil+"' and personel_sifre='"+sifre+"' ";

            ResultSet sor = st.executeQuery(sorgu2);

            if(sor.next()){
                ResultSet sor3 = st.executeQuery(sorgu3);
                if(sor3.next()){
                    String s_adi = sor3.getString("personel_adi").toUpperCase();
                    String s_soyadi = sor3.getString("personel_soyadi").toUpperCase();

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