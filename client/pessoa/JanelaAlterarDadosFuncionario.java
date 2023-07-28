package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.pessoa.funcionario.DadosFuncionarios;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class JanelaAlterarDadosFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpfFuncionario;
	private JLabel lbl_resultado = new JLabel();
	private JTextField c_novoCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAlterarDadosFuncionario frame = new JanelaAlterarDadosFuncionario();
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
	public JanelaAlterarDadosFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbL_titulo = new JLabel("ALTERAR CARGO");
		lbL_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbL_titulo.setBounds(175, 11, 164, 14);
		contentPane.add(lbL_titulo);

		JLabel lbl_cpfFuncionario = new JLabel("CPF do funcionario:");
		lbl_cpfFuncionario.setBounds(20, 64, 143, 14);
		contentPane.add(lbl_cpfFuncionario);

		c_cpfFuncionario = new JTextField();
		c_cpfFuncionario.setBounds(173, 61, 189, 20);
		contentPane.add(c_cpfFuncionario);
		c_cpfFuncionario.setColumns(10);

		JButton btn_alterar = new JButton("ALTERAR");
		btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (DadosFuncionarios.buscar(c_cpfFuncionario.getText()) == null) {
					lbl_resultado.setText("Funcionario n�o encontrado ");
				}

				if (DadosFuncionarios.buscar(c_cpfFuncionario.getText()) != null) {
					DadosFuncionarios.alterarCargo(c_cpfFuncionario.getText(), c_novoCargo.getText());
					lbl_resultado.setText("Cargo alterado com sucesso");
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

		JLabel lbl_cpfGerente = new JLabel("Novo cargo:");
		lbl_cpfGerente.setBounds(20, 92, 133, 14);
		contentPane.add(lbl_cpfGerente);

		c_novoCargo = new JTextField();
		c_novoCargo.setColumns(10);
		c_novoCargo.setBounds(173, 89, 189, 20);
		contentPane.add(c_novoCargo);
	}
}
