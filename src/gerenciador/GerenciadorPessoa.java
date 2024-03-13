package gerenciador;

import pessoa.Pessoa;

import java.util.List;

public class GerenciadorPessoa {
    private List<Pessoa> pessoas;

    public GerenciadorPessoa(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void cadastrarPessoa(Pessoa novaPessoa) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getDocumento().equals(novaPessoa.getDocumento())) {
                System.out.println("Essa pessoa já está cadastrada.");
                return;
            }
        }

        pessoas.add(novaPessoa);
    }

    public Pessoa buscarPessoa(String documento) {
        if (documento == null || documento.isEmpty()) {
            return null;
        }

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getDocumento().equals(documento)) {
                return pessoa;
            }
        }

        return null;
    }

    public void editarPessoa(String documento, String novoDocumento, String novoNome) {
        if (novoDocumento == null || novoDocumento.isBlank() ||
                novoNome == null || novoNome.isBlank()) {
            return;
        }

        Pessoa pessoa = buscarPessoa(documento);

        if (pessoa != null) {
            pessoa.setDocumento(novoDocumento);
            pessoa.setNome(novoNome);
            System.out.println("Pessoa editada com sucesso");
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }

    public List<Pessoa> listarPessoas() {
        return this.pessoas;
    }
}
