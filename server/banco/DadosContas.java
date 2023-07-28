package server.banco;

import java.util.ArrayList;

import server.pessoa.Persist;

@SuppressWarnings("unchecked")
public class DadosContas {

	private static ArrayList<Conta> contas;
	static {
		contas = (ArrayList<Conta>) Persist.recuperar("contas.dat");
		if (contas == null)
			contas = new ArrayList<Conta>();
	}

	public static void cadastrar(Conta c) {
		contas.add(c);
		Persist.gravar(contas, "contas.dat");
	}

	public static ArrayList<Conta> getContas() {
		return contas;
	}

	public static String mostrarDados() {
		String c = null;
		for (Conta objeto : contas) {
			if (objeto != null) {
				c += (objeto.mostrarDados() + "\n\n");
			}
		}
		return c;
	}

	public static Conta buscar(int nunConta) {
		Conta c = null;
		for (Conta objeto : contas) {
			if (objeto.getNumeroConta() == nunConta) {
				c = objeto;
				System.out.println("\n" + c);
				break;
			}
		}
		return c;
	}

	public static boolean atualizarSaldo(int nunConta) {
		Conta c = buscar(nunConta);
		if (c != null) {
			c.setSaldoAtual(c.getSaldoAtual());
			Persist.gravar(contas, "contas.dat");
			return true;
		} else
			return false;
	}

	public static void mudarStatus(int nunConta, String statusConta) {
		Conta c = buscar(nunConta);
		if (c != null) {
			switch (statusConta) {
				case "A":
					c.setFlagueAtiva("A");
					break;
				case "I":
					c.setFlagueAtiva("I");
					break;
				case "N":
					c.setFlagueAtiva("N");
					break;
			}
			Persist.gravar(contas, "contas.dat");
		}
	}
}