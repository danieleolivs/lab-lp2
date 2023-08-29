package br.edu.ufcg.computacao.lp2.coisa;

/**
 * Classe descanso, que classifica o ânimo do estudante a partir de parâmetros recebidos.
 * @author Daniele de Oliveira Sousa
 *
 */
public class Descanso {
	
	// guarda o total de horas descansadas.
	private int horasDescanso;
	// guarda o total de semanas.
	private int numeroSemanas;
	// guarda o status de descanso do estudante.
	private String statusDescanso;
	
	/**
	 * define as horas descansadas pelo aluno e guarda na variável local.
	 * @param valor total de horas registradas.
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
	
	/**
	 * define o número de semanas descansadas pelo estudante.
	 * @param valor total de semanas registradas.
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroSemanas = valor;
	}
	
	/**
	 * retorna o status de descanso do estudante a partir dos valores recebidos pelas outras classes.
	 * @return retorna descansado e descansado, que são os estados que o estudante pode estar dependendo do que foi adicionado.
	 */
	public String getStatusGeral() {
		
		if(horasDescanso == 0 || numeroSemanas == 0) {
			return this.statusDescanso = "cansado";
		}
		
		if(horasDescanso/numeroSemanas >= 26) {
			return this.statusDescanso = "descansado";
		}
		
		return "cansado";
	}

}
