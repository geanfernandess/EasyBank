package client;

import javax.swing.JFrame;

public class AbrirJanela {

    public static void abrirJanela(Class<? extends JFrame> classeJanela) {
        try {
            JFrame janela = classeJanela.getDeclaredConstructor().newInstance();
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            janela.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}