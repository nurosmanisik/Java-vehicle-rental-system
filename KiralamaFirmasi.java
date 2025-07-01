package Proje;

/*
 * @file KiralamaFirmasi.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 17 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class KiralamaFirmasi {

    //Kiralama Firması Bilgileri
    private String firmaAdi;
    private int arabaSayisi;
    private Kisi sahibi;
    private Araba[] arabaListesi;
    private Araba[] kiralananArabalar;
    private Kisi[] musteriListesi;
    private int kiralamaLimiti;
    private double gelir;  //firmanın toplam geliri
    private int musteriSayisi;  
    private int kiralananArabaSayisi;

    //Constructor
    public KiralamaFirmasi(String firmaAdi, Kisi sahibi, int kiralamaLimiti) {
        this.firmaAdi = firmaAdi;
        this.sahibi = sahibi;
        this.kiralamaLimiti = kiralamaLimiti;
        this.arabaListesi = new Araba[100];
        this.kiralananArabalar = new Araba[kiralamaLimiti];
        this.musteriListesi = new Kisi[200];
        this.arabaSayisi = 0;
        this.musteriSayisi = 0;
        this.kiralananArabaSayisi = 0;
    }

    //get ve set metodları
    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public int getArabaSayisi() {
        return arabaSayisi;
    }

    public void setArabaSayisi(int arabaSayisi) {
        this.arabaSayisi = arabaSayisi;
    }

    public Kisi getSahibi() {
        return sahibi;
    }

    public void setSahibi(Kisi sahibi) {
        this.sahibi = sahibi;
    }

    public Araba[] getArabaListesi() {
        return arabaListesi;
    }

    public void setArabaListesi(Araba[] arabaListesi) {
        this.arabaListesi = arabaListesi;
    }

    public int getKiralamaLimiti() {
        return kiralamaLimiti;
    }

    public void setKiralamaLimiti(int kiralamaLimiti) {
        this.kiralamaLimiti = kiralamaLimiti;
    }

    public Araba[] getKiralananArabalar() {
        return kiralananArabalar;
    }

    public void setKiralananArabalar(Araba[] kiralananArabalar) {
        this.kiralananArabalar = kiralananArabalar;
    }

    public Kisi[] getMusteriListesi() {
        return musteriListesi;
    }

    public void setMusteriListesi(Kisi[] musteriListesi) {
        this.musteriListesi = musteriListesi;
    }

    public double getGelir() {
        return gelir;
    }

    public void setGelir(double gelir) {
        this.gelir = gelir;
    }

    public int getMusteriSayisi() {
        return musteriSayisi;
    }

    public void setMusteriSayisi(int musteriSayisi) {
        this.musteriSayisi = musteriSayisi;
    }

    public int getKiralananArabaSayisi() {
        return kiralananArabaSayisi;
    }

    public void setKiralananArabaSayisi(int kiralananArabaSayisi) {
        this.kiralananArabaSayisi = kiralananArabaSayisi;
    }

    //Firmanın araba listesine araba ekler
    //Firmanın müşteri listesini ekrana yazdırır
    public void musteriListesiYazdir() {
        for (int i = 0; i < musteriListesi.length; i++) {                       //for döngüsü müşteri lsitesini gezer ve müşterilerin adını ve soyadını yazdırır.
            if (musteriListesi[i] != null) {
                System.out.println((i + 1) + ": " + musteriListesi[i].getAdi() + " " + musteriListesi[i].getSoyadi());
            }
        }
    }

    //Firmanın araba listesini kontrol ederek araba kiralar
    //Firmanın kiralanan arabalar lsitesine ekler.
    public boolean arabaKirala(Kisi kisi, String arabaAdi) {
        boolean arabaKirala = false;
        boolean arabaVarmi = false;
        boolean arabaBostami = false;
        boolean kisiBakiyeYettimi = false;
        boolean kiralamaLimitiYettimi = false;
        boolean kisiKiralamaLimitiYettimi = false;
        boolean ayniKisimiKiraliyor = false;

        if (kisi.getKiraladigiArabaSayisi() <= kisi.getKiralamaLimiti()) {      //kişinin güncel kiraladığı araba sayısnı kontrol der limti aşmamışsa if in içine girer.
            kisiKiralamaLimitiYettimi = true;
            if (kiralamaLimiti > kiralananArabaSayisi) {                        //firmanın kiralama limitinin yetip yetmediğine göre if in içine girer
                kiralamaLimitiYettimi = true;
                for (int i = 0; i < arabaListesi.length; i++) {                 //firmanın araba listesinde dolaşır ve istenilen araba varmı diye kontrol edilir
                    if (arabaListesi[i] != null && arabaListesi[i].getArabaAdi().equals(arabaAdi)) {
                        arabaVarmi = true;
                        if (arabaListesi[i].getAdet() > 0) {                    //firmanın  araba stoğu kontrol edilir stok var ise diğer if in içine girer.
                            arabaBostami = true;
                            if (arabaListesi[i].getFiyat() <= kisi.getBakiye()) { //kişinin bakiyesi yetiyormu diye kontrol edilir eğer bakiyesi yeterliyse gerekli işlemler yapılarak araba kiralanır.
                                kisiBakiyeYettimi = true;
                                arabaKirala = true;
                                for (int j = 0; j < kiralananArabalar.length; j++) { //kiralanan araba firmanın güncel kiralanan arabalar listesine eklenir

                                    if (kiralananArabalar[j] == null) {
                                        kiralananArabalar[j] = arabaListesi[i];
                                        break;
                                    }
                                }
                                for (int j = 0; j < kisi.getGuncelKiraladigiArac().length; j++) { //kiralanan arba kişinin güncel kiraladığı araç listesine eklenir.
                                    if (kisi.getGuncelKiraladigiArac()[j] == null) {
                                        kisi.getGuncelKiraladigiArac()[j] = arabaListesi[i];
                                        break;
                                    }
                                }
                                if (musteriSayisi < musteriListesi.length) {                      
                                    for (int j = 0; j < musteriListesi.length; j++) {               //Müşteri listesi kontrol edilir eğer aynı kişi kiralıyorsa müşteri listesine işlem yapılmaz.
                                        if (musteriListesi[j] != null && musteriListesi[j].equals(kisi)) {
                                            ayniKisimiKiraliyor = true;
                                            break;
                                        }
                                    }
                                    if (ayniKisimiKiraliyor == false) {                             //aynı kişi kiralmıyor ise kiralayan kişi müşteri listesine eklenir.
                                        for (int j = 0; j < musteriListesi.length; j++) {
                                            if (musteriListesi[j] == null) {
                                                musteriListesi[j] = kisi;
                                                musteriSayisi++;
                                                break;
                                            }
                                        }
                                    }
                                }
                                kiralananArabaSayisi++;
                                arabaListesi[i].setAdet(arabaListesi[i].getAdet() - 1);
                                kisi.setBakiye(kisi.getBakiye() - arabaListesi[i].getFiyat());
                                setGelir(getGelir() + arabaListesi[i].getFiyat());
                                kisi.setKiraladigiArabaSayisi(kisi.getKiraladigiArabaSayisi() + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (arabaKirala == true) {
            System.out.println("Arabası kiralama işlemi başarılı bir şekilde gerçekleşmiştir");
        } else if (kisiKiralamaLimitiYettimi == false) {
            System.out.println(" " + kisi.getAdi() + " " + kisi.getSoyadi() + " kişisinin kiralama limiti dolmuştur");
        } else if (kiralamaLimitiYettimi == false) {
            System.out.println(firmaAdi + " firmasının kiralama limiti dolmuştur, araba kiralayamazsınız ");
        } else if (arabaVarmi == false) {
            System.out.println("Araba firmada bulunmamaktadır ");
        } else if (arabaBostami == false) {
            System.out.println("Araba firmada var ama başka müşterilere kiralanmış durumda ");
        } else if (kisiBakiyeYettimi == false) {
            System.out.println("Bakiyeniz araba kiralamaya yetmiyor");
        }
        return arabaKirala;
        }

    //Firmanın araba listesini kontrol edrek arabayı iade eder
    //Firmanın iade edilen araba adedini artırır ve kiralanan arabalar listesinden iade edilen arabayı çıkarır
    public boolean arabaIade(Kisi kisi, String arabaAdi) {
        boolean arabaIadeEdildimi = false;
        boolean arabaVarmi = false;
        boolean arabayiKiralamisimi = false;
        

        for (int i = 0; i < arabaListesi.length; i++) {                         //Araba listesinde araba varmı kontrol edilir.                  
            if (arabaListesi[i] != null && arabaListesi[i].getArabaAdi().equals(arabaAdi)) {
                arabaVarmi = true;
                break;
            }
        }

        if (arabaVarmi == true) {                                               //Araba var ise 
            for (int i = 0; i < kisi.getGuncelKiraladigiArac().length; i++) {   //kişini güncel kiraladığı araç lisesi gezilir be listeden çıkarılır.
                if (kisi.getGuncelKiraladigiArac()[i] != null && kisi.getGuncelKiraladigiArac()[i].getArabaAdi().equals(arabaAdi)) {
                    kisi.getGuncelKiraladigiArac()[i] = null;
                    arabaListesi[i].setAdet(arabaListesi[i].getAdet() + 1);
                    kisi.setKiraladigiArabaSayisi(kisi.getKiraladigiArabaSayisi() - 1);
                    arabayiKiralamisimi = true;
                    arabaIadeEdildimi = true;
                    break;
                }
            }
        }

        if (arabaIadeEdildimi == true) {
            
            for (int i = 0; i < kiralananArabalar.length; i++) { //firmanın kiralanan arabalar listesini dolaşır ve iade edilen araba bulunur ve listeden çıkarılır.
                if (kiralananArabalar[i] != null && kiralananArabalar[i].getArabaAdi().equals(arabaAdi)) {
                    for (int j = 0; j < kisi.getKiralamaGecmisi().length; j++) {//bulunan araba iade işlminden sonra kişin geçmiş kiralama listesine eklenir
                        if (kisi.getKiralamaGecmisi()[j] == null) {
                            kisi.getKiralamaGecmisi()[j] = kiralananArabalar[i];
                            kiralananArabaSayisi--;
                            break;
                        }
                    }
                    kiralananArabalar[i] = null;
                    
                    break;
                }
            }

        }

        if (arabaVarmi == false) {
            System.out.println("Araba firmada yok, yanlış firma! ");
        }else{
            if (arabaIadeEdildimi == true) {
                System.out.println("Araba iadesi başarılı bir şekilde gerçekleşti!");
            } else if (arabayiKiralamisimi == false) {
                System.out.println("Firmadan güncel olarak " + arabaAdi + " isminde bir araba kiralamamışsınız, iade işlemi yapamazsınız");
            }
        }
        return arabaIadeEdildimi;
    }

    //Firmanın araba kiralama işlemlerinden kazandığı toplam parayı ekrana yazar
    public double firmaToplamBakiyeHesapla() {

        System.out.println(firmaAdi + " " + "Firmasının Kazancı:" + gelir + " TL");
        System.out.println("Kiralanan araba sayısı:" + kiralananArabaSayisi);

        return gelir;
    }

    //Firmanın aktif olarak kiraladığı, kullanılan arabaları ekrana yazdırır
    public void guncelKiralananArabalariGoster() {
        int a = 1;
        System.out.println("Güncel Kiralanan Arabalar:");
        for (int i = 0; i < kiralananArabalar.length; i++) { // kiralanan arabalar listesini dolaşarak arabaların adını ve modelini yazdırır
            if (kiralananArabalar[i] != null) {
                System.out.println(a + ":" + kiralananArabalar[i].getArabaAdi() + " " + kiralananArabalar[i].getModelYili());
                a++;
            }
        }
    }

    //Firmanın aktif olarak kiraladığı, kişinin kullandığı arabaları yazdırır
    public void guncelKiralananArabalariGoster(String kisiAdi, String kisiSoyadi) {
        int a = 1;
        boolean musteriVarmi = false;
        System.out.println(kisiAdi + " " + kisiSoyadi + " Güncel Kiralanan Arabalar:");
        for (int i = 0; i < musteriListesi.length; i++) {                       //müşteri listesinin dolaşarak istenilen müşteri bulunur
            if (musteriListesi[i] != null && musteriListesi[i].getAdi().equals(kisiAdi) && musteriListesi[i].getSoyadi().equals(kisiSoyadi)) {
                musteriVarmi = true;
                for (int j = 0; j < musteriListesi[i].getGuncelKiraladigiArac().length; j++) {//bullunan müşterinin güncel kiraladığı araç listesi dolaşılarak arabaların adı ve modeli yazdırılır
                    if (musteriListesi[i].getGuncelKiraladigiArac()[j] != null) {
                        System.out.println(a + ":" + musteriListesi[i].getGuncelKiraladigiArac()[j].getArabaAdi());
                        a++;
                    }
                }
                break;
            } 
        }if(musteriVarmi == false){
            System.out.println(kisiAdi+" "+kisiSoyadi+" "+"kişisinin firmada güncel kiralanan arabası yoktur");
        }
    }

    //Firmanın sahip olduğu bütün arabaları ekrana yazar.
    public void arabalariYazdir() {
        int a = 1;
        if (arabaSayisi > 0) {
            System.out.println(firmaAdi + " firmasının arabaları:");
            for (int i = 0; i < arabaListesi.length; i++) {                     //Firmanın araba listesi dolaşılır ve arabaların adı ve modeli yazdırlır
                if (arabaListesi[i] != null) {
                    System.out.println(a + ":" + arabaListesi[i].getArabaAdi() + " " + arabaListesi[i].getModelYili());
                    a++;
                }
            }
        } else {
            System.out.println(firmaAdi + " firmasında araba bulunmamaktadır");
        }
    }

    //Firmanın parametre olarak verilen araba ismini bulup özelliklerini ekrana yazar.
    public void arabaYazdir(String arabaAdi) {
        boolean yazdirdimi = false;
        for (int i = 0; i < arabaListesi.length; i++) {                         // araba listesi dolaşılır istenilen araba adı bulunur ve arabanın bütün özellikleri yazdırlır.
            if (arabaListesi[i] != null && arabaListesi[i].getArabaAdi().equals(arabaAdi)) {
                arabaListesi[i].arabaGoster();
                yazdirdimi = true;
                break;
            }
        }
        if (yazdirdimi == false) {
            System.out.println(arabaAdi + " adında firmada bir araba yoktur");
        }
    }

    //Firmanın araba listesine istenilen arabayı ekler veya araba var ise adedini günceller
    public boolean yeniArabaEkle(Araba araba) {
        boolean arabaEklendimi = false;
        boolean arabaVarmi = false;
        boolean arabaLimitiDoldumu = true;

        for (int i = 0; i < arabaListesi.length; i++) {                         //ilk önce araba eklenmeden önce araba listesi dolaşılır ve araba ismi kontrol edilir eğer araba varsa araba eklenmez araba adeti güncellenir
            if (arabaListesi[i] != null && arabaListesi[i].getArabaAdi().equals(araba.getArabaAdi())) {
                arabaListesi[i].setAdet(arabaListesi[i].getAdet() + 1);
                arabaVarmi = true;
                break;
            }
        }
        if (arabaVarmi == false) {                      //araba yok is araba listesi dolaşılır ve ilk boş ye yeni araba eklenir
            if (arabaSayisi < arabaListesi.length) {
                for (int j = 0; j < arabaListesi.length; j++) {
                    if (arabaListesi[j] == null) {
                        arabaListesi[j] = araba;
                        arabaLimitiDoldumu = false;
                        arabaEklendimi = true;
                        arabaSayisi++;
                        break;
                    }
                }
            }
        }
        if (arabaVarmi == true) {
            System.out.println("Araba adedi güncellendi!");
        } else if (arabaEklendimi == true) {
            System.out.println("İstenilen araba Firmaya eklendi!");
        } else if (arabaLimitiDoldumu == true) {
            System.out.println("Bu Firmaya daha fazla araba eklenemez!");
        }

        return arabaEklendimi;
    }

    //Firmanın araba listesinde olan bir arabanın bilgilerini günceller
    public boolean arabaGuncelle(String arabaAdi, double yeniFiyat, int yeniAdet) {
        boolean arabaVarmi = false;
        boolean arabaGuncellendimi = false;

        for (int i = 0; i < arabaListesi.length; i++) {                         // araba listesi dolaşılır ve istenilen araba varmı diye kontrol edilir.
            if (arabaListesi[i] != null && arabaListesi[i].getArabaAdi().equals(arabaAdi)) { // varsa alınan bilgilerler araba güncellenir
                arabaVarmi = true;
                arabaListesi[i].setFiyat(yeniFiyat);
                arabaListesi[i].setAdet(yeniAdet);
                arabaGuncellendimi = true;
                break;
            }
        }
        if (arabaGuncellendimi == true) {
            System.out.println(arabaAdi + " arabasının özellikleri başarıyla güncellendi");
        } else if (arabaVarmi == false) {
            System.out.println("Güncellenmek istenen araba ismi Firmada bulunamadı!");
        }
        return arabaGuncellendimi;
    }

    //Firmanın ilk önce kirada olan arabalırın listesine bakar eğer kirada öyle bir araba yoksa siler
    public void arabaSil(String arabaAdi) {
        boolean arabaSilindimi = false;
        boolean arabaKiradami = false;
        boolean arabaVarmi = false;

        for (int i = 0; i < kiralananArabalar.length; i++) {//kiralanan arabalar listesine bakılır eğer varsa araba silme işlemi yapılmaz.
            if (kiralananArabalar[i] != null && kiralananArabalar[i].getArabaAdi().equals(arabaAdi)) {
                arabaKiradami = true;
                break;
            }
        }

        if (arabaKiradami == false) {                       //araba kirada değilse araba firmanın araba listesinden silinir.
            for (int i = 0; i < arabaListesi.length; i++) {
                if (arabaListesi[i] != null && arabaListesi[i].getArabaAdi().equals(arabaAdi)) {
                    arabaListesi[i] = null;
                    arabaVarmi = true;
                    arabaSilindimi = true;
                    break;
                }
            }
        }
        if (arabaKiradami == true) {
            System.out.println("Silinmek istenen araba müşteri tarafından kiralanmış durumda!");
        } else if (arabaVarmi == false) {
            System.out.println("Silinmek istenen araba ismi Firmada bulunamadı!");
        } else if (arabaSilindimi == true) {
            System.out.println("Araba başarıyla silindi");
        }

    }

}
