import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.AbrirJanela;
import client.banco.agencia.JanelaEscolheDadosAgencia;
import client.banco.agencia.JanelaInformacoesAgencias;
import client.banco.conta.JanelaEscolheDadosConta;
import client.banco.conta.JanelaInformacoesContas;
import client.banco.conta.JanelaLoginContaSaldo;
import client.banco.conta.JanelaLoginContaTransacao;
import client.pessoa.JanelaEscolheDadosClientes;
import client.pessoa.JanelaEscolheDadosFuncionarios;
import client.pessoa.JanelaInformacoesClientes;
import client.pessoa.JanelaInformacoesFuncionarios;
import error.TratamentoDeErro;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

@SuppressWarnings({ "serial", "unused" })
public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		Thread.setDefaultUncaughtExceptionHandler(new TratamentoDeErro());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_tituloSistema = new JLabel("SISTEMA BANCARIO");
		lbl_tituloSistema.setBounds(183, 11, 138, 14);
		contentPane.add(lbl_tituloSistema);

		JButton btn_escolheFuncionario = new JButton("FUNCIONARIO");
		btn_escolheFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaEscolheDadosFuncionarios.class);
			}
		});
		btn_escolheFuncionario.setBounds(46, 98, 144, 23);
		contentPane.add(btn_escolheFuncionario);

		JButton btn_escolheAgencia = new JButton("AGENCIA");
		btn_escolheAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaEscolheDadosAgencia.class);
			}
		});
		btn_escolheAgencia.setBounds(261, 98, 144, 23);
		contentPane.add(btn_escolheAgencia);

		JButton btn_escolheCliente = new JButton("CLIENTE");
		btn_escolheCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaEscolheDadosClientes.class);
			}
		});
		btn_escolheCliente.setBounds(46, 148, 144, 23);
		contentPane.add(btn_escolheCliente);

		JButton btn_escolheConta = new JButton("CONTA");
		btn_escolheConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaEscolheDadosConta.class);
			}
		});
		btn_escolheConta.setBounds(261, 148, 144, 23);
		contentPane.add(btn_escolheConta);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 464, 8);
		contentPane.add(separator);

		JLabel lbl_manutencao = new JLabel("MANUTENCAO DE DADOS");
		lbl_manutencao.setBounds(148, 73, 195, 14);
		contentPane.add(lbl_manutencao);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 199, 464, 8);
		contentPane.add(separator_1);

		JLabel lbl_manutencao_1 = new JLabel("OPERACOES");
		lbl_manutencao_1.setBounds(196, 218, 115, 14);
		contentPane.add(lbl_manutencao_1);

		JButton btn_escolheTransacoes = new JButton("TRANSACOES");
		btn_escolheTransacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaLoginContaTransacao.class);
			}
		});
		btn_escolheTransacoes.setBounds(161, 259, 144, 23);
		contentPane.add(btn_escolheTransacoes);

		JButton btn_escolheConsultaSaldo = new JButton("CONSULTA SALDO");
		btn_escolheConsultaSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaLoginContaSaldo.class);
			}
		});
		btn_escolheConsultaSaldo.setBounds(161, 300, 144, 23);
		contentPane.add(btn_escolheConsultaSaldo);

		JLabel INFORMACOES = new JLabel("RELATORIO DE INFORMACOES");
		INFORMACOES.setBounds(146, 372, 233, 14);
		contentPane.add(INFORMACOES);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 353, 464, 8);
		contentPane.add(separator_1_1);

		JButton btn_informacoesAgencia = new JButton("AGENCIAS");
		btn_informacoesAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaInformacoesAgencias.class);
			}
		});
		btn_informacoesAgencia.setBounds(161, 410, 144, 23);
		contentPane.add(btn_informacoesAgencia);

		JButton btn_informacoesClientes = new JButton("CLIENTES");
		btn_informacoesClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaInformacoesClientes.class);
			}
		});
		btn_informacoesClientes.setBounds(161, 450, 144, 23);
		contentPane.add(btn_informacoesClientes);

		JButton btn_informacoesContas = new JButton("CONTAS");
		btn_informacoesContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaInformacoesContas.class);
			}
		});
		btn_informacoesContas.setBounds(161, 493, 144, 23);
		contentPane.add(btn_informacoesContas);

		JButton btn_informacoesFuncionarios = new JButton("FUNCIONARIOS");
		btn_informacoesFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaInformacoesFuncionarios.class);
			}
		});
		btn_informacoesFuncionarios.setBounds(161, 533, 144, 23);
		contentPane.add(btn_informacoesFuncionarios);
	}
}