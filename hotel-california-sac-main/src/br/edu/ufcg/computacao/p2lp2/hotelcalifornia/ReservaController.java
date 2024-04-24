package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;
import br.edu.ufcg.computacao.p2lp2.Reservas.Reserva;
import br.edu.ufcg.computacao.p2lp2.Reservas.ReservaAuditorio;
import br.edu.ufcg.computacao.p2lp2.Reservas.ReservaRestaurante;
import br.edu.ufcg.computacao.p2lp2.Exception.HotelCaliforniaException;
import br.edu.ufcg.computacao.p2lp2.areasComuns.AreasComuns;
import br.edu.ufcg.computacao.p2lp2.Reservas.ReservaQuarto;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.QuartoFamily;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.QuartosInterface;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que controla as principais funcionalidades do Hotel California
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 *
 */
public class ReservaController {
    private HashMap<Long, Reserva> mapaReservas;
    private ArrayList<ReservaQuarto> reservasQuartos;
    private QuartoGeralController objetoQuarto;
    private QuartoFamily objetoFamily;
    private Reserva objetoReserva;
    private Usuario usuario;
    private QuartosInterface quarto;
    private Refeicao refeicao;
    private ReservaQuarto objetoReservaQuarto;
    private Reserva reserva;
    private static ReservaController reservaController;
    private ReservaRestaurante reservaRestaurante;
    private ReservaAuditorio reservaAuditorio;
    private Reserva reservaCancelada;
    public ReservaController(){
        this.mapaReservas = new HashMap<>();
        this.reservasQuartos = new ArrayList<>();
    }


    /**
     * @author Fernando Gentil 122110631
     * Verifica se o quarto foi reservado. Se foi, retorna true, se não, false.
     * @param numQuarto numero do quarto
     * @return retorna se é true ou false
     */
    private boolean verificaQuartoReservado(int numQuarto) {
        return objetoQuarto.getQuarto(numQuarto).isReservaSimNao();
    }

    /**
     * @author Fernando Gentil 122110631
     * Método que reserva o quarto single
     * @param idAutenticacao id de autenticação do usuario
     * @param idCliente id do cliente
     * @param quartoAlocado numero do quarto
     * @param dataInicio data de inicio
     * @param dataFim data de fim
     * @param idRefeicoes id das refeiçoes
     * @return retorna erros caso não atenda os requisitos e retorna uma mensagem caso atenta o requisito.
     */
    public String reservarQuartoSingle(String idAutenticacao, Usuario idCliente, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes) {

        if(!idAutenticacao.contains("GER") || !idAutenticacao.contains("FUN")) {
            throw new IllegalArgumentException("NAO E POSSIVEL PARA USUARIO" + "\n" + "CADASTRAR UMA RESERVA");
        }

        if(verificaQuartoReservado(quartoAlocado))  {
            throw new IllegalArgumentException("O QUARTO JÁ FOI RESERVADO!");
        }

        for(ReservaQuarto reserva: this.reservasQuartos) {
            if(objetoReservaQuarto.getquartoAlocado() == quartoAlocado) {
                if(reserva.getDataInicio().isAfter(dataInicio) && reserva.getDataFim().isBefore(dataInicio)) {
                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                }
            }
        }

        ReservaQuarto single = new ReservaQuarto(idCliente, dataInicio, dataFim, quartoAlocado, idRefeicoes);
        this.reservasQuartos.add(single);
        return "QUARTO SINGLE RESERVADO COM SUCESSO!";
    }


    /**
     * Método que reserva o quarto double
     * @param idAutenticacao id de autenticação do usuario
     * @param idCliente id do cliente
     * @param quartoAlocado numero do quarto
     * @param dataInicio data de inicio
     * @param dataFim data de fim
     * @param idRefeicoes id das refeiçoes
     * @param pedidos pedidos dos clientes
     * @return retorna erros caso não atenda os requisitos e retorna uma mensagem caso atenta o requisito.
     */
    public String reservarQuartoDouble(Usuario idCliente, String idAutenticacao, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes, String[] pedidos) {
        if(!idAutenticacao.contains("GER") || !idAutenticacao.contains("FUN")) {
            throw new IllegalArgumentException("NAO E POSSIVEL PARA USUARIO" + "\n" + "CADASTRAR UMA RESERVA");
        }

        if(verificaQuartoReservado(quartoAlocado))  {
            throw new IllegalArgumentException("O QUARTO JÁ FOI RESERVADO!");
        }

        for(ReservaQuarto reserva: this.reservasQuartos) {
            if(objetoReservaQuarto.getquartoAlocado() == quartoAlocado) {
                if(reserva.getDataInicio().isAfter(dataInicio) && reserva.getDataFim().isBefore(dataInicio)) {
                    throw new IllegalArgumentException("ESSA RESERVA JÁ FOI OCUPADA!");
                }
            }
        }

        ReservaQuarto duplo = new ReservaQuarto(idCliente, dataInicio, dataFim, quartoAlocado, idRefeicoes);
        this.reservasQuartos.add(duplo);
        return "QUARTO DOUBLE RESERVADO COM SUCESSO!";
    }

    /**
     * Método que reserva o quarto family
     * @param idAutenticacao id de autenticação do usuario
     * @param idCliente id do cliente
     * @param quartoAlocado numero do quarto
     * @param dataInicio data de inicio
     * @param dataFim data de fim
     * @param idRefeicoes id das refeiçoes
     * @param pedidos pedidos dos clientes
     * @param numPessoas numero de pessoas que irão acomodar o quarto family
     * @return retorna erros caso não atenda os requisitos e retorna uma mensagem caso atenta o requisito.
     */
    public String reservarQuartoFamily(Usuario idCliente, String idAutenticacao, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes, String[] pedidos, int numPessoas) {
        if(!idAutenticacao.contains("GER") || !idAutenticacao.contains("FUN") || !idAutenticacao.contains("ADM")) {
            throw new IllegalArgumentException("USUARIO INVALIDO");
        }

        if(verificaQuartoReservado(quartoAlocado))  {
            throw new IllegalArgumentException("O QUARTO JÁ FOI RESERVADO!");
        }

        if(numPessoas <= 2) {
            throw new IllegalArgumentException();
        }

        if(numPessoas > objetoFamily.getVaga()) {
            throw new IllegalArgumentException("CAPACIDADE EXCEDIDA");
        }

        for(ReservaQuarto reserva: this.reservasQuartos) {
            if(objetoReservaQuarto.getquartoAlocado() == quartoAlocado) {
                if(reserva.getDataInicio().isAfter(dataInicio) && reserva.getDataFim().isBefore(dataInicio)) {
                    throw new IllegalArgumentException("ESSA RESERVA JÁ FOI OCUPADA!");
                }
            }
        }

        ReservaQuarto family = new ReservaQuarto(idCliente, dataInicio, dataFim, quartoAlocado, numPessoas, idRefeicoes);
        this.reservasQuartos.add(family);
        return "QUARTO FAMILY RESERVADO COM SUCESSO!";
    }

    /**
     * @author Fernando Gentil 122110631
     * @param idAutenticacao id de autenticacao do usuario
     * @param idReserva id de reserva do quarto
     * @return retorna uma string formatada
     */
    public String exibeReservaQuarto(String idAutenticacao, long idReserva) {
        if(!idAutenticacao.contains("GER") || !idAutenticacao.contains("FUN") || !idAutenticacao.contains("ADM")) {
            throw new IllegalArgumentException("USUARIO INVALIDO");
        }

        if(!verificaQuartoReservado((int) idReserva)) {
            return "O QUARTO NÃO FOI RESERVADO.";
        }
        return "[" + objetoReserva.getIdReserva() + "] " + "Reserva de quarto em favor de:" + "\n" +
                "- " + usuario.toString() + "\n" + "Detalhes da instalacao:" + "\n" + "- " + quarto.exibirQuarto() +
                "\n" + "Detalhes da reserva:" + "- Periodo: " + objetoReserva.getDataInicio() + " ate " + objetoReserva.getDataFim() + "\n" +
                "- " + "No. Hospedes: " + quarto.getVaga() + " pessoa(s)" + "\n" + "- " + "Refeicoes incluidas:" +
                refeicao.toString() + "\n" + "VALOR TOTAL DA RESERVA: " + quarto.calcularDiaria() + " x" + objetoReservaQuarto.calculaIntervaloDiaria() + "(diarias) => " + objetoReservaQuarto.calcularReservaQuarto() + "\n" +
                "SITUACAO DO PAGAMENTO: " + reserva.isPago();

    }

    public String reservarRestaurante(Usuario cliente, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas, Refeicao refeicao){
        if (quantidadePessoas <= 50){
            if (((Duration.between(LocalDateTime.now(), dataInicio)).toHours())/24 >= 1){
                for (Reserva reservaVerif : mapaReservas.values()){
                    if(reservaVerif.getTipoReserva().equals("RESTAURANTE")){
                        if (reservaVerif.getDataInicio().isAfter(dataInicio) && reservaVerif.getDataFim().isBefore(dataFim)){
                            throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                        } else {
                            if (reservaVerif.getHorarioInicio().isBefore(refeicao.getHorarioInicio())){
                                if (reservaVerif.getHorarioFim().isAfter(refeicao.getHorarioFinal())){
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else if (reservaVerif.getHorarioFim().isBefore(refeicao.getHorarioFinal())){
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else {
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                }
                            } else if (reservaVerif.getHorarioInicio().isAfter(refeicao.getHorarioInicio())){
                                if (reservaVerif.getHorarioFim().isAfter(refeicao.getHorarioFinal())){
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else if (reservaVerif.getHorarioFim().isBefore(refeicao.getHorarioFinal())){
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else {
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                }
                            } else {
                                if (reservaVerif.getHorarioFim().isAfter(refeicao.getHorarioFinal())){
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else if (reservaVerif.getHorarioFim().isBefore(refeicao.getHorarioFinal())){
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else {
                                    throw new IllegalArgumentException("JA EXISTE RESERVA PARA ESTA DATA");
                                }
                            }
                        }
                    }
                }
                reservaRestaurante = new ReservaRestaurante(cliente, dataInicio, dataFim, quantidadePessoas, refeicao);
                this.mapaReservas.put(reservaRestaurante.getIdReserva(), this.reservaRestaurante);
                return "RESTAURANTE RESERVADO COM SUCESSO";
            } throw new HotelCaliforniaException("NECESSARIO ANTECEDENCIA MINIMA DE 01 (UM) DIA");
        } throw new HotelCaliforniaException("CAPACIDADE EXCEDIDA");
    }

    public void cancelarReserva(Usuario cliente, String idReserva){
        if (this.mapaReservas.get(idReserva).aReservaTaAtiva()) {
            if (this.mapaReservas.get(idReserva).getCliente().equals(cliente)) {
                if (Duration.between(LocalDateTime.now(), this.mapaReservas.get(idReserva).getHorarioInicio()).toHours() >= 24) {
                    this.mapaReservas.get(idReserva).setReservaTaAtiva();
                    this.reservaCancelada = this.mapaReservas.get(idReserva);
                    this.mapaReservas.remove(idReserva);
                } throw new HotelCaliforniaException("NECESSARIO ANTECEDENCIA MINIMA DE 01 (UM) DIA");
            } throw new HotelCaliforniaException("SOMENTE O PROPRIO CLIENTE PODERA CANCELAR A SUA RESERVA");
        } throw new HotelCaliforniaException("RESERVA JÁ CANCELADA");
    }

    public void cancelarReserva(Usuario cliente, long idReserva){
        if (this.mapaReservas.get(idReserva).aReservaTaAtiva()) {
            if (this.mapaReservas.get(idReserva).getCliente().equals(cliente)) {
                if (Duration.between(LocalDateTime.now(), this.mapaReservas.get(idReserva).getHorarioInicio()).toHours() >= 24) {
                    this.mapaReservas.get(idReserva).setReservaTaAtiva();
                    this.reservaCancelada = this.mapaReservas.get(idReserva);
                    this.mapaReservas.remove(idReserva);
                } throw new HotelCaliforniaException("NECESSARIO ANTECEDENCIA MINIMA DE 01 (UM) DIA");
            } throw new HotelCaliforniaException("SOMENTE O PROPRIO CLIENTE PODERA CANCELAR A SUA RESERVA");
        } throw new HotelCaliforniaException("RESERVA JÁ CANCELADA");
    }

    public static ReservaController getInstance() {
        if (reservaController == null){
            reservaController = new ReservaController();
        } return reservaController;
    }

    public HashMap<Long, Reserva> getMapaReservas() {
        return mapaReservas;
    }

    public Reserva getReservaCancelada() {
        return reservaCancelada;
    }

    public String reservarAuditorio(Usuario cliente, AreasComuns auditorio, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas){
        if (quantidadePessoas <= 130){
            if (((Duration.between(LocalDateTime.now(), dataInicio)).toHours())/24 >= 1){
                for (Reserva reservaVerif : mapaReservas.values()){
                    if(reservaVerif.getTipoReserva().equals("AUDITÓRIO")){
                        if (reservaVerif.getDataInicio().isAfter(dataInicio) && reservaVerif.getDataFim().isBefore(dataFim)){
                            throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                        } else {
                            if (reservaVerif.getHorarioInicio().isBefore(auditorio.getHorarioInicio())){
                                if (reservaVerif.getHorarioFim().isAfter(auditorio.getHorarioFim())){
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else if (reservaVerif.getHorarioFim().isBefore(auditorio.getHorarioFim())){
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else {
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                }
                            } else if (reservaVerif.getHorarioInicio().isAfter(auditorio.getHorarioInicio())){
                                if (reservaVerif.getHorarioFim().isAfter(auditorio.getHorarioFim())){
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else if (reservaVerif.getHorarioFim().isBefore(auditorio.getHorarioFim())){
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else {
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                }
                            } else {
                                if (reservaVerif.getHorarioFim().isAfter(auditorio.getHorarioFim())){
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else if (reservaVerif.getHorarioFim().isBefore(auditorio.getHorarioFim())){
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                } else {
                                    throw new HotelCaliforniaException("JA EXISTE RESERVA PARA ESTA DATA");
                                }
                            }
                        }
                    }
                }
                reservaAuditorio = new ReservaAuditorio(cliente, auditorio, dataInicio, dataFim, quantidadePessoas);
                this.mapaReservas.put(reservaAuditorio.getIdReserva(), this.reservaAuditorio);
                return "AUDITÓRIO RESERVADO COM SUCESSO";
            } throw new HotelCaliforniaException("NECESSARIO ANTECEDENCIA MINIMA DE 01 (UM) DIA");
        } throw new HotelCaliforniaException("CAPACIDADE EXCEDIDA");
    }
}
