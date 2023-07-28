package backend.banco;
import java.util.Date;

import backend.pessoa.cliente.Cliente;

public class Poupanca extends Conta {
	
	private static final long serialVersionUID = 1L;
	
	private final double rendimentoMensal = 0.005;
	private static double tarifa = 12.50; // Valor para conta poupanca

	public Poupanca (Integer codigo, String flagueAtiva, Integer senha, Integer numeroConta, double saldoAtual, Date dataAbertura, Agencia agencia, Cliente cliente) {
		super(codigo, flagueAtiva, senha, numeroConta, saldoAtual, dataAbertura, agencia, cliente);
	}
	
	public double getRendimentoMensal() {
		return rendimentoMensal;
	}
	
	public double calculaRendimento() {
		double novoValor = 0;
		novoValor = super.getSaldoAtual() * this.rendimentoMensal;
		return super.setSaldoAtual(novoValor);
	}

	
	public double calculaTarifa() {
		return Poupanca.tarifa;
	}
	
	public String mostrarDados() {
		return super.getCodigo() + "\n" + super.getFlagueAtiva() + "\n" + super.getSenha() + "\n" + 
			   super.getNumeroConta() + "\n" + super.getSaldoAtual() + super.getDataAbertura() + "\n" + 
			   super.getAgenciaConta() + "\n" + this.getRendimentoMensal();
	}

}

