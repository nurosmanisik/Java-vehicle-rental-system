package Proje;

/*
 * @file OlgunKisi.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 16 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
public class OlgunKisi extends Kisi {

    private final int kiralamaLimitSınırı;

    
    //Constructor
    public OlgunKisi(String adi, String soyadi, double bakiye, int kiralamaLimiti) {
        super(adi, soyadi, bakiye, kiralamaLimiti);
        this.kiralamaLimitSınırı = 10;
    }

    public int getKiralamaLimitSınırı() {
        return kiralamaLimitSınırı;
    }
    
    //Olgun kişinin kalan limit bilgisini ekrana yazar.
    @Override
   public void limitleriGoster(){
        
        System.out.println("Kalan Bakiye:"+getBakiye());
        System.out.println("Kalan Araba Kiralama Limiti():"+(kiralamaLimitSınırı - getKiraladigiArabaSayisi()));       
    }
    
    
}
