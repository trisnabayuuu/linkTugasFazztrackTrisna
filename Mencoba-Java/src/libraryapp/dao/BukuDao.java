package libraryapp.dao;

import java.util.ArrayList;
import java.util.List;

import libraryapp.models.Buku;

public class BukuDao implements BaseDao<Buku, Integer>{

    List<Buku> buku = new ArrayList<>();

    @Override
    public void create(Buku data) {
        buku.add(data);
        
    }

    @Override
    public void delete(Integer id) {
        buku.remove(id-1);
    }

    @Override
    public List<Buku> findAll() {
        return this.buku;
    }

    @Override
    public Buku findById(Integer id) {
        return this.buku.get(id - 1);
    }

    @Override
    public void update(Integer id, Buku data) {
        buku.set(id - 1, data);
    }
    
}
