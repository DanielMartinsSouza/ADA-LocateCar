package pessoa;

public class PessoaFisica extends Pessoa {
    private String nomeSobrenome;

    public PessoaFisica(String documento, String nomeSobrenome) {
        super(documento);
        this.nomeSobrenome = nomeSobrenome;
    }

    @Override
    public String getNome() {
        return nomeSobrenome;
    }

    @Override
    public void setNome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }
}
