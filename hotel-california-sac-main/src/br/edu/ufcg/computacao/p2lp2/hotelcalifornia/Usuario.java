package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import java.util.Objects;

/**
 * Classe que tem as principais características de um usuário que é possível existir no sistema
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 *
 */
public class Usuario {
	
	// id do usuário
	String id;
	
	// nome do usuário
	String nome;
	
	// tipo do usuário
	String tipo;
	
	// número do documento do usuário
	long numeroDocumento;

	/**
	 * Construtor que define um usuário
	 * @param id id do usuário
	 * @param nome nome do usuário
	 * @param tipo tipo do usuário
	 * @param numeroDocumento número do documento
	 */
	public Usuario(String id, String nome, String tipo, long numeroDocumento) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.numeroDocumento = numeroDocumento;
		
	}

	public String getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getNumeroDocumento() {
		return this.numeroDocumento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, numeroDocumento, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& numeroDocumento == other.numeroDocumento && Objects.equals(tipo, other.tipo);
	}

	/**
	 * Retorna a representação de um usuário
	 */
	@Override
	public String toString() {
		return "[" + this.id + "] " + this.nome + " (No. Doc. " + this.numeroDocumento + " )";
	}
	
	
	
	
}
