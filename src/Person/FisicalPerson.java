package Person;

public class FisicalPerson extends Person{
    private String sobrenome;

    public FisicalPerson(String documento, String nome, String sobrenome) {
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
