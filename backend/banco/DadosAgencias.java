package backend.banco;
import java.util.ArrayList;

import backend.pessoa.Persist;
import backend.pessoa.funcionario.DadosFuncionarios;
import backend.pessoa.funcionario.Gerente;

@SuppressWarnings("unchecked")
public class DadosAgencias {
		
	private static ArrayList<Agencia> agencias;
	static{ agencias = (ArrayList<Agencia>)Persist.recuperar("agencias.dat");
		if (agencias == null)
			agencias = new ArrayList<Agencia>();
	}

	public static void cadastrar(Agencia a){
		agencias.add(a);
		Persist.gravar(agencias, "agencias.dat");
	}
		
	public static ArrayList<Agencia> getAgencias() {
		return agencias;
	}

	public static String mostrarDados() {
		String a = null;
		for (Agencia objeto: agencias) {
			if (objeto != null) {
				a += (objeto.mostrarDados() + "\n\n");
			}
		}
		return a;
	}
	
	public static Agencia buscar(int nunAgencia) {
		Agencia c = null;
		for (Agencia objeto: agencias) {
			if (objeto.getNumerodaAgencia() == nunAgencia) {
				c = objeto;
				System.out.println("\n" + c);
				break;
			}
		} return c;
	}
	
	public static boolean alterarGerente(int nunAgencia, String cpf){
		Agencia c = buscar(nunAgencia);
			if (c != null) {
				c.setRefGerente(((Gerente)DadosFuncionarios.buscar(cpf)));
				Persist.gravar(agencias, "agencias.dat");
				return true;
		} 
			else 
				return false;
	}
	
	public static boolean excluir(int nunAgencia){
		Object c = buscar(nunAgencia);
			if (c != null) {
				agencias.remove(c);
				Persist.gravar(agencias, "agencias.dat");
				return true;
		} 
			else 
				return false;
	}

	public static void apagarTodos() {
		agencias.clear();
		Persist.gravar(agencias, "agencias.dat");
	}	

}	