package entidades;

import java.util.ArrayList;
import java.util.Scanner;

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
	Cliente[] clientes = {};
	Balconista[] balconista={};
	Scanner scanner = new Scanner(System.in);
	ArrayList<Balconista> listaDeBalconistas = new ArrayList<Balconista>();  
	boolean executar = true;
	String recomecar = "sim";
	int operacao = 0;
	int operacaoBalconista = 0,repeteCadastroBalconista = 0,repeteBalconista = 0;
	int codigoExclusao = 0;
	
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
	
	//Listar numero de medicamentos associados aos funcionarios
	public void listarMedicamentosAssociados(){
		System.out.println("Os medicamentos vendidos pelo funcionario " + getNome() + " foram:");
		for(int i=0; (i < medicamentos.length); i++){
			quantidade++;
			System.out.println(quantidade + " " + medicamentos[i].nome);
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
	
	//Composicao
	public Balconista(Caixa caixa){
		this.caixa=caixa;
	}
	
	public void cadastrarBalconista(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa) {
		this.rg=rgPessoa;
		this.cpf=cpfPessoa;
		this.digitoCpf=digitoCpfPessoa;
		this.nome=nomePessoa;
		this.sobrenome=sobrenomePessoa;
		this.endereco=enderecoPessoa;
		this.telefone=telefonePessoa;
	}
	
	
	public void cadastrarBalconista(){
			 System.out.println("Digite 1 para cadastrar um novo  Balconista ou 0 para sair");
			 repeteCadastroBalconista = scanner.nextInt();
			 while(repeteCadastroBalconista != 0)
			 {		 
				 System.out.println("Digite o nome do Balconista: ");  
		            this.setNome(scanner.nextLine());  
		         
				 System.out.println("Digite o sobrenome do Balconista: ");  
		            this.setSobrenome(scanner.nextLine());
		         	
				 System.out.println("Digite o rg do Balconista: ");  
		         	this.setRg(scanner.nextLine()); 
		            
		         System.out.println("Digite o cpf do Balconista: ");  
		            this.setCpf(scanner.nextLine());  
		            
		         System.out.println("Digite os digitos do Cpf do Balconista: ");  
		         	this.setDigitoCpf(scanner.nextInt());       
		         
		         System.out.println("Digite o endereço do Balconista:");  
		            this.setEndereco(scanner.nextLine()); 
		            
		         System.out.println("Digite o telefone do Balconista:");  
		         	this.setTelefone(scanner.nextLine());     
				
		         System.out.println("Digite a senha do Balconista:");  
		         	this.setSenha(scanner.nextInt());  	  
		            
		         System.out.println("Digite a senha de farmácia popular do Balconista:");  
		         	this.setSenhaFarmaciaPopular(scanner.nextInt());   		         	
		         		            		 		            
		         System.out.println("Digite o código do Balconista:");  
		         	this.setCodigo(scanner.nextInt());  	  
		            
		         System.out.println("Digite o fator de comissão de vendas em porcentagem (%) do Balconista:");  
		         	this.setFatorComissao(scanner.nextInt());  	
		            
		         System.out.println("Digite as horas trabalhadas semanalmente pelo Balconista:");  
		         	this.setHoras(scanner.nextInt());              
		            
		         listaDeBalconistas.add(this);
		         Balconista balconista = new Balconista();
	         
		         System.out.println("Deseja cadastrar outro balconista?"+
		        		 			"\n(0) - Não" +
		        		 			"\n(1) - Sim");
		         repeteCadastroBalconista = scanner.nextInt();
		      }}
		    
		public void listarBalconistas()
			  {
			  if(listaDeBalconistas.size() == 0)
			  {
				  System.out.println("Cadastro em branco!\n");
			  }
			  else
			  {
				  System.out.println("\nLista de cadastros de Balconistas\n");
				  for(int b = 0; b < listaDeBalconistas.size(); b++)
				  {
					  Balconista t = listaDeBalconistas.get(b);
					  System.out.println("\nCadastro de número:" + (b+1));
					  System.out.println("\nNome: " + t.getNome() + " " + t.getSobrenome());
					  System.out.println("\nRG: " + t.getRg() + " Cpf: " + t.getDigitoCpf() + "-" +t.getCpf());
					  System.out.println("\nTelefone: " + t.getTelefone() + " Endereco:" + t.getEndereco());
					  System.out.println("\nSenha: "+ t.getSenha() + " Senha Farmacia Popular: " + t.getSenhaFarmaciaPopular());
					  System.out.println("\nCódigo do Balconista: " + t.getCodigo());
					  System.out.println("\nNúmero de horas trabalhadas semanalmente: "+t.getHoras());
					  System.out.println("\nFator de comissao: " + t.getFatorComissao() + "%");
					  System.out.println("\nSalário: " + this.calcularSalario());
				  }
				  System.out.println("Fim da lista de cadastro.\n");
			  }
			  
			  System.out.println("Deseja realizar outra operacao para balconista?"+
  		 			"\n(0) - Não" +
  		 			"\n(1) - Sim");
			  repeteBalconista = scanner.nextInt();
			  }
	
		public void excluirBalconista()
		{
			
			if(listaDeBalconistas.size() == 0)
			  {
				  System.out.println("Cadastro em branco!\n");
			  }
			  else
			  {
			  System.out.println("Digite o numero do cadastro que deseja excluir: ");
			  this.setCodigoExclusao(scanner.nextInt());
			  this.setCodigoExclusao(codigoExclusao-1);
			  listaDeBalconistas.remove(codigoExclusao);
			
			  System.out.println("A lista foi alterada");
			  listarBalconistas();
			  }
				System.out.println("Deseja realizar outra operacao para balconista?"+
	  		 			"\n(0) - Não" +
	  		 			"\n(1) - Sim");
				  repeteBalconista = scanner.nextInt();
		  }
		
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
    //Dependência entre Cliente e Balconista.
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

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public Balconista[] getBalconista() {
		return balconista;
	}

	public void setBalconista(Balconista[] balconista) {
		this.balconista = balconista;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public ArrayList<Balconista> getListaDeBalconistas() {
		return listaDeBalconistas;
	}

	public void setListaDeBalconistas(ArrayList<Balconista> listaDeBalconistas) {
		this.listaDeBalconistas = listaDeBalconistas;
	}

	public boolean isExecutar() {
		return executar;
	}

	public void setExecutar(boolean executar) {
		this.executar = executar;
	}

	public String getRecomecar() {
		return recomecar;
	}

	public void setRecomecar(String recomecar) {
		this.recomecar = recomecar;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public int getOperacaoBalconista() {
		return operacaoBalconista;
	}

	public void setOperacaoBalconista(int operacaoBalconista) {
		this.operacaoBalconista = operacaoBalconista;
	}

	public int getRepeteCadastroBalconista() {
		return repeteCadastroBalconista;
	}

	public void setRepeteCadastroBalconista(int repeteCadastroBalconista) {
		this.repeteCadastroBalconista = repeteCadastroBalconista;
	}

	public int getRepeteBalconista() {
		return repeteBalconista;
	}

	public void setRepeteBalconista(int repeteBalconista) {
		this.repeteBalconista = repeteBalconista;
	}

	public int getCodigoExclusao() {
		return codigoExclusao;
	}

	public void setCodigoExclusao(int codigoExclusao) {
		this.codigoExclusao = codigoExclusao;
	}

	


}
	

