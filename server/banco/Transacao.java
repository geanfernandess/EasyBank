package server.banco;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Transacao {

	private Date dataTransacao;
	private Agencia refAgencia;
	private double valorTransacao;
	private String idTransacao;
	private char tipoTransacao;
	private Conta refConta;

	public Transacao(Agencia refAgencia, double valorTransacao, char tipoTransacao, Conta refConta) {
		setRefAgencia(refAgencia);
		setValorTransacao(valorTransacao);
		setTipoTransacao(tipoTransacao);
		setRefConta(refConta);
	}

	public Conta getRefConta() {
		return refConta;
	}

	public void setRefConta(Conta refConta) {
		this.refConta = refConta;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Calendar dataTransacao) {
		Calendar hoje = Calendar.getInstance();
		this.dataTransacao = hoje.getTime();
	}

	public Agencia getRefAgencia() {
		return refAgencia;
	}

	public void setRefAgencia(Agencia refAgencia) {
		this.refAgencia = refAgencia;
	}

	public double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		if (valorTransacao > 0) {
			this.valorTransacao = valorTransacao;
		}
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao() {
		this.idTransacao = UUID.randomUUID().toString();
	}

	public int getTipoTransacao() {

		return tipoTransacao;
	}

	public boolean setTipoTransacao(char tipoTransacao) {
		if (tipoTransacao == 'S') {
			this.tipoTransacao = 1;
			return true;
		}
		if (tipoTransacao == 'T') {
			this.tipoTransacao = 2;
			return true;
		}
		if (tipoTransacao == 'D') {
			this.tipoTransacao = 3;
			return true;
		} else
			return false;

	}

	public void efetivaTransacao() {
		// Saque
		if (this.getTipoTransacao() == 1 && refConta.getSaldoAtual() > 0
				&& refConta.getSaldoAtual() > this.getValorTransacao()) {
			double novoSaldo = 0;
			novoSaldo = refConta.getSaldoAtual() - this.getValorTransacao();
			refConta.setSaldoAtual(novoSaldo);
			refConta.setTipoTransacao("Saque");
			refConta.setIdTransacao(UUID.randomUUID().toString());
		}
		// Transferencia
		if (this.getTipoTransacao() == 2 && refConta.getSaldoAtual() > 0
				&& refConta.getSaldoAtual() > this.getValorTransacao()) {
			double novoSaldo = 0;
			novoSaldo = refConta.getSaldoAtual() - this.getValorTransacao();
			refConta.setSaldoAtual(novoSaldo);
			refConta.setTipoTransacao("Tranferencia");
			refConta.setIdTransacao(UUID.randomUUID().toString());

		}
		// Deposito
		if (this.getTipoTransacao() == 3 && this.getValorTransacao() > 0) {
			double novoSaldo = 0;
			novoSaldo = refConta.getSaldoAtual() + this.getValorTransacao();
			refConta.setSaldoAtual(novoSaldo);
			refConta.setTipoTransacao("Deposito");
			refConta.setIdTransacao(UUID.randomUUID().toString());
		}

	}
}
