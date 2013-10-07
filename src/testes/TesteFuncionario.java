package testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entidades.Funcionario;

public class TesteFuncionario {

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("OK! Finalizando o teste!");
	}

	//Teste para confirmação do digito do CPF.
	@Test
	public void testSetDigitoCpf() {
		Funcionario funcionarioDrogaria = new Funcionario("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6",1234,5678,1,2);
		assertEquals(funcionarioDrogaria.getDigitoCpf(),99);
	}

	//Teste para confirmação da senha
	@Test
	public void testSetSenha() {
		Funcionario funcionarioDrogaria = new Funcionario("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6",15000,5678,1,2);
		assertEquals(funcionarioDrogaria.getSenha(),15000);
	}

	//Teste para confirmação da senha da farmácia popular
	@Test
	public void testSetSenhaFarmaciaPopular() {
		Funcionario funcionarioDrogaria = new Funcionario("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6",1234,2432,1,2);
		assertEquals(funcionarioDrogaria.getSenhaFarmaciaPopular(),2432);
	}

	//Teste para confirmação do código do funcionário
	@Test
	public void testGetCodigo() {
		Funcionario funcionarioDrogaria = new Funcionario("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6",1234,5678,20,2);
		assertEquals(funcionarioDrogaria.getCodigo(),20);
	}

	//Teste para confirmação do fator de comissão do funcionário
	@Test
	public void testGetFatorComissao() {
		Funcionario funcionarioDrogaria = new Funcionario("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6",1234,5678,1,15);
		assertEquals(funcionarioDrogaria.getFatorComissao(),15);
	}

}
