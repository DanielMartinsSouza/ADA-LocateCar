package aluguel;

import pessoa.Pessoa;
import veiculo.Veiculo;

import java.time.LocalDateTime;

public class Aluguel {
    private Veiculo veiculo;
    private Pessoa pessoa;
    private LocalDateTime horaDeInicio;

    public Aluguel(Veiculo veiculo, Pessoa pessoa, LocalDateTime horaDeInicio) {
        this.veiculo = veiculo;
        this.pessoa = pessoa;
        this.horaDeInicio = horaDeInicio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDateTime getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(LocalDateTime horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }
}
