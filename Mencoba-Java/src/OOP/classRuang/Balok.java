package OOP.classRuang;


import OOP.classDatar.PersegiPanjang;
import OOP.inteface.InterfaceBangunRuang;

public class Balok extends PersegiPanjang implements InterfaceBangunRuang{
    private Double tinggi;

    // @Override
    // public Double getVolume() {
    //     return Double.valueOf(super.getPanjang() * super.getLebar() * this.tinggi);
    // }

    @Override
    public Double getVolume() {
        
        return Double.valueOf(super.getPanjang() * super.getLebar() * this.tinggi);
    }

    public Double getTinggi() {
        return tinggi;
    }

    public void setTinggi(Double tinggi) {
        if (tinggi <= 0) {
            throw new ArithmeticException("tinggi tidak boleh 0!");
        }
        this.tinggi = tinggi;
    }
    


}
