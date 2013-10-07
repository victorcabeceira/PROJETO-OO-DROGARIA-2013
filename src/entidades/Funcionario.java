package entidades;

import entidades.Caixa;
import entidades.Medicamento;

public class Funcionario extends Pessoa{

	//Declaracao de atributos
	
	protected int senha;
	protected int senhaFarmaciaPopular;
	protected int codigo; //O funcionario usa o codigo de acesso junto da senha para fazer as vendas.
	protected int fatorComissao;
	protected Medicamento[] medicamentos = {};
	protected Caixa caixa;
	
	public Funcionario(){}
	
	public Funcionario(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,
			int senhaFuncionario, int senhaFarmaciaPopularFunc, int codigoFuncionario, int fatorComissaoFuncionario) {
		//Utilização por herança, pegando os atributos através do super
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		this.senha=senhaFuncionario;
		this.senhaFarmaciaPopular=senhaFarmaciaPopularFunc;
		this.codigo=codigoFuncionario;
		this.fatorComissao=fatorComissaoFuncionario;
		
		
	}

	
	public void setMedicamentos(Medicamento[] medicamentos) {
		if(medicamentos.length < 1){
			System.out.println("O medicamento não pode ser vendido sem a identificação de 1 funcionário cadastrado no Sistema! O medicamento só poderá ser comercializado por no mínimo 1 funcionário devidamente cadastrado!");
		}
		else {
			this.medicamentos = medicamentos;
		}
	}
	
	public void verificarMedicamento(Medicamento medicamento){
		int tamanhoAntigo = this.medicamentos.length;
		
		Medicamento[] novosMedicamentos = new Medicamento[tamanhoAntigo + 1];
		for(int i=0; i < tamanhoAntigo; i++){
			novosMedicamentos[i] = this.medicamentos[i];
			
		}
		
		novosMedicamentos[novosMedicamentos.length-1] = medicamento;
		this.setMedicamentos(novosMedicamentos);
		
	}
	
	//Listar nÃºmero de medicamentos associados aos funcionÃ¡rios
	public void listarMedicamentosAssociados(){
		System.out.println("O número de medicamentos vendidos por funcionÃ¡rio Ã©: ;");
		for(int i=0; (i < medicamentos.length); i++){
			System.out.println(medicamentos[i].nome);
		}
	}
	
	public void Caixa () {
		//Caixa depende de funcionario
		Caixa caixa = new Caixa();
		this.caixa = caixa;
	}
		


	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getSenhaFarmaciaPopular() {
		return senhaFarmaciaPopular;
	}

	public void setSenhaFarmaciaPopular(int senhaFarmaciaPopular) {
		this.senhaFarmaciaPopular = senhaFarmaciaPopular;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getFatorComissao() {
		return fatorComissao;
	}

	public void setFatorComissao(int fatorComissao) {
		this.fatorComissao = fatorComissao;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Medicamento[] getMedicamentos() {
		return medicamentos;
	}


}
	

