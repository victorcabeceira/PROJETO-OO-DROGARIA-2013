package sistemadrogaria;

import entidades.Caixa;
import entidades.Balconista;
import entidades.Medicamento;
import entidades.Cliente;

public class SistemaDrogaria {

	public SistemaDrogaria() {
	}

	
	public static void main(String[] args) {
		
		//Instanciando um objeto da classe dos funcionarios.
		Balconista funcionarioDrogaria = new Balconista("13.523.542-PA","123.456.789", 12, "Victor", "Fellipe", "SHCES Qd 1000", "(61)-1234-5678",1234,5678,20,2);
		
		//Instanciando um objeto da classe dos clientes
		Cliente novoCliente = new Cliente("13.999.888-DF","444.555.666", 11, "Teste", "Teste2" , "Gama qd. 1000", "(61)-1234-5678","cliente1@gmail.com");
	    
		//Criando e cadastrando um medicamento
		Medicamento novoMedicamento = new Medicamento("NomeTeste", "LaboratorioTeste", "Adulto", "Comprimido", "10/10/2020","1cp. a cada 8 horas");
		
		//Criando e cadastrando uma transacao do caixa
		Caixa caixa = new Caixa("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6", 0, 100, "10/10/2020", "transacaoTeste");
	
		//Imprimindo no console as informações do Funcionário
		System.out.println("Funcionario:" + funcionarioDrogaria.getNome() + funcionarioDrogaria.getSobrenome());
		System.out.println("CPF: " + funcionarioDrogaria.getCpf() + "-" + funcionarioDrogaria.getDigitoCpf());
		System.out.println("Senha: " + funcionarioDrogaria.getSenha() + ". Codigo: " + funcionarioDrogaria.getCodigo() + ". Fator de comissao: " + funcionarioDrogaria.getFatorComissao() + " %");
		System.out.println("Endereco: " + funcionarioDrogaria.getEndereco() + ".Telefone: " + funcionarioDrogaria.getTelefone());
	
		//Imprimindo no console as informações do Cliente
		System.out.println("Nome do Cliente cadastrado: " + novoCliente.getNome() + novoCliente.getSobrenome() + ".Endereco: " + novoCliente.getEndereco() + ".Telefone: " + novoCliente.getTelefone());
		System.out.println("RG: " + novoCliente.getRg());
		System.out.println("CPF: " + novoCliente.getCpf());
		System.out.println("Email: " + novoCliente.getEmail());
		
		//Imprimindo no console as informacões de Medicamento
		System.out.println("Nome do medicamento: " + novoMedicamento.getNome());
		System.out.println("Laboratorio fabricante: " + novoMedicamento.getFabricante());
		System.out.println("Recomendação: " + novoMedicamento.getRecomendacao());
		System.out.println("Tipo: " + novoMedicamento.getTipo());
		System.out.println("Validade: " + novoMedicamento.getValidade());

		//Imprimindo no console as informações do Caixa
		System.out.println("\nTipo da transação:" + caixa.getTipo());
		System.out.printf("Valor da transação: R$ %.2f\n", caixa.getValor());
		System.out.println("Data da transação: " + caixa.getData());
		System.out.println("Descrição: " + caixa.getDescricao());
		System.out.println("Saldo atual: " + caixa.getSaldoAtual());	
		caixa.depositar (150);
		System.out.println("\nSaldo atual: " + caixa.getSaldoAtual());
		
		
		
		//Associação
		Balconista funcionarioDrogaria1 = new Balconista("13.523.542-PA","123.456.789", 12, "Victor", "Fellipe", "SHCES Qd 1000", "(61)-1234-5678",1234,5678,20,2);
		
		Medicamento medicamento1 = new Medicamento("NomeTeste", "LaboratorioTeste", "Adulto", "Comprimido", "10/10/2020","1cp. a cada 8 horas");
		
		Medicamento medicamento2 = new Medicamento("NomeTeste 2", "LaboratorioTeste 2", "Criança", "Líquido", "01/07/2014","5 ml de 6 em 6 horas");
	
		//
		Medicamento[] medicamentos2 = {medicamento1, medicamento2};
		funcionarioDrogaria1.setMedicamentos(medicamentos2);
		
		//Listando
		funcionarioDrogaria1.listarMedicamentosAssociados();
		
		Caixa[] caixaAdd={};
		
		Balconista funcionario = new Balconista();
		
		funcionario.Caixa();
	}

}
