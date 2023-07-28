package front.pessoa;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.pessoa.funcionario.DadosFuncionarios;
import backend.pessoa.funcionario.Funcionario;
import backend.pessoa.funcionario.Gerente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings({ "serial", "unused" })
public class JanelaBuscarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpf;
	private JLabel lbl_resultado = new JLabel();
	private JLabel lbl_dadosFucionarios = new JLabel();
	private JLabel lbl_dadosFucionarios2 = new JLabel();
	private JLabel lbl_dadosFucionarios3 = new JLabel();
	private JLabel lbl_dadosFucionarios4 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaBuscarFuncionario frame = new JanelaBuscarFuncionario();
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
	public JanelaBuscarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("BUSCAR FUNCIONARIO");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(177, 11, 164, 14);
		contentPane.add(lbl_titulo);
		
		JLabel lbl_cpf = new JLabel("Digite o CPF:");
		lbl_cpf.setBounds(32, 54, 154, 14);
		contentPane.add(lbl_cpf);
		
		c_cpf = new JTextField();
		c_cpf.setBounds(177, 51, 164, 20);
		contentPane.add(c_cpf);
		c_cpf.setColumns(10);
		
		JButton btn_procurar = new JButton("PROCURAR");
		btn_procurar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				if (DadosFuncionarios.buscar(c_cpf.getText()) == null) {
					lbl_resultado.setText("Funcionario n�o cadastrado no sistema");
				}
				
				if (DadosFuncionarios.buscar(c_cpf.getText()) != null) {
					lbl_resultado.setText("Funcionario encontrada com sucesso");
					lbl_dadosFucionarios.setText("O nome e: " + DadosFuncionarios.buscar(c_cpf.getText()).getNomeCompleto());
					lbl_dadosFucionarios2.setText("O cargo e: " + DadosFuncionarios.buscar(c_cpf.getText()).getCargoEmpresa());
					lbl_dadosFucionarios3.setText("O data de admissao e: " + DadosFuncionarios.buscar(c_cpf.getText()).getDataAdmissao());
					if (DadosFuncionarios.buscar(c_cpf.getText()) instanceof Funcionario) {
						lbl_dadosFucionarios4.setText("O salario e: " + DadosFuncionarios.buscar(c_cpf.getText()).calcularSalario());
					}
					if (DadosFuncionarios.buscar(c_cpf.getText()) instanceof Gerente) {
						lbl_dadosFucionarios4.setText("O salario e: " + ((Gerente)DadosFuncionarios.buscar(c_cpf.getText())).calcularSalario());
					}
				}
			}
		});
		
		JLabel lbl_statusFuncionario = new JLabel("Status busca:" );
		lbl_statusFuncionario.setBounds(32, 92, 114, 14);
		contentPane.add(lbl_statusFuncionario);
		
		btn_procurar.setBounds(177, 259, 121, 23);
		contentPane.add(btn_procurar);
		
		lbl_resultado.setBounds(177, 92, 307, 14);
		contentPane.add(lbl_resultado);
		
		lbl_dadosFucionarios.setBounds(177, 117, 307, 14);
		contentPane.add(lbl_dadosFucionarios);
		
		lbl_dadosFucionarios2.setBounds(177, 141, 297, 14);
		contentPane.add(lbl_dadosFucionarios2);
		
		lbl_dadosFucionarios3.setBounds(177, 170, 297, 14);
		contentPane.add(lbl_dadosFucionarios3);
		
		lbl_dadosFucionarios4.setBounds(177, 198, 297, 14);
		contentPane.add(lbl_dadosFucionarios4);
	}
}
