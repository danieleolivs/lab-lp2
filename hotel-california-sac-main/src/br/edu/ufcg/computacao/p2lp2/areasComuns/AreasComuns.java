package br.edu.ufcg.computacao.p2lp2.areasComuns;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Random;

public abstract class AreasComuns {
    Random random = new Random();
    protected String titulo;
    protected String tipoAreaComum;
    protected LocalTime horarioInicio;
    protected LocalTime horarioFim;
    protected double valorPessoa;
    protected boolean disponivel;
    protected int qtMaxPessoas;
    protected long idAreaComum;


    public AreasComuns(String tipoAreaComum,  String titulo, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel, int qtMaxPessoas){
        this.titulo = titulo;
        this.tipoAreaComum = tipoAreaComum;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFinal;
        this.valorPessoa = valorPessoa;
        this.disponivel = disponivel;
        this.qtMaxPessoas = qtMaxPessoas;
    }

    public long getIdAreaComum() {
        return idAreaComum;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipoAreaComum() {
        return tipoAreaComum;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public int getQtMaxPessoas() {
        return qtMaxPessoas;
    }

    public double getValorPessoa() {
        return valorPessoa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public void setValorPessoa(double valorPessoa) {
        this.valorPessoa = valorPessoa;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setQtMaxPessoas(int qtMaxPessoas) {
        this.qtMaxPessoas = qtMaxPessoas;
    }

    @Override
    public String toString() {
       return this.tipoAreaComum + ": " + this.titulo + " (" + this.horarioInicio + " " + this.horarioFim + "). Valor por pssoa: \nR$" + this.valorPessoa+". Capacidade: " + this.qtMaxPessoas + " pessoa(s). " + this.disponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreasComuns that = (AreasComuns) o;
        return Double.compare(valorPessoa, that.valorPessoa) == 0 && disponivel == that.disponivel && qtMaxPessoas == that.qtMaxPessoas && Objects.equals(titulo, that.titulo) && Objects.equals(tipoAreaComum, that.tipoAreaComum) && Objects.equals(horarioInicio, that.horarioInicio) && Objects.equals(horarioFim, that.horarioFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, tipoAreaComum, horarioInicio, horarioFim, valorPessoa, disponivel, qtMaxPessoas);
    }
}