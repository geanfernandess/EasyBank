package backend.banco;

import java.io.Serializable;

import backend.Endereco;
import backend.banco.ImprimeDados;
import backend.pessoa.funcionario.Gerente;

public class Agencia implements Serializable, ImprimeDados {

	private static final long serialVersionUID = 1L;

	private int numerodaAgencia;
	private String nomeAg;
	private Gerente refGerente;
	private Endereco refEndereco;

	public Agencia(int numerodaAgencia, String nomeAg, Gerente refGerente, Endereco refEndereco) {
		setNumerodaAgencia(numerodaAgencia);
		setNomeAg(nomeAg);
		setRefGerente(refGerente);
		setRefEndereco(refEndereco);
	}

	public int getNumerodaAgencia() {
		return numerodaAgencia;
	}

	public boolean setNumerodaAgencia(int numerodaAgencia) {
		if (numerodaAgencia > 0) {
			this.numerodaAgencia = numerodaAgencia;
			return true;
		} else
			return false;
	}

	public String getNomeAg() {
		return nomeAg;
	}

	public boolean setNomeAg(String nomeAg) {
		if (nomeAg.length() > 0) {
			this.nomeAg = nomeAg;
			return true;
		} else
			return false;
	}

	public Gerente getRefGerente() {
		return refGerente;
	}

	public void setRefGerente(Gerente refGerente) {
		this.refGerente = refGerente;
	}

	public Endereco getRefEndereco() {
		return refEndereco;
	}

	public void setRefEndereco(Endereco refEndereco) {
		this.refEndereco = refEndereco;
	}

	public String mostrarDados() {
		return this.getNumerodaAgencia() + "\n" + this.getNomeAg() + "\n" +
				this.getRefGerente().getNomeCompleto() + "\n" + this.getRefEndereco().getCidade();
	}

}
