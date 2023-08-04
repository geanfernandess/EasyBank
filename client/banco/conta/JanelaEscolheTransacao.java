package client.banco.conta;

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
public class JanelaEscolheTransacao extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEscolheTransacao frame = new JanelaEscolheTransacao();
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
	public JanelaEscolheTransacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_realizarSaque = new JButton("REALIZAR SAQUE");
		btn_realizarSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaRealizarSaque.class);
			}
		});
		btn_realizarSaque.setBounds(66, 66, 321, 23);
		contentPane.add(btn_realizarSaque);

		JButton btn_realizarTrasferencia = new JButton("REALIZAR TRANSFERENCIA");
		btn_realizarTrasferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaRealizarTranferencia.class);
			}
		});
		btn_realizarTrasferencia.setBounds(66, 100, 321, 23);
		contentPane.add(btn_realizarTrasferencia);

		JButton btn_realizarDeposito = new JButton("REALIZAR DEPOSITO");
		btn_realizarDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirJanela.abrirJanela(JanelaRealizarDeposito.class);
			}
		});
		btn_realizarDeposito.setBounds(66, 134, 321, 23);
		contentPane.add(btn_realizarDeposito);

		JLabel lbl_titulo = new JLabel("ESCOLHE TRANSACAO");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(166, 11, 143, 14);
		contentPane.add(lbl_titulo);

	}
}