package cashierapp.services.pembayaran;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import cashierapp.dao.PembayaranDao;
import cashierapp.models.Pembayaran;

public class PembayaranImpl implements PembayranService {
    Pembayaran pembayaran;
    PembayaranDao pembayaranDao;

    public PembayaranImpl(PembayaranDao pembayaranDao) {
        this.pembayaranDao = pembayaranDao;
    }

    @Override
    public void createPembayaran(Pembayaran pembayaran) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu kk:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = formatDateTime.format(now);

        pembayaran.setTanggal(formattedDateTime);
        // set tanggal
        try {
            pembayaranDao.create(pembayaran);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("massukkan data yang benar");
        }
        
    }

    @Override
    public Pembayaran getByIdPembayaran(Integer id) {

        return null;
    }

    @Override
    public List<Pembayaran> getPembayaran() {
            List<Pembayaran> pembayaran = pembayaranDao.findAll();
        return pembayaran;
    }

    @Override
    public void updatePembayaran() {
        
    }


    
}
