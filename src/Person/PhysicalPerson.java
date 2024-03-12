package Person;

public class PhysicalPerson extends Person{
    private String sobrenome;

    public PhysicalPerson(String documento, String nome, String sobrenome) {
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
