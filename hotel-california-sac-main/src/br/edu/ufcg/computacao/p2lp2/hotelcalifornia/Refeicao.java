package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;
import java.time.*;
import java.util.Random;

/**
 * Classe que tem as informacoes gerais de uma Refeição, que serao usadas no sistema
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 *
 */
public class Refeicao {
    //objeto random para gerar um id long para a refeicao
    Random random = new Random();
    private String identificacao;
    private String tituloRefeicao;
    private String tipoRefeicao;
    private double valorRefeicao;
    private boolean disponivel;
    private long idRefeicao;
    private LocalTime horarioInicio;
    private LocalTime horarioFinal;

    /**
     * Construtor que define um usuário
     * @param tipoRefeicao o tipo da refeicao (cafe da manha, almoco e jantar)
     * @param tituloRefeicao o titulo da refeicao
     * @param horarioInicio o horario em que a refeicao comecara a estar disponivel
     * @param horarioFinal o horario em que a refeicao nao estara mais disponivel
     * @param valorRefeicao preco da refeicao por pessoa
     * @param disponivel se esta disponivel ou nao
     */
    public Refeicao(String tipoRefeicao, String tituloRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorRefeicao, boolean disponivel){
        this.tipoRefeicao = tipoRefeicao;
        this.tituloRefeicao = tituloRefeicao;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.valorRefeicao = valorRefeicao;
        this.disponivel = disponivel;
        this.idRefeicao = random.nextLong();

    }

    public double getValorRefeicao() {
        return valorRefeicao;
    }

    public void setValorRefeicao(double valorRefeicao) {
        this.valorRefeicao = valorRefeicao;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * Retorna um boolean quanto a disponibilidade da refeicao
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao() {
        this.identificacao = this.idRefeicao + " - " + this.tituloRefeicao;
    }

    public long getIdRefeicao() {
        return idRefeicao;
    }

    public String getTituloRefeicao() {
        return tituloRefeicao;
    }

    /**
     * Retorna a representação string do boolean de disponibilidade
     * @return "VIGENTE" se tiver disponivel, "INDISPONIVEL" se nao
     */
    private String disponibilidade(){
        if (this.disponivel){
            return "VIGENTE";
        } return "INDISPONIVEL";
    }

    /**
     * Retorna a representação de uma refeicao
     */
    @Override
    public String toString() {
        return ("[" + getIdRefeicao() + "]" + getTituloRefeicao() + ": " + getTituloRefeicao() + "(" + getHorarioInicio() + " as " + getHorarioFinal() + ". Valor por pessoa: R$" + getValorRefeicao() + ". " + disponibilidade());
    }
}