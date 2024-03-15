package controller;

import exceptions.BusinessException;
import services.AluguelService;
import services.PessoaService;
import pessoa.Pessoa;
import services.VeiculoService;
import utils.io.ScannerSingleton;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class AluguelController {
    private static final AluguelService aluguelService =
            new AluguelService(new ArrayList<>(), new ArrayList<>(), VeiculoController.getVeiculoService());

    public static void alugarVeiculo() {
        Scanner sc = ScannerSingleton.getScanner();
        PessoaService pessoaService = PessoaController.getPessoaService();
        VeiculoService veiculoService = VeiculoController.getVeiculoService();

        System.out.print("Digite o documento do locador: ");
        String documento = sc.nextLine();
        Pessoa pessoa = pessoaService.buscarPessoa(documento);

        if (pessoa == null) {
            System.out.println("Pessoa não encontrada");
            return;
        }

        System.out.print("Digite a placa do veículo: ");
        String placa = sc.nextLine();
        Veiculo veiculo = veiculoService.buscarVeiculo(placa);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado");
            return;
        }

        try {
            aluguelService.alugarVeiculo(pessoa, veiculo);
            System.out.println("Veículo alugado com sucesso");
        } catch (BusinessException e) {
            System.err.println(e.getMessage());
        }
    }
}
