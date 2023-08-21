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
            List<Makanan> makanan = makananDao.findAll();
        return makanan;
    }

    @Override
    public Makanan getByIdMakanan(Integer id) {
        return makananDao.findById(id);
    }
    @Override
    public void updateMakanan(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'updateMakanan'");
    }


}
