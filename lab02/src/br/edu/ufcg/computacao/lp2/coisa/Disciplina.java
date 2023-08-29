package br.edu.ufcg.computacao.lp2.coisa;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Classe que guarda as informações de disciplinas do estudante, a exemplo de nota, média e status de aprovado.
 * @author Daniele de Oliveira Sousa
 *
 */
public class Disciplina {
	
	// fixa o valor da média em uma casa decimal.
	DecimalFormat df = new DecimalFormat("#.0");
	
	// guarda o nome da disciplina estudada.
	private String nomeDisciplina;
	// guarda o total de horas estudadas.
	private int horas;
	// guarda as notas obtidas.
	private double[] notas;
	// guarda a média do estudante.
	private double media;
	
	// guarda o total de notas da disciplinas.
	private int totalNotas;
	// array que guarda os pesos de cada nota recebida.
	private int[] pesosNotas;

	/**
	 * Construtor que inicializa os valores padrões da classe ( com 4 notas ) e seu respectivo nome de disciplina.
	 * @param nomeDisciplina nome da disciplina adicionada.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[] {0.0, 0.0, 0.0, 0.0};
	}
	
	/**
	 * Construtor que inicializa com os valores do bônus, ou seja, recebe o nome da disciplina, mas também, o total de notas que 
	 * a disciplina possui. ALém disso, adiciona todos os pesos tendo o valor 1 como padrão.
	 * @param nomeDisciplina nome da disciplina adicionada.
	 * @param totalNotas total de notas da disciplina.
	 */
	public Disciplina(String nomeDisciplina, int totalNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.totalNotas = totalNotas;
		this.pesosNotas = new int[totalNotas];
		this.notas = new double[totalNotas];
		
		for(int i = 0; i < pesosNotas.length; i++) {
			pesosNotas[i] = 1;
			notas[i] = 0.0;
		}
	}
	
	/**
	 * Construtor que inicializa com os valores do bônus, ou seja, recebe o nome da disciplina, mas também, o total de notas que
	 * a disciplina possui, nesse caso, também é inicializado os valores dos pesos dependendo dos valores pelo usuário.
	 * @param nomeDisciplina nome da disciplina.
	 * @param totalNotas total de notas da disciplina.
	 * @param pesos array de pesos das notas.
	 */
	public Disciplina(String nomeDisciplina, int totalNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.totalNotas = totalNotas;
		this.pesosNotas = new int[totalNotas];
		this.notas = new double[totalNotas];
		
		for(int i = 0; i < pesos.length; i++) {
			pesosNotas[i] = pesos[i];
			notas[i] = 0.0;
		}
	}
	
	/**
	 * Calcula a média do aluno a partir das notas recebidas e seus respectivos pesos.
	 * @return retorna aprovado caso a média seja maior ou igual a 7 e reprovado caso contrário.
	 */
	public boolean aprovadoBonus() {
		double sum = 0;
		double sumBonus = 0;
		
		for(int i = 0; i < notas.length; i++) {
			sum += notas[i] * pesosNotas[i];
			sumBonus += pesosNotas[i];
		}
		
		this.media = sum/sumBonus;
		
		if(media >= 7.0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * cadastra as horas estudadas pelo estudante.
	 * @param horas total de horas estudadas.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * cadastra as notas do estudante no sistema.
	 * @param nota posição da nota no array.
	 * @param valorNota valor da nota conquistada.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Calcula se o estudante foi aprovado a depender das notas recebidas.
	 * @return retorna aprovado caso a média seja maior ou igual a 7 e reprovado caso contrário.
	 */
	public boolean aprovado() {
		double sum = 0;
		
		for(Double valor: notas) {
			sum += valor;
		}
		
		this.media = sum/4;
		
		if(media >= 7.0) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Retorna a representação em string dos valores recebidos pela classe
	 */
	@Override
	public String toString( ) {
		
		return nomeDisciplina + " " + horas + " " + df.format(media) + " " + Arrays.toString(notas);
	}
}
