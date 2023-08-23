package cashierapp.dao;

import java.util.ArrayList;
import java.util.List;

import cashierapp.models.Pembayaran;
// import cashierapp.models.Pesan;

public class PembayaranDao implements BaseDao<Pembayaran, Integer>{
    // Pembayaran pembayaran;
    List<Pembayaran> pembayaran = new ArrayList<>();

    @Override
    public void create(Pembayaran data) {
        pembayaran.add(data);
    }



    @Override
    public void delete(Pembayaran data) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public List<Pembayaran> findAll() {
        return this.pembayaran;
    }

    @Override
    public Pembayaran findById(Integer id) {
        return null;
    }

    @Override
    public void update(Integer id, Pembayaran data) {
        
    }


    
}
