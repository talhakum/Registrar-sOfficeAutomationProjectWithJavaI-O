package projem;
import java.util.Scanner;
import java.lang.String;
import java.io.*;
import java.util.StringTokenizer;



public class NotOrtalamasi extends Okul {
    static Dersler derslernesnesi=new Dersler();
    static Not notnesnesi=new Not();
    static Ogrenci ogrencinesnesi=new Ogrenci();
   static File notort_dosyasi=new File("NotOrtalamasi.txt");
   static InputStreamReader is=new InputStreamReader(System.in);
    static BufferedReader okuders=new BufferedReader(is);
    
     public  void sirala() {
       String satirdizisi[]=new String[50];
        try {
            FileInputStream oku=new FileInputStream(notort_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
            
            satirdizisi[0]=okuma.readLine();
                if(satirdizisi[0]!=null &&  satirdizisi[0].contains("ID") ) {
                   
                }
                else {
                    FileWriter fwriter4=new FileWriter(notort_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
                  
              yazdir4.write("OGR ID DERS ID NOT NOTORTALAMASI");
              yazdir4.newLine();
              yazdir4.close();
                }                  
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
     public void yazdir(String not,String ogrenciid, String istenendersid) {
       
         
            try {
                 FileWriter fwriter4=new FileWriter(notort_dosyasi,true);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
              
              
              yazdir4.write(ogrenciid+"      "+istenendersid+"       "+not);
              yazdir4.newLine();
              
            yazdir4.close();
            }
            
            catch(Exception e) {
                
            }
    }
   static public void notOrtalamasi(String ogrenciid ) {
       String satirdizisi2[]=new String[50];
       try {
       FileWriter fwriter4=new FileWriter(notort_dosyasi,true);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
              
              
       notnesnesi.bul(satirdizisi2,ogrenciid);
       String ortalama;
       int toplam=0;
       int i=0;
       while( satirdizisi2[i]!=null )  {
           
           toplam+=Integer.parseInt(satirdizisi2[i]);
           i++;
       }
       
           System.out.println("İstenen öğrencinin ortalaması: "+(double)toplam/i);
       
           yazdir4.write(ogrenciid+"                  "+String.valueOf((double)toplam/i));
           yazdir4.newLine();
            yazdir4.close();
   
       }  
       catch(Exception e) {
           System.out.println(e.getMessage());
       }
       
       
       
   }
    public static void main(String []args) {
        
   
        System.out.println("Yapmak istediğiniz işlemin numarasını giriniz: 1-Öğrencinin notunu listelemek istiyorum. 2-Öğrencinin not ortalamasını hesaplamak istiyorum.");
        int secim=new Scanner(System.in).nextInt();
        
       
        try {
             notort_dosyasi.createNewFile();
                 new NotOrtalamasi().sirala();
        switch(secim) {
            case 1:
                System.out.println("Notunu listelemek istediğiniz öğrencinin adını ve soyadını giriniz: ");
                new Ogrenci().ogrenciGoster();
                String ogrenci=okuders.readLine();
                System.out.println("Notunu öğrenmek istediğiniz dersin adını giriniz: ");
                new Dersler().derslerGoster();
                String istenenders=okuders.readLine();
                String id=ogrencinesnesi.bul(ogrenci);
               String istenendersid=derslernesnesi.bul(istenenders);
               String yazdirilacak=notnesnesi.bul(id,istenendersid);
                System.out.println(yazdirilacak);
               new NotOrtalamasi().yazdir(yazdirilacak,id,istenendersid);
                break;
            case 2:
                System.out.println("Not ortalamasını hesaplamak istediğiniz öğrencinin adını ve soyadını giriniz: ");
                new Ogrenci().ogrenciGoster();
                ogrenci=okuders.readLine();
                 id=ogrencinesnesi.bul(ogrenci);
                
                notOrtalamasi(id);
        }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}