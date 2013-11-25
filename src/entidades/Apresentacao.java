package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.Saida;

public class Apresentacao {

	public Apresentacao() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Balconista> listaDeBalconistas = new ArrayList<Balconista>();
		ArrayList<Caixa> listaDeCaixas = new ArrayList<Caixa>();
		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		ArrayList<Medicamento> listaDeMedicamentos = new ArrayList<Medicamento>();

		Balconista balconista = new Balconista();
		Caixa caixa = new Caixa();
		Cliente cliente = new Cliente();
		Medicamento medicamento = new Medicamento();

		Saida saida = new Saida();

		int operacao = 0, confirmacaoSaidaInicio = 0;
		int operacaoBalconista = 0, confirmacaoSaidaBalconista = 0;
		int operacaoCaixa = 0, confirmacaoSaidaCaixa = 0;
		int operacaoCliente = 0, confirmacaoSaidaCliente = 0;
		int operacaoMedicamento = 0, confirmacaoSaidaMedicamento = 0;

		int estados = 0;

		/*
		 * Lista de estados:
		 * 0 = Inicio do programa, menu do que se deseja fazer
		 * 1 = Passou do menu inicial, volta pro menu do q se deseja fazer (balconista, caixa etc.)
		 * 2 = balconista
		 * 3 = caixa
		 * 4 = cliente
		 * 5 = medicamento
		 */

		while (estados != 100) {
			if (estados == 0) {

				operacao = 0;
				balconista.menuInicial();

				operacao = scanner.nextInt();

				assert ((operacao >= 0) && (operacao <= 4)) : "Numero invalido: " + operacao; // Se digitar numero errado, sai do programa

				// Amarração para sair
				if (operacao == 0) {
					saida.ConfirmacaoGeral();
					confirmacaoSaidaInicio = scanner.nextInt();
					if (confirmacaoSaidaInicio == 1) {
						estados = 100;// Sai definitivamente
					}
					else if (confirmacaoSaidaInicio == 0) {
						estados = 0;// Volta para o menu
					}

				}
				else {
					estados++;

					if (estados >= 1 && estados != 100) {
						// Dentro do menu
						switch (operacao) {
						case 1:
							if (operacao == 1) {
								estados = 2;
							}
							while (estados == 2) {

								balconista.menuBalconista();// Menu de balconistas
								operacaoBalconista = scanner.nextInt();
								if (operacaoBalconista == 0) {
									System.out.println("Deseja realmente sair do menu de cadastro de Balconista?"
											+ "\n(0) - Não" + "\n(1) - Sim");
									confirmacaoSaidaBalconista = scanner.nextInt();
									if (confirmacaoSaidaBalconista == 1) {
										estados = 0;
										System.out.println("Saindo do setor de cadastro de Balconista.");
									}
									else if (confirmacaoSaidaBalconista == 0) {
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
							while (estados == 3) {

								caixa.menuCaixa();// Menu caixa
								operacaoCaixa = scanner.nextInt();
								if (operacaoCaixa == 0) {
									System.out.println("Deseja realmente sair do menu de cadastro de Caixa?"
											+ "\n(0) - Não" + "\n(1) - Sim");
									confirmacaoSaidaCaixa = scanner.nextInt();
									if (confirmacaoSaidaCaixa == 1) {
										estados = 0;
										System.out.println("Saindo do setor de cadastro de Caixa.");
									}
									else if (confirmacaoSaidaCaixa == 0) {
										estados = 3;
									}

								}

								else if (operacaoCaixa == 1) {
									caixa.cadastrarCaixa(listaDeCaixas);
									estados = 3;
								}

								else if (operacaoCaixa == 2) {
									caixa.listarCaixas(listaDeCaixas);
									estados = 3;
								}

								else if (operacaoCaixa == 3) {
									caixa.excluirCaixa(listaDeCaixas);
									estados = 3;
								}
							}
							break;

						case 3:
							if (operacao == 3) {
								estados = 4;
							}
							while (estados == 4) {

								cliente.menuCliente();// Menu caixa
								operacaoCliente = scanner.nextInt();
								if (operacaoCliente == 0) {
									System.out.println("Deseja realmente sair do menu de cadastro de Cliente?"
											+ "\n(0) - Não" + "\n(1) - Sim");
									confirmacaoSaidaCliente = scanner.nextInt();
									if (confirmacaoSaidaCliente == 1) {
										estados = 0;
										System.out.println("Saindo do setor de cadastro de Cliente.");
									}
									else if (confirmacaoSaidaCliente == 0) {
										estados = 4;
									}

								}

								else if (operacaoCliente == 1) {
									cliente.cadastrarCliente(listaDeClientes);
									estados = 4;
								}

								else if (operacaoCliente == 2) {
									cliente.listarClientes(listaDeClientes);
									estados = 4;
								}

								else if (operacaoCliente == 3) {
									cliente.excluirCliente(listaDeClientes);
									estados = 4;
								}

							}
							break;

						case 4:
							if (operacao == 4) {
								estados = 5;
							}
							while (estados == 5) {

								medicamento.menuMedicamento();// Menu caixa
								operacaoMedicamento = scanner.nextInt();
								if (operacaoMedicamento == 0) {
									System.out.println("Deseja realmente sair do menu de cadastro de Medicamento?"
											+ "\n(0) - Não" + "\n(1) - Sim");
									confirmacaoSaidaMedicamento = scanner.nextInt();
									if (confirmacaoSaidaMedicamento == 1) {
										estados = 0;
										System.out.println("Saindo do setor de cadastro de Medicamento.");
									}
									else if (confirmacaoSaidaMedicamento == 0) {
										estados = 5;
									}

								}

								else if (operacaoMedicamento == 1) {
									medicamento.cadastrarMedicamento(listaDeMedicamentos);
									estados = 5;
								}

								else if (operacaoMedicamento == 2) {
									medicamento.listarMedicamentos(listaDeMedicamentos);
									estados = 5;
								}

								else if (operacaoMedicamento == 3) {
									medicamento.excluirMedicamento(listaDeMedicamentos);
									estados = 5;
								}

							}
							break;

						default:

							/*
							 * System.out.println("Deseja realizar alguma outra operacao?");
							 * if (recomecar.equalsIgnoreCase("nao")) {
							 * estados = 100;
							 * }
							 * else if (recomecar.equalsIgnoreCase("sim")) {
							 * estados = 0;
							 * }
							 * else {
							 * System.out.println("Operacao invalida! Saindo por segurança.");
							 * estados = 100;
							 * }
							 */

						}// Saindo do Switch principal
					}// Saindo do if de estados = 1
				}
			}// Estados = 0
		}// Saindo do While de estados != 100 / fim do programa
		System.out.println("Obrigado por usar nosso sistema de gerência!" + " Saindo do programa!");
	}
}
