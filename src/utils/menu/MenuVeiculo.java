package utils.menu;

public class MenuVeiculo implements Menu{
    @Override
    public void options() {
        System.out.println("""
                Options:
                1 - Cadastrar Veiculo
                2 - Alterar Veiculo
                3 - Buscar Veiculo
                4 - Sair
                """);
    }
}
