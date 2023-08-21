package cashierapp.services.minuman;
import java.util.List;

import cashierapp.dao.MinumanDao;
import cashierapp.models.Minuman;

public class MinumanImpl implements MinumanService {
    // private List<Minuman> minuman;
    MinumanDao minumanDao;
    


    public MinumanImpl(MinumanDao minumanDao) {
        this.minumanDao = minumanDao;
    }

    @Override
    public Minuman getByIdMimuman(Integer id) {
        return minumanDao.findById(id);
    }

    @Override
    public List<Minuman> getMinuman() {
        List<Minuman> minuman = minumanDao.findAll();
        return minuman;
    }

    @Override
    public void updateMinuman(Integer id) {
        
    }
    
}
