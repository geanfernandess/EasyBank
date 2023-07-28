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

@SuppressWarnings({ "serial", "unused" })
public class JanelaLoginContaSaldo extends JFrame {

	private JPanel contentPane;
	private JTextField c_conta;
	private JLabel lbl_resultado = new JLabel();
	private JTextField c_senhaConta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLoginContaSaldo frame = new JanelaLoginContaSaldo();
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
	public JanelaLoginContaSaldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_titulo = new JLabel("LOGIN CONTA");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(177, 11, 107, 14);
		contentPane.add(lbl_titulo);

		JLabel lbl_numeroConta = new JLabel("Numero da conta:");
		lbl_numeroConta.setBounds(49, 54, 115, 14);
		contentPane.add(lbl_numeroConta);

		c_conta = new JTextField();
		c_conta.setBounds(196, 51, 145, 20);
		contentPane.add(c_conta);
		c_conta.setColumns(10);

		JButton btn_entrar = new JButton("ENTRAR");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int nroConta = Integer.parseInt(c_conta.getText());
				int senha = Integer.parseInt(c_senhaConta.getText());

				if (DadosContas.buscar(nroConta) == null) {
					lbl_resultado.setText("Conta n�o encontrada no sistema");
				}

				if (DadosContas.buscar(nroConta).getSenha() != senha) {
					lbl_resultado.setText("Senha invalida");
				}

				if (DadosContas.buscar(nroConta) != null && DadosContas.buscar(nroConta).getSenha() == senha) {
					JanelaConsultaSaldo.main(null);
				}
			}
		});

		JLabel lbl_dadoEncontrados = new JLabel("Status busca:");
		lbl_dadoEncontrados.setBounds(48, 136, 137, 14);
		contentPane.add(lbl_dadoEncontrados);

		btn_entrar.setBounds(177, 254, 121, 23);
		contentPane.add(btn_entrar);

		lbl_resultado.setBounds(176, 136, 278, 14);
		contentPane.add(lbl_resultado);

		c_senhaConta = new JTextField();
		c_senhaConta.setColumns(10);
		c_senhaConta.setBounds(196, 93, 145, 20);
		contentPane.add(c_senhaConta);

		JLabel lbl_senhaConta = new JLabel("Senha da conta:");
		lbl_senhaConta.setBounds(49, 96, 115, 14);
		contentPane.add(lbl_senhaConta);
	}
}
