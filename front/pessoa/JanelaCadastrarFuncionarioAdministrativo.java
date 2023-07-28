package front.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Endereco;
import backend.ValidaCPF;
import backend.pessoa.funcionario.DadosFuncionarios;
import backend.pessoa.funcionario.Funcionario;

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
import javax.swing.JList;

@SuppressWarnings({ "unused", "serial" })
public class JanelaCadastrarFuncionarioAdministrativo extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpf;
	private JTextField c_nome;
	private JTextField c_dataNascimento;
	private JTextField c_dataAdmissao;
	private JTextField c_sexo;
	private JTextField c_cargoEmpresa;
	private JTextField c_estado;
	private JTextField c_cidade;
	private JTextField c_bairro;
	private JTextField c_rua;
	private JTextField c_numero;
	private JTextField c_estadoCivil;
	private JLabel t_dataAdmissao;
	private JLabel t_sexo;
	private JLabel t_cargoEmpresa;
	private JLabel t_estado;
	private JLabel t_cidade;
	private JLabel t_bairro;
	private JLabel t_rua;
	private JLabel t_numero;
	private JButton b_CadastrarGerente;
	private JLabel t_estadoCivilLembrete;
	private JLabel lbl_lembreteSexo;
	private JLabel t_endereco;
	private JLabel t_statusCadastro;
	private JLabel lbl_resultado;
	private String[] itens = { "Solteiro", "Casado" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarFuncionarioAdministrativo frame = new JanelaCadastrarFuncionarioAdministrativo();
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
	public JanelaCadastrarFuncionarioAdministrativo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_tituloCadastrarAdministrativo = new JLabel("CADASTRAR FUNCIONARIO ADMINISTRATIVO");
		lbl_tituloCadastrarAdministrativo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_tituloCadastrarAdministrativo.setBounds(106, 11, 290, 14);
		contentPane.add(lbl_tituloCadastrarAdministrativo);

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
		t_estadoCivil.setBounds(20, 152, 117, 14);
		contentPane.add(t_estadoCivil);

		c_dataAdmissao = new JTextField();
		c_dataAdmissao.setColumns(10);
		c_dataAdmissao.setBounds(147, 177, 290, 20);
		contentPane.add(c_dataAdmissao);

		c_sexo = new JTextField();
		c_sexo.setColumns(10);
		c_sexo.setBounds(147, 227, 290, 20);
		contentPane.add(c_sexo);

		c_cargoEmpresa = new JTextField();
		c_cargoEmpresa.setColumns(10);
		c_cargoEmpresa.setBounds(147, 258, 290, 20);
		contentPane.add(c_cargoEmpresa);

		c_estado = new JTextField();
		c_estado.setColumns(10);
		c_estado.setBounds(147, 314, 290, 20);
		contentPane.add(c_estado);

		c_cidade = new JTextField();
		c_cidade.setColumns(10);
		c_cidade.setBounds(147, 345, 290, 20);
		contentPane.add(c_cidade);

		c_bairro = new JTextField();
		c_bairro.setColumns(10);
		c_bairro.setBounds(147, 376, 290, 20);
		contentPane.add(c_bairro);

		c_rua = new JTextField();
		c_rua.setColumns(10);
		c_rua.setBounds(147, 407, 290, 20);
		contentPane.add(c_rua);

		c_numero = new JTextField();
		c_numero.setColumns(10);
		c_numero.setBounds(147, 438, 290, 20);
		contentPane.add(c_numero);

		t_dataAdmissao = new JLabel("Data Admiss\u00E3o:");
		t_dataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_dataAdmissao.setBounds(20, 183, 117, 14);
		contentPane.add(t_dataAdmissao);

		t_sexo = new JLabel("Sexo:");
		t_sexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_sexo.setBounds(20, 233, 117, 14);
		contentPane.add(t_sexo);

		t_cargoEmpresa = new JLabel("Cargo Empresa:");
		t_cargoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_cargoEmpresa.setBounds(20, 264, 117, 14);
		contentPane.add(t_cargoEmpresa);

		t_estado = new JLabel("Estado:");
		t_estado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_estado.setBounds(20, 320, 117, 14);
		contentPane.add(t_estado);

		t_cidade = new JLabel("Cidade:");
		t_cidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_cidade.setBounds(20, 351, 117, 14);
		contentPane.add(t_cidade);

		t_bairro = new JLabel("Bairro:");
		t_bairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_bairro.setBounds(20, 382, 117, 14);
		contentPane.add(t_bairro);

		t_rua = new JLabel("Rua:");
		t_rua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_rua.setBounds(20, 413, 117, 14);
		contentPane.add(t_rua);

		t_numero = new JLabel("Numero");
		t_numero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_numero.setBounds(20, 444, 117, 14);
		contentPane.add(t_numero);

		c_estadoCivil = new JTextField();
		c_estadoCivil.setColumns(10);
		c_estadoCivil.setBounds(147, 146, 290, 20);
		contentPane.add(c_estadoCivil);

		b_CadastrarGerente = new JButton("Cadastrar");
		b_CadastrarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int estadoCivil = Integer.parseInt(c_estadoCivil.getText());
				int sexo = Integer.parseInt(c_sexo.getText());

				if (ValidaCPF.isCPF(c_cpf.getText()) == false) {
					lbl_resultado.setText("CPF digitado inv�lido");
				}

				if (estadoCivil < 1 || estadoCivil > 2) {
					lbl_resultado.setText("Estado civil digitado inv�lido");
				}

				if (sexo < 1 || sexo > 2) {
					lbl_resultado.setText("Sexo digitado inv�lido");
				}

				if (ValidaCPF.isCPF(c_cpf.getText()) != false && (estadoCivil == 1 || estadoCivil == 2) &&
						(sexo == 1 || sexo == 2)) {
					DadosFuncionarios
							.cadastrar(new Funcionario(c_cpf.getText(), c_nome.getText(), c_dataNascimento.getText(),
									new Endereco(c_estado.getText(), c_cidade.getText(), c_bairro.getText(),
											c_rua.getText(), c_numero.getText()),
									estadoCivil, c_dataAdmissao.getText(),
									sexo, c_cargoEmpresa.getText()));
					lbl_resultado.setText("Cadastro realizado com sucesso");
				}

			}
		});
		b_CadastrarGerente.setBounds(171, 527, 117, 23);
		contentPane.add(b_CadastrarGerente);

		t_estadoCivilLembrete = new JLabel("Digite: 1 para Solteiro ou 2 para Casado");
		t_estadoCivilLembrete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_estadoCivilLembrete.setBounds(147, 130, 290, 14);
		contentPane.add(t_estadoCivilLembrete);

		lbl_lembreteSexo = new JLabel("Digite: 1 para Masculino ou 2 para Feminino");
		lbl_lembreteSexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_lembreteSexo.setBounds(147, 208, 290, 14);
		contentPane.add(lbl_lembreteSexo);

		t_endereco = new JLabel("Endereco");
		t_endereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		t_endereco.setBounds(234, 299, 117, 14);
		contentPane.add(t_endereco);

		t_statusCadastro = new JLabel("Status Cadastro:");
		t_statusCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		t_statusCadastro.setBounds(20, 484, 106, 14);
		contentPane.add(t_statusCadastro);

		lbl_resultado = new JLabel();
		lbl_resultado.setBounds(147, 484, 290, 14);
		contentPane.add(lbl_resultado);

	}
}