package cashierapp.models;

public class Minuman {
    private String minuman;
    private Double hargaMinuman;

    
    public Minuman() {
    }
    public Minuman(String minuman, Double hargaMinuman) {
        this.minuman = minuman;
        this.hargaMinuman = hargaMinuman;
    }
    public String getMinuman() {
        return minuman;
    }
    public Double getHargaMinuman() {
        return hargaMinuman;
    }
    @Override
    public String toString() {
        return minuman + " - " + hargaMinuman ;
    }

    
}
