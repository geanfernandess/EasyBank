package client.banco.conta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.banco.DadosContas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

@SuppressWarnings({ "serial", "unused" })
public class JanelaConsultaSaldo extends JFrame {

	private JPanel contentPane;
	private JTextField c_nroConta;
	private JLabel lbl_resultado = new JLabel();
	private JLabel lbl_dadosConta = new JLabel();
	private JLabel lbl_dadosConta2 = new JLabel();
	private JLabel lbl_dadosConta3 = new JLabel();
	private JLabel lbl_dadosConta4 = new JLabel();
	private JLabel lbl_dadosConta5 = new JLabel();
	private JLabel lbl_dadosConta6 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaConsultaSaldo frame = new JanelaConsultaSaldo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaConsultaSaldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_titulo = new JLabel("BUSCAR CONTA");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(177, 11, 107, 14);
		contentPane.add(lbl_titulo);

		JLabel lbl_nroConta = new JLabel("Digite o n�mero da conta:");
		lbl_nroConta.setBounds(21, 54, 205, 14);
		contentPane.add(lbl_nroConta);

		c_nroConta = new JTextField();
		c_nroConta.setBounds(177, 51, 196, 20);
		contentPane.add(c_nroConta);
		c_nroConta.setColumns(10);

		JButton btn_procurar = new JButton("BUSCA SALDO");
		btn_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int nroConta = Integer.parseInt(c_nroConta.getText());

				if (DadosContas.buscar(nroConta) == null) {
					lbl_resultado.setText("Conta n�o encontrada no sistema");
				}

				if (DadosContas.buscar(nroConta) != null) {
					lbl_resultado.setText("O saldo e de: " + DadosContas.buscar(nroConta).getSaldoAtual());
				}
			}
		});

		JLabel lbl_statusFuncionario = new JLabel("Status busca:");
		lbl_statusFuncionario.setBounds(21, 91, 177, 14);
		contentPane.add(lbl_statusFuncionario);

		btn_procurar.setBounds(160, 223, 121, 23);
		contentPane.add(btn_procurar);

		lbl_resultado.setBounds(128, 91, 346, 14);
		contentPane.add(lbl_resultado);

		lbl_dadosConta.setBounds(128, 116, 346, 14);
		contentPane.add(lbl_dadosConta);

		lbl_dadosConta2.setBounds(128, 141, 346, 14);
		contentPane.add(lbl_dadosConta2);

		lbl_dadosConta3.setBounds(128, 170, 346, 14);
		contentPane.add(lbl_dadosConta3);

		lbl_dadosConta4.setBounds(128, 198, 346, 14);
		contentPane.add(lbl_dadosConta4);
		lbl_dadosConta5.setBounds(128, 226, 346, 14);

		contentPane.add(lbl_dadosConta5);
		lbl_dadosConta6.setBounds(128, 251, 346, 14);

		contentPane.add(lbl_dadosConta6);
	}
}
