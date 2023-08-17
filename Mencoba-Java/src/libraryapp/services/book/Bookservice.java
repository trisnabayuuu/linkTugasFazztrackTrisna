package libraryapp.services.book;

import java.util.List;

import libraryapp.models.Buku;

public interface Bookservice {
    void createBook(Buku buku);
    List<Buku> getBook();
    Buku getBookById(Integer id);
}
