package pessoa;

public abstract class Pessoa {
    private String documento;
    private String nome;

    public Pessoa(String documento, String nome) {
        this.documento = documento;
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
