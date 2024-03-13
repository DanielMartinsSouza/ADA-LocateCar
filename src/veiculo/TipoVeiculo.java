package veiculo;

public enum TipoVeiculo {
    PEQUENO(100),
    MEDIO(150),
    SUV(200);

    private double taxaDiaria;

    TipoVeiculo(double taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    public double getTaxaDiaria() {
        return taxaDiaria;
    }
}
