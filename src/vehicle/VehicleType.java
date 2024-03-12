package vehicle;

public enum VehicleType {
    PEQUENO(25),
    MEDIO(50),
    SUV(100);

    private double taxaDiaria;

    VehicleType(double taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    public double getTaxaDiaria() {
        return taxaDiaria;
    }
}
