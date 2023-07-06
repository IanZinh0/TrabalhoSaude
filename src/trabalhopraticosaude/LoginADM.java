package trabalhopraticosaude;

import javax.swing.*;

public class LoginADM {
    private JFrame frame;
    private JPanel panel;
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton loginButton;

    public LoginADM() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Menu de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioField = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> realizarLogin());

        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(loginButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void realizarLogin() {
        String usuario = usuarioField.getText();
        String senha = new String(senhaField.getPassword());

        if (usuario.equals("admin") && senha.equals("senha123")) {
            JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
            exibirInformacoesPlanosSaude();
            exibirMenu();
        } else {
            JOptionPane.showMessageDialog(frame, "Login falhou. Encerrando o programa...");
            System.exit(0);
        }
    }

    private void exibirInformacoesPlanosSaude() {
        
    }

    private void exibirMenu() {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginADM::new);
    }
}
