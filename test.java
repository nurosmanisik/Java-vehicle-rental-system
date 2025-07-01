package Proje;

import java.util.Scanner;

/*
 * @file KiralamaFirmasi.java
 * @description Bu program araba kiralama işlemlerini yöneten bir sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 17 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
public class test {

    private static KiralamaFirmasi f;
    private static Scanner giris = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
        
        //Arabalar
        Otomobil o1 = new Otomobil(18, "TOYATA", 1250, 10, 2024, "Kırmızı");
        Otomobil o2 = new Otomobil(18, "CITROËN", 5000, 10, 2021, "Mavi");
        Otomobil o3 = new Otomobil(18, "SKODA", 6000, 10, 2022, "Siyah");
        Minibus m1 = new Minibus(8, "BMW", 1000, 10, 2023, "Siyah");
        Minibus m2 = new Minibus(14, "HYUNDAİ", 8000, 8, 2018, "Sarı");
        Minibus m3 = new Minibus(10, "FIAT", 3000, 10, 2024, "Kırmızı");
        TicariArac t1 = new TicariArac(10, "Mercedes", 2000, 10, 2020, "Gri");
        TicariArac t2 = new TicariArac(20, "RENAULT", 5500, 25, 2023, "Beyaz");
        TicariArac t3 = new TicariArac(25, "Ford", 3500, 10, 2023, "Kahverengi");

        //Kişiler
        GencKisi k1 = new GencKisi("Osman", "Işık", 500000, 10);
        GencKisi k2 = new GencKisi("Emre", "Yazıcı", 50000, 10);
        GencKisi k3 = new GencKisi("Berat", "Aydın", 50000, 10);
        GencKisi k4 = new GencKisi("Cihan", "Caferoğlu", 50000, 10);
        GencKisi k5 = new GencKisi("Şevval", "Koç", 50000, 10);
        GencKisi k6 = new GencKisi("Veranur", "Durmuş", 50000, 10);
        OlgunKisi k7 = new OlgunKisi("Emir", "Varol", 100000, 10);
        OlgunKisi k8 = new OlgunKisi("Hamza", "Kaan", 105000, 10);
        OlgunKisi k9 = new OlgunKisi("Rahime", "Çalık", 110000, 10);
        OlgunKisi k10 = new OlgunKisi("Elif", "Uyar", 110000, 10);

        //Firma Sahibi
        Kisi k = new Kisi("Kadir", "Aram", 999999, 10);

        //Kiralama Firması
        f = new KiralamaFirmasi("BORUSAN", k6, 200);

        //Firmaya eklenen araçlar
        f.yeniArabaEkle(o1);
        f.yeniArabaEkle(o2);
        f.yeniArabaEkle(o3);
        f.yeniArabaEkle(m1);
        f.yeniArabaEkle(m2);
        f.yeniArabaEkle(m3); 
        f.yeniArabaEkle(t1);
        f.yeniArabaEkle(t2);
        f.yeniArabaEkle(t3);

        //Firmadan araba kiralayanlar
        f.arabaKirala(k1, "TOYATA");
        f.arabaKirala(k2, "SKODA");
        f.arabaKirala(k3, "BMW");
        f.arabaKirala(k4, "HYUNDAİ");
        f.arabaKirala(k5, "FIAT");
        f.arabaKirala(k6, "Mercedes");
        f.arabaKirala(k7, "RENAULT");
        f.arabaKirala(k8, "Ford");
        f.arabaKirala(k9, "CITROËN");
        f.arabaKirala(k10, "TOYATA");

        //Firmadan araba kiralayanların arabsını iade edenler
        f.arabaIade(k2, "SKODA");
        f.arabaIade(k4, "HYUNDAİ");
        f.arabaIade(k6, "Mercedes");
        f.arabaIade(k10, "TOYATA");
        System.out.println("");
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");
        
        
        
        
        
        

        
        
        
        
        
        
        
        //Menü 
        while (true) {
            System.out.println("");
            System.out.println("[Araba Kiralama Sistemi]");
            System.out.println("(1) Araba Kirala");
            System.out.println("(2) Araba İade");
            System.out.println("(3) Araba Sil");
            System.out.println("(4) Güncel Kiralanan Arabalar");
            System.out.println("(5) Müşteri Bilgileri");
            System.out.println("(6) Firmanın Sahip Olduğu Arabalar");
            System.out.println("(7) Yeni Araba Ekle");
            System.out.println("(8) Araba Güncelle");
            System.out.println("(9) Firma Bakiye");
            System.out.println("(10) Sistemden Çıkış");
            System.out.print("İşlem:");
            

            int islem = giris.nextInt();
            giris.nextLine();

            switch (islem) {
                case 1:
                    arabaKirala();
                    break;
                case 2:
                    arabaIade();
                    break;
                case 3:
                    arabaSil();
                    break;
                case 4:
                    GuncelKiralananArabalar();
                    break;
                case 5:
                    MusteriBilgileri();
                    break;
                case 6:
                    firmaArabalar();
                    break;
                case 7:
                    arabaEkle();
                    break;
                case 8:
                    arabaGuncelle();
                    break;
                case 9:
                    firmaBakiye();
                    break;
                case 10:
                    System.out.println("Sistemden çıkılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz işlem lütfen tekrar deneyin");
            }
        }
    }
    //firmadan araba kirala metodunu çağırarak gerekli işlemleri yapar
    public static void arabaKirala() {
        System.out.println("Eski Müşteri (0) "+"Yeni Müşteri(1)");
        int secim = giris.nextInt();
        giris.nextLine();
        boolean kontrol=true;
        while (kontrol==true) {            
            if(secim == 0){
                System.out.println("Firmanın Müşteri Listesi:");
                f.musteriListesiYazdir();
                System.out.println("-----------------------------");
                System.out.print("Müşterinin Adı:");
                String adi = giris.nextLine();
                System.out.print("Müşterinin Soyadı:");
                String soyAdi = giris.nextLine(); 
                
                boolean musteriVarmi= false;
                
                for (int i = 0; i < f.getMusteriListesi().length; i++) {
                     if (f.getMusteriListesi()[i] != null && f.getMusteriListesi()[i].getAdi().equals(adi) && f.getMusteriListesi()[i].getSoyadi().equals(soyAdi)) {
                       System.out.println("-----------------------------");
                         f.arabalariYazdir();
                       System.out.println("-----------------------------");
                       System.out.print("Kişin Kiralamak İstediği Araba Adı:");
                       String arabaAdi = giris.nextLine();
                       f.arabaKirala(f.getMusteriListesi()[i], arabaAdi);
                       System.out.println("-----------------------------");
                       musteriVarmi = true;
                       
                        break;
                    }   
                }if(musteriVarmi == false){
                    System.out.println("Müşteri listesinde bulunmamaktadır");
                }
                
                break; 
            }else if(secim == 1){
                
        
        
        while (true) {
        System.out.println("Kişinin sağlık durumu (Olgun) veya (Genç)");
        String durumu = giris.nextLine();
            if ("Genç".equals(durumu)) {

                System.out.println("Kiralyan Kişinin Adı:");
                String adi = giris.nextLine();
                System.out.println("Kiralyan Kişinin Soyadı:");
                String soyadi = giris.nextLine();
                int kiralamaLimiti = 10;
                System.out.println("Kişinin Bakiyesi (Maksimum 50.000 olabilir):");
                double bakiye = giris.nextDouble();
                giris.nextLine();
                GencKisi kisi = new GencKisi(adi, soyadi, bakiye, kiralamaLimiti);
                System.out.println("-----------------------------");
                f.arabalariYazdir();
                System.out.println("-----------------------------");
                System.out.print("Kişin Kiralamak İstediği Araba Adı:");
                String arabaAdi = giris.nextLine();
                f.arabaKirala(kisi, arabaAdi);
                System.out.println("-----------------------------");
                kontrol=false;
                break;
            } else if ("Olgun".equals(durumu)) {

                System.out.println("Kiralyan Kişinin Adı:");
                String adi = giris.nextLine();
                System.out.println("Kiralyan Kişinin Soyadı:");
                String soyadi = giris.nextLine();
                int kiralamaLimiti = 10;
                System.out.println("Kişinin Bakiyesi:");
                double bakiye = giris.nextDouble();
                giris.nextLine();
                OlgunKisi kisi = new OlgunKisi(adi, soyadi, bakiye, kiralamaLimiti);
                System.out.println("-----------------------------");
                f.arabalariYazdir();
                System.out.println("-----------------------------");
                System.out.print("Kişin Kiralamak İstediği Araba Adı:");
                
                String arabaAdi = giris.nextLine();
                f.arabaKirala(kisi, arabaAdi);
                System.out.println("-----------------------------");
                kontrol=false;
                break;
            } else {
                System.out.println("Kişinin sağlık durumunu yanlış girdiniz tekrar giriniz!");
                
            }

        }
            }else{
                System.out.println("Yanlış seçim yaptınız, tekrar giriniz");
                secim = giris.nextInt();
                giris.nextLine();
            }
        }
    }
    
    //firmadan araba iade metodunu çağırarak iade işlemlerini yapar
    public static void arabaIade() {
                System.out.print("Kiralyan Kişinin Adı:");
                String adi = giris.nextLine();
                System.out.print("Kiralyan Kişinin Soyadı:");
                String soyAdi = giris.nextLine();
                System.out.print("Kişin İade Etmek İstediği Araba Adı:");
                String arabaAdi = giris.nextLine();
                
                boolean kisiVarmi = false;
                for (int i = 0; i < f.getMusteriListesi().length; i++) {
                    if (f.getMusteriListesi()[i] != null && f.getMusteriListesi()[i].getAdi().equals(adi) && f.getMusteriListesi()[i].getSoyadi().equals(soyAdi)) {
                        f.arabaIade(f.getMusteriListesi()[i], arabaAdi);
                        kisiVarmi = true;
                        break;
                    }
                }
                if(kisiVarmi == false){
                    System.out.println(adi+" "+soyAdi+" kişisi firmadan araba kiralamamıştır,yanlış firma!");
                }
    }

    //firmadan araba sil metodunu çağırarak silme işlemlerini yapar
    public static void arabaSil() {
        System.out.print("Firmadan silmek istediğiniz arabanın adını giriniz:");
        String arabaAdi = giris.nextLine();
        f.arabaSil(arabaAdi);

    }

    //firmadan güncelkiralananarabalar metodlarını çağırark istediğimiz metodu kullandırır
    public static void GuncelKiralananArabalar() {
        System.out.println("Firmadaki güncel kiralanan arabaları görmek için (0) yada sadece müşterinin güncel kiraladığı arabları görmek için (1) seçiniz");
        int secim = giris.nextInt();
        giris.nextLine();
        while (true) {
            if (secim == 0) {
                f.guncelKiralananArabalariGoster();
                break;
            } else if (secim == 1) {
                System.out.print("Müşterinin Adı:");
                String kisiAdi = giris.nextLine();
                System.out.print("Müşterinin Soyadı:");
                String kisiSoyadi = giris.nextLine();
                f.guncelKiralananArabalariGoster(kisiAdi,kisiSoyadi);
                break;
            } else {
                System.out.println("Yanlış seçim yaptınız tekrar yapınız!");
                secim = giris.nextInt();
                giris.nextLine();
            }
        }
    }

    //firmadan ve kişiler kalsından alına metodlarlar çağrılır
    public static void MusteriBilgileri() {

        System.out.println("Müşterinin geçmişte kiralayıp teslim ettiği arabaları görmek için (0)");
        System.out.println("Müşterinin geçmişte kiralayıp teslim ettiği (belirtilen klasmandaki) arabaları görmek için (1) ");
        System.out.println("Müşterinin kalan limitlerini görmek için (2)");
        int secim = giris.nextInt();
        giris.nextLine();
        boolean musteriVarmi = false;
        
        while (true) {
            
            
            if(secim == 0){
                System.out.print("Müşterinin Adı:");
                String adi = giris.nextLine();
                System.out.print("Müşterinin Soyadı:");
                String soyAdi = giris.nextLine(); 
                
                
                for (int i = 0; i < f.getMusteriListesi().length; i++) {
                     if (f.getMusteriListesi()[i] != null && f.getMusteriListesi()[i].getAdi().equals(adi) && f.getMusteriListesi()[i].getSoyadi().equals(soyAdi)) {
                        f.getMusteriListesi()[i].KiralamaGecmisiniGoster();
                        musteriVarmi = true;
                        break;
                    }
                     
                }if(musteriVarmi == false){
                         System.out.println("Firmada kiralama geçmişi bulunmamaktadır");
                         
                     }
                break;
            }else if(secim == 1){
                System.out.print("Müşterinin Adı:");
                String adi = giris.nextLine();
                System.out.print("Müşterinin Soyadı:");
                String soyAdi = giris.nextLine(); 
                System.out.print("Araba Klasmanı:");
                String klasman = giris.nextLine();
                
                
                for (int i = 0; i < f.getMusteriListesi().length; i++) {
                     if (f.getMusteriListesi()[i] != null && f.getMusteriListesi()[i].getAdi().equals(adi) && f.getMusteriListesi()[i].getSoyadi().equals(soyAdi)) {
                        f.getMusteriListesi()[i].KiralamaGecmisiniGoster(klasman);
                        musteriVarmi = true;
                        break;
                }
                    
            }if(musteriVarmi == false){
                         System.out.println("Firmada kiralama geçmişi bulunmamaktadır");
                         
                     }
                break;
        }else if (secim == 2){
                System.out.print("Müşterinin Adı:");
                String adi = giris.nextLine();
                System.out.print("Müşterinin Soyadı:");
                String soyAdi = giris.nextLine(); 
                
                
                for (int i = 0; i < f.getMusteriListesi().length; i++) {
                     if (f.getMusteriListesi()[i] != null && f.getMusteriListesi()[i].getAdi().equals(adi) && f.getMusteriListesi()[i].getSoyadi().equals(soyAdi)) {
                         f.getMusteriListesi()[i].limitleriGoster();
                        musteriVarmi = true;
                        break;
                    }
                     
                }if(musteriVarmi == false){
                    System.out.println(adi+" "+soyAdi+" adlı müşteri bulunmamaktadır.");
                }
                break;
        }
            else{
                System.out.println("Yanlış seçim yaptınız, tekrar giriniz");
                secim = giris.nextInt();
                giris.nextLine();
            }    
    }
    }
    
    //firmadan arablarıyazdır ve arabayazdır metodlarını çağırarak istediğini yazdırır
    public static void firmaArabalar() {
        System.out.println("Firmadaki arabaları görmek için (0) yada firmada olan bir arabanın özelliklerini görmek için (1)");
        int secim = giris.nextInt();
        giris.nextLine();
        while (true) {
            if (secim == 0) {
                f.arabalariYazdir();
                break;
            } else if (secim == 1) {
                System.out.print("Özellikleri görmek için araba adını giriniz:");
                String arabaAdi = giris.nextLine();
                f.arabaYazdir(arabaAdi);
                break;
            } else {
                System.out.println("Yanlış seçim yaptınız tekrar yapınız!");
                secim = giris.nextInt();
            }
        }
    }

    //firmadan araba ekle metodunu çağırarak ekleme işlemleri yapar
    public static void arabaEkle() {
        System.out.println("Araba Klasmanı (Otomobil),(Minibus),(TicariArac):");
        String klasman = giris.nextLine();
        while (true) {
            if ("Otomobil".equals(klasman)) {
                System.out.println("Yaş Limiti:");
                int yaslimiti = giris.nextInt();
                giris.nextLine();
                System.out.print("Araba Adı:");
                String arabaAdi = giris.nextLine();
                System.out.print("Fiyat:");
                double fiyat = giris.nextDouble();
                System.out.print("Adet:");
                int adet = giris.nextInt();
                System.out.print("Model Yılı:");
                int modelYili = giris.nextInt();
                giris.nextLine();
                System.out.print("Renk:");
                String renk = giris.nextLine();
                Otomobil otomobil = new Otomobil(yaslimiti, arabaAdi, fiyat, adet, modelYili, renk);
                f.yeniArabaEkle(otomobil);
                break;

            } else if ("Minibus".equals(klasman)) {
                System.out.println("Kişi Kapasitesi:");
                int kisiKapasite = giris.nextInt();
                giris.nextLine();
                System.out.print("Araba Adı:");
                String arabaAdi = giris.nextLine();
                System.out.print("Fiyat:");
                double fiyat = giris.nextDouble();
                System.out.print("Adet:");
                int adet = giris.nextInt();
                System.out.print("Model Yılı:");
                int modelYili = giris.nextInt();
                giris.nextLine();
                System.out.print("Renk:");
                String renk = giris.nextLine();

                Minibus minibus = new Minibus(kisiKapasite, arabaAdi, fiyat, adet, modelYili, renk);
                f.yeniArabaEkle(minibus);
                break;
            } else if ("TicariArac".equals(klasman)) {
                System.out.println("Yük Kapasitesi:");
                int yukKapasitesi = giris.nextInt();
                giris.nextLine();
                System.out.print("Araba Adı:");
                String arabaAdi = giris.nextLine();
                System.out.print("Fiyat:");
                double fiyat = giris.nextDouble();
                System.out.print("Adet:");
                int adet = giris.nextInt();
                System.out.print("Model Yılı:");
                int modelYili = giris.nextInt();
                giris.nextLine();
                System.out.print("Renk:");
                String renk = giris.nextLine();

                TicariArac ticariArac = new TicariArac(yukKapasitesi, arabaAdi, fiyat, adet, modelYili, renk);
                f.yeniArabaEkle(ticariArac);
                break;
            } else {
                System.out.println("Firmada böyle bir araba klasmanı yokktur tekrar giriniz!");
                klasman = giris.nextLine();
            }
        }

    }

    //firmadaki istenilen arabayı araba güncelle metodu çağrılarak güncelleme işlemlerini yapar
    public static void arabaGuncelle() {
        f.arabalariYazdir();
        System.out.print("Güncellemk istediğiniz arabanın adı:");
        String arabaAdi = giris.nextLine();
        System.out.print("Yeni Fiyat:");
        double fiyat = giris.nextDouble();
        System.out.print("Yeni Adet:");
        int adet = giris.nextInt();
        giris.nextLine();

        f.arabaGuncelle(arabaAdi, fiyat, adet);
    }

    //firmadan firmatoplambakiye hesapla metodunu çağırarak firmanın bakiyesi hesaplar.
    public static void firmaBakiye() {
        f.firmaToplamBakiyeHesapla();
    }

}
