package cashierapp.models;

public class Pembayaran {
    private Double uangPembayaran;
    private Double uangKembalian;
    

    
    public Pembayaran() {
    }
    public Pembayaran(Double uangPembayaran, Double uangKembalian) {
        this.uangPembayaran = uangPembayaran;
        this.uangKembalian = uangKembalian;
    }
    public Double getUangPembayaran() {
        return uangPembayaran;
    }
    public void setUangPembayaran(Double uangPembayaran) {
        this.uangPembayaran = uangPembayaran;
    }
    public Double getUangKembalian() {
        return uangKembalian;
    }
    public void setUangKembalian(Double uangKembalian) {
        this.uangKembalian = uangKembalian;
    }

    


}
