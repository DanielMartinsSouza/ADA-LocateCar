package utils.menu;

public class Menu {
    public static void invalidOptionMessage() {
        System.out.println("Opção invalida. Aperte Enter para continuar.");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void welcomeMessage() {
        System.out.println("Bem vindo ao ADA LocateCar - Locadora de Veículos!");
    }

    public static void exitMessage() {
        System.out.println("Ficamos agradecidos por usarem nosso sistema!");
    }

    public static void options() {
        System.out.println("""
                Opções:
                1 - Veiculo
                2 - Cliente
                3 - Aluguel
                4 - Sair
                """);
    }
}
