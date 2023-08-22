package cashierapp.services.paket;


import java.util.List;

import cashierapp.dao.PaketDao;
import cashierapp.models.Paket;

public class PaketImpl implements PaketService {
    // private List<Paket> paket;

    PaketDao paketDao;


    
    public PaketImpl(PaketDao paketDao) {
        this.paketDao = paketDao;
    }

    @Override
    public Paket getByIdPaket(Integer id) {
        try {
            return paketDao.findById(id);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("id tidak ditemukan");
        }
        return null;
    }

    @Override
    public List<Paket> getPaket() {
        List<Paket> paket = paketDao.findAll();
        return paket;
    }

    @Override
    public void updatePaket(Integer id) {
        
    }
    
}
