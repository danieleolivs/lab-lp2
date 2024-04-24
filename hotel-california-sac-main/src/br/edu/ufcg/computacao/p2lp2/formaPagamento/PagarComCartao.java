package br.edu.ufcg.computacao.p2lp2.formaPagamento;

public class PagarComCartao extends Pagamento{
	
	protected String numCartao;
	protected String validade;
	protected String codigoDeSeguranca;
	protected int qtdeParcelas;

	public PagarComCartao(String idCliente, long IdReserva, String nomeTitular, String numCartao, String validade, String codigoDeSeguranca, int qtdeParcelas) {
		super(idCliente, IdReserva, nomeTitular);
		this.numCartao = numCartao;
		this.codigoDeSeguranca = codigoDeSeguranca;
		this.validade = validade;
		this.qtdeParcelas = qtdeParcelas;
		this.totalDesconto = 1;
	}

	
}

