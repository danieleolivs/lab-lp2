package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import java.time.LocalTime;
import java.util.HashMap;

public class RefeicaoController {
    // Hashmap que guarda as refeicoes
    private HashMap<Long, Refeicao> mapaRefeicoes;
    private Refeicao refeicao;
    private static RefeicaoController refeicaoController;

    public RefeicaoController() {
        this.mapaRefeicoes = new HashMap<>();

    }

    /**
     * Disponibiliza refeições no sistema
     * @param id do usuario
     * @param tipoRefeicao o tipo da refeicao (cafe da manha, almoco e jantar)
     * @param tituloRefeicao o titulo da refeicao
     * @param horarioInicio o horario em que a refeicao comecara a estar disponivel
     * @param horarioFinal o horario em que a refeicao nao estara mais disponivel
     * @param valorRefeicao preco da refeicao por pessoa
     * @param disponivel se esta disponivel ou nao
     * @return "REFEIÇÃO DISPONIBILIZADA COM SUCESSO!" se a disponibilizacao foi bem sucedida
     */
    public String disponibilizarRefeicao(String id, String tipoRefeicao, String tituloRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorRefeicao, boolean disponivel){
        if (horarioFinal.isAfter(horarioInicio)) {
            for (Refeicao verificaTitulo : this.mapaRefeicoes.values()) {
                if (verificaTitulo.getTituloRefeicao().equals(tituloRefeicao)) {
                    throw new IllegalArgumentException("REFEIÇÃO JÁ EXISTE!");
                }
            }
            if (tipoRefeicao.equals("Cafe-da-manha") || tipoRefeicao.equals("Almoco") || tipoRefeicao.equals("Jantar")) {
                this.refeicao = new Refeicao(tipoRefeicao, tituloRefeicao, horarioInicio, horarioFinal, valorRefeicao, disponivel);
                if (mapaRefeicoes.put(refeicao.getIdRefeicao(), refeicao).equals(true)) {
                    return "REFEIÇÃO DISPONIBILIZADA COM SUCESSO!";
                }
                throw new IllegalArgumentException("REFEIÇÃO JÁ EXISTE!");
            } throw new IllegalArgumentException("TIPO NÃO EXISTE!");
        } throw new IllegalArgumentException("HORÁRIOS INVÁLIDOS!");
    }

    /**
     * Permite alterar a disponibilidade de horarios da refeicao, se esta disponivel e o preco refeicao no sistema
     * @param idRefeicao a identificacao da refeicao
     * @param horarioInicio o horario em que a refeicao comecara a estar disponivel
     * @param horarioFinal o horario em que a refeicao nao estara mais disponivel
     * @param valorPessoa preco da refeicao por pessoa
     * @param disponivel se esta disponivel ou nao
     * @return "REFEIÇÃO ATUALIZADA COM SUCESSO!"g se a alteracao foi realizada com sucesso
     */
    public String alterarRefeicao(long idRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel){
        if (this.mapaRefeicoes.containsKey(idRefeicao)) {
            this.mapaRefeicoes.get(idRefeicao).setHorarioInicio(horarioInicio);
            if (horarioFinal.isAfter(horarioInicio)) {
                this.mapaRefeicoes.get(idRefeicao).setHorarioFinal(horarioFinal);
                this.mapaRefeicoes.get(idRefeicao).setValorRefeicao(valorPessoa);
                this.mapaRefeicoes.get(idRefeicao).setDisponivel(disponivel);
                return "REFEIÇÃO ATUALIZADA COM SUCESSO!";
            } throw new IllegalArgumentException("HORÁRIOS INVÁLIDOS!");
        } throw new IllegalArgumentException("REFEIÇÃO NÃO CADASTRADA!");
    }

    /**
     * Permite alterar a disponibilidade de horarios da refeicao, se esta disponivel e o preco refeicao no sistema
     * @param idRefeicao a identificacao da refeicao
     * @return toString da refeicao
     */
    public String exibirRefeicao(long idRefeicao){
        return this.mapaRefeicoes.get(idRefeicao).toString();
    }

    /**
     * Lista todos os usuários cadastrados no sistema
     * @return lista com o toString de todos as refeicoes cadastradas
     */
    public String listarRefeicoes(){
        String saidaRefeicoes = "";
        for(long refeicoess : mapaRefeicoes.keySet()) {
            saidaRefeicoes += this.mapaRefeicoes.get(refeicoess).toString() + "\n";
        } return saidaRefeicoes;
    }

    public static RefeicaoController getInstance() {
        if (refeicaoController == null){
            refeicaoController = new RefeicaoController();
        } return refeicaoController;
    }
    public void init() {
        this.mapaRefeicoes.clear();
    }

    public HashMap<Long, Refeicao> getMapaRefeicoes() {
        return mapaRefeicoes;
    }
}
