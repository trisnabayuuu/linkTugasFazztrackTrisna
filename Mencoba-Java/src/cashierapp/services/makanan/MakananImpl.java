package cashierapp.services.makanan;

import java.util.List;

import cashierapp.dao.MakananDao;
import cashierapp.models.Makanan;

public class MakananImpl implements MakananService {
    // private List<Makanan> daftarMakanan;
    MakananDao makananDao;
    


    public MakananImpl(MakananDao makananDao) {
        this.makananDao = makananDao;
    }

    @Override
    public List<Makanan> getAll() {
        try {
            
            List<Makanan> makanan = makananDao.findAll();
            return makanan;
        } catch (Exception e) {
            System.out.println("kosong");
        }    return null;
    }

    @Override
    public Makanan getByIdMakanan(Integer id) {
        try {
            return makananDao.findById(id);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("id tidak ditemukan");
        }
        return null;
    }
    @Override
    public void updateMakanan(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'updateMakanan'");
    }


}
