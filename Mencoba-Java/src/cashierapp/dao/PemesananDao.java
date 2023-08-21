package cashierapp.dao;

import java.util.ArrayList;
import java.util.List;

import cashierapp.models.Pesan;

public class PemesananDao implements BaseDao<Pesan, Integer>{
    List<Pesan> pesan = new ArrayList<>();

    @Override
    public void create(Pesan data) {
        pesan.add(data);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Pesan> findAll() {

        return this.pesan;
    }

    @Override
    public Pesan findById(Integer id) {

        return null;
    }

    @Override
    public void update(Integer id, Pesan data) {

        
    }
    
}
