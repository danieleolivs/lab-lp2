package br.edu.ufcg.computacao.lp2.coisa;

import java.util.Arrays;

/**
 * Registra os resumos das disciplinas estudadas.
 * @author Daniele de Oliveira Sousa
 *
 */
public class RegistroResumos {
	
	// array que guarda os resumos estudados
	private String[] resumos;
	// array que guarda os temas dos resumos
	private String[] temas;
	// guarda o total de resumos.
	private int totalResumos;
	// guarda o total de resumos cadastrados.
	private int totalCadastrados;
	
	/**
	 * Construtor que inicializa a classe RegistraResumo com os valores atribuidos pelo usuário.
	 * @param numeroDeResumos total de resumos que serão cadastrados.
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.resumos = new String[numeroDeResumos];
		this.temas = new String[numeroDeResumos];
		this.totalResumos = 0;
	}
	
	/**
	 * Adiciona um resumo ao array inicializado.
	 * @param tema tema do resumo
	 * @param resumo breve descrição do tema
	 */
	public void adiciona(String tema, String resumo) {
		resumos[totalResumos] = tema + ":" + " " + resumo;
		temas[totalResumos] = tema;
		this.totalResumos ++;
		this.totalCadastrados++;
		
		if(totalResumos == resumos.length) {
			this.totalResumos = 0;
		}
	}
	
	/**
	 * Retorna o array de resumos cadastrados no sistema.
	 * @return retorna todos os resumos do array.
	 */
	public String[] pegaResumos() {
		return resumos;
	}
	
	/**
	 * Imprime o total de resumos que foram cadastrados, além de uma breve descrição dos temas cadastrados.
	 * @return uma string com o resumo das informações.
	 */
	public String imprimeResumos() {
		
		String nomeTema = "";
		
		for(int i = 0; i<totalCadastrados; i++) {
			if(i == totalCadastrados - 1) {
				nomeTema += " " + temas[i];
			}else {
				nomeTema += temas[i] + " | ";
			}
		}
		
		return "- " + totalCadastrados + " resumo(s) cadastrado(s) \n" + "- " + nomeTema;
	}
	
	/**
	 * Total de arrays cadastrados no sistema.
	 * @return retorna o total de arrays cadastrados no sistema.
	 */
	public int conta() {
		return totalCadastrados;
	}
	
	/**
	 * verifica se existe um resumo cadastrado a partir de um determinado tema.
	 * @param tema tema buscado.
	 * @return retorna true caso o resumo esteja cadastrado ou false se não.
	 */
	public boolean temResumo(String tema) {
		for(String nomeTema: temas) {
			if(tema.equals(nomeTema)) {
				return true;
			}
		}
		
		return false;
	}
}
