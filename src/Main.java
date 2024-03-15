import gerenciador.GerenciadorPessoa;
import gerenciador.GerenciadorVeiculo;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import utils.menu.*;
import veiculo.TipoVeiculo;
import veiculo.Veiculo;

import java.util.Scanner;

public class Main
{
    static GerenciadorPessoa gerenciadorPessoa = new GerenciadorPessoa();
    static GerenciadorVeiculo gerenciadorVeiculo = new GerenciadorVeiculo();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        MenuPrincipal.welcomeMessage();

        do {
            Menu menu = new MenuPrincipal();
            menu.options();
            option = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (option) {
                case 1:
                    opcoesDoVeiculo(sc);
                    break;
                case 2:
                    opcoesDoCliente(sc);
                    break;
                case 3:
                    opcoesAluguel(sc);
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

        MenuPrincipal.exitMessage();
        sc.close();
    }

    private static void opcoesAluguel(Scanner sc) {
        Menu menu;
        menu = new MenuAluguel();
        int opcaoAluguel;
        do {
            menu.options();
            opcaoAluguel = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (opcaoAluguel) {
                case 1:
//                    TODO Alugar Veiculo
                    break;
                case 2:
//                    TODO Devolver Veiculo
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

    private static void opcoesDoCliente(Scanner sc) {
        Menu menu;
        menu = new MenuCliente();
        int opcaoCliente;
        do {
            menu.options();
            opcaoCliente = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (opcaoCliente) {
                case 1:
                    System.out.println("Digite o tipo de pessoa (FISICA, JURIDICA):");
                    String tipoPessoa = sc.nextLine().toUpperCase();
                    System.out.println("Digite o documento da pessoa:");
                    String documento = sc.nextLine();
                    System.out.println("Digite o nome da pessoa:");
                    String nome = sc.nextLine();
                    Pessoa novaPessoa;
                    if (tipoPessoa.equals("FISICA")) {
                        novaPessoa = new PessoaFisica(documento, nome);
                    } else {
                        novaPessoa = new PessoaJuridica(documento, nome);
                    }
                    gerenciadorPessoa.cadastrarPessoa(novaPessoa);
                    break;
                case 2:
                    System.out.println("Digite o documento da pessoa a ser alterada:");
                    String documentoAntigo = sc.nextLine();
                    System.out.println("Digite o novo documento da pessoa:");
                    String novoDocumento = sc.nextLine();
                    System.out.println("Digite o novo nome da pessoa:");
                    String novoNome = sc.nextLine();
                    gerenciadorPessoa.editarPessoa(documentoAntigo, novoDocumento, novoNome);
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

    private static void opcoesDoVeiculo(Scanner sc) {
        Menu menu;
        menu = new MenuVeiculo();
        int opcaoVeiculo;
        do {
            menu.options();
            opcaoVeiculo = sc.nextInt();
            sc.nextLine();
            Menu.clearConsole();

            switch (opcaoVeiculo) {
                case 1:
                    System.out.println("Digite a placa do veículo:");
                    String placa = sc.nextLine();
                    System.out.println("Digite o tipo do veículo (PEQUENO, MEDIO, SUV):");
                    TipoVeiculo tipo = TipoVeiculo.valueOf(sc.nextLine().toUpperCase());
                    Veiculo novoVeiculo = new Veiculo(placa, tipo);
                    gerenciadorVeiculo.cadastrarVeiculo(novoVeiculo);
                    break;
                case 2:
                    System.out.println("Digite a placa do veículo a ser alterado:");
                    String placaAntiga = sc.nextLine();
                    System.out.println("Digite a nova placa do veículo:");
                    String novaPlaca = sc.nextLine();
                    System.out.println("Digite o novo tipo do veículo (PEQUENO, MEDIO, SUV):");
                    TipoVeiculo novoTipo = TipoVeiculo.valueOf(sc.nextLine().toUpperCase());
                    gerenciadorVeiculo.editarVeiculo(placaAntiga, novaPlaca, novoTipo);
                    break;

                case 3:
                    System.out.println("Digite a placa do veículo a ser buscado:");
                    String placaBusca = sc.nextLine();
                    Veiculo veiculoEncontrado = gerenciadorVeiculo.buscarVeiculo(placaBusca);
                    if (veiculoEncontrado != null) {
                        System.out.println("Veículo encontrado: " + veiculoEncontrado.getPlaca() + ", " + veiculoEncontrado.getTipoVeiculo());
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
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
