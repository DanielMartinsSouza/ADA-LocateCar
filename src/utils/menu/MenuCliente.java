package utils.menu;

public class MenuCliente implements Menu{
    @Override
    public void options() {
        System.out.println("""
                Options:
                1 - Cadastrar Cliente
                2 - Alterar Cliente
                3 - Sair
                """);
    }
}
