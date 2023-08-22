package cashierapp.dao;

import java.util.ArrayList;
import java.util.List;

import cashierapp.models.Pesan;

public class PemesananDao implements BaseDao<Pesan, Integer>{
    List<Pesan> listPesan = new ArrayList<>();


    @Override
    public void create(Pesan data) {
        listPesan.add(data);
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public List<Pesan> findAll() {

        return this.listPesan;
    }

    @Override
    public Pesan findById(Integer id) {

        return this.listPesan.get(id-1);
    }

    @Override
    public void update(Integer id, Pesan data) {
        Pesan pesanToUpdate = listPesan.get(id - 1);
        pesanToUpdate.setQty(data.getQty());
    }
    
}
