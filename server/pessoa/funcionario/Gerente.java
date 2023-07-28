package server.pessoa.funcionario;

import java.util.Calendar;

import server.Endereco;
import server.banco.Agencia;

public class Gerente extends Funcionario {

	private static final long serialVersionUID = 1L;

	private int ingressoGerente;
	private int cursoGerente;
	private Agencia refAgencia;
	private static double bonificacao = 150;

	public Gerente(String cpf, String nomeCompleto, String dataNascimento, Endereco refEndereco, int estadoCivil,
			String dataAdmissao, int sexo, String cargoEmpresa, int ingressoGerente, int cursoGerente,
			Agencia refAgencia, double salarioBase) {
		super(cpf, nomeCompleto, dataNascimento, refEndereco, estadoCivil, dataAdmissao, sexo, cargoEmpresa);
		setIngressoGerente(ingressoGerente);
		setCursoGerente(cursoGerente);
		setRefAgencia(refAgencia);
	}

	public Gerente(String cpf, String nomeCompleto, String dataNascimento, Endereco refEndereco, int estadoCivil,
			String dataAdmissao, int sexo, String cargoEmpresa, int ingressoGerente, int cursoGerente) {
		super(cpf, nomeCompleto, dataNascimento, refEndereco, estadoCivil, dataAdmissao, sexo, cargoEmpresa);
		setIngressoGerente(ingressoGerente);
		setCursoGerente(cursoGerente);
	}

	public int getIngressoGerente() {
		return ingressoGerente;
	}

	public void setIngressoGerente(int ingressoGerente) {
		this.ingressoGerente = ingressoGerente;
	}

	public Agencia getRefAgencia() {
		return refAgencia;
	}

	public void setRefAgencia(Agencia refAgencia) {
		this.refAgencia = refAgencia;
	}

	public String getCursoGerente() {
		if (this.cursoGerente == 1) {
			return "Sim";
		}
		if (this.cursoGerente == 2) {
			return "Nao";
		} else
			return "ERRO!";
	}

	public boolean setCursoGerente(int cursoGerente) {
		switch (cursoGerente) {
			case 1:
				this.cursoGerente = 1;
				break;
			case 2:
				this.cursoGerente = 2;
				break;
			default:
				return false;
		}
		return true;
	}

	public static double getBonificacao() {
		return bonificacao;
	}

	public static boolean setBonificacao(double bonificacao) {
		if (bonificacao > 0) {
			Gerente.bonificacao = bonificacao;
			return true;
		} else
			return false;
	}

	public double calcularSalario() {
		Calendar hoje = Calendar.getInstance();
		double salarioGerente = 0;
		double anosGerente = 0;
		anosGerente = hoje.get(Calendar.YEAR) - this.getIngressoGerente();
		salarioGerente = super.getSalarioBase() + bonificacao * anosGerente;
		return salarioGerente;
	}

	public String mostrarDados() {
		return super.getCPF() + "\n" + super.getNomeCompleto() + "\n" + super.getDataNascimento() + "\n" +
				super.getEstadoCivil() + "\n" + super.getCargoEmpresa() + "\n" + super.getDataAdmissao() + "\n" +
				super.getSexo() + "\n" + Funcionario.getSalarioBase() + "\n" + this.ingressoGerente + "\n" +
				this.cursoGerente + "\n" + bonificacao;
	}

}
