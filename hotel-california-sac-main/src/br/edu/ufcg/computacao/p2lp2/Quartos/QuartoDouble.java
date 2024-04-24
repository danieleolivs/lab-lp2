package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe que tem as caracteristicas principais de um quarto double, e que faz o uso da interface.
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 */
public class QuartoDouble implements QuartosInterface {
	// atributo que define a constante de numeros de vagas
	private final int vaga;
	
	// atributo que define o numero do quarto
	private int numeroQuarto;
	
	// atributo que define o valor basico
	private double valorBasico;
	
	// atributo que define o valor por pessoa
	private double valorPessoa;
	
	// atributo para ser usado como parametro no metodo fazer pedido
	private String pedido;
	
	// atributo que define uma lista de pedidos
	private String[] pedidos;
	
	private boolean reservaSimNao;
	
	/**
	 * Construtor da classe double
	 * @param vaga parametro que recebe o numero de vagas
	 * @param numeroQuarto parametro que recebe o numero do quarto
	 */
	public QuartoDouble(int vaga, int numeroQuarto, String[] pedidos) {
		this.vaga = 2;
		this.numeroQuarto = numeroQuarto;
		this.pedidos = pedidos;
		this.reservaSimNao = true;
	}
	
	// método que calcula a diaria do quarto, que estará presente na interface
	@Override
	public int calcularDiaria() {
		return (int) (valorBasico + (valorPessoa * vaga));
	}
	
	// método que exibe os quartos com suas respectivas descrições dentro da caracteristica de Quarto Double
	public String[] getPedidos() {
		return pedidos;
	}

	@Override
	public String exibirQuarto() {
		return "[" + this.numeroQuarto + "] " + "Quarto Double " + "(" + "custo básico: " + "R$" + this.valorBasico + ", " + "adiciona por pessoa: " +
				"\n" + "R$" + this.valorPessoa + " >>> " + "R$" + calcularDiaria() + " diária." + ")." +" Pedidos: " + pedidosToString();
	}
	
	private String pedidosToString() {
		String conc = "";
		if(this.pedidos.length == 0) {
			conc = "(nenhum)";
		} else {
			conc = Arrays.toString(pedidos);
		}
		return conc;
	}
	
	@Override
	public int getVaga() {
		return vaga;
	}
	
	@Override
	public boolean isReservaSimNao() {
		return reservaSimNao;
	}
	
	@Override
	public void setReservaSimNao(boolean reservaSimNao) {
		this.reservaSimNao = reservaSimNao;
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
