package entidades;
import interfaces.*;

public class Cliente extends Pessoa implements Recomendavel{
	
	
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
		
		System.out.println("Possui pelo menos um balconista para atendê-lo!!"); // ---> DEPENDENCIA
		Balconista.setStatusBalconista(true);
		//Por ser static, não é necessário instanciar.
	}
	
	
	//Interface
	public void remediosRecomendados (String tipoRemedio, String uso) {
				if(tipoRemedio == "TARJA PRETA" && uso == "ADULTO") {
					System.out.println("A quantidade de remedios recomendados pelo Balconista é: 1");
				}
				
				if(tipoRemedio == "TARJA PRETA" && uso == "PEDIATRICO") {
					System.out.println("A quantidade de remedios recomendados pelo Balconista é: 0");
				}
				
				if(tipoRemedio == "GENERICO" && uso == "ADULTO") {
					System.out.println("A quantidade de remedios recomendados pelo Balconista é: 5");
				}
				
				if(tipoRemedio == "GENERICO" && uso == "PEDIATRICO") {
					System.out.println("A quantidade de remedios recomendados pelo Balconista é: 3");
				}
					
					
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

	public Balconista[] getBalconistas() {
		return balconistas;
	}

	public void setBalconistas(Balconista[] balconistas) {
		this.balconistas = balconistas;
	}



}
