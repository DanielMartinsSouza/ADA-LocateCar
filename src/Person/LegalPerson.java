package Person;

public class LegalPerson extends Person{
    private String razaoSocial;

    public LegalPerson(String documento, String nome, String razaoSocial) {
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
