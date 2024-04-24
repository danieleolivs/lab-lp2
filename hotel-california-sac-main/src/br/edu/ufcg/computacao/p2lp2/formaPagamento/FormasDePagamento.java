package br.edu.ufcg.computacao.p2lp2.formaPagamento;

import java.util.Objects;

/**
 * Classe responsável por criar uma nova forma de pagamento no sistema
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 *
 */
public abstract class FormasDePagamento {
	
	private String idAutenticacao;
	private String formaPagamento;
	private double percentualDesconto;
	
	/**
	 * Construtor que inicializa as principais variáveis da forma de pagamento
	 * @param idAutenticacao id do usuário cadastrado
	 * @param formaPagamento forma de paagamento escolhida
	 * @param percentualDesconto total de desconto para o pagamento
	 */
	public FormasDePagamento(String idAutenticacao, String formaPagamento, double percentualDesconto) {
		this.idAutenticacao = idAutenticacao;
		this.formaPagamento = formaPagamento;
		this.percentualDesconto = percentualDesconto;
	

	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public String getIdAutenticacao() {
		return idAutenticacao;
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formaPagamento, idAutenticacao, percentualDesconto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormasDePagamento other = (FormasDePagamento) obj;
		return Objects.equals(formaPagamento, other.formaPagamento)
				&& Objects.equals(idAutenticacao, other.idAutenticacao)
				&& Double.doubleToLongBits(percentualDesconto) == Double.doubleToLongBits(other.percentualDesconto);
	}

	/**
	 * Representação textual de uma forma de pagamento
	 */
	@Override
	public String toString() {
		return "Forma de pagamento: " + this.formaPagamento + "(" + this.percentualDesconto + "% de desconto em pagamentos)";          
 	}
	
}
