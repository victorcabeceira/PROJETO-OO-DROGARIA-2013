package entidades;

public class Cliente extends Pessoa{
	
	
	protected String email;
	protected Caixa[] caixas;
	Balconista[] balconistas = {};
	
	public Cliente(){}
	
	//Construtor só para herança
	public Cliente (String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa) {
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
	}
	
	public Cliente (String rgPessoa,String cpfPessoa, int digitoCpfPessoa,String nomePessoa,
			String sobrenomePessoa, String enderecoPessoa, String telefonePessoa,String emailCliente) {
		super(rgPessoa, cpfPessoa, digitoCpfPessoa, nomePessoa, sobrenomePessoa, enderecoPessoa, telefonePessoa);
		this.email=emailCliente;
		
		System.out.println("Possui pelo menos um balconista para atendê-lo!!");
		Balconista.setStatusBalconista(true);
		//Por ser static, não é necessário instanciar.
	}
	

	public void listarCaixas() {
		for (int x=0; x<(caixas.length); x+=1) {
			System.out.println(("Caixa [" +x +"]:" +caixas[x]));
		}
	}
	
	//Agregação
	public void listarBalconistas(){
		System.out.println("Os balconistas sao: ");
		for(int n=0;n<balconistas.length;n++){
			System.out.println(balconistas[n].nome);
	}
	}
	
	public void adicionarBalconista(Balconista balconista){
		int tamanhoAnterior=this.balconistas.length;
		Balconista[] novosBalconistas = new Balconista[tamanhoAnterior+1];
		for(int n=0;n<tamanhoAnterior;n++){novosBalconistas[n] = this.balconistas[n];}
		novosBalconistas[novosBalconistas.length-1] = balconista;
		this.setBalconistas(novosBalconistas);
	}//Fim agregação-espelho

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Caixa[] getCaixas() {
		return caixas;
	}

	public void setCaixas(Caixa[] caixas) {
		this.caixas = caixas;
	}

	public Balconista[] getBalconistas() {
		return balconistas;
	}

	public void setBalconistas(Balconista[] balconistas) {
		this.balconistas = balconistas;
	}



}
