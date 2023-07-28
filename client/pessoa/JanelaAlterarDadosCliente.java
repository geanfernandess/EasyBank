package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.pessoa.cliente.DadosClientes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class JanelaAlterarDadosCliente extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpfCliente;
	private JLabel lbl_resultado = new JLabel();
	private JTextField c_escolaridade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAlterarDadosCliente frame = new JanelaAlterarDadosCliente();
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
	public JanelaAlterarDadosCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbL_titulo = new JLabel("ALTERAR ESCOLARIDADE");
		lbL_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbL_titulo.setBounds(175, 11, 164, 14);
		contentPane.add(lbL_titulo);

		JLabel lbl_nroAgencia = new JLabel("CPF do cliente:");
		lbl_nroAgencia.setBounds(20, 64, 143, 14);
		contentPane.add(lbl_nroAgencia);

		c_cpfCliente = new JTextField();
		c_cpfCliente.setBounds(173, 61, 189, 20);
		contentPane.add(c_cpfCliente);
		c_cpfCliente.setColumns(10);

		JButton btn_alterar = new JButton("ALTERAR");
		btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (DadosClientes.buscar(c_cpfCliente.getText()) == null) {
					lbl_resultado.setText("Cliente n�o encontrado ");
				}

				if (DadosClientes.buscar(c_cpfCliente.getText()) != null) {
					DadosClientes.alterarEscolaridade(c_cpfCliente.getText(), c_escolaridade.getText());
					lbl_resultado.setText("Escolaridade alterada com sucesso");
				}
			}
		});
		btn_alterar.setBounds(175, 167, 89, 23);
		contentPane.add(btn_alterar);

		JLabel lbl_status = new JLabel("Status altera\u00E7\u00E3o:");
		lbl_status.setBounds(20, 126, 128, 14);
		contentPane.add(lbl_status);

		lbl_resultado.setBounds(175, 126, 260, 14);
		contentPane.add(lbl_resultado);

		JLabel lbl_cpfGerente = new JLabel("Nova escoladidade:");
		lbl_cpfGerente.setBounds(20, 92, 133, 14);
		contentPane.add(lbl_cpfGerente);

		c_escolaridade = new JTextField();
		c_escolaridade.setColumns(10);
		c_escolaridade.setBounds(173, 89, 189, 20);
		contentPane.add(c_escolaridade);
	}
}
