package entidades;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Caixa;
import entidades.Medicamento;

public class Balconista extends Pessoa {

	// Declaracao de atributos

	protected int senha;
	protected int senhaFarmaciaPopular;
	protected int codigo; // O funcionario usa o codigo de acesso junto da senha para fazer as vendas.
	protected int fatorComissao;
	protected Medicamento[] medicamentos = {};
	protected Caixa caixa;
	private static boolean statusBalconista;
	protected int horas;
	protected int quantidade = 0;
	// Utilizacao de STATIC para depend�ncia
	Cliente[] clientes = {};
	
	
	//SOmente para cria��o do console;
	Balconista[] balconista = {};
	Scanner scanner = new Scanner(System.in);
	Scanner scanner1 = new Scanner(System.in);
	private int operacao = 0;
	private int operacaoBalconista = 0, repeteCadastroBalconista = 0, repeteBalconista = 0;
	private int codigoExclusao = 0;
	private int confirmacaoExclusaoBalconista = 0;
	private Object getCpf;

	public Balconista() {
	}

	public Balconista(String rgPessoa, String cpfPessoa, int digitoCpfPessoa, String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa, int senhaBalconista,
			int senhaFarmaciaPopularBalconista, int codigoBalconista, int fatorComissaoBalconista,
			int horasTrabalhadas) {
		// Utiliza��o por heran�a, pegando os atributos atrav�s do super
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		this.senha = senhaBalconista;
		this.senhaFarmaciaPopular = senhaFarmaciaPopularBalconista;
		this.codigo = codigoBalconista;
		this.fatorComissao = fatorComissaoBalconista;
		this.horas = horasTrabalhadas;
	}

	// Verifica a confirma��o de pagamento na Caixa (POLIMORFISMO)
	public double confirmacaoPagamento() {
		if (this.confirmacaoPagamento == 1) {
			return 1; // Confirma que o pagamento foi aceito.
		}
		else {
			return 0; // Confirma que o pagamento n�o foi aceito
		}
	}

	public void setMedicamentos(Medicamento[] medicamentos) {
		if (medicamentos.length < 1) {
			System.out
					.println("O medicamento n�o pode ser vendido sem a identifica��o de 1 funcion�rio cadastrado no Sistema! O medicamento s� poder� ser comercializado por no m�nimo 1 funcion�rio devidamente cadastrado!");
		}
		else {
			this.medicamentos = medicamentos;
		}
	}

	public void verificarMedicamento(Medicamento medicamento) {
		int tamanhoAntigo = this.medicamentos.length;

		Medicamento[] novosMedicamentos = new Medicamento[tamanhoAntigo + 1];
		for (int i = 0; i < tamanhoAntigo; i++) {
			novosMedicamentos[i] = this.medicamentos[i];

		}

		novosMedicamentos[novosMedicamentos.length - 1] = medicamento;
		this.setMedicamentos(novosMedicamentos);

	}

	// Listar numero de medicamentos associados aos funcionarios
	public void listarMedicamentosAssociados() {
		System.out.println("Os medicamentos vendidos pelo funcionario " + getNome() + " foram:");
		for (int i = 0; (i < medicamentos.length); i++) {
			quantidade++;
			System.out.println(quantidade + " " + medicamentos[i].nome);
		}
	}

	// Utilizacao da clasase abstrata
	public double calcularSalario() {
		double comissao = this.fatorComissao;
		double horasTrabalhadas = this.horas;
		double salario = 75 + horasTrabalhadas * comissao;
		this.setSalario(salario);
		return salario;
	}

	// Composicao
	public Balconista(Caixa caixa) {
		this.caixa = caixa;
	}

	public void cadastraBalconista(String rg, String cpf, int digitoCpf, String nome, String sobrenome,
			String endereco, String telefone) {

		this.rg = rg;
		this.cpf = cpf;
		this.digitoCpf = digitoCpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public void menuInicial() {
		System.out.println("Qual setor voc� deseja utilizar?" + "\n(0) - Sair" + "\n(1) - Balconista\n" + "(2) - Caixa\n"
				+ "(3) - Cliente\n" + "(4) - Medicamento\n");
	}

	public void menuBalconista() {
		System.out.println("\nInsira o que deseja fazer de acordo com as op��es seguintes:" + "\n(0) - Sair\n"
				+ "(1) - Cadastrar novo Balconista\n" + "(2) - Listar Balconistas\n"
				+ "(3) - Excluir Balconista\n");
	}

	public void cadastrarBalconista(ArrayList<Balconista> listaDeBalconistas) {

		Balconista balconista = new Balconista();

		System.out.println("Digite o nome completo do Balconista: ");
		balconista.setNome(scanner.nextLine());

		/*System.out.println("Digite o sobrenome do Balconista: ");
		balconista.setSobrenome(scanner1.nextLine());*/

		System.out.println("Digite o rg do Balconista: ");
		balconista.setRg(scanner.nextLine());

		System.out.println("Digite o cpf do Balconista: ");
		balconista.setCpf(scanner.nextLine());

		System.out.println("Digite os digitos do Cpf do Balconista: ");
		balconista.setDigitoCpf(scanner.nextInt());

		/*System.out.println("Digite o endere�o do Balconista:");
		balconista.setEndereco(scanner.nextLine());*/

		System.out.println("Digite o telefone do Balconista:");
		balconista.setTelefone(scanner1.nextLine());

		System.out.println("Digite a senha do Balconista:");
		balconista.setSenha(scanner.nextInt());

		System.out.println("Digite a senha de farm�cia popular do Balconista:");
		balconista.setSenhaFarmaciaPopular(scanner.nextInt());

		System.out.println("Digite o c�digo do Balconista:");
		balconista.setCodigo(scanner.nextInt());

		System.out.println("Digite o fator de comiss�o de vendas em porcentagem (%) do Balconista:");
		balconista.setFatorComissao(scanner.nextInt());

		System.out.println("Digite as horas trabalhadas semanalmente pelo Balconista:");
		balconista.setHoras(scanner.nextInt());

		listaDeBalconistas.add(balconista);

	}

	public void listarBalconistas(ArrayList<Balconista> listaDeBalconistas) {
		if (listaDeBalconistas.size() == 0) {
			System.out.println("Cadastro em branco!\n");
		}
		else {
			System.out.println("\nLista de cadastros de Balconistas\n");
			for (int b = 0; b < listaDeBalconistas.size(); b++) {
				Balconista t = listaDeBalconistas.get(b);
				System.out.println("\nCadastro de n�mero:" + (b + 1));
				System.out.println("\nNome: " + t.getNome()/*+ " "
						+ listaDeBalconistas.get(b).getSobrenome()*/);
				System.out.println("\nRG: " + t.getRg() + " Cpf: " + t.getDigitoCpf() + "-" + t.getCpf.substring(1,3) + "." + t.getCpf.substring(4,6) + "." + t.getCpf.substring(7,9));
				System.out.println("\nTelefone: " + t.getTelefone()/* + " Endereco:" + t.getEndereco()*/);
				System.out.println("\nSenha: " + t.getSenha() + " Senha Farmacia Popular: "
						+ t.getSenhaFarmaciaPopular());
				System.out.println("\nC�digo do Balconista: " + t.getCodigo());
				System.out.println("\nN�mero de horas trabalhadas semanalmente: " + t.getHoras());
				System.out.println("\nFator de comissao: " + t.getFatorComissao() + "%");
				System.out.println("\nSal�rio: " + this.calcularSalario());
			}
			System.out.println("Fim da lista de cadastro.\n");
		}

		
	}

	public void excluirBalconista(ArrayList<Balconista> listaDeBalconistas) {

		if (listaDeBalconistas.size() == 0) {
			System.out.println("Cadastro em branco!\n");
		}
		else {
			System.out.println("Digite o numero do cadastro que deseja excluir: ");
			this.setCodigoExclusao(scanner.nextInt());
			System.out.println("Voc� deseja realmente excluir o cadastro de numero: " + this.codigoExclusao + "?"
					+ "\n(0) - N�o" + "\n(1) - Sim");
			this.setConfirmacaoExclusaoBalconista(scanner.nextInt());
			if (confirmacaoExclusaoBalconista == 1) {
				this.setCodigoExclusao(codigoExclusao - 1);
				listaDeBalconistas.remove(codigoExclusao);

				System.out.println("A lista foi alterada");
				listarBalconistas(listaDeBalconistas);
			}
			else if (confirmacaoExclusaoBalconista == 0) {
				this.setCodigoExclusao(0);
			}
		}
		
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

	// Depend�ncia entre Cliente e Balconista.
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

	public Scanner getScanner1() {
		return scanner1;
	}

	public void setScanner1(Scanner scanner1) {
		this.scanner1 = scanner1;
	}

	public int getConfirmacaoExclusaoBalconista() {
		return confirmacaoExclusaoBalconista;
	}

	public void setConfirmacaoExclusaoBalconista(int confirmacaoExclusaoBalconista) {
		this.confirmacaoExclusaoBalconista = confirmacaoExclusaoBalconista;
	}

}
