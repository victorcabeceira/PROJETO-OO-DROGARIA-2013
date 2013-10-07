package entidades;

public class Cliente extends Pessoa{
	
	
	protected String email;
	protected Caixa[] caixas;

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
	}
	

	public void listarCaixas() {
		for (int x=0; x<(caixas.length); x+=1) {
			System.out.println(("Caixa [" +x +"]:" +caixas[x]));
		}
	}
	
	

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



}
