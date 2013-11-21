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

public class Apresentacao2 {

	public Apresentacao2() {

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

		while (start) {
			balconista.menuInicial();

			operacao = scanner.nextInt();

			if (operacao > 0 && operacao < 5) {
				start = true;
				executar = true;
			}

			else if (operacao == 0) {
				start = false;
			}

			while (executar) {
				switch (operacao) {
				case 1:
					System.out
							.println("Digite 1 para prosseguir para acessar o menu de gerenciamento de balconista e 0 para retornar");
					repeteBalconista = scanner.nextInt();
					while (repeteBalconista != 0) {
						balconista.menuBalconista();// Menu de balconistas
						operacaoBalconista = scanner.nextInt();

						switch (operacaoBalconista) {
						case 0:
							System.out.println("Deseja realmente sair?" + "\n(0) - Não" + "\n(1) - Sim");
							confirmacaoSaida = scanner.nextInt();
							if (confirmacaoSaida == 1) {
								executar = false;
								start = true;
							}
							else if (confirmacaoSaida == 0) {
								executar = true;
								start = true;
							}
							System.out.println("Saindo do setor de cadastro de balconistas.");

							break;
						case 1:

							System.out.println("Digite 1 para cadastrar um novo  Balconista ou 0 para sair");
							repeteCadastroBalconista = scanner.nextInt();

							if (repeteCadastroBalconista == 1) {
								start = true;
								executar = true;
							}

							else if (repeteCadastroBalconista == 0) {
								executar = false;
							}

							while (repeteCadastroBalconista != 0) {
								balconista.cadastrarBalconista(listaDeBalconistas);

								System.out.println("Deseja cadastrar outro balconista?" + "\n(0) - Não"
										+ "\n(1) - Sim");
								repeteCadastroBalconista = scanner.nextInt();
							}
							break;
						case 2:
							balconista.listarBalconistas(listaDeBalconistas);
							break;
						case 3:
							balconista.excluirBalconista(listaDeBalconistas);
							break;
						}// Fecha o switch de balconista
					}

					executar = false;
				case 2:

					break;

				case 3:

					break;

				case 4:

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
			}// Saindo do While de executar
		}// Saindo do While de start
		System.out.println("Obrigado por usar nosso sistema de gerência!" + " Saindo do programa!");
	}
}
