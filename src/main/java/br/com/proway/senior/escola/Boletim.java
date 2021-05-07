package br.com.proway.senior.escola;

import java.util.ArrayList;

/**
 * Reune as {@link Prova}s de um {@link Aluno}.
 * 
 * O boletim possui uma lista de {@link Prova}s e é referente a um periodo de um
 * {@link Aluno} Para cada periodo é calculada a média das provas
 * 
 * @author Daniella Lira
 *
 */

public class Boletim {

	private Aluno aluno;
	private Integer periodo;
	private Double media;
	private ArrayList<Prova> provas;

	/**
	 * Cria um novo Boletim.
	 * 
	 * O Boletim é criado a partir de um aluno e um periodo. Conforme as provas são
	 * adicionadas, realiza-se o calculo atualizado da média.
	 * 
	 * @param aluno
	 * @param periodo
	 * @param media
	 */

	public Boletim(Aluno aluno, Integer periodo) {
		this.aluno = aluno;
		this.periodo = periodo;
		this.media = 0.0;
		this.provas = new ArrayList<Prova>();

	}

	/**
	 * Aluno do boletim
	 * 
	 * @return
	 */

	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Periodo do formato yyyymm
	 * 
	 * @return
	 */
	public Integer getPeriodo() {
		return periodo;
	}

	/**
	 * Retorna a média das provas atualizada.
	 * 
	 * @return
	 */
	public Double getMedia() {
			return media;
	}

	/**
	 * Retorna todas as provas.
	 * 
	 * @return ArrayList<Prova>
	 */

	public ArrayList<Prova> getProvas() {
		return this.provas;
	}

	/**
	 * Adicionar a Prova, a média é recalculada.
	 * 
	 * @param prova
	 */

	public void removeProva(int index) {
		this.provas.remove(index);
		this.calculaMedia();		
	}

	/**
	 * Calcula a média ponderada das provas.
	 * 
	 * Realiza o cálculo da média das notas das provas e atualiza o valor da media.
	 * 
	 */
	private void calculaMedia() {
		int quantidadeProvas = this.provas.size();
		media = 0.0;
		for(Prova prova: this.provas) {
			media += prova.getNota();
		}
		media /= quantidadeProvas ;		
	}

	/**
	 * Remove todas as provas.
	 */
	public void removeProvas() {
		this.provas = new ArrayList<Prova>();
		}

	public void addProva(Prova prova) {
		this.provas.add(prova);
		this.calculaMedia();
		
	}	
}
