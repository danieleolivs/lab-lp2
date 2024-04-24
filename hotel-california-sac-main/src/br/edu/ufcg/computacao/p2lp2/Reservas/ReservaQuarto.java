package br.edu.ufcg.computacao.p2lp2.Reservas;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.QuartosInterface;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.Refeicao;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.Usuario;
import java.time.LocalDateTime;

/**
 * Classe que cuida da manipulação dos tipos de reservas de quarto
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 */
public class ReservaQuarto extends Reserva {
	private int quartoAlocado;
	private int quantidadeHospedes;
	private int diarias;
	protected Refeicao refeicaoIncluida;
	private QuartosInterface valor;
	private boolean ativa;
	
	/**
	 * Reserva de Quarto Family
	 * @param cliente
	 * @param dataInicio
	 * @param dataFim
	 * @param quartoAlocado
	 * @param quantidadeHospedes
	 * @param refeicaoIncluida
	 */
	public ReservaQuarto(Usuario cliente, LocalDateTime dataInicio, LocalDateTime dataFim, int quartoAlocado, int quantidadeHospedes, Refeicao refeicaoIncluida) {
		super(cliente, dataInicio, dataFim);
		this.tipoReserva = "QUARTO";
		this.quantidadeHospedes = quantidadeHospedes;
		this.refeicaoIncluida = refeicaoIncluida;
		this.quartoAlocado = quartoAlocado;
		this.idReserva = random.nextLong();
		this.ativa = true;
		
	}
	
	/**
	 * Reserva de Quarto Single
	 * @param cliente
	 * @param dataInicio
	 * @param dataFim
	 * @param quartoAlocado
	 * @param refeicaoIncluida
	 */
	public ReservaQuarto(Usuario cliente, LocalDateTime dataInicio, LocalDateTime dataFim, int quartoAlocado, Refeicao refeicaoIncluida) {
		super(cliente, dataInicio, dataFim);
		this.tipoReserva = "QUARTO";
		this.refeicaoIncluida = refeicaoIncluida;
		this.quartoAlocado = quartoAlocado;
		this.idReserva = random.nextLong();
		this.ativa = true;
	}
	
	
	
	
	public String situacaoDoPagamento(){
        if (pago == true){
            return "PAGO";
        } return "PENDENTE";
    }

	public boolean isAtiva() {
		return ativa;
	}


	public int getQuartoAlocado() {
		return quartoAlocado;
	}
	
	
	public int calculaIntervaloDiaria() {
		return dataFim.getDayOfMonth() - dataInicio.getDayOfMonth();
	}


	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public void setQuartoAlocado(int quartoAlocado) {
		this.quartoAlocado = quartoAlocado;
	}



	public int getQuantidadeHospedes() {
		return quantidadeHospedes;
	}



	public void setQuantidadeHospedes(int quantidadeHospedes) {
		this.quantidadeHospedes = quantidadeHospedes;
	}



	public Refeicao getRefeicaoIncluida() {
		return refeicaoIncluida;
	}



	public int getquartoAlocado() {
		return quartoAlocado;
	}
	
	public double calcularReservaQuarto() {
		double preco = 0;
		double comida = preco + refeicaoIncluida.getValorRefeicao();
		return calculaIntervaloDiaria() * (valor.getValorBasico() + this.quantidadeHospedes * valor.getValorPessoa()) + calculaIntervaloDiaria() * this.quantidadeHospedes * comida;
	}
	
	
	
}
