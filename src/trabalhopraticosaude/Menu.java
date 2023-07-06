package trabalhopraticosaude;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Menu {

    private Scanner scanner;
    private Cliente cliente;
    private Vendedor vendedor;
    private Gerente gerente;
    private Cadastro cadastro;
    private List<Gerente> gerentes;
    private List<Vendedor> vendedores;
    private List<Atendente> atendentes;
    private List<Cliente> clientes;

    public Menu() {
        this.cadastro = new Cadastro();
        this.gerentes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Fazer Login");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    fazerLogin();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida \n");
            }
        }
    }

    private void cadastrarFuncionario() {
        System.out.println("\n////Insira os dados para o cadastro do FUNCIONARIO////");
        System.out.print("Digite o nome: ");
        String nome = scanner.next();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.next();
        System.out.print("Digite a data de nascimento [DD/MM/AAAA]: ");
        String dataNascimento = scanner.next();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.next();
        System.out.print("Digite o e-mail: ");
        String email = scanner.next();

        System.out.print("Digite o salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Digite o usuário: ");
        String usuario = scanner.next();
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        int cargo = 0;
        while (cargo < 1 || cargo > 3) {
            System.out.print("\nDigite o cargo do funcionário (1 - GERENTE, 2 - VENDEDOR, 3 - ATENDENTE): ");
            cargo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (cargo < 1 || cargo > 3) {
                System.out.println("Opção Inválida \n");
            }
        }

        Funcionario funcionario;
        switch (cargo) {
            case 1:
                funcionario = new Gerente(nome, cpf, dataNascimento, telefone, email, salario, usuario, senha);
                cadastro.cadastrarGerente((Gerente) funcionario);
                break;
            case 2:
                funcionario = new Vendedor(nome, cpf, dataNascimento, telefone, email, salario,usuario, senha);
                cadastro.cadastrarVendedor((Vendedor) funcionario);
                break;
            case 3:
                funcionario = new Atendente(nome, cpf, dataNascimento, telefone, email, salario, usuario, senha);
                cadastro.cadastrarAtendente((Atendente) funcionario);
                break;
        }
    }

    private void listarFuncionarios() {
        System.out.println("\n=== LISTA DE FUNCIONÁRIOS ===");
        cadastro.listarFuncionarios();
        System.out.println();
    }

    private void cadastrarCliente() {
        System.out.println("\n////Insira os dados para o cadastro do CLIENTE////");
        System.out.print("\nDigite o nome: ");
        String nome = scanner.next();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.next();
        System.out.print("Digite a data de nascimento [DD/MM/AAAA]: ");
        String dataNascimento = scanner.next();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.next();
        System.out.print("Digite o e-mail: ");
        String email = scanner.next();

        cadastro.cadastrarCliente(nome, cpf, dataNascimento, telefone, email, null);
    }

    private void cadastrarDependente() {
        System.out.println("\n////Insira os dados para o cadastro do DEPENDENTE////");
        System.out.print("\nDigite o nome: ");
        String nome = scanner.next();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.next();
        System.out.print("Digite a data de nascimento[DD/MM/AAAA]: ");
        String dataNascimento = scanner.next();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.next();
        System.out.print("Digite o e-mail : ");
        String email = scanner.next();

        System.out.print("Digite o CPF do titular: ");
        String cpfDoTitular = scanner.next();
        System.out.print("Digite o grau de parentesco: ");
        String grauParentesco = scanner.next();

        cadastro.cadastrarDependente(nome, cpf, dataNascimento, telefone, email, cpfDoTitular, grauParentesco);
    }

    private void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        cadastro.listarClientes();
        System.out.println();
    }

    public void venderPlano(String cpf) {
        cliente = cadastro.buscarClientePorCpf(cpf);

        List<String> clinicasPlanoBasic = new ArrayList<>();
        clinicasPlanoBasic.add("Clínica Saúde Total");
        List<String> especialidadesPlanoBasic = new ArrayList<>();
        especialidadesPlanoBasic.add("Pediatria - Oftalmologista");

        List<String> clinicasPlanoPremium = new ArrayList<>();
        clinicasPlanoPremium.add("Clínica São Lucas - Clínica Santa Clara");
        List<String> especialidadesPlanoPremium = new ArrayList<>();
        especialidadesPlanoPremium.add("Pediatria - Oftalmologista - Geriatria - Odontologia - Fisioterapia");

        List<String> clinicasPlanoDeluxe = new ArrayList<>();
        clinicasPlanoDeluxe.add("Clínica Premium Care - Clínica Belle Vie - Clínica Platinum Wellness");
        List<String> especialidadesPlanoDeluxe = new ArrayList<>();
        especialidadesPlanoDeluxe.add("Pediatria - Oftalmologista - Geriatria - Odontologia - Fisioterapia -"
                + " RejuvenescimentoFacial - Nutricionista - Psicólogo - Harmonização Facial");

        PlanoSaude planoBasic = new PlanoSaude(100.0, clinicasPlanoBasic, especialidadesPlanoBasic, "Plano Premium");
        PlanoSaude planoPremium = new PlanoSaude(1000.0, clinicasPlanoPremium, especialidadesPlanoPremium, "Plano Premium");
        PlanoSaude planoDeluxe = new PlanoSaude(1500.0, clinicasPlanoDeluxe, especialidadesPlanoDeluxe, "Plano Deluxe");

        System.out.println("Escolha qual plano será vendido: ");
        System.out.println("1 - Plano Basic [R$ 100 reais]\n"
                + "2 - Plano Premium [R$ 1000 reais]\n"
                + "3 - Plano Deluxe [R$ 1500 reais]");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                cliente.plano = planoBasic;
                break;
            case 2:
                cliente.plano = planoPremium;
                break;
            case 3:
                cliente.plano = planoDeluxe;
                break;
            default:
                System.out.println("Opção Inválida \n");
        }
    }

    private void fazerLogin() {
        System.out.println("\n//// FAZENDO LOGIN ////");
        System.out.print("Digite o usuário: ");
        String usuario = scanner.next();
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        if (cadastro.fazerLogin(usuario, senha)) {
            if (cadastro.getUsuarioLogado() != null) {
                if (cadastro.getUsuarioLogado().equals("Atendente")) {
                    menuAtendente();
                } else if (cadastro.getUsuarioLogado().equals("Gerente")) {
                    menuGerente(gerente);
                } else if (cadastro.getUsuarioLogado().equals("Vendedor")) {
                    menuVendedor(vendedor);
                } else {
                    System.out.println("Usuário ou senha incorreto \n");
                }
            }
        }
    }

    private void menuAtendente() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU ATENDENTE ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Dependente");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    cadastrarDependente();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida \n");
            }
        }
    }

    private void menuVendedor(Vendedor vendedor) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU VENDEDOR ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Vender Plano");
           System.out.println("4 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    System.out.print("\nDigite o CPF do cliente: ");
                    String cpf = scanner.next();
                    venderPlano(cpf);
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida \n");
            }
        }
    }

    private void menuGerente(Gerente gerente) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU GERENTE ===");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida \n");
            }
        }
    }}