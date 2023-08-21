package cashierapp.services.pembayaran;

import java.util.List;

import cashierapp.models.Pembayaran;

public interface PembayranService {
    // void pembayaran(Pembayaran pembayaran);
    List<Pembayaran> getPembayaran();
    Pembayaran getByIdPembayaran(Integer id);
    void updatePembayaran();

}
