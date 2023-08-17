package libraryapp.services.book;

import java.util.List;

import libraryapp.dao.BukuDao;
import libraryapp.models.Buku;

public class BookServiceImpl implements Bookservice {
    BukuDao bukuDao;

    public BookServiceImpl(BukuDao bukuDao) {
        this.bukuDao = bukuDao;
    }

    @Override
    public void createBook(Buku buku) {
        if (buku.getJudul() == "") {
            System.out.println("judul empty");
        } else if (buku.getPenerbit() == "") {
            System.out.println("penerbit empty");
        } else if (buku.getPengarang() == ""){
            System.out.println("pengarang empty");
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
