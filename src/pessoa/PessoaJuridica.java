package pessoa;

public class PessoaJuridica extends Pessoa {
    private String razaoSocial;

    public PessoaJuridica(String documento, String razaoSocial) {
        super(documento);
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getNome() {
        return razaoSocial;
    }

    @Override
    public void setNome(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
