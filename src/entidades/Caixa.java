package entidades;

import entidades.Cliente;
import entidades.Balconista;

public class Caixa extends Pessoa{
	private float saldoAtual = 0;
	private int tipo; // 0-Receita ou 1-Despesa
	private float valor;
	private String data;
	private String descricao; // Informacoes
								
	protected Cliente[] clientes;
	protected Balconista[] funcionario;
	
	public Caixa() {
		this.saldoAtual = 0;
		this.tipo = 0;
		this.valor = 0;
		this.data = "Default";
		this.descricao = "Default";
	}

	public Caixa(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,
			int tipoTransacao, float valorTransacao, String dataTransacao, String descricaoTransacao){
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		if (tipo == 0 || tipo == 1) {
			this.tipo = tipoTransacao;
			this.valor = valorTransacao;
			this.data = dataTransacao;
			this.descricao = descricaoTransacao;
		}
		else {
			System.out.println("Caixa nao cadastrado.");
			
		}
		
		System.out.println("Verificacao de um funcionário para atendê-lo.");
		Balconista.setStatusBalconista(true); //Utilizacao de static para dependência
	}
	
	
	//Verifica a confirmação de pagamento na Caixa (POLIMORFISMO)
		public double confirmacaoPagamento() 
		{
			if(this.confirmacaoPagamento == 1)
				{
				return 1; //Confirma que o pagamento foi aceito.
				}
			else
				{
				return 0; //Confirma que o pagamento não foi aceito	
				}
		}
		
	
	
	// Método depositar
	public void depositar(float valor) {
		System.out.println("Valor do saldo atual: " + saldoAtual);
		saldoAtual += valor;
		System.out.println("Valor após o depósito: " + saldoAtual);
	}

	
	public double calcularSalario(){
		this.setSalario(715);
		return 715;
	}
	
	
	private void setSalario(double i) {	
	}

	public Balconista[] getFuncionario() {
			return funcionario;
	}
		  
	public Cliente[] getCliente () {
		   return clientes;
	}
		  
	public void setClientes(Cliente [] clientes){
		    this.clientes = clientes;
	}
		  
	public void listarClientes () {
		    for (int x=0; x<(clientes.length); x+=1)
		    {
		      System.out.println(("Clientes: [" +x +"]: "+clientes[x]));
		    }
	}
	
	
	// Especificando métodos get and set.
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(float saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setFuncionario(Balconista[] funcionario) {
		this.funcionario = funcionario;
	}
}