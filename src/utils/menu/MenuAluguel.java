package utils.menu;

public class MenuAluguel implements Menu{

    @Override
    public void options() {
        System.out.println("""
                Options:
                1 - Alugar Veiculo
                2 - Devolver Veiculo
                3 - Sair
                """);
    }


}
