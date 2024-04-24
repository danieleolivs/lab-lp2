package br.edu.ufcg.computacao.p2lp2.formaPagamento;

import java.util.ArrayList;

public class PagamentoController {
    private ArrayList<Pagamento> mapaPagamento;
    Pagamento pagar;

    public PagamentoController(){
        this.mapaPagamento = new ArrayList<>();
    }

    public String pagarReservaComDinheiro(String idCliente, int idReserva, String nomeTitular ) {
        this.pagar = new PagarComDinheiro(idCliente, idReserva, nomeTitular);
        this.mapaPagamento.add(pagar);
        return "RESERVA PAGA COM SUCESSO";
    }

    public String pagarReservaComCartao(String idCliente, int idReserva, String nomeTitular, String numCartao, String validade, String codigoDeSeguranca, int qtdeParcelas) {

        this.pagar = new PagarComCartao(idCliente, idReserva, nomeTitular, numCartao, validade, codigoDeSeguranca, qtdeParcelas);
        this.mapaPagamento.add(pagar);
        return "RESERVA PAGA COM SUCESSO";
    }

    public String pagarReservaComPix(String idCliente, int idReserva, String nomeTitular, String cpf, String banco) {

        this.pagar = new PagarComPix(idCliente, idReserva, nomeTitular, cpf, banco);
        this.mapaPagamento.add(pagar);
        return "RESERVA PAGA COM SUCESSO";
    }
}
