package trabalhopraticosaude;

class Funcionario extends Pessoa {

    private double salario;
    private String usuario;
    private String senha;

    public Funcionario(String nome, String cpf, String dataNascimento, String telefone, String email,
            double salario, String usuario, String senha) {
        super(nome, cpf, dataNascimento, telefone, email);
        this.salario = salario;
        this.usuario = usuario;
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário: " + salario + ", Usuário: " + usuario + ", Senha: " + senha;
    }
}
