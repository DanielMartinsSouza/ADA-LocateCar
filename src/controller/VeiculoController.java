package controller;

import services.VeiculoService;
import utils.io.ScannerSingleton;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeiculoController {
    private static final VeiculoService veiculoService = new VeiculoService(new ArrayList<>());

    public static VeiculoService getVeiculoService() {
        return veiculoService;
    }

    public static void cadastrarVeiculo() {
        Scanner sc = ScannerSingleton.getScanner();

        System.out.print("Digite a placa do veículo: ");
        String placa = sc.nextLine();

        System.out.print("Digite o tipo do veículo (PEQUENO, MEDIO, SUV): ");
        TipoVeiculo tipo = TipoVeiculo.valueOf(sc.nextLine().toUpperCase());

        Veiculo novoVeiculo = new Veiculo(placa, tipo);
        veiculoService.cadastrarVeiculo(novoVeiculo);
    }

    public static void alterarVeiculo() {
        Scanner sc = ScannerSingleton.getScanner();

        System.out.print("Digite a placa do veículo a ser alterado: ");
        String placaAntiga = sc.nextLine();

        System.out.print("Digite a nova placa do veículo: ");
        String novaPlaca = sc.nextLine();

        System.out.print("Digite o novo tipo do veículo (PEQUENO, MEDIO, SUV): ");
        TipoVeiculo novoTipo = TipoVeiculo.valueOf(sc.nextLine().toUpperCase());

        veiculoService.editarVeiculo(placaAntiga, novaPlaca, novoTipo);
    }

    public static void buscarVeiculo() {
        Scanner sc = ScannerSingleton.getScanner();

        System.out.print("Digite a placa do veículo a ser buscado: ");
        String placaBusca = sc.nextLine();

        Veiculo veiculoEncontrado = veiculoService.buscarVeiculo(placaBusca);
        if (veiculoEncontrado != null) {
            System.out.println("Veículo encontrado: " + veiculoEncontrado.getPlaca() + ", " + veiculoEncontrado.getTipoVeiculo());
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public static List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }
}
