package client.banco.agencia;
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

@SuppressWarnings({ "serial", "unused" })
public class JanelaEscolheDadosAgencia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEscolheDadosAgencia frame = new JanelaEscolheDadosAgencia();
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
	public JanelaEscolheDadosAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_cadastrar = new JButton("CADASTRAR AG�NCIA");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCadastrarAgencia.main(null);
			}
		});
		btn_cadastrar.setBounds(66, 66, 321, 23);
		contentPane.add(btn_cadastrar);
		
		JButton btn_buscar = new JButton("BUSCAR AGENCIA");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaBuscarAgencia.main(null);
			}
		});
		btn_buscar.setBounds(66, 134, 321, 23);
		contentPane.add(btn_buscar);
		
		JButton btn_excluir = new JButton("EXCLUIR AGENCIA");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaExcluirAgencia.main(null);
			}
		});
		btn_excluir.setBounds(66, 168, 321, 23);
		contentPane.add(btn_excluir);
		
		JLabel lbl_titulo = new JLabel("DADOS AGENCIAS");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(176, 11, 116, 14);
		contentPane.add(lbl_titulo);
		
		JButton btn_alterar = new JButton("ALTERAR GERENTE AG\u00CANCIA");
		btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAlterarDadosAgencia.main(null);
			}
		});
		btn_alterar.setBounds(66, 100, 321, 23);
		contentPane.add(btn_alterar);
	}
}
