package cashierapp.dao;

import java.util.ArrayList;
import java.util.List;

import cashierapp.models.Minuman;

public class MinumanDao implements BaseDao<Minuman, Integer> {
List<Minuman> minuman = new ArrayList<>();
    @Override
    public void create(Minuman data) {
        
    }



    @Override
    public void delete(Minuman data) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public List<Minuman> findAll() {
        minuman = new ArrayList<>();
        minuman.add(new Minuman("Teh Manis Panas", 3000.0));
        minuman.add(new Minuman("Teh Manis Dingin", 3000.0));
        minuman.add(new Minuman("Fanta ", 5000.0));
        minuman.add(new Minuman("Sprite ", 5000.0));
        minuman.add(new Minuman("Coca-Cola", 5000.0));
        minuman.add(new Minuman("Air Mineral", 2500.0));
        minuman.add(new Minuman("Kopi Hitam", 3000.0));
        return this.minuman;
    }

    @Override
    public Minuman findById(Integer id) {
        return this.minuman.get(id-1);
    }

    @Override
    public void update(Integer id, Minuman data) {
        
    }
    
}
