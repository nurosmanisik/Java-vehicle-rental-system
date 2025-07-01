package Proje;

/*
 * @file Araba.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 15 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class Araba {
    //Araba Bilgileri
    private String arabaAdi;
    private double fiyat;
    private int adet;
    private int modelYili;
    private String renk;

    
    //Constructor
    public Araba(String arabaAdi, double fiyat, int adet) {
        this.arabaAdi = arabaAdi;
        this.fiyat = fiyat;
        this.adet = adet;
    }
    //Constructor
    public Araba(String arabaAdi, double fiyat, int adet, int modelYili, String renk) {
        this.arabaAdi = arabaAdi;
        this.fiyat = fiyat;
        this.adet = adet;
        this.modelYili = modelYili;
        this.renk = renk;
    }    
    
    //get ve set metodları
    public String getArabaAdi() {
        return arabaAdi;
    }

    public void setArabaAdi(String arabaAdi) {
        this.arabaAdi = arabaAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getModelYili() {
        return modelYili;
    }

    public void setModelYili(int modelYili) {
        this.modelYili = modelYili;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }
    
    //Arabanın tüm özelliklerini ekrana yazdırır.
    public void arabaGoster(){         
        System.out.println("Araba Adı:"+arabaAdi);
        System.out.println("Fiyat:"+fiyat);
        System.out.println("Araba Adedi:"+adet);
        System.out.println("Model Yılı:"+modelYili);
        System.out.println("Araba Rengi:"+renk);
    }
    }

