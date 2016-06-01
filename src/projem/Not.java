package projem;
import java.util.Scanner;
import java.lang.String;
import java.io.*;
import java.util.StringTokenizer;

public class Not extends Okul implements yazdirUnutma {
    static String ata;
 
        static StringTokenizer st;
            static int y;
  static File not_dosyasi=new File("not.txt");
    static InputStreamReader is=new InputStreamReader(System.in);
    static BufferedReader okuders=new BufferedReader(is);
     
    public  void sirala() {
       String satirdizisi[]=new String[50];
        try {
            FileInputStream oku=new FileInputStream(not_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
            
            satirdizisi[0]=okuma.readLine();
                if(satirdizisi[0]!=null &&  satirdizisi[0].contains("ID") ) {
                   
                }
                else {
                    FileWriter fwriter4=new FileWriter(not_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
                  
              yazdir4.write("OGR ID DERS ID NOT");
              yazdir4.newLine();
              yazdir4.close();
                }                  
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void bul( String satirdizisi2[],String guncelid) {
         try {
        not_dosyasi.createNewFile();
              FileInputStream oku=new FileInputStream(not_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
           String not;
           String satirdizisi[]=new String[50];
              int i=0;
              int b=0;
              while ((satirdizisi[i]=okuma.readLine())!=null){
                           this.st=new StringTokenizer(satirdizisi[i]);
                          
                           if(this.st.nextToken().contains(guncelid) ) {
                               this.st.nextToken();
                                 satirdizisi2[b]=this.st.nextToken();
                               b++;
                            }
                            i++;
                            
                      
                      }
                              
                                  
                okuma.close();
                      
    
         }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
         
    }
    
    
    public static String bul(String guncelid, String istenenders) {
         try {
        
              FileInputStream oku=new FileInputStream(not_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
           String not;
           String satirdizisi[]=new String[50];
              int i=0;
                      while ((satirdizisi[i]=okuma.readLine())!=null){
                           st=new StringTokenizer(satirdizisi[i]);
                            if(st.nextToken().contains(guncelid) && st.nextToken().contains(istenenders) ) {
                                
                                 ata=st.nextToken();
                            }
                            i++;
                      }
                     
                      
                      okuma.close();
                      
              
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
         return ata;
    }
    
    public static void guncelle(String guncelid,String guncelders, String guncelnot) {
       
        try {
        
              FileInputStream oku=new FileInputStream(not_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
           String satirdizisi[]=new String[50];
              int i=0;
                      while ((satirdizisi[i]=okuma.readLine())!=null){
                           st=new StringTokenizer(satirdizisi[i]);
                            if(st.nextToken().contains(guncelid) && st.nextToken().contains(guncelders) ) {
                                
                                  satirdizisi[i]=(guncelid+"      "+guncelders+"       "+guncelnot);
                                  System.out.println(guncelnot);
                            }
                            i++;
                      }
                    new Not().yazdir(satirdizisi,i);
                      okuma.close();
                      
              
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    } 
    
      public  void yazdir(String param[],int f) {
         
            try {
                 FileWriter fwriter4=new FileWriter(not_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
              
                 int d=0;
                 while(d<f) {
                     System.out.println(param[d]);
                      yazdir4.write(param[d]);
                      yazdir4.newLine();
                       d++;
                    }
                      yazdir4.close();
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
     }
    
    public static void yazdir(String ogrenciId,String dersId, String not) {
        
         
            try {
                 FileWriter fwriter4=new FileWriter(not_dosyasi,true);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
              
              yazdir4.write(ogrenciId+"      "+dersId+"       "+not);
              yazdir4.newLine();
              
            yazdir4.close();
            }
            
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
     }
    
    
    public static void main(String[]args) {
        
        System.out.println("Seçiminizi yapın: 1-Not eklemek istiyorum. 2-Not güncellemek istiyorum.");
        int secim=new Scanner(System.in).nextInt();
       
        
        try {
            not_dosyasi.createNewFile();
            new Not().sirala();
            
        switch(secim) {
            case 1:
                System.out.println("Not eklemek istediğiniz öğrencinin adını ve soyadını giriniz: ");
                new Ogrenci().ogrenciGoster();
                String adsoyad=okuders.readLine();
                new Dersler().derslerGoster();
                System.out.println("Eklemek istediğiniz dersin adını giriniz: ");
                String ders=okuders.readLine();
                
                System.out.println("Eklemek istediğiniz notu giriniz: ");
                String not=okuders.readLine();
                String idbul=new Ogrenci().bul(adsoyad);
                String dersibul=new Dersler().bul(ders);
                yazdir(idbul,dersibul,not);
                break;
            case 2:
                System.out.println("Notunu güncellemek istediğiniz öğrencinin adını ve soyadını giriniz: ");
                new Ogrenci().ogrenciGoster();
                String gunceladsoyad=okuders.readLine();
                System.out.println("Notunu güncellemek istediğiniz dersi giriniz: ");
                new Dersler().derslerGoster();
                String guncelders=okuders.readLine();
                
                System.out.println("Yeni notu giriniz: ");
                String guncelnot=okuders.readLine();
                idbul=new Ogrenci().bul(gunceladsoyad);
                guncelders=new Dersler().bul(guncelders);
                guncelle(idbul,guncelders,guncelnot);
            break;
        }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }
}
