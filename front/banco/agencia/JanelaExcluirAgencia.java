package front.banco.agencia;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.banco.DadosAgencias;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class JanelaExcluirAgencia extends JFrame {

	private JPanel contentPane;
	private JTextField c_nroAgencia;
	private JLabel lbl_resultado = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaExcluirAgencia frame = new JanelaExcluirAgencia();
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
	public JanelaExcluirAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbL_titulo = new JLabel("EXCLUIR AG�NCIA");
		lbL_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbL_titulo.setBounds(186, 11, 99, 14);
		contentPane.add(lbL_titulo);
		
		JLabel lbl_CPF = new JLabel("Digite o numero da agencia:");
		lbl_CPF.setBounds(20, 64, 203, 14);
		contentPane.add(lbl_CPF);
		
		c_nroAgencia = new JTextField();
		c_nroAgencia.setBounds(215, 61, 170, 20);
		contentPane.add(c_nroAgencia);
		c_nroAgencia.setColumns(10);
		
		JButton btn_excluir = new JButton("EXCLUIR");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nroAgencia = Integer.parseInt(c_nroAgencia.getText());
				
				if (DadosAgencias.buscar(nroAgencia) == null) {
					lbl_resultado.setText("Agencia n�o encontrada ");
				}
				
				if (DadosAgencias.buscar(nroAgencia) != null) {
					DadosAgencias.excluir(nroAgencia);
					lbl_resultado.setText("Agencia excluida com sucesso");
				}
				
			}
		});
		btn_excluir.setBounds(186, 218, 89, 23);
		contentPane.add(btn_excluir);
		
		JLabel lbl_status = new JLabel("Status exclusao:");
		lbl_status.setBounds(20, 124, 128, 14);
		contentPane.add(lbl_status);
		
		lbl_resultado.setBounds(192, 124, 260, 14);
		contentPane.add(lbl_resultado);
	}
}
