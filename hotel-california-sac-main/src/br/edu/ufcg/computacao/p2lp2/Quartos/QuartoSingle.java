package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

/**
 * Classe que tem as caracteristicas principais de um quarto single, e que faz o uso da interface.
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 */
public class QuartoSingle implements QuartosInterface{
	// atributo que define a constante de numero de vagas para um quarto Single
	private final int vaga;
	
	// atributo que define o numero do quarto
	private int numeroQuarto;
	
	//atributo que define o valor basico
	private double valorBasico;
	
	//atributo que define o valor por pessoa
	private double valorPessoa;
	
	private boolean reservaSimNao;
	
	
	/**
	 * Construtor da classe que cria um objeto Quarto Single
	 * @param vaga numero de vagas
	 * @param numeroQuarto numero do quarto
	 */
	public QuartoSingle(int vaga, int numeroQuarto, double valorBasico, double valorPessoa) {
		this.vaga = 1;
		this.numeroQuarto = numeroQuarto;
		this.valorBasico = valorBasico;
		this.valorPessoa = valorPessoa;
		this.reservaSimNao = true;
	}
	
	@Override
	public boolean isReservaSimNao() {
		return reservaSimNao;
	}
	
	@Override
	public void setReservaSimNao(boolean reservaSimNao) {
		this.reservaSimNao = reservaSimNao;
	}

	public QuartoSingle() {
		this.vaga = 0;
		this.numeroQuarto = 0;
		this.valorBasico = 0.0;
		this.valorPessoa = 0.0;
	}
	
	// método que calcula a diaria do quarto, que estará presente na interface
	@Override
	public int calcularDiaria() {
		return (int) (valorBasico + (valorPessoa * vaga));
	}
	
	// método que irá exibir o quarto e irá descrever ele dentro da caracteristica de Quarto Single
	@Override
	public String exibirQuarto() {
		return  "[" + this.numeroQuarto + "] " + "Quarto Single (custo basico: " + this.valorBasico + ", " + "adicional por pessoa: " + "\n" + "R$" + this.valorPessoa +
				" >>> " + "R$" + calcularDiaria() + " diária" + ")";
	}
	
	@Override
	public int getVaga() {
		return vaga;
	}
	
	@Override
	public double getValorBasico() {
		return valorBasico;
	}
	
	@Override
	public double getValorPessoa() {
		return valorPessoa;
	}
}
