package Proje;

/*
 * @file Minibus.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 15 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class Minibus extends Araba {

    private int kisiKapasite;

    public Minibus(int kisiKapasite, String arabaAdi, double fiyat, int adet, int modelYili, String renk) {
        super(arabaAdi, fiyat, adet, modelYili, renk);
        this.kisiKapasite = kisiKapasite;
    }

    public int getKisiKapasite() {
        return kisiKapasite;
    }

    public void setKisiKapasite(int kisiKapasite) {
        this.kisiKapasite = kisiKapasite;
    }

    //Minibüsün tüm özelliklerini ekrana yazdırır
    @Override
    public void arabaGoster() {
        super.arabaGoster();
        System.out.println("Kişi Kapasitesi:" + getKisiKapasite());
    }

}
