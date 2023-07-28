package client.banco.agencia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.banco.DadosAgencias;
import server.pessoa.funcionario.DadosFuncionarios;
import server.pessoa.funcionario.Gerente;
import server.Endereco;
import server.banco.Agencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class JanelaCadastrarAgencia extends JFrame {

	private JPanel contentPane;
	private JTextField c_nroAgencia;
	private JTextField c_nomeAg;
	private JTextField c_cpfGerente;
	private JTextField c_estado;
	private JTextField c_cidade;
	private JTextField c_bairro;
	private JTextField c_rua;
	private JTextField c_numero;
	private JLabel t_estado;
	private JLabel t_cidade;
	private JLabel t_bairro;
	private JLabel t_rua;
	private JLabel t_numero;
	private JButton b_CadastrarGerente;
	private JLabel t_endereco;
	private JLabel lbl_resultado;
	private JLabel t_statusCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarAgencia frame = new JanelaCadastrarAgencia();
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
	public JanelaCadastrarAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_tituloCadastrarAgencia = new JLabel("CADASTRAR AG�NCIA");
		lbl_tituloCadastrarAgencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_tituloCadastrarAgencia.setBounds(177, 11, 216, 14);
		contentPane.add(lbl_tituloCadastrarAgencia);

		JLabel t_nroAgencia = new JLabel("N\u00FAmero da Ag\u00EAncia:");
		t_nroAgencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_nroAgencia.setBounds(20, 42, 104, 14);
		contentPane.add(t_nroAgencia);

		c_nroAgencia = new JTextField();
		c_nroAgencia.setBounds(155, 36, 282, 20);
		contentPane.add(c_nroAgencia);
		c_nroAgencia.setColumns(10);

		c_nomeAg = new JTextField();
		c_nomeAg.setColumns(10);
		c_nomeAg.setBounds(155, 67, 282, 20);
		contentPane.add(c_nomeAg);

		JLabel t_nomeAg = new JLabel("Nome Ag\u00EAncia:");
		t_nomeAg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_nomeAg.setBounds(20, 73, 80, 14);
		contentPane.add(t_nomeAg);

		JLabel t_cpfGerente = new JLabel("CPF Gerente cadastrado:");
		t_cpfGerente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_cpfGerente.setBounds(20, 105, 137, 14);
		contentPane.add(t_cpfGerente);

		c_cpfGerente = new JTextField();
		c_cpfGerente.setColumns(10);
		c_cpfGerente.setBounds(155, 99, 282, 20);
		contentPane.add(c_cpfGerente);

		c_estado = new JTextField();
		c_estado.setColumns(10);
		c_estado.setBounds(155, 164, 282, 20);
		contentPane.add(c_estado);

		c_cidade = new JTextField();
		c_cidade.setColumns(10);
		c_cidade.setBounds(155, 195, 282, 20);
		contentPane.add(c_cidade);

		c_bairro = new JTextField();
		c_bairro.setColumns(10);
		c_bairro.setBounds(155, 226, 282, 20);
		contentPane.add(c_bairro);

		c_rua = new JTextField();
		c_rua.setColumns(10);
		c_rua.setBounds(155, 257, 282, 20);
		contentPane.add(c_rua);

		c_numero = new JTextField();
		c_numero.setColumns(10);
		c_numero.setBounds(155, 288, 282, 20);
		contentPane.add(c_numero);

		t_estado = new JLabel("Estado:");
		t_estado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_estado.setBounds(20, 170, 117, 14);
		contentPane.add(t_estado);

		t_cidade = new JLabel("Cidade:");
		t_cidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_cidade.setBounds(20, 201, 117, 14);
		contentPane.add(t_cidade);

		t_bairro = new JLabel("Bairro:");
		t_bairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_bairro.setBounds(20, 232, 117, 14);
		contentPane.add(t_bairro);

		t_rua = new JLabel("Rua:");
		t_rua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_rua.setBounds(20, 263, 117, 14);
		contentPane.add(t_rua);

		t_numero = new JLabel("Numero:");
		t_numero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_numero.setBounds(20, 294, 117, 14);
		contentPane.add(t_numero);

		b_CadastrarGerente = new JButton("Cadastrar");
		b_CadastrarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int nroAgencia = Integer.parseInt(c_nroAgencia.getText());

				if (DadosFuncionarios.buscar(c_cpfGerente.getText()) == null) {
					lbl_resultado.setText("O gerente n�o est� cadastrado no sistema");
				}
				if (DadosFuncionarios.buscar(c_cpfGerente.getText()) != null) {
					DadosAgencias.cadastrar(new Agencia(nroAgencia, c_nomeAg.getText(),
							((Gerente) DadosFuncionarios.buscar(c_cpfGerente.getText())),
							new Endereco(c_estado.getText(), c_cidade.getText(), c_bairro.getText(), c_rua.getText(),
									c_numero.getText())));
					lbl_resultado.setText("Cadastro realizado com sucesso");

				}

			}
		});
		b_CadastrarGerente.setBounds(165, 370, 117, 23);
		contentPane.add(b_CadastrarGerente);

		t_endereco = new JLabel("Endereco Agencia");
		t_endereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		t_endereco.setBounds(185, 139, 117, 14);
		contentPane.add(t_endereco);

		lbl_resultado = new JLabel();
		lbl_resultado.setBounds(147, 331, 290, 14);
		contentPane.add(lbl_resultado);

		t_statusCadastro = new JLabel("Status Cadastro:");
		t_statusCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statusCadastro.setBounds(20, 331, 106, 14);
		contentPane.add(t_statusCadastro);

	}

}