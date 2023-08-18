package libraryapp.services.book;

import java.util.List;

import libraryapp.dao.BukuDao;
import libraryapp.models.Buku;

public class BookImpl implements Bookservice {
    BukuDao bukuDao;

    public BookImpl(BukuDao bukuDao) {
        this.bukuDao = bukuDao;
    }

    @Override
    public void createBook(Buku buku) {
        if (buku.getJudul() == "") {
            throw new ExceptionInInitializerError("judul kosong");
        } else if (buku.getPenerbit() == "") {
            throw new ExceptionInInitializerError("penerbit kosong");
        } else if (buku.getPengarang() == ""){
            throw new ExceptionInInitializerError("pengarang kosong");
        } else {
        }
        bukuDao.create(buku);
        System.out.println("buku sukses di tambahkan");
    }

    @Override
    public List<Buku> getBook() {

        return bukuDao.findAll();
    }

    @Override
    public Buku getBookById(Integer id) {
        try {
            return bukuDao.findById(id);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("id tidak ditemukan");
        }
        return null;
    }

    
}
