package OOP.classDatar;
import OOP.inteface.InterfaceBangunDatar;



public class PersegiPanjang implements InterfaceBangunDatar {
    private Double panjang;
    private Double lebar;


    @Override
    public Double getKeliling() {
        
        return Double.valueOf((2 * this.getPanjang()) + (2 * this.getLebar())) ;
    }
    @Override
    public Double getLuas() {
        
        return Double.valueOf(this.getPanjang() * this.getLebar());
    }
    @Override
    public void karakteristikBangun() {
        System.out.println("=== KARAKTERISTIK ===");
        System.out.println("memiliki 4 titik sudut siku-siku, mempunyai panjang dan lebar.");
        
    }
    @Override
    public void menggambarBangun() {
        System.out.println("===     PERSEGI PANJANG     ===");
        for (int i = 0; i < this.panjang; i++) {
            for (int j = 0; j < this.lebar; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
    public Double getPanjang() {
        return panjang;
    }
    public void setPanjang(Double panjang) {
        if (panjang <= 0) {
            throw new ArithmeticException("Sisi tidak boleh 0!");
        }
        this.panjang = Double.valueOf(panjang);
    }
    public Double getLebar() {
        return lebar;
    }
    public void setLebar(Double lebar) {
        if (lebar <= 0) {
            throw new ArithmeticException("Sisi tidak boleh 0!");
        }
        this.lebar = Double.valueOf(lebar);
    }
}

