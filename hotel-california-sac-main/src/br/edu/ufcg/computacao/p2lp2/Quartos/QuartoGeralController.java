package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Classe que controla e designa as principais funcionalidades e caracteristicas dos quartos do hotel.
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 *
 */
public class QuartoGeralController  {
	private HashMap<Integer, QuartosInterface> quartos;
	
	private QuartosInterface quarto;
	
	public QuartoGeralController() {
		this.quartos = new HashMap<>();
	}
	
	/**
	 * Esse método faz com que o quarto seja disponibilizado de acordo com o numero do quarto e o tipo da hospedagem.
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param numeroQuarto parametro para o numero do quarto
	 * @param precoPessoa preco por pessoa
	 * @param precoBase preco base
	 * @return ele retorna um erro caso o tipo do usuario esteja errado, e retorna uma mensagem para cada tipo de hospedagem.
	 **/
	
	public String disponibilizarQuartoSingle(String idAutenticacao, int numeroQuarto, double precoPessoa, double precoBase) {
		QuartosInterface single = new QuartoSingle(1, numeroQuarto, precoBase, precoPessoa);
		if(!idAutenticacao.contains("ADM")) {
			throw new IllegalArgumentException("Usuario não permitido");
		}
		
		single.calcularDiaria();
		quartos.put(numeroQuarto, single);
		return "Quarto Single disponibilizado";
	}
	
	/**
	 * Esse método faz com que o quarto seja disponibilizado de acordo com o numero do quarto e o tipo da hospedagem.
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param numeroQuarto parametro para o numero do quarto
	 * @param precoPessoa preco por pessoa
	 * @param precoBase preco base
	 * @param pedidos pedidos do cliente
	 * @return ele retorna um erro caso o tipo do usuario esteja errado, e retorna uma mensagem para cada tipo de hospedagem.
	 **/
	public String disponibilizarQuartoDouble(String idAutenticacao, int numQuarto, double precoPessoa, double precoBase, String[] pedidos) {
		QuartoDouble duplo = new QuartoDouble(2, numQuarto, pedidos);
		if(!idAutenticacao.contains("ADM")) {
			throw new IllegalArgumentException("Usuario não permitido");
		}
		
		duplo.calcularDiaria();
		quartos.put(numQuarto, duplo);
		return "Quarto Double disponibilizado";
	}
	/**
	 * Esse método faz com que o quarto seja disponibilizado de acordo com o numero do quarto e o tipo da hospedagem.
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param numeroQuarto parametro para o numero do quarto
	 * @param precoPessoa preco por pessoa
	 * @param precoBase preco base
	 * @param pedidos pedidos do cliente
	 * @param qtdMaximaPessoa quantidade maxima de pessoa que um quarto family irá receber
	 * @return ele retorna um erro caso o tipo do usuario esteja errado, e retorna uma mensagem para cada tipo de hospedagem.
	 **/
	public String disponibilizarQuartoFamily(String idAutenticacao, int numQuarto, double precoPessoa, double precoBase, String[] pedidos, int qtdMaximaPessoa) {
		QuartoFamily family = new QuartoFamily(numQuarto, precoBase, precoPessoa, pedidos, qtdMaximaPessoa);
		if(!idAutenticacao.contains("ADM")) {
			throw new IllegalArgumentException("Usuario não permitido");
		}
		
		family.calcularDiaria();
		quartos.put(numQuarto, family);
		return "Quarto Family disponibilizado";
	}
	
	
	/**
	 * Esse método faz o uso da interface QuartosInteface, e chama o método de exibir Quarto que está presente em cada classe de 
	 * quartos.
	 * @return ele retorna o método da interface que sobescreve todos os métodos iguais das classes de quartos.
	 */
	public String exibirQuartos(int numQuarto) {
		QuartosInterface quarto = quartos.get(numQuarto);
		return quarto.exibirQuarto();
	}
	
	public String listarQuartos(int numQuarto) {
		String conc = "";
		for(int i=0; i < quartos.size(); i++) {
			conc += exibirQuartos(numQuarto);
		}
		return conc;
	}
	
	public QuartosInterface getQuarto(int numQuarto) {
		return quartos.get(numQuarto);
	}
}
