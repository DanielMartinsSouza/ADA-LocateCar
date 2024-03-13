package gerenciador;

import aluguel.Aluguel;
import pessoa.Pessoa;
import veiculo.Status;
import veiculo.Veiculo;

import java.time.LocalDateTime;
import java.util.List;

public class GerenciadorAluguel {
    private List<Aluguel> alugueis;
    private GerenciadorVeiculo gerenciadorVeiculo;

    public GerenciadorAluguel(List<Aluguel> alugueis, GerenciadorVeiculo gerenciadorVeiculo) {
        this.alugueis = alugueis;
        this.gerenciadorVeiculo = gerenciadorVeiculo;
    }

    public void alugarVeiculo(Pessoa pessoa, Veiculo veiculo) {
        if (pessoa == null || veiculo == null) return;

        Status statusVeiculo = gerenciadorVeiculo.checarStatusDeVeiculo(veiculo.getPlaca());
        if (statusVeiculo == null || statusVeiculo.equals(Status.ALUGADO)) return;

        Aluguel aluguel = new Aluguel(veiculo, pessoa, LocalDateTime.now());
        gerenciadorVeiculo.alterarStatusDeVeiculo(veiculo, Status.ALUGADO);
        alugueis.add(aluguel);
    }
}
