package libraryapp.models;

public class Peminjaman {

    private String tanggalPengembalian;
    private String tanggalPeminjaman;
    private Buku buku;
    private User user;


    
    public Peminjaman() {
    }
    
    public Peminjaman(String tanggalPengembalian, String tanggalPeminjaman, Buku buku, User user) {
        this.tanggalPengembalian = tanggalPengembalian;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.buku = buku;
        this.user = user;
    }

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }
    public void setTanggalPengembalian(String tanggalPengembalian) {
    //    DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        this.tanggalPengembalian = tanggalPengembalian;
    }
    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }
    public void setTanggalPeminjaman(String tanggalPeminjaman) {
        // DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        this.tanggalPeminjaman = tanggalPeminjaman;
    }
    public Buku getBuku() {
        return buku;
    }
    public void setBuku(Buku buku) {
        this.buku = buku;
    }
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "Peminjaman [tanggalPengembalian=" + tanggalPengembalian + ", tanggalPeminjaman=" + tanggalPeminjaman
                + ", " + buku + ", " + user + "]";
    }

}
