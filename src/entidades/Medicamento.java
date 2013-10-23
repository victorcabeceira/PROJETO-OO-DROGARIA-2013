package entidades;

public class Medicamento extends Produto {
	
	protected String tipo; //Comprimidos, liquido, etc
	protected String posologia;
	protected Registro_Anvisa registro;
	
	public Medicamento (){}
	
	
	public Medicamento(String nomeProduto, String fabricanteProduto, String recomendacaoProduto, String validadeProduto, String tipoMedicamento, String posologiaMedicamento) {
		super(nomeProduto,fabricanteProduto,recomendacaoProduto,validadeProduto);
		this.tipo = tipoMedicamento;
		this.posologia= posologiaMedicamento;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getPosologia() {
		return posologia;
	}


	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}


	public Registro_Anvisa getRegistro() {
		return registro;
	}


	public void setRegistro(Registro_Anvisa registro) {
		this.registro = registro;
	}
	
	
	
}