package backend.pessoa.funcionario;

import backend.Endereco;
import backend.pessoa.Pessoa;

public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String dataAdmissao;
	private byte sexo;
	private String cargoEmpresa;
	private static final double salarioBase = 2500;

	public Funcionario(String cpf, String nomeCompleto, String dataNascimento, Endereco refEndereco, int estadoCivil,
			String dataAdmissao, int sexo, String cargoEmpresa) {
		super(cpf, nomeCompleto, dataNascimento, refEndereco, estadoCivil);
		setDataAdmissao(dataAdmissao);
		setSexo(sexo);
		setCargoEmpresa(cargoEmpresa);
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getSexo() {
		if (this.sexo == 1) {
			return "Masculino";
		}
		if (this.sexo == 2) {
			return "Feminino";
		} else
			return "ERRO!";
	}

	public boolean setSexo(int sexo) {
		switch (sexo) {
			case 1:
				this.sexo = 1;
				break;
			case 2:
				this.sexo = 2;
				break;
			default:
				return false;
		}
		return true;
	}

	public String getCargoEmpresa() {
		return cargoEmpresa;
	}

	public boolean setCargoEmpresa(String cargoEmpresa) {
		if (cargoEmpresa.length() > 0) {
			this.cargoEmpresa = cargoEmpresa;
			return true;
		} else
			return false;
	}

	public static double getSalarioBase() {
		return salarioBase;
	}

	public double calcularSalario() {
		return salarioBase;
	}

	public String mostrarDados() {
		return super.getCPF() + "\n" + super.getNomeCompleto() + "\n" +
				super.getDataNascimento() + "\n" + super.getEstadoCivil() + "\n" +
				this.cargoEmpresa + "\n" + this.dataAdmissao + "\n" + this.sexo + "\n" +
				Funcionario.getSalarioBase();
	}
}
