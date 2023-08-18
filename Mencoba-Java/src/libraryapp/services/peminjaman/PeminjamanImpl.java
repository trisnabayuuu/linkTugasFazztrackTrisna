package libraryapp.services.peminjaman;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import libraryapp.dao.PeminjamanDao;
import libraryapp.models.Peminjaman;

public class PeminjamanImpl implements PeminjamanService {
    PeminjamanDao peminjamanDao;
    Peminjaman peminjaman;

    public PeminjamanImpl(PeminjamanDao peminjamanDao) {
        this.peminjamanDao = peminjamanDao;

    }

    @Override
    public void createPeminjaman(Peminjaman peminjaman) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = formatDateTime.format(now);

        peminjaman.setTanggalPeminjaman(formattedDateTime);
        // set tanggal
        try {
            peminjamanDao.create(peminjaman);
            System.out.println("buku berhasil dipinjam");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("massukkan data yang benar");
        }
    }

    @Override
    public List<Peminjaman> getPeminjaman() {

        try {
            List<Peminjaman> peminjaman = peminjamanDao.findAll();

            if (peminjaman.isEmpty()) {
                throw new ExceptionInInitializerError("Daftar pengguna kosong");
            }
            return peminjaman;
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
            return new ArrayList<>(); // Mengembalikan daftar kosong
        }
    }

    @Override
    public Peminjaman getPeminjamanById(Integer Id) {
        try {
            return peminjamanDao.findById(Id);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("id tidak ditemukan");
        }
        return null;

    }

    @Override
    public void updatePeminjaman(Integer id, Peminjaman peminjaman) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = formatDateTime.format(now);
        try {
            peminjaman.setTanggalPengembalian(formattedDateTime);
            peminjamanDao.update(id, peminjaman);
            System.out.println("Data peminjaman berhasil diperbarui");

        } catch (Exception e) {

        }
    }

}
