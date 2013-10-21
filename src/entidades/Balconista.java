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
	//Utilizacao de STATIC para depend�ncia
	
	public Balconista(){}
	
	public Balconista(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,
			int senhaBalconista, int senhaFarmaciaPopularBalconista, int codigoBalconista, int fatorComissaoBalconista) {
		//Utiliza��o por heran�a, pegando os atributos atrav�s do super
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		this.senha=senhaBalconista;
		this.senhaFarmaciaPopular=senhaFarmaciaPopularBalconista;
		this.codigo=codigoBalconista;
		this.fatorComissao=fatorComissaoBalconista;
		
	}

	
	public void setMedicamentos(Medicamento[] medicamentos) {
		if(medicamentos.length < 1){
			System.out.println("O medicamento n�o pode ser vendido sem a identifica��o de 1 funcion�rio cadastrado no Sistema! O medicamento s� poder� ser comercializado por no m�nimo 1 funcion�rio devidamente cadastrado!");
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
	
	//Listar número de medicamentos associados aos funcionários
	public void listarMedicamentosAssociados(){
		System.out.println("O n�mero de medicamentos vendidos por funcionário é: ;");
		for(int i=0; (i < medicamentos.length); i++){
			System.out.println(medicamentos[i].nome);
		}
	}
	
	//Utilizacao da clasase abstrata
	public double calcularSalario(){
		double comissao = this.fatorComissao;
		double horasTrabalhadas = this.horas;
		double salario = 300 + horasTrabalhadas*comissao;
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
		System.out.println("H� um funcion�rio dispon�vel para atend�-lo! Status:" + statusBalconista);
	}


}
	

