package cashierapp.services.pesan;

import java.util.ArrayList;
import java.util.List;

import cashierapp.dao.PemesananDao;
import cashierapp.models.Pesan;


public class PemesananImpl implements PemesananService{
    PemesananDao pemesananDao;
    Pesan pesan;

    public PemesananImpl(PemesananDao pemesananDao) {
        this.pemesananDao = pemesananDao;
    }

    @Override
    public void UpdatePesan(Integer id, Pesan pesan) {
        pemesananDao.update(id-1, pesan);
        
    }


    @Override
    public void createPesan(Pesan pesan) {
        pemesananDao.create(pesan);
    }

    @Override
    public Pesan getIdPesan(Integer id) {

        return null;
    }

    @Override
    public List<Pesan> getPesan() {
        try {
            List<Pesan> pesan = pemesananDao.findAll();
            if (pesan.isEmpty()){
                throw new ExceptionInInitializerError("Daftar Pesanan kosong");
            }
            return pesan;
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace(); 
            return new ArrayList<>();
        }
    }

    @Override
    public void deletePesan(Pesan pesan) {
        pemesananDao.delete(pesan);
        
    }
    
    
}
