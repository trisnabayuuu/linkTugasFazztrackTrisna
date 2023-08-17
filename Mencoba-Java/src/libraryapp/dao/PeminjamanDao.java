package libraryapp.dao;

import java.util.ArrayList;
import java.util.List;

import libraryapp.models.Peminjaman;

public class PeminjamanDao implements BaseDao<Peminjaman, Integer>{

    List<Peminjaman> peminjaman = new ArrayList<>();

    @Override
    public void create(Peminjaman data) {
        peminjaman.add(data);
    }

    @Override
    public void delete(Integer id) {
        
    }

    @Override
    public List<Peminjaman> findAll() {
        return this.peminjaman;
    }

    @Override
    public Peminjaman findById(Integer id) {
        return this.peminjaman.get(id -1);
    }

    @Override
    public void update(Integer id, Peminjaman data) {
        peminjaman.set(id-1, data);
    }
    
    
}
