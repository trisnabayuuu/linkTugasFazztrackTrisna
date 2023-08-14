package OOP;

public class Balok extends PersegiPanjang implements InterfaceBangunRuang{
    private Double tinggi;

    @Override
    public Double getVolume() {
        return Double.valueOf(super.getPanjang() * super.getLebar() * this.tinggi);
    }

    public Double getTinggi() {
        return tinggi;
    }

    public void setTinggi(Double tinggi) {
        this.tinggi = tinggi;
    }
    


}
