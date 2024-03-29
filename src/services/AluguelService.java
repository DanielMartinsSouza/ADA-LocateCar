package services;

import aluguel.Aluguel;
import devolucao.DevolucaoAluguel;
import exceptions.BusinessException;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import veiculo.Status;
import veiculo.Veiculo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AluguelService {
    private List<Aluguel> alugueis;
    private List<DevolucaoAluguel> devolucoes;
    private VeiculoService veiculoService;

    public AluguelService(
            List<Aluguel> alugueis,
            List<DevolucaoAluguel> devolucoes,
            VeiculoService veiculoService) {
        this.alugueis = alugueis;
        this.devolucoes = devolucoes;
        this.veiculoService = veiculoService;
    }

    public void alugarVeiculo(Pessoa pessoa, Veiculo veiculo) throws BusinessException {
        if (pessoa == null) {
            throw new BusinessException("A pessoa não pode ser nula.");
        }
        if (veiculo == null) {
            throw new BusinessException("O veículo não pode ser nulo.");
        }
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()) {
            throw new BusinessException("A placa do veículo não pode ser nula ou vazia.");
        }

        Status statusVeiculo = veiculoService.checarStatusDeVeiculo(veiculo.getPlaca());
        if (statusVeiculo == null || statusVeiculo.equals(Status.ALUGADO)) {
            throw new BusinessException("O veículo já está alugado.");
        }

        Aluguel aluguel = new Aluguel(veiculo, pessoa, LocalDateTime.now());
        veiculoService.alterarStatusDeVeiculo(veiculo, Status.ALUGADO);
        alugueis.add(aluguel);
    }

    public Aluguel buscarAluguel(Veiculo veiculo, Pessoa pessoa) {
        if (veiculo == null || pessoa == null) {
            return null;
        }

        for (Aluguel aluguel : alugueis) {
            if (aluguel.getPessoa().equals(pessoa) && aluguel.getVeiculo().equals(veiculo)) {
                return aluguel;
            }
        }

        return null;
    }

    private void validarEntrada(Aluguel aluguel, LocalDateTime horaDevolucao) {
        if (aluguel == null) {
            throw new BusinessException("O aluguel não pode ser nulo.");
        }
        if (horaDevolucao == null) {
            throw new BusinessException("A hora de devolução não pode ser nula.");
        }
        if (horaDevolucao.isBefore(aluguel.getHoraDeInicio())) {
            throw new BusinessException("A hora de devolução não pode ser antes da hora de início do aluguel.");
        }
    }

    public DevolucaoAluguel devolverVeiculo(Aluguel aluguel, LocalDateTime horaDevolucao) throws BusinessException {
        validarEntrada(aluguel, horaDevolucao);

        long dias = calcularDiasDeAluguel(aluguel, horaDevolucao);
        double valorTotal = calcularValorTotal(aluguel, dias);

        veiculoService.alterarStatusDeVeiculo(aluguel.getVeiculo(), Status.DISPONIVEL);
        alugueis.remove(aluguel);
        devolucoes.add(new DevolucaoAluguel(aluguel, horaDevolucao, valorTotal));

        return new DevolucaoAluguel(aluguel, horaDevolucao, valorTotal);
    }

    private long calcularDiasDeAluguel(Aluguel aluguel, LocalDateTime horaDevolucao) {
        long dias = ChronoUnit.DAYS.between(aluguel.getHoraDeInicio().toLocalDate(), horaDevolucao.toLocalDate());
        if (horaDevolucao.toLocalTime().isAfter(aluguel.getHoraDeInicio().toLocalTime())) {
            dias += 1;
        }
        return dias;
    }

    private double calcularValorTotal(Aluguel aluguel, long dias) {
        double valorTotal = dias * aluguel.getVeiculo().getTipoVeiculo().getTaxaDiaria();
        if (aluguel.getPessoa() instanceof PessoaFisica && dias > 5) {
            valorTotal *= 0.95;
        } else if (aluguel.getPessoa() instanceof PessoaJuridica && dias > 3) {
            valorTotal *= 0.90;
        }
        return valorTotal;
    }
}
