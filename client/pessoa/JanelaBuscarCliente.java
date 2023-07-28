package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.pessoa.cliente.DadosClientes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings({ "serial", "unused" })
public class JanelaBuscarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpf;
	private JLabel lbl_resultado = new JLabel();
	private JLabel lbl_dadosClientes = new JLabel();
	private JLabel lbl_dadosClientes2 = new JLabel();
	private JLabel lbl_dadosClientes3 = new JLabel();
	private JLabel lbl_dadosClientes4 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaBuscarCliente frame = new JanelaBuscarCliente();
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
	public JanelaBuscarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_titulo = new JLabel("BUSCAR CLIENTE");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(177, 11, 107, 14);
		contentPane.add(lbl_titulo);

		JLabel lbl_cpf = new JLabel("Digite o CPF:");
		lbl_cpf.setBounds(49, 54, 99, 14);
		contentPane.add(lbl_cpf);

		c_cpf = new JTextField();
		c_cpf.setBounds(196, 51, 145, 20);
		contentPane.add(c_cpf);
		c_cpf.setColumns(10);

		JButton btn_procurar = new JButton("PROCURAR");
		btn_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (DadosClientes.buscar(c_cpf.getText()) == null) {
					lbl_resultado.setText("Cliente n�o cadastrado no sistema");
				}

				if (DadosClientes.buscar(c_cpf.getText()) != null) {
					lbl_resultado.setText("Cliente encontrada com sucesso");
					lbl_dadosClientes.setText("O nome e: " + DadosClientes.buscar(c_cpf.getText()).getNomeCompleto());
					lbl_dadosClientes2.setText("O CPF e: " + DadosClientes.buscar(c_cpf.getText()).getCPF());
					lbl_dadosClientes3
							.setText("O estado civil e: " + DadosClientes.buscar(c_cpf.getText()).getEstadoCivil());
					lbl_dadosClientes4
							.setText("A escolaridade e: " + DadosClientes.buscar(c_cpf.getText()).getEscolaridade());
				}

			}
		});

		JLabel lbl_dadoEncontrados = new JLabel("Status busca:");
		lbl_dadoEncontrados.setBounds(49, 91, 137, 14);
		contentPane.add(lbl_dadoEncontrados);

		btn_procurar.setBounds(177, 254, 121, 23);
		contentPane.add(btn_procurar);

		lbl_resultado.setBounds(177, 91, 278, 14);
		contentPane.add(lbl_resultado);

		lbl_dadosClientes.setBounds(177, 116, 278, 14);
		contentPane.add(lbl_dadosClientes);

		lbl_dadosClientes2.setBounds(177, 141, 297, 14);
		contentPane.add(lbl_dadosClientes2);

		lbl_dadosClientes3.setBounds(177, 170, 297, 14);
		contentPane.add(lbl_dadosClientes3);

		lbl_dadosClientes4.setBounds(177, 198, 297, 14);
		contentPane.add(lbl_dadosClientes4);
	}
}
