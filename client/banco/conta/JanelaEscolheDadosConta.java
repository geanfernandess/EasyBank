package client.banco.conta;
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
public class JanelaEscolheDadosConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEscolheDadosConta frame = new JanelaEscolheDadosConta();
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
	public JanelaEscolheDadosConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_cadastrar = new JButton("CADASTRAR CONTA - CORRENTE");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCadastrarContaCorrente.main(null);
			}
		});
		btn_cadastrar.setBounds(66, 66, 321, 23);
		contentPane.add(btn_cadastrar);
		
		JButton btn_cadastrar_1 = new JButton("CADASTRAR CONTA - POUPANCA");
		btn_cadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCadastrarContaPoupanca.main(null);
			}
		});
		btn_cadastrar_1.setBounds(66, 100, 321, 23);
		contentPane.add(btn_cadastrar_1);
		
		JButton btn_cadastrar_1_1 = new JButton("CADASTRAR CONTA - SALARIO");
		btn_cadastrar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCadastrarContaSalario.main(null);
			}
		});
		btn_cadastrar_1_1.setBounds(66, 134, 321, 23);
		contentPane.add(btn_cadastrar_1_1);
		
		JButton btn_alterarStatus = new JButton("ALTERAR STATUS DA CONTA");
		btn_alterarStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAlterarStatusConta.main(null);
			}
		});
		btn_alterarStatus.setBounds(66, 168, 321, 23);
		contentPane.add(btn_alterarStatus);
		
		JLabel lbl_titulo = new JLabel("DADOS CONTAS");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(176, 11, 116, 14);
		contentPane.add(lbl_titulo);
		
		JButton btn_calculaTarifa = new JButton("ENCONTRAR TARIFAS DAS CONTAS");
		btn_calculaTarifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaBuscarTarifasContas.main(null);
			}
		});
		btn_calculaTarifa.setBounds(66, 202, 321, 23);
		contentPane.add(btn_calculaTarifa);
		
		JButton btn_buscar_1_1 = new JButton("BUSCAR CONTA");
		btn_buscar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaBuscarConta.main(null);
			}
		});
		btn_buscar_1_1.setBounds(66, 236, 321, 23);
		contentPane.add(btn_buscar_1_1);
				
	}
}
