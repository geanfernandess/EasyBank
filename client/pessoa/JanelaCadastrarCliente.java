package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.banco.DadosAgencias;
import server.pessoa.cliente.Cliente;
import server.pessoa.cliente.DadosClientes;
import server.Endereco;
import server.ValidaCPF;

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
public class JanelaCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpf;
	private JTextField c_nome;
	private JTextField c_dataNascimento;
	private JTextField c_escolaridade;
	private JTextField c_agCadastro;
	private JTextField c_estado;
	private JTextField c_cidade;
	private JTextField c_bairro;
	private JTextField c_rua;
	private JTextField c_numero;
	private JTextField c_estadoCivil;
	private JLabel t_escolaridade;
	private JLabel t_escolheAgencia;
	private JLabel t_estado;
	private JLabel t_cidade;
	private JLabel t_bairro;
	private JLabel t_rua;
	private JLabel t_numero;
	private JButton b_CadastrarGerente;
	private JLabel t_estadoCivilLembrete;
	private JLabel t_endereco;
	private JLabel t_statusCadastro;
	private JLabel lbl_resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarCliente frame = new JanelaCadastrarCliente();
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
	public JanelaCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_tituloCadastrarCliente = new JLabel("CADASTRAR CLIENTE");
		lbl_tituloCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_tituloCadastrarCliente.setBounds(186, 11, 216, 14);
		contentPane.add(lbl_tituloCadastrarCliente);

		JLabel t_CPF = new JLabel("CPF:");
		t_CPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_CPF.setBounds(20, 42, 46, 14);
		contentPane.add(t_CPF);

		c_cpf = new JTextField();
		c_cpf.setBounds(147, 36, 290, 20);
		contentPane.add(c_cpf);
		c_cpf.setColumns(10);

		c_nome = new JTextField();
		c_nome.setColumns(10);
		c_nome.setBounds(147, 67, 290, 20);
		contentPane.add(c_nome);

		JLabel t_nome = new JLabel("Nome:");
		t_nome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_nome.setBounds(20, 73, 46, 14);
		contentPane.add(t_nome);

		JLabel t_dataNascimento = new JLabel("Data Nascimento:");
		t_dataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_dataNascimento.setBounds(20, 105, 117, 14);
		contentPane.add(t_dataNascimento);

		c_dataNascimento = new JTextField();
		c_dataNascimento.setColumns(10);
		c_dataNascimento.setBounds(147, 99, 290, 20);
		contentPane.add(c_dataNascimento);

		JLabel t_estadoCivil = new JLabel("Estado Civil");
		t_estadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_estadoCivil.setBounds(20, 153, 117, 14);
		contentPane.add(t_estadoCivil);

		c_escolaridade = new JTextField();
		c_escolaridade.setColumns(10);
		c_escolaridade.setBounds(147, 178, 290, 20);
		contentPane.add(c_escolaridade);

		c_agCadastro = new JTextField();
		c_agCadastro.setColumns(10);
		c_agCadastro.setBounds(147, 209, 290, 20);
		contentPane.add(c_agCadastro);

		c_estado = new JTextField();
		c_estado.setColumns(10);
		c_estado.setBounds(147, 255, 290, 20);
		contentPane.add(c_estado);

		c_cidade = new JTextField();
		c_cidade.setColumns(10);
		c_cidade.setBounds(147, 286, 290, 20);
		contentPane.add(c_cidade);

		c_bairro = new JTextField();
		c_bairro.setColumns(10);
		c_bairro.setBounds(147, 317, 290, 20);
		contentPane.add(c_bairro);

		c_rua = new JTextField();
		c_rua.setColumns(10);
		c_rua.setBounds(147, 348, 290, 20);
		contentPane.add(c_rua);

		c_numero = new JTextField();
		c_numero.setColumns(10);
		c_numero.setBounds(147, 379, 290, 20);
		contentPane.add(c_numero);

		t_escolaridade = new JLabel("Escolaridade:");
		t_escolaridade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_escolaridade.setBounds(20, 184, 117, 14);
		contentPane.add(t_escolaridade);

		t_escolheAgencia = new JLabel("Agencia Cadastro:");
		t_escolheAgencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_escolheAgencia.setBounds(20, 212, 117, 14);
		contentPane.add(t_escolheAgencia);

		t_estado = new JLabel("Estado:");
		t_estado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_estado.setBounds(20, 258, 117, 14);
		contentPane.add(t_estado);

		t_cidade = new JLabel("Cidade:");
		t_cidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_cidade.setBounds(20, 289, 117, 14);
		contentPane.add(t_cidade);

		t_bairro = new JLabel("Bairro:");
		t_bairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_bairro.setBounds(20, 320, 117, 14);
		contentPane.add(t_bairro);

		t_rua = new JLabel("Rua:");
		t_rua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_rua.setBounds(20, 351, 117, 14);
		contentPane.add(t_rua);

		t_numero = new JLabel("Numero");
		t_numero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_numero.setBounds(20, 382, 117, 14);
		contentPane.add(t_numero);

		c_estadoCivil = new JTextField();
		c_estadoCivil.setColumns(10);
		c_estadoCivil.setBounds(147, 147, 290, 20);
		contentPane.add(c_estadoCivil);

		b_CadastrarGerente = new JButton("Cadastrar");
		b_CadastrarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int estadoCivil = Integer.parseInt(c_estadoCivil.getText());
				int agCadastro = Integer.parseInt(c_agCadastro.getText());

				if (DadosAgencias.buscar(agCadastro) == null) {
					lbl_resultado.setText("A agencia n�o est� cadastrado no sistema");
				}

				if (ValidaCPF.isCPF(c_cpf.getText()) == false) {
					lbl_resultado.setText("CPF digitado inv�lido");
				}

				if (estadoCivil < 1 || estadoCivil > 2) {
					lbl_resultado.setText("Estado civil digitado inv�lido");
				}

				if (DadosAgencias.buscar(agCadastro) != null && ValidaCPF.isCPF(c_cpf.getText()) != false &&
						(estadoCivil == 1 || estadoCivil == 2)) {
					DadosClientes.cadastrar(new Cliente(c_cpf.getText(), c_nome.getText(), c_dataNascimento.getText(),
							new Endereco(c_estado.getText(), c_cidade.getText(), c_bairro.getText(),
									c_rua.getText(), c_numero.getText()),
							estadoCivil, c_escolaridade.getText(),
							DadosAgencias.buscar(agCadastro)));
					lbl_resultado.setText("Cadastro realizado com sucesso ");
				}
			}
		});
		b_CadastrarGerente.setBounds(170, 466, 117, 23);
		contentPane.add(b_CadastrarGerente);

		t_estadoCivilLembrete = new JLabel("Digite: 1 para Solteiro ou 2 para Casado");
		t_estadoCivilLembrete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_estadoCivilLembrete.setBounds(147, 130, 290, 14);
		contentPane.add(t_estadoCivilLembrete);

		t_endereco = new JLabel("Endereco");
		t_endereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		t_endereco.setBounds(209, 240, 117, 14);
		contentPane.add(t_endereco);

		t_statusCadastro = new JLabel("Status Cadastro:");
		t_statusCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statusCadastro.setBounds(20, 421, 106, 14);
		contentPane.add(t_statusCadastro);

		lbl_resultado = new JLabel();
		lbl_resultado.setBounds(147, 421, 290, 14);
		contentPane.add(lbl_resultado);

	}

}