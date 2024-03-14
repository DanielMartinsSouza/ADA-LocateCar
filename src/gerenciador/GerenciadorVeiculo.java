package gerenciador;

import veiculo.Status;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

import exceptions.BusinessException;

public class GerenciadorVeiculo {
    private List<Veiculo> veiculos;

    public GerenciadorVeiculo(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void cadastrarVeiculo(Veiculo novoVeiculo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(novoVeiculo.getPlaca())) {
                throw new BusinessException("Esse veículo já está cadastrado.");
            }
        }
        veiculos.add(novoVeiculo);
    }

    public Veiculo buscarVeiculo(String placa) {
        if (placa == null || placa.isBlank()) {
            return null;
        }

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }

        return null;
    }

    public void editarVeiculo(String placa, String novaPlaca, TipoVeiculo novoTipo) {
        if (novaPlaca == null || novaPlaca.isBlank() || novoTipo == null) {
            return;
        }

        Veiculo veiculo = buscarVeiculo(placa);

        if (veiculo != null) {
            veiculo.setPlaca(novaPlaca);
            veiculo.setTipoVeiculo(novoTipo);
            System.out.println("Veículo editado com sucesso");
        } else {
            System.out.println("Veículo não encontrado");
        }
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getStatus() == Status.DISPONIVEL) {
                veiculosDisponiveis.add(veiculo);
            }
        }

        return veiculosDisponiveis;
    }

    protected Status checarStatusDeVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo.getStatus();
            }
        }

        return null;
    }

    protected void alterarStatusDeVeiculo(Veiculo veiculoAlterado, Status status) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.equals(veiculoAlterado)) {
                veiculo.setStatus(status);
            }
        }
    }

    public List<Veiculo> listarVeiculosPaginado(int numeroPagina, int tamanhoPagina) {
        int inicio = numeroPagina * tamanhoPagina;
        int fim = Math.min(inicio + tamanhoPagina, veiculos.size());
        return veiculos.subList(inicio, fim);
    }
}
