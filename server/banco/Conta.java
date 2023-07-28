package server.banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import server.pessoa.cliente.Cliente;

public abstract class Conta implements Serializable, ImprimeDados {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private byte flagueAtiva;
	private Integer senha;
	private Integer numeroConta;
	private double saldoAtual;
	private Date dataAbertura;
	private Agencia refAgencia;

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Transacao> refTransacao = new ArrayList<Transacao>();
	private ArrayList<String> tipoTransacao = new ArrayList<>();
	private ArrayList<String> idTransacao = new ArrayList<>();

	public Conta(Agencia refAgencia) {
		setAgenciaConta(refAgencia);
	}

	public Conta(Integer codigo, String flagueAtiva, Integer senha, Integer numeroConta, double saldoAtual,
			Date dataAbertura, Agencia agencia, Cliente cliente) {
		setCodigo(codigo);
		setFlagueAtiva(flagueAtiva);
		setSenha(senha);
		setNumeroConta(numeroConta);
		setSaldoAtual(saldoAtual);
		setDataAbertura(dataAbertura);
		setAgenciaConta(agencia);
		setCliente(cliente);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public boolean setCodigo(Integer data) {
		if (data > 0) {
			this.codigo = data;
			return true;
		} else
			return false;
	}

	public String getFlagueAtiva() {
		if (this.flagueAtiva == 1) {
			return "Ativa";
		}
		if (this.flagueAtiva == 2) {
			return "Inativa";
		}
		if (this.flagueAtiva == 3) {
			return "Analise";
		}
		return "ERRO";
	}

	public boolean setFlagueAtiva(String data) {
		switch (data) {
			case "A":
				this.flagueAtiva = 1;
				break;
			case "I":
				this.flagueAtiva = 2;
				break;
			case "N":
				this.flagueAtiva = 3;
				break;
			default:
				return false;
		}
		return true;
	}

	public Integer getSenha() {
		return senha;
	}

	public boolean setSenha(Integer data) {
		if (data > 0) {
			this.senha = data;
			return true;
		} else
			return false;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public boolean setNumeroConta(Integer numeroConta) {
		if (numeroConta > 0) {
			this.numeroConta = numeroConta;
			return true;
		} else
			return false;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public double setSaldoAtual(double saldoAtual) {
		if (saldoAtual > 0) {
			this.saldoAtual = saldoAtual;
		}
		return this.saldoAtual;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Agencia getAgenciaConta() {
		return refAgencia;
	}

	public void setAgenciaConta(Agencia data) {
		this.refAgencia = data;
	}

	public ArrayList<Cliente> getCliente() {
		return clientes;
	}

	public boolean setCliente(Cliente data) {
		if (clientes.size() < 2) {
			clientes.add(data);
			return true;
		} else
			return false;
	}

	public ArrayList<Transacao> getRefTransacao() {
		return refTransacao;
	}

	public void setRefTransacao(Transacao data) {
		refTransacao.add(data);
	}

	public ArrayList<String> getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipo) {
		tipoTransacao.add(tipo);
	}

	public ArrayList<String> getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String id) {
		idTransacao.add(id);
	}

	public String mostrarDados() {
		return this.getCodigo() + "\n" + this.getFlagueAtiva() + "\n" + this.getSenha() + "\n" +
				this.getNumeroConta() + "\n" + this.getSaldoAtual() + "\n" + this.getDataAbertura() + "\n" +
				this.getAgenciaConta() + "\n" + this.getCliente() + "\n" + this.getRefTransacao() + "\n" +
				this.getTipoTransacao() + "\n" + this.getIdTransacao();
	}

	public abstract double calculaTarifa();

}
