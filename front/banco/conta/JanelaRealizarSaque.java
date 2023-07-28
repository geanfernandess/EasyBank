package front.banco.conta;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.banco.DadosAgencias;
import backend.banco.DadosContas;
import backend.banco.Transacao;

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
public class JanelaRealizarSaque extends JFrame {

	private JPanel contentPane;
	private JTextField c_valorTransacao;
	private JLabel lbl_resultado = new JLabel();
	private JLabel lbl_saldoAtual = new JLabel();
	private JTextField c_conta;
	private JTextField c_agencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaRealizarSaque frame = new JanelaRealizarSaque();
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
	public JanelaRealizarSaque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("SAQUE");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(204, 11, 107, 14);
		contentPane.add(lbl_titulo);
		
		JLabel lbl_cpf = new JLabel("Digite o valor a ser sacado:");
		lbl_cpf.setBounds(21, 106, 205, 14);
		contentPane.add(lbl_cpf);
		
		c_valorTransacao = new JTextField();
		c_valorTransacao.setBounds(232, 103, 176, 20);
		contentPane.add(c_valorTransacao);
		c_valorTransacao.setColumns(10);
		
		JButton btn_sacar = new JButton("SACAR");
		btn_sacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int nroAgencia = Integer.parseInt(c_agencia.getText());
				int nroConta = Integer.parseInt(c_conta.getText());
				double valorSaque = Double.parseDouble(c_valorTransacao.getText());
			
				if (DadosAgencias.buscar(nroAgencia) == null) {
					lbl_resultado.setText("Agencia n�o encontrada");
					lbl_saldoAtual.setText("O saldo atual e: " + DadosContas.buscar(nroConta).getSaldoAtual() );
				}
				
				if (DadosContas.buscar(nroConta) == null) {
					lbl_resultado.setText("Conta n�o encontrada");
					lbl_saldoAtual.setText("O saldo atual e:: " + DadosContas.buscar(nroConta).getSaldoAtual() );
				}
				
				if (DadosAgencias.buscar(nroAgencia) != null && DadosContas.buscar(nroConta) != null &&
						DadosContas.buscar(nroConta).getSaldoAtual() > valorSaque) {
					Transacao transacao = new Transacao( DadosAgencias.buscar(nroAgencia), valorSaque, 'S' , DadosContas.buscar(nroConta));
					
					// Professora, pelo que eu entendi da sua explicacao o objeto conta deveria chamar o metodo efetiva transacao, feita da seguinte forma:
					// DadosContas.buscar(nroConta).setRefTransacao(transacao);
					// DadosContas.buscar(nroConta).getRefTransacao().get(0).efetivaTransacao();
					
					// Por�m quando eu seto uma transacao dentro do objeto conta eu n�o consigo fazer a persistencia dos dados da conta,
					// sendo assim a unica maneira que consegui realizar a transacao e persistir os dados da conta, foi da forma feita abaixo:
					
					transacao.efetivaTransacao();
			       	DadosContas.atualizarSaldo(nroConta);
					lbl_resultado.setText("Saque realizado com sucesso");
					lbl_saldoAtual.setText("O saldo atual e: " + DadosContas.buscar(nroConta).getSaldoAtual());
				}
							
			}
		});
		
		JLabel lbl_statusSaque = new JLabel("Status saque:" );
		lbl_statusSaque.setBounds(21, 143, 149, 14);
		contentPane.add(lbl_statusSaque);
		
		btn_sacar.setBounds(177, 256, 121, 23);
		contentPane.add(btn_sacar);
		

		lbl_resultado.setBounds(177, 143, 297, 14);
		contentPane.add(lbl_resultado);
		
		lbl_saldoAtual.setBounds(177, 166, 297, 14);
		contentPane.add(lbl_saldoAtual);
		
		JLabel lbl_nroConta = new JLabel("Digite o numero da conta: ");
		lbl_nroConta.setBounds(21, 78, 205, 14);
		contentPane.add(lbl_nroConta);
		
		c_conta = new JTextField();
		c_conta.setColumns(10);
		c_conta.setBounds(232, 75, 176, 20);
		contentPane.add(c_conta);
		
		JLabel lbl_nroAgencia = new JLabel("Digite a agencia da conta: ");
		lbl_nroAgencia.setBounds(21, 50, 205, 14);
		contentPane.add(lbl_nroAgencia);
		
		c_agencia = new JTextField();
		c_agencia.setColumns(10);
		c_agencia.setBounds(232, 47, 176, 20);
		contentPane.add(c_agencia);
	}
}
