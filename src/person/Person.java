package person;

public abstract class Person {
    private String documento;
    private String nome;

    public Person(String documento, String nome) {
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
