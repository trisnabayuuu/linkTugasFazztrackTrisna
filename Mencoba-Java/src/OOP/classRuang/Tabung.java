package OOP.classRuang;
import OOP.classDatar.Lingkaran;
// import OOP.inteface.InterfaceBangunDatar;
import OOP.inteface.InterfaceBangunRuang;




public class Tabung extends Lingkaran implements InterfaceBangunRuang{
    private Double tinggi;


    @Override
    public Double getVolume() {
        return Double.valueOf(super.getPhi() * ((super.getJariJari() * super.getJariJari()) * this.tinggi));
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