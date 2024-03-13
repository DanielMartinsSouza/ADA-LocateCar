package pessoa;

public class PessoaFisica extends Pessoa {
    private String sobrenome;

    public PessoaFisica(String documento, String nome, String sobrenome) {
        super(documento, nome);
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
