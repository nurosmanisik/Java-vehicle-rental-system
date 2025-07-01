package Proje;

/*
 * @file Otomobil.java
 * @description Bu program araba kiralama işlemlerini yöneten bis sistemi simüle eder.Araba kiralama, iade etme, kiralama limitleri kontrolü, araba ekleme, silme, güncelleme gibi işlevleri içerir.
 * @date 15 Mayıs 2024
 * @author Osman Işık - nurosman.isik@stu.fsm.edu.tr
 */
class Otomobil extends Araba{
    private int yaslimiti;

    public Otomobil(int yaslimiti, String arabaAdi, double fiyat, int adet, int modelYili, String renk) {
        super(arabaAdi, fiyat, adet, modelYili, renk);
        this.yaslimiti = yaslimiti;
    }

    public int getYaslimiti() {
        return yaslimiti;
    }

    public void setYaslimiti(int yaslimiti) {
        this.yaslimiti = yaslimiti;
    }
        
    //Otomobilin tüm özelliklerini ekrana yazdırır
    @Override
    public void arabaGoster(){
        super.arabaGoster();
        System.out.println("Yaş Limiti:"+getYaslimiti());
        
    }
    
}
