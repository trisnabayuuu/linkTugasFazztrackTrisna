package OOP;

public class Lingkaran implements InterfaceBangunDatar {
    private Double phi = 3.14;
    private Double jariJari;

    @Override
    public Double getKeliling() {

        return Double.valueOf(this.getPhi() * (2 * this.getJariJari()));
    }

    @Override
    public Double getLuas() {
        return Double.valueOf(this.getPhi() * this.getJariJari()) * this.getJariJari();
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("=== KARAKTERISTIK ===");
        System.out.println("Memiliki jumlah sudut 180 derajat dan Memiliki diameter yang membagi lingkaran menjadi 2 sisi seimbang");
        
    }

    @Override
    public void menggambarBangun() {
        System.out.println("*GAMBAR lINGKARAN*");
        
    }

    public Double getPhi() {
        return phi;
    }

    public void setPhi(Double phi) {
        this.phi = phi ;
    }

    public Double getJariJari() {
        return jariJari;
    }

    public void setJariJari(Double jariJari) {
        this.jariJari = jariJari;
    }

    
}
