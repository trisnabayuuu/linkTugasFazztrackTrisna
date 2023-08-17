package libraryapp.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public void setTanggalPengembalian(LocalDateTime tanggalPengembalian) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        this.tanggalPengembalian = tanggalPengembalian.format(formatDateTime);
    }
    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }
    public void setTanggalPeminjaman(LocalDateTime localDateTime) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        this.tanggalPeminjaman = localDateTime.format(formatDateTime);
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
