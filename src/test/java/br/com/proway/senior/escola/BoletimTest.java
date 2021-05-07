package br.com.proway.senior.escola;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BoletimTest {
	
	static Boletim boletim ;
	private static int periodoPadrao = 202105;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = periodoPadrao;
		boletim = new Boletim(aluno, periodo) ;
	}
	
	@Test
	public void testBoletim() {
		assertNotNull(boletim);
	}

	@Test
	public void testGetAluno() {
		assertNotNull(boletim.getAluno());
	}

	@Test
	public void testGetPeriodo() {
		assertEquals(periodoPadrao, (int) boletim.getPeriodo());
	}

	@Test
	public void testGetMedia() {
		boletim.removeProvas();
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		try {
			prova.setNota(10.0);
			boletim.addProva(prova);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(10.0, boletim.getMedia(), 0.01);
	}

	@Test
	public void testAddProva() throws Exception {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		prova.setNota(5.0);
		boletim.addProva(prova);
		assertEquals(2,(int) boletim.getProvas().size());
	}

	@Test
	public void testRemoveProva() throws Exception {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		boletim.removeProvas();
		prova.setNota(7.0);
		boletim.addProva(prova);
		boletim.addProva(prova);
		boletim.removeProva(0);
		assertEquals(1, boletim.getProvas().size());
			}

	@Test
	public void testRemoveTodasProvas() throws Exception {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		prova.setNota(8.0);
		boletim.addProva(prova);
		boletim.removeProvas();
		assertFalse(boletim.getProvas().size() > 0);
	}

}