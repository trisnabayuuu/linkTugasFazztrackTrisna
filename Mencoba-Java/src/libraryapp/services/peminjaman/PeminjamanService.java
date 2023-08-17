package libraryapp.services.peminjaman;

import java.util.List;

import libraryapp.models.Peminjaman;

public interface PeminjamanService {

    void createPeminjaman(Peminjaman peminjaman);
    List<Peminjaman> getPeminjaman();
    Peminjaman getPeminjamanById(Integer Id);
    void updatePeminjaman(Integer id, Peminjaman peminjaman);


} 
