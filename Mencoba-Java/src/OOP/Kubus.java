package OOP;

public class Kubus extends Persegi implements InterfaceBangunRuang{

    @Override
    public Double getVolume() {
        return Double.valueOf(super.getLuas() * super.getSisi());
    }

    
    
}
