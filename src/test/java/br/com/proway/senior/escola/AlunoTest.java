package br.com.proway.senior.escola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AlunoTest {

	@Test (expected = Exception.class)
	public void testSetNomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Dani123");
		assertNotNull(aluno.getNome());
	}
	
	@Test
	public void testSetNomeSemCaracter() {
		Aluno aluno = new Aluno();
		try {
			aluno.setNome("Dani");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		assertNotNull(aluno.getNome());
	}
	
	@Test (expected = Exception.class)
	public void testSetNomeComcaracterEspecial() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Dani..$$");
		assertNotNull(aluno.getNome());
	}
	
	
	@Test (expected = Exception.class)
	public void testSetSobrenomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setSobrenome("Dani123");
		assertNotNull(aluno.getSobrenome());
	}
	
	@Test
	public void testSetSobrenomeSemCaracter() {
		Aluno aluno = new Aluno();
		try {
			aluno.setSobrenome("Dani");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		assertNotNull(aluno.getSobrenome());
	}
	
	@Test (expected = Exception.class)
	public void testSetSobrenomeComcaracterEspecial() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setSobrenome("Dani..$$");
		assertNull(aluno.getNome());
	}
	
	@Test
	public void testSetIdade() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(9);
		assertEquals(9, (int) aluno.getIdade());
	}
	
	@Test (expected = Exception.class)
	public void testSetIdadeNegatva() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(-15);
	}
	
	@Test (expected = Exception.class)
	public void testSetIdadeMaior () throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(150);
	}
	
	@Test
	public void testSetIdadeMensagemException () {
		Aluno aluno = new Aluno();
		try {
			aluno.setIdade(150);
		}
		catch(Exception e) {
			assertNotNull("Idade não pode ser maior que 130 e menor que zero", 
					e.getMessage());
		}
	}
}
