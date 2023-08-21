package cashierapp.models;

public class Paket {
    private String paket;
    private Double hargaPaket;

    
    public Paket() {
    }
    public Paket(String paket, Double hargaPaket) {
        this.paket = paket;
        this.hargaPaket = hargaPaket;
    }
    public String getPaket() {
        return paket;
    }
    public void setPaket(String paket) {
        this.paket = paket;
    }
    public Double getHargaPaket() {
        return hargaPaket;
    }
    public void setHargaPaket(Double hargaPaket) {
        this.hargaPaket = hargaPaket;
    }
    @Override
    public String toString() {
        return paket + " - " + hargaPaket;
    }
    
}
