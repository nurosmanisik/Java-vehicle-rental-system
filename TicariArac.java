package Proje;

/*
 * @file TicariArac.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 15 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class TicariArac extends Araba {

    private int yukKapasitesi;

    public TicariArac(int yukKapasitesi, String arabaAdi, double fiyat, int adet, int modelYili, String renk) {
        super(arabaAdi, fiyat, adet, modelYili, renk);
        this.yukKapasitesi = yukKapasitesi;
    }

    public int getYukKapasitesi() {
        return yukKapasitesi;
    }

    public void setYukKapasitesi(int yukKapasitesi) {
        this.yukKapasitesi = yukKapasitesi;
    }

    //Ticari Aracın tüm özelliklerini ekrana yazdırır
    @Override
    public void arabaGoster() {
        super.arabaGoster();
        System.out.println("Yük Kapesitesi:" + getYukKapasitesi() + " ton");
    }

}
