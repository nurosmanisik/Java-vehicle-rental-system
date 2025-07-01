package Proje;

/*
 * @file GencKisi.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 16 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class GencKisi extends Kisi {
    private final double bakiyeLimitSınırı;
    private final int kiralamaLimitSınırı;

    
    
    //Constructor
    public GencKisi(String adi, String soyadi, double bakiye, int kiralamaLimiti) {
        super(adi, soyadi, bakiye, kiralamaLimiti);
        this.bakiyeLimitSınırı = 50000;
        this.kiralamaLimitSınırı = 10;
        if(kiralamaLimiti > kiralamaLimitSınırı){
            
        }
        if(bakiye > bakiyeLimitSınırı){
            setBakiye(bakiyeLimitSınırı);
        }
    }

    //get metodları
    public double getBakiyeLimitSınırı() {
        return bakiyeLimitSınırı;
    }

    public int getKiralamaLimitSınırı() {
        return kiralamaLimitSınırı;
    }
    
    //Gencin kalan limit bilgisini ekrana yazar.
    @Override
    public void limitleriGoster(){
        
        System.out.println("Kalan Bakiye:"+getBakiye());
        System.out.println("Kalan Araba Kiralama Limiti():"+(kiralamaLimitSınırı - getKiraladigiArabaSayisi()));
 
    }
    
    
    
    
    
}
