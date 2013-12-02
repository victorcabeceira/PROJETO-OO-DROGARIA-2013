package entidades;

import java.util.Scanner;

public class Complementar {

	protected int confirmacao = 0, confirmacaoSaidaBalconista = 0, confirmacaoSaidaCaixa = 0,
			confirmacaoSaidaCliente = 0, confirmacaoSaidaMedicamento = 0, confirmacaoSaidaAjuda = 0,
			operacaoMenu = 0;

	private static String string = "";

	Scanner scanner = new Scanner(System.in);
	Scanner scannerR = new Scanner(System.in);

	public Complementar() {
	}

	public Complementar(int confirmacaoTeste) {
		this.confirmacao = confirmacaoTeste;
	}

	public void ConfirmacaoGeral() {
		System.out.println("Deseja realmente sair do programa?" + "\n(0) - N�o" + "\n(1) - Sim");

	}

	public int ConfirmacaoGeral2(int estados) {
		System.out.println("Deseja realmente sair?" + "\n(0) - N�o" + "\n(1) - Sim");
		confirmacao = scanner.nextInt();
		if (confirmacao == 1) {
			estados = 100;// Sai definitivamente

		}
		else if (confirmacao == 0) {
			estados = 0;// Volta para o menu

		}

		return estados;

	}

	public int ConfirmacaoBalconista(int estados) {
		System.out.println("Deseja realmente sair do menu de cadastro de Balconista?" + "\n(0) - N�o"
				+ "\n(1) - Sim");
		confirmacaoSaidaBalconista = scanner.nextInt();
		if (confirmacaoSaidaBalconista == 1) {
			estados = 0;
			System.out.println("Saindo do setor de cadastro de Balconista.");
		}
		else if (confirmacaoSaidaBalconista == 0) {
			estados = 2;
		}
		return estados;
	}

	public int ConfirmacaoCaixa(int estados) {
		System.out.println("Deseja realmente sair do menu de cadastro de Caixa?" + "\n(0) - N�o" + "\n(1) - Sim");
		confirmacaoSaidaCaixa = scanner.nextInt();
		if (confirmacaoSaidaCaixa == 1) {
			estados = 0;
			System.out.println("Saindo do setor de cadastro de Caixa.");
		}
		else if (confirmacaoSaidaCaixa == 0) {
			estados = 3;
		}
		return estados;
	}

	public int ConfirmacaoCliente(int estados) {
		System.out
				.println("Deseja realmente sair do menu de cadastro de Cliente?" + "\n(0) - N�o" + "\n(1) - Sim");
		confirmacaoSaidaCliente = scanner.nextInt();
		if (confirmacaoSaidaCliente == 1) {
			estados = 0;
			System.out.println("Saindo do setor de cadastro de Cliente.");
		}
		else if (confirmacaoSaidaCliente == 0) {
			estados = 4;
		}
		return estados;
	}

	public int ConfirmacaoMedicamento(int estados) {
		System.out.println("Deseja realmente sair do menu de cadastro de Medicamento?" + "\n(0) - N�o"
				+ "\n(1) - Sim");
		confirmacaoSaidaMedicamento = scanner.nextInt();
		if (confirmacaoSaidaMedicamento == 1) {
			estados = 0;
			System.out.println("Saindo do setor de cadastro de Medicamento.");
		}
		else if (confirmacaoSaidaMedicamento == 0) {
			estados = 5;
		}

		return estados;
	}

	// Ler String
	public static String readString() {
		string = new Scanner(System.in).nextLine();
		return string;
	}

	// Ler Int
	public static int readInt() {
		boolean erro = false;
		int i = 0;
		do {
			try {
				i = Integer.parseInt(readString()); // Atribui��o do termo digito ao Inteiro pedido
				erro = false;
			} catch (NumberFormatException t) {
				System.out.println("Voc� inseriu algo diferente de um n�mero. Digite um n�mero inteiro: ");
				erro = true;
			}
		} while (erro);
		return i;
	}

	public int menuAjuda(int estados) {
		System.out
				.println("A ajuda deste programa tem como objetivo auxili�-lo nos m�todos de inser��o para utiliza��o do sistema de ger�ncia.");
		System.out.println("Escolha a op��o em que voc� deseja saber mais");
		System.out.println("(0) - Sair\n(1) - Balconista\n(2) - Caixa \n(3) - Cliente\n(4) - Medicamento");

		operacaoMenu = new Scanner(System.in).nextInt();
		switch (operacaoMenu) {

		case 0:
			System.out.println("Deseja realmente sair do menu de Ajuda?" + "\n(0) - N�o" + "\n(1) - Sim");
			confirmacaoSaidaAjuda = scanner.nextInt();
			if (confirmacaoSaidaAjuda == 1) {
				estados = 0;
				System.out.println("Saindo do setor de cadastro de Medicamento.");
			}
			else if (confirmacaoSaidaAjuda == 0) {
				estados = 6;
			}

			break;
		case 1:
			System.out
					.println("Os campos de nome,sobrenome e endere�o para 'Balconista' devem ser inseridos diretamente letra a letra onde cada informa��o deve ser separada por espa�o simples");
			System.out.println("Exemplo: \nDigite nome: 'Victor'");
			System.out
					.println("J� os campos de 'senha', 'senha de farm�cia popular', 'c�digo', 'fator de comissao' e 'horas trabalhadas' devem ser inseridos como numeros inteiros");
			System.out.println("Exemplo: \nDigite a senha: 5734");
			System.out.println("Os campos de rg devem inseridos com o �rg�o expeditor seguido do n�mero.");
			System.out.println("Exemplo: \nDigite o rg: MG452333");
			System.out
					.println("O campo de cpf deve ser inserido sem o d�gito, pois este ser� inserido no campo 'D�gito de cpf' a partir dos 2 n�meros que se deseja cadastrar");
			System.out.println("Exemplo: \nSe seu cpf for 123.456.789-00, digite apenas: '123456789'");
			System.out
					.println("O campo 'validade' de medicamento deve ser inserido sem nenhum caractere espa�ando os dias do m�s e ano respectivamente");
			System.out.println("Exemplo: \nData de validade: 12122014");
			estados = 6;
			break;
		case 2:
			System.out
					.println("Os campos de nome,sobrenome e endere�o para 'Caixa' devem ser inseridos diretamente letra a letra onde cada informa��o deve ser separada por espa�o simples");
			System.out.println("Exemplo: \nDigite nome: 'Victor'");
			System.out.println("J� o campo de 'c�digo' deve ser inserido como numero inteiro");
			System.out.println("Exemplo: \nDigite o c�digo do caixa: 2");
			System.out.println("Os campos de rg devem inseridos com o �rg�o expeditor seguido do n�mero.");
			System.out.println("Exemplo: \nDigite o rg: MG452333");
			System.out
					.println("O campo de cpf deve ser inserido sem o d�gito, pois este ser� inserido no campo 'D�gito de cpf' a partir dos 2 n�meros que se deseja cadastrar");
			System.out.println("Exemplo: \nSe seu cpf for 123.456.789-00, digite apenas: '123456789'");
			estados = 6;
			break;
		case 3:
			System.out
					.println("Os campos de nome,sobrenome,endere�o e email para 'Cliente' devem ser inseridos diretamente letra a letra onde cada informa��o deve ser separada por espa�o simples");
			System.out.println("Exemplo: \nDigite nome: 'Victor'");
			System.out.println("Os campos de rg devem inseridos com o �rg�o expeditor seguido do n�mero.");
			System.out.println("Exemplo: \nDigite o rg: MG452333");
			System.out
					.println("O campo de cpf deve ser inserido sem o d�gito, pois este ser� inserido no campo 'D�gito de cpf' a partir dos 2 n�meros que se deseja cadastrar");
			System.out.println("Exemplo: \nSe seu cpf for 123.456.789-00, digite apenas: '123456789'");
			estados = 6;
			break;
		case 4:
			System.out
					.println("Os campos de 'nome','fabricante','recomenda��o','tipo' e 'posologia' para 'Medicamento' devem ser inseridos diretamente onde cada informa��o deve ser separada por espa�o simples");
			System.out.println("Exemplo: \nDigite nome: 'Neosaldina'");
			System.out
					.println("J� o campo 'validade' de medicamento deve ser inserido sem nenhum caractere espa�ando os dias do m�s e ano respectivamente");
			System.out.println("Exemplo: \nData de validade: 12122014");
			estados = 6;
			break;
		}
		return estados;

	}

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
