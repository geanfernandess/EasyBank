package server.pessoa.cliente;

import java.util.ArrayList;

import server.pessoa.Persist;

@SuppressWarnings("unchecked")
public class DadosClientes {

	private static ArrayList<Cliente> clientes;
	static {
		clientes = (ArrayList<Cliente>) Persist.recuperar("clientes.dat");
		if (clientes == null)
			clientes = new ArrayList<Cliente>();
	}

	public static void cadastrar(Cliente c) {
		clientes.add(c);
		Persist.gravar(clientes, "clientes.dat");
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static String mostrarDados() {
		String c = null;
		for (Cliente objeto : clientes) {
			if (objeto != null) {
				c += (objeto.mostrarDados() + "\n\n");
			}
		}
		return c;
	}

	public static Cliente buscar(String cpf) {
		Cliente c = null;
		for (Cliente objeto : clientes) {
			if (objeto.getCPF().equals(cpf)) {
				c = objeto;
				System.out.println("\n" + c);
				break;
			}
		}
		return c;
	}

	public static boolean alterarEscolaridade(String cpf, String escolaridade) {
		Cliente c = buscar(cpf);
		if (c != null) {
			c.setEscolaridade(escolaridade);
			Persist.gravar(clientes, "clientes.dat");
			return true;
		} else
			return false;
	}

	public static boolean excluir(String cpf) {
		Cliente c = buscar(cpf);
		if (c != null) {
			clientes.remove(c);
			Persist.gravar(clientes, "clientes.dat");
			return true;
		} else
			return false;
	}

	public static void apagarTodos() {
		clientes.clear();
		Persist.gravar(clientes, "clientes.dat");
	}

}