package entidades;

import java.util.Scanner;

public class Saida {

	protected int confirmacao = 0;
	Scanner scanner = new Scanner(System.in);

	public Saida() {
	}

	public Saida(int confirmacaoTeste) {
		this.confirmacao = confirmacaoTeste;
	}

	public void ConfirmacaoGeral() {
		System.out.println("Deseja realmente sair do programa?" + "\n(0) - Não" + "\n(1) - Sim");

	}

	/*
	 * public int ConfirmacaoGeral2(int estados)
	 * {
	 * System.out.println("Deseja realmente sair?" + "\n(0) - Não" + "\n(1) - Sim");
	 * confirmacao = scanner.nextInt();
	 * if (confirmacao == 1) {
	 * estados = 100;// Sai definitivamente
	 * 
	 * }
	 * else if (confirmacao == 0) {
	 * estados = 0;// Volta para o menu
	 * 
	 * }System.out.println(estados);
	 * 
	 * return estados;
	 * 
	 * }
	 */

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public int getconfirmacao() {
		return confirmacao;
	}

	public void setconfirmacao(int confirmacao) {
		this.confirmacao = confirmacao;
	}

}
