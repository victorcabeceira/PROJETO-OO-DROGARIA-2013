package entidades;

import entidades.Registro;

public class Medicamento extends Produto {
	
	protected String tipo; //Comprimidos, liquido, etc
	protected String posologia;
	protected Registro registro;
	
	public Medicamento (){}
	
	
	public Medicamento(String nomeProduto, String fabricanteProduto, String recomendacaoProduto, String validadeProduto, String tipoMedicamento, String posologiaMedicamento) {
		super(nomeProduto,fabricanteProduto,recomendacaoProduto,validadeProduto);
		this.tipo = tipoMedicamento;
		this.posologia= posologiaMedicamento;
	}
	
	//Agregacao - Listagem e adicao
	public void listarRegistro(){
		System.out.println("O registro do medicamento "+ this.nome +" é:" + registro.codigo);
	}

	public void adicionarRegistro()
	{
		Registro novoRegistro = new Registro();
		novoRegistro=this.registro;
		this.setRegistro(novoRegistro);
	}//Fim Agregacao
	
	
	//Getters & Setters
	
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


	public Registro getRegistro() {
		return registro;
	}


	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	
	
	
}