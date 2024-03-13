package utils.menu;

public class MenuPrincipal implements Menu{
    public static void welcomeMessage() {
        System.out.println("Bem vindo ao ADA LocateCar - Locadora de Veículos!");
    }

    public static void exitMessage() {
        System.out.println("Ficamos agradecidos por usarem nosso sistema!");
    }

    public void options() {
        System.out.println("""
                Options:
                1 - Veiculo
                2 - Cliente
                3 - Aluguel
                4 - Sair
                """);
    }

}
