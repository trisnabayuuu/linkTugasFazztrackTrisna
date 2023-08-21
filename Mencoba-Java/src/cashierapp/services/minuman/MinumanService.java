package cashierapp.services.minuman;

import java.util.List;

import cashierapp.models.Minuman;

public interface MinumanService {
    List<Minuman> getMinuman();
    Minuman getByIdMimuman(Integer id);
    void updateMinuman(Integer id);
}
