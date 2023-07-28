package backend;
import java.io.Serializable;

public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;

	public Endereco(String estado, String cidade, String bairro , String rua, String numero) {
		setEstado(estado);
		setCidade(cidade);
		setBairro(bairro);
		setRua(rua);
		setNumero(numero);
	}
	
	public String getEstado() {
		return estado;
	}
	public boolean setEstado(String data) {
		if (data.length() > 0) {
			this.estado = data;
			return true;
		}
		else
			return false;
	}

	public String getCidade() {
		return cidade;
	}
	
	public boolean setCidade(String data) {
		if (data.length() > 0) {
			this.cidade = data;
			return true;
		}
		else
			return false;
	}

	public String getBairro() {
		return bairro;
	}
	
	public boolean setBairro(String data) {
		if (data.length() > 0) {
			this.bairro = data;
			return true;
		}
		else
			return false;
	}

	public String getRua() {
		return rua;
	}
	
	public boolean setRua(String data) {
		if (data.length() > 0) {
			this.rua = data;
			return true;
		}
		else
			return false;
	}

	public String getNumero() {
		return numero;
	}
	public boolean setNumero(String data) {
		if (data.length() > 0) {
			this.numero = data;
			return true;
		}
		else
			return false;
	}
}