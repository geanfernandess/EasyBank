package server.banco;

import java.util.Date;

import server.pessoa.cliente.Cliente;

public class Corrente extends Conta {

	private static final long serialVersionUID = 1L;

	private final double limChequeEspecial = 300;
	private final double taxaAdm = 25;
	private double tarifa;
	private int categoria;

	public Corrente(Integer codigo, String flagueAtiva, Integer senha, Integer numeroConta, double saldoAtual,
			Date dataAbertura, Agencia agencia, Cliente cliente, int categoria) {
		super(codigo, flagueAtiva, senha, numeroConta, saldoAtual, dataAbertura, agencia, cliente);
		setCategoria(categoria);
	}

	public double getLimChequeEspecial() {
		return limChequeEspecial;
	}

	public double getTaxaAdm() {
		return taxaAdm;
	}

	public double utilizarChequeEspecial() {
		double novoValor = 0;
		novoValor = super.getSaldoAtual() + this.limChequeEspecial;
		return super.setSaldoAtual(novoValor);
	}

	public double cobrarTaxaAdm() {
		double novoValor = 0;
		novoValor = super.getSaldoAtual() - this.taxaAdm;
		return super.setSaldoAtual(novoValor);
	}

	public String getCategoria() {
		if (this.categoria == 1) {
			return "Standard";
		}
		if (this.categoria == 2) {
			return "Premiun";
		}
		return "ERRO";
	}

	public boolean setCategoria(int categoria) {
		if (categoria == 1) {
			this.categoria = 1;
			tarifa = 15; // Valor para conta corrente Standard
			return true;
		}
		if (categoria == 2) {
			this.categoria = 2;
			tarifa = 25; // Valor para conta corrente Premiun
			return true;
		} else
			return false;
	}

	public double calculaTarifa() {
		return this.tarifa;
	}

	public String mostrarDados() {
		return super.getCodigo() + "\n" + super.getFlagueAtiva() + "\n" + super.getSenha() + "\n" +
				super.getNumeroConta() + "\n" + super.getSaldoAtual() + super.getDataAbertura() + "\n" +
				super.getAgenciaConta() + "\n" + this.getLimChequeEspecial() + "\n" + this.getTaxaAdm() + "\n" +
				this.getCategoria();
	}
}
