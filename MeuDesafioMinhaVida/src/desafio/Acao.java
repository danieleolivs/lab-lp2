package desafio;

import java.util.Objects;

public class Acao {
	String data;
	int codigo;
	int idDesafio;
	int totalAcao;
	
	public Acao(int codigo, String data, int idDesafio) {
		this.data = data;
		this.codigo = codigo;
		this.idDesafio = idDesafio;
		
		this.totalAcao = 0;
	}
	
	public void atualizaAcao() {
		this.totalAcao += 10;
	}
	
	public void atualizaAcao(int total) {
		if(totalAcao < 100) {
			this.totalAcao += total;
			if(totalAcao >= 100) {
				this.totalAcao = 100;
			}
		}
		
	}
	
	public String getData() {
		return this.data;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public int getIdDesafio() {
		return this.idDesafio;
	}

	public int getTotalAcao() {
		return this.totalAcao;
	}

	@Override
	public String toString() {
		return "Ação " + this.codigo + " - " + this.data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, data, idDesafio, totalAcao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		return codigo == other.codigo && Objects.equals(data, other.data) && idDesafio == other.idDesafio
				&& totalAcao == other.totalAcao;
	}
	
	
}
