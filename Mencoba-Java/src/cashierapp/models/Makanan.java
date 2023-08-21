package cashierapp.models;


public class Makanan {
    private String makanan;
    private Double harga;

    public Makanan(String makanan, Double harga) {
        this.makanan = makanan;
        this.harga = harga;
    }

    public String getMakanan() {
        return makanan;
    }
    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }
    public Double getHarga() {
        return harga;
    }
    public void setHarga(Double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return makanan + " - " + harga  ;
    }

}
