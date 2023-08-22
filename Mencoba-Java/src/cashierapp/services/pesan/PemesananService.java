package cashierapp.services.pesan;

import java.util.List;

import cashierapp.models.Pesan;

public interface PemesananService {
    void createPesan (Pesan pesan);
    List<Pesan> getPesan();
    Pesan getIdPesan(Integer id);
    void UpdatePesan(Integer id, Pesan pesan);
    
}
