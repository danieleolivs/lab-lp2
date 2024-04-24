package br.edu.ufcg.computacao.p2lp2.formaPagamento;

public class PagarComDinheiro extends Pagamento{

	public PagarComDinheiro(String idCliente, long IdReserva, String nomeTitular) {
		super(idCliente, IdReserva, nomeTitular);
		this.totalDesconto = 0.1;
	}

}
