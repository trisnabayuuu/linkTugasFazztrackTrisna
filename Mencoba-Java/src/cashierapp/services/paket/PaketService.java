package cashierapp.services.paket;

import java.util.List;

import cashierapp.models.Paket;

public interface PaketService {
    List<Paket> getPaket();
    Paket getByIdPaket(Integer id);
    void updatePaket(Integer id);
}
