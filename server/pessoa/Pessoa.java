package server.pessoa;

import java.io.Serializable;

import server.Endereco;
import server.banco.ImprimeDados;
import server.ValidaCPF;

public abstract class Pessoa implements Serializable, ImprimeDados {

	private static final long serialVersionUID = 1L;

	private String CPF;
	private String nomeCompleto;
	private String dataNascimento;
	private Endereco refEndereco;
	private int estadoCivil;

	public Pessoa(String cpf, String nomeCompleto, String dataNascimento, Endereco refEndereco, int estadoCivil) {
		setCPF(cpf);
		setNomeCompleto(nomeCompleto);
		setDataNascimento(dataNascimento);
		setRefEndereco(refEndereco);
		setEstadoCivil(estadoCivil);
	}

	public String getCPF() {
		return this.CPF;
	}

	public boolean setCPF(String data) {
		boolean istrue = ValidaCPF.isCPF(data);
		if (istrue) {
			this.CPF = data;
			return true;
		}
		return false;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public boolean setNomeCompleto(String nomeCompleto) {
		if (nomeCompleto.length() > 0) {
			this.nomeCompleto = nomeCompleto;
			return true;
		} else
			return false;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getRefEndereco() {
		return refEndereco;
	}

	public void setRefEndereco(Endereco refEndereco) {
		this.refEndereco = refEndereco;
	}

	public String getEstadoCivil() {
		if (this.estadoCivil == 1) {
			return "Solteiro";
		}
		if (this.estadoCivil == 2) {
			return "Casado";
		} else
			return "ERRO";
	}

	public boolean setEstadoCivil(int estadoCivil) {
		switch (estadoCivil) {
			case 1:
				this.estadoCivil = 1;
				break;
			case 2:
				this.estadoCivil = 2;
				break;
			default:
				return true;
		}
		return false;
	}

	public String mostrarDados() {
		return this.CPF + "\n" + this.dataNascimento + "\n" + this.estadoCivil + "\n" +
				this.nomeCompleto;
	}

}