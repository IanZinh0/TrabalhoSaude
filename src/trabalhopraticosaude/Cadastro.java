package trabalhopraticosaude;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {

    private List<Gerente> gerentes;
    private List<Vendedor> vendedores;
    private List<Atendente> atendentes;
    private List<Cliente> clientes;
    private List<Dependente> dependentes;
    private String usuarioLogado;

    public Cadastro() {
        gerentes = new ArrayList<>();
        vendedores = new ArrayList<>();
        atendentes = new ArrayList<>();
        clientes = new ArrayList<>();
        dependentes = new ArrayList<>();
        usuarioLogado = null;
    }

    public void cadastrarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public void cadastrarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void cadastrarAtendente(Atendente atendente) {
        atendentes.add(atendente);
    }

    public void cadastrarCliente(String nome, String cpf, String dataNascimento, String telefone, String email, PlanoSaude plano) {
        Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone, email, plano);
        clientes.add(cliente);
    }

    public void cadastrarDependente(String nome, String cpf, String dataNascimento, String telefone, String email,
            String cpfDoTitular, String grauParentesco) {
        Cliente clienteTitular = buscarClientePorCpf(cpfDoTitular);
        if (clienteTitular != null) {
            Dependente dependente = new Dependente(nome, cpf, dataNascimento, telefone, email, cpfDoTitular,
                    grauParentesco);
            dependentes.add(dependente);
        } else {
            System.out.println("O CPF do cliente titular não existe no sistema. Não é possível cadastrar o dependente");
        }
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private String obterNomeClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente.getNome();
            }
        }
        return null;
    }

    public void listarFuncionarios() {
        if (!gerentes.isEmpty()) {
            System.out.println("\n=== Gerentes ===");
            for (Gerente gerente : gerentes) {
                System.out.println(gerente);
            }
        }

        if (!vendedores.isEmpty()) {
            System.out.println("\n=== Vendedores ===");
            for (Vendedor vendedor : vendedores) {
                System.out.println(vendedor);
            }
        }

        if (!atendentes.isEmpty()) {
            System.out.println("\n=== Atendentes ===");
            for (Atendente atendente : atendentes) {
                System.out.println(atendente);
            }
        }
    }

    public void listarClientes() {
        if (!clientes.isEmpty()) {
            System.out.println("\n=== Clientes ===");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
                if (cliente.plano != null) {
                    System.out.println("Seu plano é: " + cliente.plano.getNome());
                }
            }
        }

        if (!dependentes.isEmpty()) {
            System.out.println("\n=== Dependentes ===");
            for (Dependente dependente : dependentes) {
                System.out.println(dependente);
                String cpfTitular = dependente.getCpfDoTitular();
                String nomeCliente = obterNomeClientePorCpf(cpfTitular);
                System.out.println("Dependente de: " + nomeCliente);
            }
        }
    }

    public boolean fazerLogin(String usuario, String senha) {
        for (Gerente gerente : gerentes) {
            if (gerente.getUsuario().equals(usuario) && gerente.getSenha().equals(senha)) {
                usuarioLogado = "Gerente";
                return true;
            }
        }

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getUsuario().equals(usuario) && vendedor.getSenha().equals(senha)) {
                usuarioLogado = "Vendedor";
                return true;
            }
        }

        for (Atendente atendente : atendentes) {
            if (atendente.getUsuario().equals(usuario) && atendente.getSenha().equals(senha)) {
                usuarioLogado = "Atendente";
                return true;
            }
        }

        System.out.println("Usuário ou senha inválidos \n");
        return false;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }
}
