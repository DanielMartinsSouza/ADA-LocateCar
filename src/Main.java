import controller.AluguelController;
import controller.PessoaController;
import controller.VeiculoController;
import services.PessoaService;
import services.VeiculoService;
import utils.io.ScannerSingleton;
import utils.menu.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = ScannerSingleton.getScanner();
        int option;
        Menu.welcomeMessage();

        do {
            Menu.options();
            option = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (option) {
                case 1:
                    opcoesDoVeiculo();
                    break;
                case 2:
                    opcoesDoCliente();
                    break;
                case 3:
                    opcoesAluguel();
                    break;
                case 4:
                    break;
                default:
                    Menu.invalidOptionMessage();
                    sc.nextLine();
                    break;
            }

            Menu.clearConsole();
        } while (option != 4);

        Menu.exitMessage();
        ScannerSingleton.closeScanner();
    }

    private static void opcoesAluguel() {
        Scanner sc = ScannerSingleton.getScanner();
        PessoaService pessoaService = PessoaController.getPessoaService();
        VeiculoService veiculoService = VeiculoController.getVeiculoService();

        int opcaoAluguel;
        do {
            MenuAluguel.options();
            opcaoAluguel = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (opcaoAluguel) {
                case 1:
                    AluguelController.alugarVeiculo(pessoaService, veiculoService);
                    break;
                case 2:
                    AluguelController.devolverVeiculo(pessoaService, veiculoService);
                    break;
                case 3:
                    break;
                default:
                    Menu.invalidOptionMessage();
                    sc.nextLine();
                    break;
            }
        } while (opcaoAluguel != 3);
    }

    private static void opcoesDoCliente() {
        Scanner sc = ScannerSingleton.getScanner();
        int opcaoCliente;
        do {
            MenuPessoa.options();
            opcaoCliente = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (opcaoCliente) {
                case 1:
                    PessoaController.cadastrarPessoa();
                    break;
                case 2:
                    PessoaController.alterarPessoa();
                    break;
                case 3:
                    break;
                default:
                    Menu.invalidOptionMessage();
                    sc.nextLine();
                    break;
            }
        } while (opcaoCliente != 3);
    }

    private static void opcoesDoVeiculo() {
        Scanner sc = ScannerSingleton.getScanner();
        int opcaoVeiculo;
        do {
            MenuVeiculo.options();
            opcaoVeiculo = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (opcaoVeiculo) {
                case 1:
                    VeiculoController.cadastrarVeiculo();
                    break;
                case 2:
                    VeiculoController.alterarVeiculo();
                    break;
                case 3:
                    VeiculoController.buscarVeiculo();
                    break;
                case 4:
                    break;
                default:
                    Menu.invalidOptionMessage();
                    sc.nextLine();
                    break;
            }

            Menu.clearConsole();

        } while (opcaoVeiculo != 4);
    }
}
