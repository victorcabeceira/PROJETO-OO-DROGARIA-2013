package entidades;

public class Pessoa {

	
	protected String rg;
	protected String cpf;
	protected int digitoCpf;
	protected String nome;
	protected String sobrenome;
	protected String endereco;
	protected String telefone;
	
	
	public Pessoa() {}

	//Documentos
	public Pessoa (String rgPessoa,String cpfPessoa, int digitoCpfPessoa){
		this.rg=rgPessoa;
		this.cpf=cpfPessoa;
		this.digitoCpf=digitoCpfPessoa;
	}
	//Nomes
	public Pessoa (String nomePessoa, String sobrenomePessoa, String enderecoPessoa, String telefonePessoa){
		this.nome=nomePessoa;
		this.sobrenome=sobrenomePessoa;
		this.endereco=enderecoPessoa;
		this.telefone=telefonePessoa;
	}
	//Todos os parametros
	public Pessoa (String rgPessoa,String cpfPessoa, int digitoCpfPessoa,
		String nomePessoa, String sobrenomePessoa, String enderecoPessoa, String telefonePessoa){
		this.rg=rgPessoa;
		this.cpf=cpfPessoa;
		this.digitoCpf=digitoCpfPessoa;
		this.nome=nomePessoa;
		this.sobrenome=sobrenomePessoa;
		this.endereco=enderecoPessoa;
		this.telefone=telefonePessoa;
	}
	
	//Validacao digito
	private boolean validarCpf(int digitoCpfPessoa)
	{
		boolean validar1;
		if(digitoCpfPessoa > 99)
		{
			validar1 = false;
		}
		else
		{
			validar1 = true;
		}
		
			return validar1;
	}
	
	
	public void cadastrarPessoa(String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa, String sobrenomePessoa, String enderecoPessoa, String telefonePessoa){
		//Atributos
		this.nome=nomePessoa;
		this.sobrenome=sobrenomePessoa;
		this.endereco=enderecoPessoa;
		this.telefone=telefonePessoa;
		this.rg=rgPessoa;
		this.cpf=cpfPessoa;
		this.digitoCpf=digitoCpfPessoa;
		
		boolean validacaoDigitoCpf = this.validarCpf(digitoCpfPessoa);
		if(validacaoDigitoCpf == true)
		{
			System.out.println("Funcion�rio cadastrado com sucesso!");
		}
		else
		{
			System.out.println("Funcion�rio n�o cadastrado!");
		}
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getDigitoCpf() {
		return digitoCpf;
	}

	public void setDigitoCpf(int digitoCpf) {
		this.digitoCpf = digitoCpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
}
