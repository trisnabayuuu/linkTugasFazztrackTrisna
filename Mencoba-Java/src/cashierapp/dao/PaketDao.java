package cashierapp.dao;

import java.util.ArrayList;
import java.util.List;

import cashierapp.models.Paket;

public class PaketDao implements BaseDao<Paket, Integer> {
List<Paket> paket = new ArrayList<>();

    @Override
    public void create(Paket data) {
        
    }

    @Override
    public void delete(Integer id) {
        
    }

    @Override
    public List<Paket> findAll() {
        paket = new ArrayList<>();
        paket.add(new Paket("Paket A: Ayam Geprek + Nasi + Es Teh Manis", 20000.0));
        paket.add(new Paket("Paket B: Ayam Geprek + Nasi + Tahu + Tempe + Es Teh Manis", 23000.0));
        paket.add(new Paket("Paket C: Ayam Geprek + Nasi + Tahu + Tempe + Sate(Kulit/Usus/Ati Ampela) + Es Teh Manis ", 25000.0));
        return paket;
    }

    @Override
    public Paket findById(Integer id) {
        return this.paket.get(id);
    }

    @Override
    public void update(Integer id, Paket data) {

        
    }
    
}
