package server.pessoa.funcionario;

import java.util.ArrayList;

import server.pessoa.Persist;

@SuppressWarnings("unchecked")
public class DadosFuncionarios {

	private static ArrayList<Funcionario> funcionarios;
	static {
		funcionarios = (ArrayList<Funcionario>) Persist.recuperar("funcionarios.dat");
		if (funcionarios == null)
			funcionarios = new ArrayList<Funcionario>();
	}

	public static boolean cadastrar(Funcionario f) {
		funcionarios.add(f);
		Persist.gravar(funcionarios, "funcionarios.dat");
		return true;
	}

	public static ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public static String mostrarDados() {
		String f = null;
		for (Funcionario objeto : funcionarios) {
			if (objeto != null) {
				f += (objeto.mostrarDados() + "\n\n");
			}
		}
		return f;
	}

	public static Funcionario buscar(String cpf) {
		Funcionario f = null;
		for (Funcionario objeto : funcionarios) {
			if (objeto.getCPF().equals(cpf)) {
				f = objeto;
				System.out.println("\n" + f);
				break;
			}
		}
		return f;
	}

	public static boolean alterarCargo(String cpf, String novoCargo) {
		Funcionario f = buscar(cpf);
		if (f != null) {
			f.setCargoEmpresa(novoCargo);
			Persist.gravar(funcionarios, "funcionarios.dat");
			return true;
		} else
			return false;
	}

	public static boolean excluir(String cpf) {
		Funcionario c = buscar(cpf);
		if (c != null) {
			funcionarios.remove(c);
			Persist.gravar(funcionarios, "funcionarios.dat");
			return true;
		} else
			return false;
	}

	public static void apagarTodos() {
		funcionarios.clear();
		Persist.gravar(funcionarios, "funcionarios.dat");
	}

}