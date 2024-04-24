package br.edu.ufcg.computacao.p2lp2.formaPagamento;

public class PagarComPix extends Pagamento{
	
	protected String cpf;
	protected String banco;

	public PagarComPix(String idCliente, long IdReserva, String nomeTitular, String cpf, String banco) {
		super(idCliente, IdReserva, nomeTitular);
		this.banco = banco;
		this.cpf = cpf;
		this.totalDesconto = 0.05;
		
	}
	
}
