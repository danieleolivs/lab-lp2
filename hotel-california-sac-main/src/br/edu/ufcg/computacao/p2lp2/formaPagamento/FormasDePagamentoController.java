package br.edu.ufcg.computacao.p2lp2.formaPagamento;

import br.edu.ufcg.computacao.p2lp2.Exception.HotelCaliforniaException;

import java.util.HashMap;

public class FormasDePagamentoController {
    private HashMap<Integer, FormasDePagamento> mapaFormasDePagamento;
    FormasDePagamento pagamento;

    public FormasDePagamentoController(){
        this.mapaFormasDePagamento = new HashMap<>();

    }

    public String disponibilizarFormaDePagamento(String idAutenticacao, String formaPagamento, double percentualDesconto){
        if(formaPagamento.equals("PIX")) {
            this.pagamento = new Pix(idAutenticacao, formaPagamento, percentualDesconto);
        }else if(formaPagamento.equals("Cartão")) {
            this.pagamento = new Cartao(idAutenticacao, formaPagamento, percentualDesconto);
        }else if(formaPagamento.equals("Dinheiro")) {
            this.pagamento = new Dinheiro(idAutenticacao, formaPagamento, percentualDesconto);
        }

        this.mapaFormasDePagamento.put(this.mapaFormasDePagamento.size()+1, pagamento);
        return "PAGAMENTO ADICIONADO COM SUCESSO";
    }

    public String alterarFormaDePagamento(String idAutenticacao, int idFormaPagamento, String formaPagamento, double percentualDesconto) {

        if(!mapaFormasDePagamento.containsKey(idFormaPagamento)) {
            throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO CADASTRADA");
        }

        mapaFormasDePagamento.get(idFormaPagamento).setPercentualDesconto(percentualDesconto);
        return "DESCONTO ATUALIZADO COM SUCESSO";
    }

    public String exibirFormaPagamento(int idFormaPagamento) {

        if(mapaFormasDePagamento.size() == 0){
            return "NENHUM PAGAMENTO CADASTRADO";
        }

        if(!mapaFormasDePagamento.containsKey(idFormaPagamento)) {
            throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO CADASTRADA");
        }

        return "[" + idFormaPagamento +"] "+ mapaFormasDePagamento.get(idFormaPagamento).toString();

    }

    public String listarFormasPagamento() {
        if(mapaFormasDePagamento.size() == 0){
            return "NENHUM PAGAMENTO CADASTRADO";
        }

        String concatPagamentos = "";

        for(int pagamento: this.mapaFormasDePagamento.keySet()) {
            concatPagamentos += "[" + pagamento + "] " + this.mapaFormasDePagamento.get(pagamento).toString() + "\n";
        }

        return concatPagamentos;
    }
}
