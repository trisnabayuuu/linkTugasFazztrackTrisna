package libraryapp.services.peminjaman;

import java.util.List;

import libraryapp.dao.PeminjamanDao;
import libraryapp.models.Peminjaman;

public class PeminjamanImpl implements PeminjamanService {
    PeminjamanDao peminjamanDao;

    
    public PeminjamanImpl(PeminjamanDao peminjamanDao) {
        this.peminjamanDao = peminjamanDao;

    }

    @Override
    public void createPeminjaman(Peminjaman peminjaman) {
        peminjamanDao.create(peminjaman);
        System.out.println("buku berhasil dipinjam");
    }

    @Override
    public List<Peminjaman> getPeminjaman() {
        return peminjamanDao.findAll();
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
        peminjamanDao.update(id, peminjaman);
        System.out.println("Data peminjaman berhasil diperbarui");
        
    }
    
    
}
