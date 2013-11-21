package entidades;

import java.text.DecimalFormat;

import entidades.Balconista;
import entidades.Caixa;
import entidades.Cliente;
import entidades.Administrativo;
import entidades.Medicamento;
import entidades.Pessoa;
import entidades.Registro;

import java.util.ArrayList;
import java.util.Scanner;

public class Apresentacao {

	public Apresentacao() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<Balconista> listaDeBalconistas = new ArrayList<Balconista>();  
		Balconista balconista = new Balconista();
		boolean executar = true;
		String recomecar = "sim";
		int operacao = 0;
		int operacaoBalconista = 0,repeteCadastroBalconista = 0,repeteBalconista = 0;
		
		/*listaDeBalconistas.remove(i)*/
		
		
		System.out.println("Qual setor você deseja utilizar?" +
		"\n(1) - Balconista\n"+
		"(2) - Caixa\n"+ 
		"(3) - Cliente\n"+
		"(4) - Produto\n");
		
		operacao = scanner.nextInt();  
		while (executar){
		switch (operacao){
		  case 1:
			  System.out.println("Digite 1 para prosseguir para acessar o menu de gerenciamento de balconista e 0 para retornar");
			  repeteBalconista = scanner.nextInt();
			  while(repeteBalconista!=0){
			  System.out.println("\nInsira o que deseja fazer de acordo com as opções seguintes:" +
					  			"\n(0) - Sair\n" +
					  			"(1) - Cadastrar novo Balconista\n" +
					  			"(2) - Listar Balconistas\n" +
					  			"(3) - Excluir Balconista\n");
			  operacaoBalconista = scanner.nextInt();
			  Balconista balconista1 = new Balconista();
			  switch(operacaoBalconista)
			  {
			  case 0:
				  System.out.println("Saindo do sistema de cadastro de balconistas.");
				 
				  executar = false;
				  
				  break;
			  case 1:
				 
				  balconista.cadastrarBalconista();
				  break;
			  case 2:
				  balconista.listarBalconistas();
				  break;
			  case 3:
				  balconista.excluirBalconista();
				  break;
			 }//Fecha o switch de balconista
			  
			 System.out.println("Saindo do programa. \n");
			 }
		  case 2:
			  
			  break;
			  
		  case 3:
			  
			  break;
		
		  case 4:
			  
			  break;
			  
		  default:
			  
			  System.out.println("Deseja realizar alguma outra operacao?");
		          if(recomecar.equalsIgnoreCase("nao"))
		          {
		        	 executar = false; 
		          }
		          else if(recomecar.equalsIgnoreCase("sim"))
		          {}
		          else
		          {
		        	  System.out.println("Operacao invalida! Saindo por segurança.");
		        	  executar = false;
		          }
	}//Saindo do Switch principal
	}//Saindo do While
}
}
