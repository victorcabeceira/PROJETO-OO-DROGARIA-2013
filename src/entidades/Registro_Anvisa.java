package entidades;

public class Registro_Anvisa extends Medicamento {

	protected String registro;
	
	public Registro_Anvisa() {}

	public Registro_Anvisa(String nomeProduto, String fabricanteProduto,
			String recomendacaoProduto, String validadeProduto,
			String tipoMedicamento, String posologiaMedicamento) {
		super(nomeProduto, fabricanteProduto, recomendacaoProduto,
				validadeProduto, tipoMedicamento, posologiaMedicamento);
		
	}

}
