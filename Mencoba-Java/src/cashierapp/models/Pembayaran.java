package cashierapp.models;

public class Pembayaran {
    private String tanggal;

    
    public Pembayaran(String tanggal) {
        this.tanggal = tanggal;
    }

    public Pembayaran() {
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "tanggal : " + tanggal ;
    }
    
}
