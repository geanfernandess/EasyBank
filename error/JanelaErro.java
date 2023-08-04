package error;

import javax.swing.JOptionPane;

public class JanelaErro {
    public static void exibirErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}