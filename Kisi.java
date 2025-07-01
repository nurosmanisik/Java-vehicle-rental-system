package Proje;

/*
 * @file Kisi.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 16 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class Kisi {

    //Kişi bilgileri
    private String adi;
    private String soyadi;
    private double bakiye;
    private Araba[] kiralamaGecmisi;
    private Araba[] guncelKiraladigiArac;
    private int kiralamaLimiti; //Kişinin aynı anda kiralaya bilceği araba sayısı
    private int kiraladigiArabaSayisi; //Kişinin güncel kiraladığı araba sayısı

    //Constructor
    public Kisi(String adi, String soyadi, double bakiye, int kiralamaLimiti) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.bakiye = bakiye;
        this.kiralamaLimiti = kiralamaLimiti;
        this.kiralamaGecmisi = new Araba[100];
        this.guncelKiraladigiArac = new Araba[kiralamaLimiti];
        this.kiraladigiArabaSayisi = 0;
        

    }

    //get ve set metodları
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public Araba[] getKiralamaGecmisi() {
        return kiralamaGecmisi;
    }

    public void setKiralamaGecmisi(Araba[] kiralamaGecmisi) {
        this.kiralamaGecmisi = kiralamaGecmisi;
    }

    public int getKiralamaLimiti() {
        return kiralamaLimiti;
    }

    public Araba[] getGuncelKiraladigiArac() {
        return guncelKiraladigiArac;
    }

    public void setGuncelKiraladigiArac(Araba[] guncelKiraladigiArac) {
        this.guncelKiraladigiArac = guncelKiraladigiArac;
    }

    public int getKiraladigiArabaSayisi() {
        return kiraladigiArabaSayisi;
    }

    public void setKiraladigiArabaSayisi(int kiraladigiArabaSayisi) {
        this.kiraladigiArabaSayisi = kiraladigiArabaSayisi;
    }

    // Kişinin geçmişte kiralayıp teslim ettiği arabaları ekrana yazar.
    public void KiralamaGecmisiniGoster() {
        int a = 1;
        System.out.println(adi + " " + soyadi + " kişisinin kiralayıp teslim ettiği arabaları:");
        
           for (int i = 0; i < kiralamaGecmisi.length; i++){                                         //for döngüsü kişinin kiralma geçmişi listesine bakarak sadece araba adı ve araba modelini yazdırıyor.        
            if (kiralamaGecmisi[i] != null) {                                                           
                System.out.println(a + ":" + kiralamaGecmisi[i].getArabaAdi() + " " + kiralamaGecmisi[i].getModelYili());
                a++;
            }
        }
    }

    //Kişinin geçmişte kiralayıp teslim ettiği arabalardan istediği araba tipini yazdırır.
    public void KiralamaGecmisiniGoster(String arabaTipi) {
        int a = 1;

        if ("Otomobil".equals(arabaTipi)) {
            System.out.println(adi + " " + soyadi + " kişisinin kiralayıp teslim ettiği " + arabaTipi + " arabaları:");
            for (int i = 0; i < kiralamaGecmisi.length; i++) {                                        //for döngüsü kişinin kiralma geçmişi listesine bakarak sadece Otomobil olan araba adı ve araba modelini yazdırıyor. 
                if (kiralamaGecmisi[i] != null && kiralamaGecmisi[i] instanceof Otomobil) {
                    System.out.println(a + ":" + kiralamaGecmisi[i].getArabaAdi() + " " + kiralamaGecmisi[i].getModelYili());
                    a++;
                }
            }
        } else if ("Minibus".equals(arabaTipi)) {
            System.out.println(adi + " " + soyadi + " kişisinin kiralayıp teslim ettiği " + arabaTipi + " arabaları:");
            for (int i = 0; i < kiralamaGecmisi.length; i++) {
                if (kiralamaGecmisi[i] != null && kiralamaGecmisi[i] instanceof Minibus) {             //for döngüsü kişinin kiralma geçmişi listesine bakarak sadece Minibus olan araba adı ve araba modelini yazdırıyor. 
                    System.out.println(a + ":" + kiralamaGecmisi[i].getArabaAdi() + " " + kiralamaGecmisi[i].getModelYili());
                    a++;
                }
            }
        } else if ("TicariArac".equals(arabaTipi)) {
            System.out.println(adi + " " + soyadi + " kişisinin kiralayıp teslim ettiği " + arabaTipi + " arabaları:");
            for (int i = 0; i < kiralamaGecmisi.length; i++) {
                if (kiralamaGecmisi[i] != null && kiralamaGecmisi[i] instanceof TicariArac) {           //for döngüsü kişinin kiralma geçmişi listesine bakarak sadece TicariArac olan araba adı ve araba modelini yazdırıyor. 
                    System.out.println(a + ":" + kiralamaGecmisi[i].getArabaAdi() + " " + kiralamaGecmisi[i].getModelYili());
                    a++;
                }
            }
        } else {
            System.out.println(arabaTipi + " adında bir araba tipi yoktur.");
        }
    }
    
    //Kişinin kalan limit bilgisini ekrana yazar.
    public void limitleriGoster(){
        
        System.out.println("Kalan Bakiye:"+getBakiye());
        System.out.println("Kalan Araba Kiralama Limiti():"+(10 - getKiraladigiArabaSayisi()));
 
    }
    }
