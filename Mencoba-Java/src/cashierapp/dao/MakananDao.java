package cashierapp.dao;

import java.util.ArrayList;
import java.util.List;

import cashierapp.models.Makanan;

public class MakananDao implements BaseDao<Makanan, Integer>{
List<Makanan> makanan = new ArrayList<>();

    @Override
    public void create(Makanan data) {
    }

    @Override
    public void delete(Makanan data) {
        
    }

    @Override
    public List<Makanan> findAll() {
        makanan = new ArrayList<>();
        makanan.add(new Makanan("Ayam Geprek", 14000.0));
        makanan.add(new Makanan("Lele", 10000.0));
        makanan.add(new Makanan("Nasi Putih", 4000.0));
        makanan.add(new Makanan("Sate Usus", 3000.0));
        makanan.add(new Makanan("Sate Kulit", 3000.0));
        makanan.add(new Makanan("Sate Ati Ampela", 3000.0));
        makanan.add(new Makanan("Sate Telor Puyuh", 3000.0));
        makanan.add(new Makanan("Tahu", 1500.0));
        makanan.add(new Makanan("Tempe", 1500.0));
        return this.makanan;
    }

    @Override
    public Makanan findById(Integer id) {
        return this.makanan.get(id-1);
    }

    @Override
    public void update(Integer id, Makanan data) {
        
    }
    
    
}
