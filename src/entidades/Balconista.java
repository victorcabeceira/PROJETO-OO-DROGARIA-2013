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
	//Utilizacao de STATIC para depend�ncia
	Cliente[] clientes = {};
	
	public Balconista(){}
	
	public Balconista(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,
			int senhaBalconista, int senhaFarmaciaPopularBalconista, int codigoBalconista, int fatorComissaoBalconista, int horasTrabalhadas) {
		//Utiliza��o por heran�a, pegando os atributos atrav�s do super
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		this.senha=senhaBalconista;
		this.senhaFarmaciaPopular=senhaFarmaciaPopularBalconista;
		this.codigo=codigoBalconista;
		this.fatorComissao=fatorComissaoBalconista;
		this.horas=horasTrabalhadas;
		
		
	}

	//Verifica a confirma��o de pagamento na Caixa (POLIMORFISMO)
	public double confirmacaoPagamento() 
	{
			if(this.confirmacaoPagamento == 1)
			{
				return 1; //Confirma que o pagamento foi aceito.
			}
			else
			{
				return 0; //Confirma que o pagamento n�o foi aceito	
			}
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
	/*
	//Agrega��o entre cliente e balconista
	public void listarClientesAtendidos(){
		System.out.println("Os clientes sao: ");
		for(int n=0;n<clientes.length;n++){
			System.out.println(clientes[n].nome);
		}
	}
	
	public void adicionarCLiente(Cliente cliente){
		int tamanhoAnterior=this.clientes.length;
		Cliente[] novosClientes = new Cliente[tamanhoAnterior+1];
		for(int n=0;n<tamanhoAnterior;n++){novosClientes[n] = this.clientes[n];}
		novosClientes[novosClientes.length-1] = cliente;
		this.setClientes(novosClientes);
	}//Fim Agrega��o*/
	
	private void setSalario(double salario) {
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static boolean isStatusBalconista() {
		return statusBalconista;
	}
    //Depend�ncia entre Cliente e Balconista.
	public static void setStatusBalconista(boolean statusFuncionarioPresente) {
		Balconista.statusBalconista = statusFuncionarioPresente;
		System.out.println("H� um funcion�rio dispon�vel para atend�-lo! Status:" + statusBalconista);
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}


}
	

