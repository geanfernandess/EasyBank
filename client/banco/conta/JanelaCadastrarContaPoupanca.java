package client.banco.conta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.banco.DadosAgencias;
import server.banco.DadosContas;
import server.banco.Poupanca;
import server.pessoa.cliente.DadosClientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class JanelaCadastrarContaPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField c_codigoConta;
	private JTextField c_statusConta;
	private JTextField c_senha;
	private JTextField c_saldoAtual;
	private JTextField c_agenciaCadastro;
	private JTextField c_cpfCliente;
	private JTextField c_nrConta;
	private JLabel t_saldoAtual;
	private JLabel t_agenciaCadastro;
	private JLabel t_cliente;
	private JButton b_CadastrarGerente;
	private JLabel t_statuslLembrete;
	private JLabel t_statusCadastro;
	private JLabel lbl_resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarContaPoupanca frame = new JanelaCadastrarContaPoupanca();
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
	public JanelaCadastrarContaPoupanca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_tituloCadastrarCliente = new JLabel("CADASTRAR CONTA POUPANCA");
		lbl_tituloCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_tituloCadastrarCliente.setBounds(155, 11, 216, 14);
		contentPane.add(lbl_tituloCadastrarCliente);

		JLabel t_codigoConta = new JLabel("Codigo Conta:");
		t_codigoConta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_codigoConta.setBounds(20, 42, 106, 14);
		contentPane.add(t_codigoConta);

		c_codigoConta = new JTextField();
		c_codigoConta.setBounds(147, 36, 290, 20);
		contentPane.add(c_codigoConta);
		c_codigoConta.setColumns(10);

		c_statusConta = new JTextField();
		c_statusConta.setColumns(10);
		c_statusConta.setBounds(147, 85, 290, 20);
		contentPane.add(c_statusConta);

		JLabel t_statusConta = new JLabel("Status Conta:");
		t_statusConta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statusConta.setBounds(20, 88, 77, 14);
		contentPane.add(t_statusConta);

		JLabel t_senha = new JLabel("Senha:");
		t_senha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_senha.setBounds(20, 122, 117, 14);
		contentPane.add(t_senha);

		c_senha = new JTextField();
		c_senha.setColumns(10);
		c_senha.setBounds(147, 116, 290, 20);
		contentPane.add(c_senha);

		JLabel t_nrConta = new JLabel("Numero Conta:");
		t_nrConta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_nrConta.setBounds(20, 153, 117, 14);
		contentPane.add(t_nrConta);

		c_saldoAtual = new JTextField();
		c_saldoAtual.setColumns(10);
		c_saldoAtual.setBounds(147, 178, 290, 20);
		contentPane.add(c_saldoAtual);

		c_agenciaCadastro = new JTextField();
		c_agenciaCadastro.setColumns(10);
		c_agenciaCadastro.setBounds(147, 209, 290, 20);
		contentPane.add(c_agenciaCadastro);

		c_cpfCliente = new JTextField();
		c_cpfCliente.setColumns(10);
		c_cpfCliente.setBounds(147, 240, 290, 20);
		contentPane.add(c_cpfCliente);

		t_saldoAtual = new JLabel("Saldo Atual:");
		t_saldoAtual.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_saldoAtual.setBounds(20, 184, 117, 14);
		contentPane.add(t_saldoAtual);

		t_agenciaCadastro = new JLabel("Agencia Cadastro:");
		t_agenciaCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_agenciaCadastro.setBounds(20, 212, 117, 14);
		contentPane.add(t_agenciaCadastro);

		t_cliente = new JLabel("CPF Cliente:");
		t_cliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_cliente.setBounds(20, 243, 117, 14);
		contentPane.add(t_cliente);

		c_nrConta = new JTextField();
		c_nrConta.setColumns(10);
		c_nrConta.setBounds(147, 147, 290, 20);
		contentPane.add(c_nrConta);

		b_CadastrarGerente = new JButton("Cadastrar");
		b_CadastrarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int codigoConta = Integer.parseInt(c_codigoConta.getText());
				int senha = Integer.parseInt(c_senha.getText());
				int nrConta = Integer.parseInt(c_nrConta.getText());
				double saldoAtual = Double.parseDouble(c_saldoAtual.getText());
				Calendar hoje = Calendar.getInstance();
				int agCadastro = Integer.parseInt(c_agenciaCadastro.getText());

				if (DadosAgencias.buscar(agCadastro) == null) {
					lbl_resultado.setText("A agencia n�o est� cadastrado no sistema");
				}
				if (DadosClientes.buscar(c_cpfCliente.getText()) == null) {
					lbl_resultado.setText("O cliente n�o est� cadastrado no sistema");
				}
				if (DadosAgencias.buscar(agCadastro) != null && DadosClientes.buscar(c_cpfCliente.getText()) != null) {
					DadosContas.cadastrar(new Poupanca(codigoConta, c_statusConta.getText().toUpperCase(), senha,
							nrConta, saldoAtual, hoje.getTime(),
							DadosAgencias.buscar(agCadastro), DadosClientes.buscar(c_cpfCliente.getText())));
					lbl_resultado.setText("Cadastro realizado com sucesso ");
				}
			}
		});
		b_CadastrarGerente.setBounds(170, 329, 117, 23);
		contentPane.add(b_CadastrarGerente);

		t_statuslLembrete = new JLabel("Digite: A para ativa, I para inativa e N para analise");
		t_statuslLembrete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statuslLembrete.setBounds(147, 67, 290, 14);
		contentPane.add(t_statuslLembrete);

		t_statusCadastro = new JLabel("Status Cadastro:");
		t_statusCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statusCadastro.setBounds(20, 287, 106, 14);
		contentPane.add(t_statusCadastro);

		lbl_resultado = new JLabel();
		lbl_resultado.setBounds(147, 287, 290, 14);
		contentPane.add(lbl_resultado);

	}
}