package utils.menu;

import controller.VeiculoController;
import veiculo.Veiculo;

import java.util.List;

public class MenuVeiculo {
    public static void options() {
        System.out.println(listarVeiculos() + """
                \n
                Opções:
                1 - Cadastrar Veiculo
                2 - Alterar Veiculo
                3 - Buscar Veiculo
                4 - Sair
                """);
    }

    private static String listarVeiculos() {
        List<Veiculo> veiculos = VeiculoController.listarVeiculos();
        StringBuilder ret = new StringBuilder("""
                >>> Veículos cadastrados <<<
                Placa    | Tipo    | Status
                """);

        for (Veiculo veiculo : veiculos) {
            String placa = String.format("%-9s", veiculo.getPlaca());
            String tipo = String.format("%-8s", veiculo.getTipoVeiculo());
            ret.append(placa).append("| ").append(tipo).append("| ").append(veiculo.getStatus());
        }

        return String.valueOf(ret);
    }
}
