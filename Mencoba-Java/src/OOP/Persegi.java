package OOP;

public class Persegi implements InterfaceBangunDatar {
    private Double sisi;



    public Double getSisi() {
        return sisi;
    }

    public void setSisi(Double sisi) {
        if (sisi <= 0) {
            throw new ArithmeticException("Sisi tidak boleh 0!");
        }

        this.sisi = sisi;
    }


    @Override
    public Double getKeliling() {
        return Double.valueOf(4 * this.getSisi());
        
    }
    @Override
    public Double getLuas() {
        return Double.valueOf(this.getSisi() * this.getSisi());
        
    }
    @Override
    public void karakteristikBangun() {
        System.out.println("karakteristik");
        
    }
    @Override
    public void menggambarBangun() {
        System.out.println("       PERSEGI      ");
        for (int i = 0; i < this.sisi; i++) {
            for (int j = 0; j < this.sisi; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }


}
