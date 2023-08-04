package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.AbrirJanela;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings({ "serial", "unused" })
public class JanelaEscolheDadosClientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEscolheDadosClientes frame = new JanelaEscolheDadosClientes();
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
	public JanelaEscolheDadosClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_cadastrar = new JButton("CADASTRAR CLIENTE");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaCadastrarCliente.class);
			}
		});
		btn_cadastrar.setBounds(66, 66, 321, 23);
		contentPane.add(btn_cadastrar);

		JButton btn_buscar = new JButton("BUSCAR CLIENTE");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaBuscarCliente.class);
			}
		});
		btn_buscar.setBounds(66, 136, 321, 23);
		contentPane.add(btn_buscar);

		JButton btn_excluir = new JButton("EXCLUIR CLIENTE");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaExcluirCliente.class);
			}
		});
		btn_excluir.setBounds(66, 170, 321, 23);
		contentPane.add(btn_excluir);

		JLabel lbl_titulo = new JLabel("DADOS CLIENTES");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(176, 11, 116, 14);
		contentPane.add(lbl_titulo);

		JButton btn_alterarEscolaridade = new JButton("ALTERAR ESCOLARIDADE CLIENTE");
		btn_alterarEscolaridade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaAlterarDadosCliente.class);
			}
		});
		btn_alterarEscolaridade.setBounds(66, 102, 321, 23);
		contentPane.add(btn_alterarEscolaridade);
	}
}