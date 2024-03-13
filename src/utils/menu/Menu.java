package utils.menu;

public interface Menu {
    void options();

    static void invalidOptionMessage() {
        System.out.println("Opção invalida. Aperte Enter para continuar.");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
