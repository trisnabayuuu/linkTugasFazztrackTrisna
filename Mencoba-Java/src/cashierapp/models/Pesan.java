package cashierapp.models;

public class Pesan {
    private Integer qty;
    private String namaBarang;
    private Double harga;

    public Pesan() {
    }
    public Pesan(Integer qty, String namaBarang, Double harga) {
        this.qty = qty;
        this.namaBarang = namaBarang;
        this.harga = harga;
        // this.total = total;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public Double getHarga() {
        return harga ;
    }
    public void setHarga(Double harga) {
        this.harga = harga;
    }
    
    public Double getTotal() {
        return harga * qty;
    }
    // public Double getTotalTax(){

    //     for (Pesan pesan : daftarPesanan) {
    //         totalPesanan += pesan.getTotal();
    //     }
    // }

    @Override
    public String toString() {
        return  namaBarang +" = " + "" + qty +" "+ "*" + " " +  harga + " = " + getTotal();
    }

}
