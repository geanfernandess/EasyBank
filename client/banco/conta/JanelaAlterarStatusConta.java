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
public class JanelaAlterarStatusConta extends JFrame {

	private JPanel contentPane;
	private JTextField c_nroConta;
	private JLabel lbl_resultado = new JLabel();
	private JTextField t_novoStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAlterarStatusConta frame = new JanelaAlterarStatusConta();
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
	public JanelaAlterarStatusConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_titulo = new JLabel("ALTERAR STATUS DA CONTA");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(155, 11, 177, 14);
		contentPane.add(lbl_titulo);

		JLabel lbl_nroConta = new JLabel("N\u00FAmero da conta:");
		lbl_nroConta.setBounds(21, 54, 149, 14);
		contentPane.add(lbl_nroConta);

		c_nroConta = new JTextField();
		c_nroConta.setBounds(180, 51, 245, 20);
		contentPane.add(c_nroConta);
		c_nroConta.setColumns(10);

		JButton btn_alterar = new JButton("ALTERAR");
		btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int nroConta = Integer.parseInt(c_nroConta.getText());

				if (DadosContas.buscar(nroConta) == null) {
					lbl_resultado.setText("Conta n�o encontrada no sistema");
				}

				if (DadosContas.buscar(nroConta) != null) {
					DadosContas.mudarStatus(nroConta, t_novoStatus.getText().toUpperCase());
					lbl_resultado.setText("Status da conta alterado com sucesso");
				}
			}
		});

		JLabel lbl_statusAlteracao = new JLabel("Status alteracao:");
		lbl_statusAlteracao.setBounds(21, 137, 149, 14);
		contentPane.add(lbl_statusAlteracao);

		btn_alterar.setBounds(177, 180, 121, 23);
		contentPane.add(btn_alterar);

		lbl_resultado.setBounds(180, 137, 245, 14);
		contentPane.add(lbl_resultado);

		JLabel lbl_novoStatus = new JLabel("Novo status da conta:");
		lbl_novoStatus.setBounds(21, 103, 149, 14);
		contentPane.add(lbl_novoStatus);

		t_novoStatus = new JTextField();
		t_novoStatus.setColumns(10);
		t_novoStatus.setBounds(180, 100, 245, 20);
		contentPane.add(t_novoStatus);

		JLabel t_statuslLembrete = new JLabel("Digite: A para ativa, I para inativa e N para analise");
		t_statuslLembrete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statuslLembrete.setBounds(184, 82, 290, 14);
		contentPane.add(t_statuslLembrete);
	}
}
