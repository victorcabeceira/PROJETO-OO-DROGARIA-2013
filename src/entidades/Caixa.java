package entidades;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Balconista;

public class Caixa extends Pessoa{
	private float saldoAtual = 0;
	private int tipo; // 0-Receita ou 1-Despesa
	private float valor;
	private String data;
	private String descricao; // Informacoes
	private Balconista balconista;							
	protected Cliente[] clientes;
	protected Balconista[] funcionario;
	private int codigo;
	
	//COnsole
	Caixa[] caixa = {};
	Scanner scanner = new Scanner(System.in);
	Scanner scanner1 = new Scanner(System.in);
	int operacao = 0;
	int operacaoCaixa = 0, repeteCadastroCaixa = 0, repeteCaixa = 0;
	int codigoExclusao = 0;
	int confirmacaoExclusaoCaixa = 0;
	
	public Caixa() {
		this.saldoAtual = 0;
		this.tipo = 0;
		this.valor = 0;
		this.data = "Default";
		this.descricao = "Default";
	}

	public Caixa(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,
			int tipoTransacao, float valorTransacao, String dataTransacao, String descricaoTransacao,int codigo){
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		if (tipo == 0 || tipo == 1) {
			this.tipo = tipoTransacao;
			this.valor = valorTransacao;
			this.data = dataTransacao;
			this.descricao = descricaoTransacao;
			this.codigo = codigo;
		}
		else {
			System.out.println("Caixa nao cadastrado.");
			
			
		}
		//Composicao - so existe um Caixa se ja existir um balconista!
		Balconista balconista = new Balconista(this);
		this.balconista=balconista;
			
		
		
		System.out.println("Verificacao de um funcion�rio para atend�-lo.");
		Balconista.setStatusBalconista(true); //Utilizacao de static para depend�ncia
	}
	
	//Composicao - Criacao de um novo caixa a partir de um balconista
	public void criarBalconista(){
		Balconista balconista = new Balconista(this);
		this.balconista=balconista;
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
		
	
	
	// M�todo depositar
	public void depositar(float valor) {
		System.out.println("Valor do saldo atual: " + saldoAtual);
		saldoAtual += valor;
		System.out.println("Valor ap�s o dep�sito: " + saldoAtual);
	}

	
	public double calcularSalario(){
		this.setSalario(715);
		return 715;
	}
	
	
	public void menuCaixa() {
		System.out.println("\nInsira o que deseja fazer de acordo com as op��es seguintes:" + "\n(0) - Sair\n"
				+ "(1) - Cadastrar novo Caixa\n" + "(2) - Listar Caixas\n"
				+ "(3) - Excluir Caixa\n");
	}
	
	public void cadastrarCaixa(ArrayList<Caixa> listaDeCaixas) {

		Caixa caixa = new Caixa();

		System.out.println("Digite o nome completo do Caixa: ");
		caixa.setNome(scanner.nextLine());

		/*System.out.println("Digite o sobrenome do Caixa: ");
		caixa.setSobrenome(scanner1.nextLine());*/

		System.out.println("Digite o rg do Caixa: ");
		caixa.setRg(scanner.nextLine());

		System.out.println("Digite o cpf do Caixa: ");
		caixa.setCpf(scanner.nextLine());

		System.out.println("Digite os digitos do Cpf do Caixa: ");
		caixa.setDigitoCpf(scanner.nextInt());

		/*System.out.println("Digite o endere�o do Caixa:");
		caixa.setEndereco(scanner.nextLine());*/

		System.out.println("Digite o telefone do Caixa:");
		caixa.setTelefone(scanner1.nextLine());

		/*System.out.println("Digite o tipo de operacao do Caixa:");
		caixa.setTipo(scanner.nextInt());

		System.out.println("Digite o valor de vendas do Caixa:");
		caixa.setValor(scanner.nextInt());

		System.out.println("Data de vendas do Caixa:");
		caixa.setData(scanner.nextLine());

		System.out.println("Digite uma descri��o caso necess�rio: ");
		caixa.setDescricao(scanner.nextLine());*/
		
		System.out.println("Digite o c�digo do Caixa:");
		caixa.setCodigo(scanner.nextInt());
		listaDeCaixas.add(caixa);

	}
	
	public void listarCaixas(ArrayList<Caixa> listaDeCaixas) {
		if (listaDeCaixas.size() == 0) {
			System.out.println("Cadastro em branco!\n");
		}
		else {
			System.out.println("\nLista de cadastros de Balconistas\n");
			for (int b = 0; b < listaDeCaixas.size(); b++) {
				Caixa t = listaDeCaixas.get(b);
				System.out.println("\nCadastro de n�mero:" + (b + 1));
				System.out.println("\nNome: " + listaDeCaixas.get(b).getNome()/*+ " "
						+ listaDeBalconistas.get(b).getSobrenome()*/);
				System.out.println("\nRG: " + t.getRg() + " Cpf: " + t.getDigitoCpf() + "-" + t.getCpf());
				System.out.println("\nTelefone: " + t.getTelefone()/* + " Endereco:" + t.getEndereco()*/);
				/*System.out.println("\nTipo: " + t.getTipo() + " Valor de Vendas: "
						+ t.getValor());*/
				System.out.println("\nC�digo do Caixa: " + t.getCodigo());
				/*System.out.println("\nData: " + t.getData());
				System.out.println("\nDescri��o: " + t.getDescricao());*/
				System.out.println("\nSal�rio: " + this.calcularSalario());
			}
			System.out.println("Fim da lista de cadastro.\n");
		}

		
	}
	
	public void excluirCaixa(ArrayList<Caixa> listaDeCaixas) {

		if (listaDeCaixas.size() == 0) {
			System.out.println("Cadastro em branco!\n");
		}
		else {
			System.out.println("Digite o numero do cadastro do Caixa que deseja excluir: ");
			this.setCodigoExclusao(scanner.nextInt());
			System.out.println("Voc� deseja realmente excluir o cadastro de numero: " + this.codigoExclusao + "?"
					+ "\n(0) - N�o" + "\n(1) - Sim");
			this.setConfirmacaoExclusaoCaixa(scanner.nextInt());
			if (confirmacaoExclusaoCaixa == 1) {
				this.setCodigoExclusao(codigoExclusao - 1);
				listaDeCaixas.remove(codigoExclusao);

				System.out.println("A lista foi alterada");
				listarCaixas(listaDeCaixas);
			}
			else if (confirmacaoExclusaoCaixa == 0) {
				this.setCodigoExclusao(0);
			}
		}
		
	}
	
	
	// Especificando m�todos get and set.
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
		      System.out.println(("Clientes: ["+ x +"]: " + clientes[x]));
		    }
	}
	
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

	public Balconista getBalconista() {
		return balconista;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Caixa[] getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa[] caixa) {
		this.caixa = caixa;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Scanner getScanner1() {
		return scanner1;
	}

	public void setScanner1(Scanner scanner1) {
		this.scanner1 = scanner1;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public int getOperacaoCaixa() {
		return operacaoCaixa;
	}

	public void setOperacaoCaixa(int operacaoCaixa) {
		this.operacaoCaixa = operacaoCaixa;
	}

	public int getRepeteCadastroCaixa() {
		return repeteCadastroCaixa;
	}

	public void setRepeteCadastroCaixa(int repeteCadastroCaixa) {
		this.repeteCadastroCaixa = repeteCadastroCaixa;
	}

	public int getRepeteCaixa() {
		return repeteCaixa;
	}

	public void setRepeteCaixa(int repeteCaixa) {
		this.repeteCaixa = repeteCaixa;
	}

	public int getCodigoExclusao() {
		return codigoExclusao;
	}

	public void setCodigoExclusao(int codigoExclusao) {
		this.codigoExclusao = codigoExclusao;
	}

	public int getConfirmacaoExclusaoCaixa() {
		return confirmacaoExclusaoCaixa;
	}

	public void setConfirmacaoExclusaoCaixa(int confirmacaoExclusaoCaixa) {
		this.confirmacaoExclusaoCaixa = confirmacaoExclusaoCaixa;
	}

	public void setBalconista(Balconista balconista) {
		this.balconista = balconista;
	}
}