import utils.menu.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Main
{
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

        LocalDateTime data = LocalDateTime.now();
        LocalDateTime dataLogoAposAluguel = data.plusMinutes(15);
        LocalDateTime dataTresDiasAntes = data.minusDays(3);
        LocalDateTime dataDoisDiasAntes = dataTresDiasAntes.plusMinutes(1);
        long tresDias = Duration.between(dataTresDiasAntes, data).toDays() + 1;
        long doisDias = Duration.between(dataDoisDiasAntes, data).toDays() + 1;
        long nenhumDia = Duration.between(dataLogoAposAluguel, data).toDays() + 1;
        System.out.println(data);
        System.out.println(dataLogoAposAluguel);
        System.out.println(dataTresDiasAntes);
        System.out.println(dataDoisDiasAntes);
        System.out.println(nenhumDia);
        System.out.println(tresDias);
        System.out.println(doisDias);
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
//                    TODO Cadastrar Cliente
                    break;
                case 2:
//                    TODO Alterar Cliente
                    break;
                case 3:
                    break;
                default:
                    Menu.invalidOptionMessage();
                    sc.nextLine();
                    break;
            }
        } while (opcaoCliente != 3);
        return;
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
//                    TODO Cadastrar Veiculo
                    break;
                case 2:
//                    TODO Alterar Veiculo
                    break;
                case 3:
//                    TODO Buscar Veiculo
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