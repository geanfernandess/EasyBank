package server.banco;

import java.util.Date;

import server.pessoa.cliente.Cliente;

public class Salario extends Conta {

	private static final long serialVersionUID = 1L;

	private final double saldoMinino = 100;
	private double tarifa;

	public Salario(Integer codigo, String flagueAtiva, Integer senha, Integer numeroConta, double saldoAtual,
			Date dataAbertura, Agencia agencia, Cliente cliente) {
		super(codigo, flagueAtiva, senha, numeroConta, saldoAtual, dataAbertura, agencia, cliente);
	}

	public double getSaldoMinino() {
		return saldoMinino;
	}

	public double calculaTarifa() {
		this.tarifa = super.getSaldoAtual() * 0.001;
		return this.tarifa;
	}

	public String mostrarDados() {
		return super.getCodigo() + "\n" + super.getFlagueAtiva() + "\n" + super.getSenha() + "\n" +
				super.getNumeroConta() + "\n" + super.getSaldoAtual() + super.getDataAbertura() + "\n" +
				super.getAgenciaConta() + "\n" + this.getSaldoMinino();
	}

}
