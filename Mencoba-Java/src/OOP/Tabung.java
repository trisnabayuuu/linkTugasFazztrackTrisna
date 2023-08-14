package OOP;

public class Tabung extends Lingkaran implements InterfaceBangunRuang{
    private Double tinggi;

    // public Double getVolume(){
    //     return Double.valueOf(super.getPhi() * ((super.getJariJari() * super.getJariJari()) * this.tinggi));
    // }

    @Override
    public Double getVolume() {
        return Double.valueOf(super.getPhi() * ((super.getJariJari() * super.getJariJari()) * this.tinggi));
    }

    public Double getTinggi() {
        return tinggi;
    }

    public void setTinggi(Double tinggi) {
        this.tinggi = tinggi;
    }
}
