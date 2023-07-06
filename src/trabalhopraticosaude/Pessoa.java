package trabalhopraticosaude;

class Pessoa {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    public PlanoSaude plano;

    public Pessoa(String nome, String cpf, String dataNascimento, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(String nome, String cpf, String dataNascimento, String telefone, String email, PlanoSaude plano) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento
                + ", Telefone: " + telefone + ", Email: " + email;
    }
}
