package desafio;

import java.util.Objects;

public abstract class Desafio {
	
	String titulo;
	String descricao;
	int totalExecuções;
	boolean desafioConcluido;
	int satisfacao;
	String tipo;
	
	public Desafio(String titulo, String descricao, String tipo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.totalExecuções = 0;
		this.tipo = tipo;
		this.satisfacao = 0;
		this.desafioConcluido = false;
	}
	
	public Desafio(String titulo, String tipo) {
		this.titulo = titulo;
		this.totalExecuções = 0;
		this.desafioConcluido = false;
		this.satisfacao = 0;
	}
	
	public void concluirDesafio() {
		this.desafioConcluido = true;
		this.totalExecuções += 1;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean isDesafioConcluido() {
		return desafioConcluido;
	}

	@Override
	public String toString() {
		return "Título: " + this.titulo + "\n" + this.totalExecuções + " execuções";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, titulo, totalExecuções);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desafio other = (Desafio) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(titulo, other.titulo)
				&& totalExecuções == other.totalExecuções;
	}
	
	
}
