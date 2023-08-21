package cashierapp.services.makanan;

import java.util.List;

import cashierapp.models.Makanan;

public interface MakananService {
        
    List<Makanan> getAll();
    Makanan getByIdMakanan(Integer id);
    void updateMakanan(Integer id);
}
