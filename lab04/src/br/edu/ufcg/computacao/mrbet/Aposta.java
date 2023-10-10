package br.edu.ufcg.computacao.mrbet;

import java.util.Objects;

/**
 * Classe que cria as funcionalidades de Aposta.
 * @author Daniele de Oliveira Sousa
 *
 */
public class Aposta {
	// Código do time que será apostado
	String codigo;
	// nome do campeonato que será usado na aposta
	String campeonato;
	// colocação do time apostado em relação ao campeonato
	int colocacao;
	// valor apostado
	String valorAposta;
	
	/**
	 * Construtor que inicializa um objeto aposta
	 * @param codigo código do time 
	 * @param campeonato nome do campeonato
	 * @param colocacao colocação em relação ao campeonato
	 * @param valorAposta valor da aposta 
	 */
	public Aposta(String codigo, String campeonato, int colocacao, String valorAposta) {
		this.codigo = codigo;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.valorAposta = valorAposta;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getCampeonato() {
		return this.campeonato;
	}

	public int getColocacao() {
		return this.colocacao;
	}

	public String getValorAposta() {
		return this.valorAposta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(campeonato, codigo, colocacao, valorAposta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		return Objects.equals(campeonato, other.campeonato) && Objects.equals(codigo, other.codigo)
				&& colocacao == other.colocacao && Objects.equals(valorAposta, other.valorAposta);
	}
	
	
	
}
