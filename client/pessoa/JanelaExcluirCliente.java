package client.pessoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.pessoa.cliente.DadosClientes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class JanelaExcluirCliente extends JFrame {

	private JPanel contentPane;
	private JTextField c_cpf;
	private JLabel lbl_resultado = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaExcluirCliente frame = new JanelaExcluirCliente();
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
	public JanelaExcluirCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbL_titulo = new JLabel("Excluir Cliente");
		lbL_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbL_titulo.setBounds(186, 11, 99, 14);
		contentPane.add(lbL_titulo);

		JLabel lbl_CPF = new JLabel("Digite o CPF:");
		lbl_CPF.setBounds(29, 64, 99, 14);
		contentPane.add(lbl_CPF);

		c_cpf = new JTextField();
		c_cpf.setBounds(164, 61, 199, 20);
		contentPane.add(c_cpf);
		c_cpf.setColumns(10);

		JButton btn_excluir = new JButton("EXCLUIR");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (DadosClientes.buscar(c_cpf.getText()) == null) {
					lbl_resultado.setText("Cliente n�o encontrada ");
				}

				if (DadosClientes.buscar(c_cpf.getText()) != null) {
					DadosClientes.excluir(c_cpf.getText());
					lbl_resultado.setText("Cliente excluido com sucesso");
				}

			}
		});
		btn_excluir.setBounds(186, 218, 89, 23);
		contentPane.add(btn_excluir);

		JLabel lbl_status = new JLabel("Status exclusao:");
		lbl_status.setBounds(29, 123, 106, 14);
		contentPane.add(lbl_status);

		lbl_resultado.setBounds(164, 123, 252, 14);
		contentPane.add(lbl_resultado);
	}
}
