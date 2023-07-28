package backend.pessoa.cliente;

import java.util.ArrayList;

import backend.Endereco;
import backend.banco.Agencia;
import backend.banco.Conta;
import backend.pessoa.Pessoa;

public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String escolaridade;
	private Agencia agenciaCadastro;

	private ArrayList<Conta> contas = new ArrayList<Conta>();

	public Cliente(String cpf, String nomeCompleto, String dataNascimento, Endereco refEndereco, int estadoCivil,
			String escolaridade, Agencia agenciaCadastro) {
		super(cpf, nomeCompleto, dataNascimento, refEndereco, estadoCivil);
		setEscolaridade(escolaridade);
		setAgenciaCadastro(agenciaCadastro);
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public boolean setEscolaridade(String escolaridade) {
		if (escolaridade.length() > 0) {
			this.escolaridade = escolaridade;
			return true;
		} else
			return false;
	}

	public Agencia getAgenciaCadastro() {
		return agenciaCadastro;
	}

	public void setAgenciaCadastro(Agencia agenciaCadastro) {
		this.agenciaCadastro = agenciaCadastro;
	}

	public ArrayList<Conta> getConta() {
		return contas;
	}

	public void setConta(Conta conta) {
		contas.add(conta);
	}

	public String mostrarDados() {
		return super.getCPF() + "\n" + super.getNomeCompleto() + "\n" +
				super.getDataNascimento() + "\n" + super.getEstadoCivil() + "\n" +
				this.escolaridade;
	}

}
