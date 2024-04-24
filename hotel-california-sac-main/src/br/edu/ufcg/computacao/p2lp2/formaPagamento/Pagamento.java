package br.edu.ufcg.computacao.p2lp2.formaPagamento;

import java.util.Objects;

public abstract class Pagamento {

	protected String idCliente;
	protected long idReserva;
	protected String nomeTitular;
	protected double totalDesconto;
	
	public Pagamento(String idCliente, long idReserva, String nomeTitular) {
		this.idCliente = idCliente;
		this.idReserva = idReserva;
		this.nomeTitular = nomeTitular;
	}
	
	public double totalDeDesconto() {
		return this.totalDesconto;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente, idReserva, nomeTitular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(idCliente, other.idCliente) && idReserva == other.idReserva
				&& Objects.equals(nomeTitular, other.nomeTitular);
	}
	
}
