package trabalhopraticosaude;

class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, String dataNascimento, String telefone, String email,
            double salario, String usuario, String senha) {
        super(nome, cpf, dataNascimento, telefone, email, salario, usuario, senha);
    }

    @Override
    public String toString() {
        return super.toString() + ", Cargo: Vendedor";
    }
}
