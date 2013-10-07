/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entidades.Cliente;


public class TesteCliente {

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizando o teste!");
	}
	
	//Teste de idade.
	@Test
	public void testSetDigitoCpf() {
		Cliente novoCliente = new Cliente("Teste 1","Teste 2", 50, "Teste 3", "Teste 4", "Teste 5", "Teste 6");
		assertEquals(novoCliente.getDigitoCpf(),50);
		
	}

}
	
