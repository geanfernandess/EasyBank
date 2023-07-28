package front.banco.agencia;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.banco.DadosAgencias;
import backend.pessoa.funcionario.DadosFuncionarios;

@SuppressWarnings({ "serial", "unused" })
public class JanelaAlterarDadosAgencia extends JFrame {

	private JPanel contentPane;
	private JTextField c_nroAgencia;
	private JLabel lbl_resultado = new JLabel();
	private JTextField c_cpfGerente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAlterarDadosAgencia frame = new JanelaAlterarDadosAgencia();
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
	public JanelaAlterarDadosAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbL_titulo = new JLabel("ALTERAR GERENTE");
		lbL_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbL_titulo.setBounds(175, 11, 164, 14);
		contentPane.add(lbL_titulo);
		
		JLabel lbl_nroAgencia = new JLabel("Numero da agencia:");
		lbl_nroAgencia.setBounds(20, 64, 143, 14);
		contentPane.add(lbl_nroAgencia);
		
		c_nroAgencia = new JTextField();
		c_nroAgencia.setBounds(173, 61, 189, 20);
		contentPane.add(c_nroAgencia);
		c_nroAgencia.setColumns(10);
		
		JButton btn_alterar = new JButton("ALTERAR");
		btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nroAgencia = Integer.parseInt(c_nroAgencia.getText());
				
				if (DadosAgencias.buscar(nroAgencia) == null) {
					lbl_resultado.setText("Agencia n�o encontrada ");
				}
				
				if (DadosFuncionarios.buscar(c_cpfGerente.getText()) == null) {
					lbl_resultado.setText("Gerente n�o encontrada ");
				}
				
				if (DadosAgencias.buscar(nroAgencia) != null && DadosFuncionarios.buscar(c_cpfGerente.getText()) != null) {
					DadosAgencias.alterarGerente(nroAgencia, c_cpfGerente.getText());
					lbl_resultado.setText("Gerente alterado com sucesso");
				}
				
			}
		});
		btn_alterar.setBounds(175, 167, 89, 23);
		contentPane.add(btn_alterar);
		
		JLabel lbl_status = new JLabel("Status alteracao:");
		lbl_status.setBounds(20, 126, 128, 14);
		contentPane.add(lbl_status);
		
		lbl_resultado.setBounds(175, 126, 260, 14);
		contentPane.add(lbl_resultado);
		
		JLabel lbl_cpfGerente = new JLabel("CPF novo gerente:");
		lbl_cpfGerente.setBounds(20, 92, 133, 14);
		contentPane.add(lbl_cpfGerente);
		
		c_cpfGerente = new JTextField();
		c_cpfGerente.setColumns(10);
		c_cpfGerente.setBounds(173, 89, 189, 20);
		contentPane.add(c_cpfGerente);
	}
}
