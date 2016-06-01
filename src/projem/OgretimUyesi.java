package projem;
import java.util.Scanner;
import java.lang.String;
import java.io.*;
import java.util.StringTokenizer;

public class OgretimUyesi extends Okul implements siralaUnutma {
    
    static int y;
    int d=0;
    static StringTokenizer st;
    static File hoca_dosyasi=new File("OgretimUyesi.txt");
    static InputStreamReader is=new InputStreamReader(System.in);
    static BufferedReader okuhoca=new BufferedReader(is);
    
     public  void sirala() {
       String satirdizisi[]=new String[50];
        try {
            FileInputStream oku=new FileInputStream(hoca_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
            
            satirdizisi[0]=okuma.readLine();
                if(satirdizisi[0]!=null &&  satirdizisi[0].contains("ID") ) {
                   
                }
                else {
                    FileWriter fwriter4=new FileWriter(hoca_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
                  
              yazdir4.write("HOCA ID HOCA AD          DERSLER");
              yazdir4.newLine();
              yazdir4.close();
                }                  
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
     public static void hocaGoster() {
         String satirdizisi[]=new String[50];
         try {
         FileInputStream oku=new FileInputStream(hoca_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
             int s=0;
      while((satirdizisi[s]=okuma.readLine())!=null  ) {
          if(  !(satirdizisi[s].contains("ID")) ){
          System.out.println(satirdizisi[s]);
          }
          
          s++;
      }
           
         }
         catch(Exception e) {
             System.out.println(e.getMessage());
         }
     }
    public static void yazdir(String hocaAdi,String dersAdi) {
        String satirdizisi[]=new String[50];
        try {
        FileInputStream oku=new FileInputStream(hoca_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
          int i=0;
           
                      while ((satirdizisi[i]=okuma.readLine())!=null){
                            if(satirdizisi[i].contains(hocaAdi)) {
                                
                                satirdizisi[i]=satirdizisi[i]+"       "+dersAdi;
                            }
                            i++;
                      }
                     new OgretimUyesi().yazdir(satirdizisi,i);
                      okuma.close();
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }        
    }
     public void yazdir(String satirdizisi[],int f) {
                try {
                 FileWriter fwriter4=new FileWriter(hoca_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
              
                 this.d=0; //THİS ANAHTAR KELİMESİ EN AZ 3 KERE KULLANILDI.
                 while(d<f) {
                      yazdir4.write(satirdizisi[d]);
                      yazdir4.newLine();
                       d++;
                    }
                      yazdir4.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
    }
    
    public static void main(String []args) {
        
        
        String satirdizisi[]=new String[50];
        Dersler derslernesnesi=new Dersler();
        try{
          
            hoca_dosyasi.createNewFile();
              new OgretimUyesi().sirala();
              FileInputStream oku=new FileInputStream("OgretimUyesi.txt");
            BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
           
            FileWriter fwriter=new FileWriter("OgretimUyesi.txt",true);
            BufferedWriter yazdir=new BufferedWriter(fwriter);
           
            System.out.println("Yapmak istediğiniz işlemi seçiniz: 1-Öğretim Üyesi eklemek istiyorum. 2-Öğretim Üyesine ders atamak istiyorum.");
            int secim=new Scanner(System.in).nextInt();
            
            
            switch(secim) {
                case 1:
                    System.out.println("Eklemek istediğiniz Öğretim Üyesini giriniz: ");
                    String hocaAdi=okuhoca.readLine();
        
        int s=0;
         while(true) {
                         satirdizisi[s]=okuma.readLine();
                         
                         if(satirdizisi[s]!=null && satirdizisi[s].contains("ID") ) {
                             s++;
                             continue;
                             
                         } 
                         if(satirdizisi[s]==null) {
                             yazdir.write(Integer.toString(s)+"       "+hocaAdi);
                             yazdir.newLine();
                             yazdir.close();
                             break;
                         }
                         
                         s++;
                         
                         
                     }
                break;
                
                case 2:
                    System.out.println("Ders eklemek istediğiniz öğretim üyesinin adını ve soyadını giriniz: ");
                    hocaGoster();
                    hocaAdi=okuhoca.readLine();
                    System.out.println("Eklemek istediğiniz dersin adını giriniz: ");
                    new Dersler().derslerGoster();
                    String dersAdi=okuhoca.readLine();
                    dersAdi=derslernesnesi.bul(dersAdi);
                    
                    yazdir(hocaAdi,dersAdi);
                    
               
                    
                    
                    break;
                    
            }
        
        
         
        okuma.close();
        yazdir.close();
        
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
