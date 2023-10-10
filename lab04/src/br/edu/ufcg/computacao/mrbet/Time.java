package br.edu.ufcg.computacao.mrbet;

import java.util.Objects;

/**
 * Classe que cadastra um novo time no sistema.
 * @author Daniele de Oliveira Sousa
 *
 */
public class Time {
	// código do time 
	private String codigo;
	// nome do time
	private String nome;
	// mascote do time
	private String mascote;
	
	/**
	 * Construtor que inicializa um novo time no sistema
	 * @param codigo código do time
	 * @param nome nome do time
	 * @param mascote mascote do time
	 */
	public Time(String codigo, String nome, String mascote) {
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
	}

	public String getNome() {
		return this.nome;
	}

	public String getMascote() {
		return this.mascote;
	}
	
	@Override
	public String toString() {
		return "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, mascote, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(mascote, other.mascote)
				&& Objects.equals(nome, other.nome);
	}

	
}
