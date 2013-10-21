package entidades;

import entidades.Caixa;
import entidades.Medicamento;

public class Balconista extends Pessoa{

	//Declaracao de atributos
	
	protected int senha;
	protected int senhaFarmaciaPopular;
	protected int codigo; //O funcionario usa o codigo de acesso junto da senha para fazer as vendas.
	protected int fatorComissao;
	protected Medicamento[] medicamentos = {};
	protected Caixa caixa;
	private static boolean statusBalconista;
	protected int horas;
	protected int quantidade=0;
	//Utilizacao de STATIC para dependência
	
	public Balconista(){}
	
	public Balconista(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,
			int senhaBalconista, int senhaFarmaciaPopularBalconista, int codigoBalconista, int fatorComissaoBalconista, int horasTrabalhadas) {
		//Utilização por herança, pegando os atributos através do super
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		this.senha=senhaBalconista;
		this.senhaFarmaciaPopular=senhaFarmaciaPopularBalconista;
		this.codigo=codigoBalconista;
		this.fatorComissao=fatorComissaoBalconista;
		this.horas=horasTrabalhadas;
		
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
		System.out.println("Os medicamentos vendidos pelo funcionario" + getNome() + "foram:");
		for(int i=0; (i < medicamentos.length); i++){
			quantidade++;
			System.out.println(quantidade);
			System.out.println(medicamentos[i].nome);
		}
	}
	
	//Utilizacao da clasase abstrata
	public double calcularSalario(){
		double comissao = this.fatorComissao;
		double horasTrabalhadas = this.horas;
		double salario = 75 + horasTrabalhadas*comissao;
		this.setSalario(salario);
		return salario;
	}
	
	private void setSalario(double salario) {
		// TODO Auto-generated method stub
		
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

	public void Caixa () {
		//Caixa depende de funcionario
		Caixa caixa = new Caixa();
		this.caixa = caixa;
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

	public static boolean isStatusBalconista() {
		return statusBalconista;
	}

	public static void setStatusBalconista(boolean statusFuncionarioPresente) {
		Balconista.statusBalconista = statusFuncionarioPresente;
		System.out.println("Há um funcionário disponível para atendê-lo! Status:" + statusBalconista);
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}


}
	

