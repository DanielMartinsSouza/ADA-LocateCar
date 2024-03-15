package utils.menu;

import controller.PessoaController;
import pessoa.Pessoa;

import java.util.List;

public class MenuPessoa {
    public static void options() {
        System.out.println(listarPessoas() + """ 
               \n
               Opções:
               1 - Cadastrar Pessoa
               2 - Alterar Pessoa
               3 - Sair
               """);
    }

    private static String listarPessoas() {
        List<Pessoa> pessoas = PessoaController.listarPessoas();
        StringBuilder ret = new StringBuilder("""
                >>> Pessoas cadastradas <<<
                Documento      | Nome
                """);

        for (Pessoa pessoa : pessoas) {
            String doc = String.format("%-15s", pessoa.getDocumento());
            ret.append(doc).append("| ").append(pessoa.getNome());
        }

        return String.valueOf(ret);
    }
}
