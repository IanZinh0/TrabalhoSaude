package trabalhopraticosaude;

class Dependente extends Pessoa {

    private String grauParentesco;
    private String cpfDoTitular;

    public Dependente(String nome, String cpf, String dataNascimento, String telefone, String email, String cpfDoTitular, String grauParentesco) {
        super(nome, cpf, dataNascimento, telefone, email);
        this.cpfDoTitular = cpfDoTitular;
        this.grauParentesco = grauParentesco;
    }

    public String getCpfDoTitular() {
        return cpfDoTitular;
    }

    public void setCpfDoTitular(String cpfDoTitular) {
        this.cpfDoTitular = cpfDoTitular;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

}
