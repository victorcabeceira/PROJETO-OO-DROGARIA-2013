package entidades;

public class Registro_Anvisa extends Medicamento {

	protected String codigo;
	protected Medicamento medicamento;
	
	public Registro_Anvisa() {}

	public Registro_Anvisa(String nomeProduto, String fabricanteProduto,
			String recomendacaoProduto, String validadeProduto,
			String tipoMedicamento, String posologiaMedicamento) {
		super(nomeProduto, fabricanteProduto, recomendacaoProduto,
				validadeProduto, tipoMedicamento, posologiaMedicamento);
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

}
