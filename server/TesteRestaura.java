package server;

import java.util.ArrayList;

import server.banco.Agencia;
import server.banco.Conta;
import server.pessoa.Persist;
import server.pessoa.cliente.Cliente;

public class TesteRestaura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		{
			@SuppressWarnings("unchecked")
			ArrayList<Cliente> clientes = (ArrayList<Cliente>) Persist.recuperar("clientes.dat");

			int i = 1;
			for (Cliente item : clientes) {
				System.out.printf("Cliente numero: %d.\n", i++);
				System.out.println(item.getCPF() + "\n" + item.getNomeCompleto() + "\n" + item.getDataNascimento()
						+ "\n" + item.getEstadoCivil() + "\nEscolaridade: " + item.getEscolaridade() + "\n"
						+ item.getRefEndereco().getCidade() + "\n");
			}
		}

		{
			@SuppressWarnings("unchecked")
			ArrayList<Conta> contas = (ArrayList<Conta>) Persist.recuperar("contas.dat");

			int i = 1;
			for (Conta item : contas) {
				System.out.printf("Conta numero: %d.\n", i++);
				System.out.println(item.getCodigo() + "\nNumero Agencia: " + item.getAgenciaConta().getNumerodaAgencia()
						+ "\n" + item.getFlagueAtiva() + "\nNumero Conta: " + item.getNumeroConta()
						+ "\nSenha: " + item.getSenha() + "\n" + item.getSaldoAtual() + "\n" + item.getDataAbertura()
						+ "\n" + item.getTipoTransacao() + "\n" + item.getIdTransacao() + "\n"
						+ item.getAgenciaConta().getNomeAg()
						+ "\n" + item.getCliente().get(0).getNomeCompleto() + "\n");
			}
		}

		// System.out.println(DadosFuncionarios.getFuncionarios());
		{
			@SuppressWarnings("unchecked")
			ArrayList<Agencia> agencias = (ArrayList<Agencia>) Persist.recuperar("agencias.dat");

			int i = 1;
			for (Agencia item : agencias) {
				System.out.printf("Agencia numero: %d.\n", i++);
				System.out.println(item.getNomeAg() + "\n" + item.getNumerodaAgencia()
						+ "\n" + item.getRefGerente().getNomeCompleto() + "\n" + item.getRefEndereco().getRua() + "\n");
			}
		}
		/*
		 * {
		 * 
		 * @SuppressWarnings("unchecked")
		 * ArrayList<Funcionario> funcionarios =
		 * (ArrayList<Funcionario>)Persist.recuperar("funcionarios.dat");
		 * 
		 * int i = 1;
		 * for (Funcionario item: funcionarios) {
		 * System.out.printf("Funcionario numero: %d.\n", i++);
		 * System.out.println(item.getNomeCompleto()+ "\n" + item.getCPF()+ "\n" +
		 * item.getEstadoCivil()
		 * + "\n" + item.getSexo()+ "\n" + item.getCargoEmpresa() + "\n" +
		 * item.getDataAdmissao()+ "\n" );
		 * }
		 * }
		 */

	}

}
