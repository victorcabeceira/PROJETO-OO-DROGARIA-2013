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
		boolean executar = true; // Começa o switch/case de gerência a partir do escolhido
		boolean start = true; // Começa o programa
		String recomecar = "sim";
		int operacao = 0;
		int operacaoBalconista = 0, repeteCadastroBalconista = 0, repeteBalconista = 0, confirmacaoSaida = 0;
		int estados = 0;

		/*
		 * Lista de estados:
		 * 0 = Inicio do programa, menu do que se deseja fazer
		 * 1 = Passou do menu inicial, volta pro menu do q se deseja fazer (balconista, caixa etc.)
		 * 2 =
		 */

		while (estados != 100) {
			if (estados == 0) {

				operacao = 0;
				balconista.menuInicial();

				operacao = scanner.nextInt();

				// Amarração para sair
				if (operacao == 0) {
					//Confirmação para sair
					estados = 100;
				}
				else {
					estados++;

					if (estados >= 1 && estados != 100) {
						switch (operacao) {
						case 1:
							if (operacao == 1) {
								estados = 2;
							}
							while (estados == 2) {

								balconista.menuBalconista();// Menu de balconistas
								operacaoBalconista = scanner.nextInt();
								if (operacaoBalconista == 0) {
									System.out.println("Deseja realmente sair?" + "\n(0) - Não" + "\n(1) - Sim");
									confirmacaoSaida = scanner.nextInt();
									if (confirmacaoSaida == 1) {
										estados = 0;
										System.out.println("Saindo do setor de cadastro de balconistas.");
									}
									else if (confirmacaoSaida == 0) {
										estados = 2;
									}

								}

								else if (operacaoBalconista == 1) {
									balconista.cadastrarBalconista(listaDeBalconistas);
									estados = 2;
								}

								else if (operacaoBalconista == 2) {
									balconista.listarBalconistas(listaDeBalconistas);
									estados = 2;
								}

								else if (operacaoBalconista == 3) {
									balconista.excluirBalconista(listaDeBalconistas);
									estados = 2;
								}

								// Fecha o if de balconista
							}// if de estados = 2;
						case 2:
							if (operacao == 2) {
								estados = 3;
							}
							if (estados == 3) {
								System.out.println("Caixa");
							}
							break;

						case 3:
							System.out.println("Cliente");
							break;

						case 4:
							System.out.println("Medicamento");
							break;

						default:

							System.out.println("Deseja realizar alguma outra operacao?");
							if (recomecar.equalsIgnoreCase("nao")) {
								executar = false;
								start = false;
							}
							else if (recomecar.equalsIgnoreCase("sim")) {
							}
							else {
								System.out.println("Operacao invalida! Saindo por segurança.");
								executar = false;
								start = false;
							}

						}// Saindo do Switch principal
					}// Saindo do if de estados = 1
				}
			}// Estados = 0
		}// Saindo do While de estados != 100 / fim do programa
		System.out.println("Obrigado por usar nosso sistema de gerência!" + " Saindo do programa!");
	}
}
