package projem;
import java.util.Scanner;
import java.lang.String;
import java.io.*;
interface siralaUnutma { 
     public void sirala();
}
public class Dersler extends Okul implements siralaUnutma{
    static String id;
    static File dersler_dosyasi=new File("dersler.txt");
    static InputStreamReader is=new InputStreamReader(System.in);
    static BufferedReader okuders=new BufferedReader(is);
    @Override
     public  void sirala() {
       String satirdizisi[]=new String[50];
        try {
            FileInputStream oku=new FileInputStream(dersler_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
            
            satirdizisi[0]=okuma.readLine();
                if(satirdizisi[0]!=null &&  satirdizisi[0].contains("ID") ) {
                   
                }
                else {
                    FileWriter fwriter4=new FileWriter(dersler_dosyasi);
              BufferedWriter yazdir4=new BufferedWriter(fwriter4);
                  
              yazdir4.write("DERS ID DERS AD");
              yazdir4.newLine();
              yazdir4.close();
                }                  
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
  
  public String bul(String ders) {
      
        try {
            String idbul="";
            String satirdizisi[]=new String[50];
         FileInputStream oku=new FileInputStream(dersler_dosyasi);
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
              
               int i=0;
                      while ((satirdizisi[i]=okuma.readLine())!=null){
                          
                            if(satirdizisi[i].contains(ders)) {
                                
                                  idbul=Integer.toString(i);
                            }
                            i++;
                      }
                      
                     this.id=idbul; //THİS ANAHTAR KELİMESİ EN AZ 3 KERE KULLANILDI.
        }
       catch(Exception e) {
       System.out.println(e.getMessage());
                              }
               
        return this.id;
    }
  public void derslerGoster(){
      String satirdizisi[]=new String[50];
      try {
      FileInputStream oku=new FileInputStream("dersler.txt");
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
     
      while((satirdizisi[super.s]=okuma.readLine())!=null ) {
          if(satirdizisi[super.s].contains("ID")) {
              
          }
          else {
          System.out.println(satirdizisi[s]);
          }
          super.s++; //SUPER ANAHTAR KELİMESİ EN AZ 3 KERE KULLANILDI.
      }
           
           
      }
      catch(Exception e) {
          System.out.println(e.getMessage());      
      }
  }
    public static void main(String []args) {
       
        String satirdizisi[]=new String[50];
        try{
            
            dersler_dosyasi.createNewFile();
             new Dersler().sirala();
              FileInputStream oku=new FileInputStream("dersler.txt");
           BufferedReader okuma=new BufferedReader(new InputStreamReader(oku));
           
            FileWriter fwriter=new FileWriter("dersler.txt",true);
            BufferedWriter yazdir=new BufferedWriter(fwriter);

       
        System.out.println("Eklemek istediğiniz ders ismini giriniz: ");
        String dersAdi=okuders.readLine();
        
        int s=0;
       while(true) {
                         satirdizisi[s]=okuma.readLine();
                         
                         if(satirdizisi[s]!=null && satirdizisi[s].contains("ID") ) {
                             s++;
                             continue;
                             
                         } 
                         if(satirdizisi[s]==null) {
                             yazdir.write(Integer.toString(s)+"       "+dersAdi);
                             yazdir.newLine();
                             yazdir.close();
                             break;
                         }
                         
                         s++;
                         
                         
                     }
        okuma.close();
        yazdir.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
