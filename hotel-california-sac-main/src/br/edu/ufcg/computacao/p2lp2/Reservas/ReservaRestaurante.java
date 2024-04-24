package br.edu.ufcg.computacao.p2lp2.Reservas;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.Refeicao;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.Usuario;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservaRestaurante extends Reserva{
    protected Refeicao refeicao;
    public ReservaRestaurante(Usuario cliente, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas, Refeicao refeicao) {
        super(cliente, dataInicio, dataFim);
        this.reservaTaAtiva = true;
        this.tipoReserva = "RESTAURANTE";
        this.quantidadePessoas = quantidadePessoas;
        this.refeicao = refeicao;
        this.horarioInicio = LocalTime.from(this.refeicao.getHorarioInicio());
        this.horarioFim = LocalTime.from(this.refeicao.getHorarioFinal());
        this.duracao = Duration.between(dataInicio, dataFim).toHours();
        this.idReserva = random.nextLong();
    }

    public double valorReservaSemDuracao() {
        return this.quantidadePessoas * this.refeicao.getValorRefeicao();
    }

    public void setValorReserva() {
        this.valorReserva = this.quantidadePessoas * Math.ceil(this.duracao/24) * this.refeicao.getValorRefeicao();
    }

    public String situacaoDoPagamento(){
        if (pago == true){
            return "REALIZADO";
        } return "PENDENTE";
    }

    @Override
    public String toString() {
        if (aReservaTaAtiva()) {
            return "[" + getIdReserva() + "] " + "Reserva de RESTAURANTE em favor de:\n" + this.cliente.toString() +
                    "\nDetalhes da reserva:" +
                    "\n- Periodo:" + getDataInicio() + " " + getHorarioInicio() + " ate " + getDataFim() + " " + getHorarioFim() +
                    "\n - Qtde. de Convidados: " + getQuantidadePessoas() + "pessoa(s)" +
                    "\n- Refeicao incluida: " + refeicao.toString() +
                    "\nVALOR TOTAL DA RESERVA: R$" + valorReservaSemDuracao() + " x" + getDuracao() + "(diarias) => R$" + getValorReserva() +
                    "SITUACAO DO PAGAMENTO: " + situacaoDoPagamento() + ".";
        } else {
            return "[CANCELADA] [" + getIdReserva() + "] " + "Reserva de RESTAURANTE em favor de:\n" + this.cliente.toString() +
                    "\nDetalhes da reserva:" +
                    "\n- Periodo:" + getDataInicio() + " " + getHorarioInicio() + " ate " + getDataFim() + " " + getHorarioFim() +
                    "\n - Qtde. de Convidados: " + getQuantidadePessoas() + "pessoa(s)" +
                    "\n- Refeicao incluida: " + refeicao.toString() +
                    "\nVALOR TOTAL DA RESERVA: R$" + valorReservaSemDuracao() + " x" + getDuracao() + "(diarias) => R$" + getValorReserva() +
                    "SITUACAO DO PAGAMENTO: " + situacaoDoPagamento() + ".";
        }
    }
}