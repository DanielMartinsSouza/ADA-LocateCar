package devolucao;

import aluguel.Aluguel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DevolucaoAluguel {
    private Aluguel aluguel;
    private LocalDateTime horaDeDevolucao;
    private double valorTotal;

    public DevolucaoAluguel(Aluguel aluguel, LocalDateTime horaDeDevolucao, double valorTotal) {
        this.aluguel = aluguel;
        this.horaDeDevolucao = horaDeDevolucao;
        this.valorTotal = valorTotal;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public LocalDateTime getHoraDeDevolucao() {
        return horaDeDevolucao;
    }

    public void setHoraDeDevolucao(LocalDateTime horaDeDevolucao) {
        this.horaDeDevolucao = horaDeDevolucao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        String horaFormatada = horaDeDevolucao.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
        return "Horário de devolução: " + horaFormatada +
                "\nValor total: " + valorTotal;
    }
}
