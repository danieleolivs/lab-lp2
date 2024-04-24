package br.edu.ufcg.computacao.p2lp2.Reservas;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.Usuario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public abstract class Reserva {
    Random random = new Random();
    protected Usuario cliente;
    protected LocalDateTime dataInicio;
    protected LocalDateTime dataFim;
    protected boolean pago;
    protected LocalTime horarioInicio;
    protected LocalTime horarioFim;
    protected String tipoReserva;
    protected long idReserva;
    protected boolean reservaTaAtiva;
    protected int quantidadePessoas;
    protected double valorReserva;
    protected double duracao;

    public Reserva(Usuario cliente, LocalDateTime dataInicio, LocalDateTime dataFim){
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public long getIdReserva() {
        return idReserva;
    }
    public boolean aReservaTaAtiva() {
        return reservaTaAtiva;
    }
    public void setReservaTaAtiva() {
        this.reservaTaAtiva = false;
    }
    public double getDuracao() {
        return Math.ceil(duracao/24);
    }
    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public double getValorReserva() {
        return valorReserva;
    }
}
