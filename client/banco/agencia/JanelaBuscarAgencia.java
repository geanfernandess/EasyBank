package client.banco.agencia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.banco.DadosAgencias;

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
public class JanelaBuscarAgencia extends JFrame {

	private JPanel contentPane;
	private JTextField c_nroAgencia;
	private JLabel lbl_resultado = new JLabel();
	private JLabel lbl_dadosAgencia = new JLabel();
	private JLabel lbl_dadosAgencia2 = new JLabel();
	private JLabel lbl_dadosAgencia3 = new JLabel();
	private JLabel lbl_dadosAgencia4 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaBuscarAgencia frame = new JanelaBuscarAgencia();
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
	public JanelaBuscarAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_titulo = new JLabel("BUSCAR AG�NCIA");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(177, 11, 107, 14);
		contentPane.add(lbl_titulo);

		JLabel lbl_cpf = new JLabel("Digite o n�mero da ag�ncia:");
		lbl_cpf.setBounds(21, 54, 205, 14);
		contentPane.add(lbl_cpf);

		c_nroAgencia = new JTextField();
		c_nroAgencia.setBounds(209, 51, 164, 20);
		contentPane.add(c_nroAgencia);
		c_nroAgencia.setColumns(10);

		JButton btn_procurar = new JButton("PROCURAR");
		btn_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int nroAgencia = Integer.parseInt(c_nroAgencia.getText());

				if (DadosAgencias.buscar(nroAgencia) == null) {
					lbl_resultado.setText("Ag�ncia n�o cadastrada no sistema");
				}

				if (DadosAgencias.buscar(nroAgencia) != null) {
					lbl_resultado.setText("Agencia encontrada com sucesso");
					lbl_dadosAgencia.setText("O nome da agencia e: " + DadosAgencias.buscar(nroAgencia).getNomeAg());
					lbl_dadosAgencia2
							.setText("O numero da agencia e: " + DadosAgencias.buscar(nroAgencia).getNumerodaAgencia());
					lbl_dadosAgencia3.setText(
							"A cidade da agencia e: " + DadosAgencias.buscar(nroAgencia).getRefEndereco().getCidade());
					lbl_dadosAgencia4.setText("O Gerente da agencia e: "
							+ DadosAgencias.buscar(nroAgencia).getRefGerente().getNomeCompleto());

				}
			}
		});

		JLabel lbl_statusFuncionario = new JLabel("Status busca:");
		lbl_statusFuncionario.setBounds(49, 91, 149, 14);
		contentPane.add(lbl_statusFuncionario);

		btn_procurar.setBounds(177, 256, 121, 23);
		contentPane.add(btn_procurar);

		lbl_resultado.setBounds(177, 91, 297, 14);
		contentPane.add(lbl_resultado);

		lbl_dadosAgencia.setBounds(177, 116, 297, 14);
		contentPane.add(lbl_dadosAgencia);

		lbl_dadosAgencia2.setBounds(177, 141, 297, 14);
		contentPane.add(lbl_dadosAgencia2);

		lbl_dadosAgencia3.setBounds(177, 170, 297, 14);
		contentPane.add(lbl_dadosAgencia3);

		lbl_dadosAgencia4.setBounds(177, 198, 297, 14);
		contentPane.add(lbl_dadosAgencia4);
	}
}
