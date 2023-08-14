package OOP;

public class Kubus extends Persegi implements InterfaceBangunRuang{

    @Override
    public Double getVolume() {
        return Double.valueOf(super.getLuas() * super.getSisi());
    }
    // public Double getVolume() {
    //     return super.getLuas() * super.getSisi();
    // }
    
    
}
