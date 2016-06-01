package projem;
import java.io.*;
import java.lang.String;
import java.util.Scanner;
import java.util.StringTokenizer;
interface yazdirUnutma { //EN AZ 2 İNTERFACE OLUŞTURULDU.
    public  void yazdir(String satirunutma[],int satirindis);
}
public class Ogrenci extends Okul   {
    
    static StringTokenizer st;
    static int y;
    static File ogr_dosyasi=new File("ogrenci.txt");
    static int x;
   static InputStreamReader is=new InputStreamReader(System.in);
    static BufferedReader okuid=new BufferedReader(is);
    static String id;
    
     public  void sirala() {
         
       String satirdizisi[]=new String[50];
        try {
            FileInputStream oku=new FileInputStream(ogr_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
            
            satirdizisi[0]=okuma.readLine();
                if(satirdizisi[0]!=null &&  satirdizisi[0].contains("ID") ) {
                   
                }
                else {
                    FileWriter fwriter4=new FileWriter(ogr_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
                  
              yazdir4.write("OGR ID OGR NUMARA OGR ISIM");
              yazdir4.newLine();
              yazdir4.close();
                }                  
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    static public void ogrenciGoster() {
        String satirdizisi[]=new String[50];
         try {
             ogr_dosyasi.createNewFile();
         FileInputStream oku=new FileInputStream(ogr_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
             int s=0;
      while((satirdizisi[s]=okuma.readLine())!=null) {
          System.out.println(satirdizisi[s]);
          
          s++;
      }
           
         }
         catch(Exception e) {
             System.out.println(e.getMessage());
         }
    }
    
    static public String bul(String adsoyad) {
        String satirdizisi[]=new String[50];
        try {
            String idbul="";
          
         FileInputStream oku=new FileInputStream(ogr_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
              
               int i=0;
                      while ((satirdizisi[i]=okuma.readLine())!=null){
                            if(satirdizisi[i].contains(adsoyad)) {
                                
                               
                                  idbul=Integer.toString(i);
                            }
                            i++;
                      }
                      
                      id=idbul;
        }
       catch(Exception e) {
       System.out.println(e.getMessage());
                              }
               
        return id;
    }
    
     public  void yazdir(String param[],int f) {
         
            try {
                 FileWriter fwriter4=new FileWriter(ogr_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
              
                 int d=0;
                 while(d<f) {
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
   
     static public int oku(String satirdizisi[],String id,String yeriniAlacak,String numara) {
         Ogrenci nesne=new Ogrenci();
         nesne.y=0;
         try {
             String test;
             FileInputStream oku=new FileInputStream(ogr_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
              
               int i=0;
                      while ((satirdizisi[i]=okuma.readLine())!=null){
                st=new StringTokenizer(satirdizisi[i]);
               
                   test=st.nextToken();
                   if(test.equals(id)) {
                       satirdizisi[i]=test+"      "+numara+" "+yeriniAlacak;
                   }       
                  i++;
            }
             y=i;
             
         }
         catch(Exception e) {
             System.out.println(e.getMessage());
         }
         return y;
     } 
     
    public static  void main(String []args) {
        
        try {
            ogr_dosyasi.createNewFile();
            new Ogrenci().sirala();
            FileInputStream oku=new FileInputStream(ogr_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
            
            FileWriter fwriter=new FileWriter(ogr_dosyasi,true);
            BufferedWriter yazdir=new BufferedWriter(fwriter);
            String dizi2[]=new String[50];
           
            int islem;
            String adsoyad;
            Scanner secim=new Scanner(System.in);
            
             System.out.println("Yapmak istediğiniz işlemi seçiniz: 1-Öğrenci Kaydetme 2-Öğrenci Silme 3-Öğrenci Güncelleme.");
             islem=secim.nextInt();

             switch(islem) {
                 
                 case 1:
                         
                     System.out.println("Öğrencinin adını ve soyadını giriniz: ");
                     adsoyad=okuid.readLine();
                     System.out.println("Öğrenci numarasını giriniz: ");
                     String numara=okuid.readLine();
                     int s=0;
                     
                     while(true) {
                         dizi2[s]=okuma.readLine();
                         
                         if(dizi2[s]!=null && dizi2[s].contains("ID") ) {
                             s++;
                             continue;
                             
                         } 
                         if(dizi2[s]==null) {
                             yazdir.write(Integer.toString(s)+"      "+numara+" "+adsoyad);
                             yazdir.newLine();
                             yazdir.close();
                             break;
                         }
                         
                         s++;
                         
                         
                     }
                     
                     
                     
                     
                     
                     break;
                
                 case 2:
                     
                     System.out.println("Silmek istediğiniz öğrencinin adını ve soyadını giriniz: ");
                       String silinecek=okuid.readLine();
                       String silinecekid=bul(silinecek);
                       
                     int i=0;
                    i= oku(dizi2,silinecekid,"","");
             new Ogrenci().yazdir(dizi2,i);
                      break;
                 case 3:
                     System.out.println("Güncellemek istediğiniz öğrencinin adını ve soyadını giriniz: ");
                     adsoyad=okuid.readLine();
                     System.out.println("Güncel ad ve soyadı giriniz :");
                     String guncelisim=okuid.readLine();  
                     System.out.println("Güncel numarayı giriniz: ");
                     numara=okuid.readLine();
           int f=0;
                    String adsoyadid=bul(adsoyad);
                     f=oku(dizi2,adsoyadid,guncelisim,numara);
                     new Ogrenci().yazdir(dizi2,f);
                     
           }     
             okuid.close();
             yazdir.close();
             okuma.close();
        }
        
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}