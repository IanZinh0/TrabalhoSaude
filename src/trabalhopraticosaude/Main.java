package trabalhopraticosaude;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo, Administrador! Faça o seu login:");
        if (realizarLogin()) {
            System.out.println("Login realizado com sucesso!\n");
            exibirInformacoesPlanosSaude();
            Menu menu = new Menu();
            menu.exibirMenu();
        } else {
            System.out.println("Login falhou. Encerrando o programa...");
        }
    }

    private static boolean realizarLogin() {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Verificar as credenciais do administrador
        if (usuario.equals("admin") && senha.equals("senha123")) {
            return true;
        } else {
            return false;
        }
    }

    private static void exibirInformacoesPlanosSaude() {
        // Criando listas de clínicas e especialidades
        List<String> clinicasPlanoBasic = new ArrayList<>();
        clinicasPlanoBasic.add("Clínica Saúde Total");

        List<String> especialidadesPlanoBasic = new ArrayList<>();
        especialidadesPlanoBasic.add("Pediatria - Oftalmologista");

        List<String> clinicasPlanoPremium = new ArrayList<>();
        clinicasPlanoPremium.add("Clínica São Lucas");
        clinicasPlanoPremium.add("Clínica Santa Clara");

        List<String> especialidadesPlanoPremium = new ArrayList<>();
        especialidadesPlanoPremium.add("Pediatria - Oftalmologista - Geriatria - Odontologia - Fisioterapia");

        List<String> clinicasPlanoDeluxe = new ArrayList<>();
        clinicasPlanoDeluxe.add("Clínica Premium Care");
        clinicasPlanoDeluxe.add("Clínica Belle Vie");
        clinicasPlanoDeluxe.add("Clínica Platinum Wellness");

        List<String> especialidadesPlanoDeluxe = new ArrayList<>();
        especialidadesPlanoDeluxe.add("Pediatria - Oftalmologista - Geriatria - Odontologia - Fisioterapia"
                + " - Rejuvenescimento Facial - Nutricionista - Psicólogo - Harmonização Facial");

        // Criando os planos de saúde
        PlanoSaude planoBasic = new PlanoSaude(100.0, clinicasPlanoBasic, especialidadesPlanoBasic);
        PlanoSaude planoPremium = new PlanoSaude(500, clinicasPlanoPremium, especialidadesPlanoPremium);
        PlanoSaude planoDeluxe = new PlanoSaude(1500, clinicasPlanoDeluxe, especialidadesPlanoDeluxe);

        // Exemplo de acesso às informações dos planos de saúde
        System.out.println("\n## PLANO BASIC ##:");
        System.out.println("PREÇO: " + planoBasic.getPreco());
        System.out.println("CLÍNICAS: " + planoBasic.getClinicas());
        System.out.println("ESPECIALIDADES: " + planoBasic.getEspecialidades());
        System.out.println();

        System.out.println("\n#### PLANO PREMIUM ####");
        System.out.println("PREÇO: " + planoPremium.getPreco());
        System.out.println("CLÍNICAS: " + planoPremium.getClinicas());
        System.out.println("ESPECIALIDADES: " + planoPremium.getEspecialidades());
        System.out.println();

        System.out.println("\n####### PLANO DELUXE ######");
        System.out.println("PREÇO: " + planoDeluxe.getPreco());
        System.out.println("CLÍNICAS: " + planoDeluxe.getClinicas());
        System.out.println("ESPECIALIDADES: " + planoDeluxe.getEspecialidades());
    }

}
