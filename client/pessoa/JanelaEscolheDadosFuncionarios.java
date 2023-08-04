package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import client.AbrirJanela;

@SuppressWarnings({ "serial", "unused" })
public class JanelaEscolheDadosFuncionarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEscolheDadosFuncionarios frame = new JanelaEscolheDadosFuncionarios();
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
	public JanelaEscolheDadosFuncionarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_cadastrar = new JButton("CADASTRAR FUNCIONARIO - GERENTE");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaCadastrarFuncionarioGerente.class);
			}
		});
		btn_cadastrar.setBounds(66, 66, 321, 23);
		contentPane.add(btn_cadastrar);

		JButton btn_buscar = new JButton("BUSCAR FUNCIONARIO");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaBuscarFuncionario.class);
			}
		});
		btn_buscar.setBounds(66, 171, 321, 23);
		contentPane.add(btn_buscar);

		JButton btn_excluir = new JButton("EXCLUIR FUNCIONARIO");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaExcluirFuncionario.class);
			}
		});
		btn_excluir.setBounds(66, 205, 321, 23);
		contentPane.add(btn_excluir);

		JLabel lbl_titulo = new JLabel("DADOS FUNCIONARIOS");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(166, 11, 172, 14);
		contentPane.add(lbl_titulo);

		JButton btn_cadastrar_1 = new JButton("CADASTRAR FUNCIONARIO - ADMINISTRATIVO");
		btn_cadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaCadastrarFuncionarioAdministrativo.class);
			}
		});
		btn_cadastrar_1.setBounds(66, 100, 321, 23);
		contentPane.add(btn_cadastrar_1);

		JButton btn_alterarCargo = new JButton("ALTERAR CARGO DO FUNCIONARIO");
		btn_alterarCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaAlterarDadosFuncionario.class);
			}
		});
		btn_alterarCargo.setBounds(66, 137, 321, 23);
		contentPane.add(btn_alterarCargo);
	}
}