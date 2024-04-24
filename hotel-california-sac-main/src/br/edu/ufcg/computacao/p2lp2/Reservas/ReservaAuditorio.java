package br.edu.ufcg.computacao.p2lp2.Reservas;

import br.edu.ufcg.computacao.p2lp2.Exception.HotelCaliforniaException;
import br.edu.ufcg.computacao.p2lp2.areasComuns.AreasComuns;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.Usuario;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservaAuditorio extends Reserva{
    private AreasComuns auditorio;
    public ReservaAuditorio(Usuario cliente, AreasComuns auditorio, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas) {
        super(cliente, dataInicio, dataFim);
        this.reservaTaAtiva = true;
        if (this.auditorio.getTipoAreaComum().equals("Auditório")){
            this.tipoReserva = "AUDITÓRIO";
            this.quantidadePessoas = quantidadePessoas;
            this.auditorio = auditorio;
            this.horarioInicio = LocalTime.from(this.auditorio.getHorarioInicio());
            this.horarioFim = LocalTime.from(this.auditorio.getHorarioFim());
            this.duracao = Duration.between(dataInicio, dataFim).toHours();
            this.idReserva = random.nextLong();
        } throw new HotelCaliforniaException("A ÁREA INFORMADA NAO CORRESPONDE A UM AUDITÓRIO");
    }

    public double valorReservaSemDuracao() {
        return this.quantidadePessoas * this.auditorio.getValorPessoa();
    }

    public void setValorReserva() {
        this.valorReserva = this.quantidadePessoas * Math.ceil(this.duracao/24) * this.auditorio.getValorPessoa();
    }

    public String situacaoDoPagamento(){
        if (pago == true){
            return "REALIZADO";
        } return "PENDENTE";
    }

    @Override
    public String toString() {
        if (aReservaTaAtiva()) {
            return "[" + getIdReserva() + "] " + "Reserva de AUDITORIO em favor de:\n" + this.cliente.toString() +
                    "\nDetalhes da reserva:" +
                    "\n- Periodo:" + getDataInicio() + " " + getHorarioInicio() + " ate " + getDataFim() + " " + getHorarioFim() +
                    "\n - Qtde. de Convidados: " + getQuantidadePessoas() + "pessoa(s)" +
                    "\n- Refeicao incluida: " + auditorio.toString() +
                    "\nVALOR TOTAL DA RESERVA: R$" + valorReservaSemDuracao() + " x" + getDuracao() + "(diarias) => R$" + getValorReserva() +
                    "SITUACAO DO PAGAMENTO: " + situacaoDoPagamento() + ".";
        } else {
            return "[CANCELADA] [" + getIdReserva() + "] " + "Reserva de RESTAURANTE em favor de:\n" + this.cliente.toString() +
                    "\nDetalhes da reserva:" +
                    "\n- Periodo:" + getDataInicio() + " " + getHorarioInicio() + " ate " + getDataFim() + " " + getHorarioFim() +
                    "\n - Qtde. de Convidados: " + getQuantidadePessoas() + "pessoa(s)" +
                    "\n- Refeicao incluida: " + auditorio.toString() +
                    "\nVALOR TOTAL DA RESERVA: R$" + valorReservaSemDuracao() + " x" + getDuracao() + "(diarias) => R$" + getValorReserva() +
                    "SITUACAO DO PAGAMENTO: " + situacaoDoPagamento() + ".";
        }
    }
}
