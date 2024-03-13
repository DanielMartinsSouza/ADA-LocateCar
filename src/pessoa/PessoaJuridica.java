package pessoa;

public class PessoaJuridica extends Pessoa {
    private String razaoSocial;

    public PessoaJuridica(String documento, String nome, String razaoSocial) {
        super(documento, nome);
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
