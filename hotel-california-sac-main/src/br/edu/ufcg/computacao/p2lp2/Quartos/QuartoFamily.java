package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe que tem as caracteristicas principais de um quarto family, e que faz o
 * uso da interface.
 * 
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 */
public class QuartoFamily implements QuartosInterface {
	// atributo que define a variavel de numeros de vagas
	private int vaga;

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
	
	private int qtdMaximaPessoas;
	
	private boolean reservaSimNao;

	/**
	 * Construtor da classe QuartoFamily
	 * 
	 * @param numeroQuarto numero do quarto
	 */
	public QuartoFamily(int numeroQuarto, double valorBasico, double valorPessoa, String[] pedidos, int vaga) {
		this.numeroQuarto = numeroQuarto;
		this.vaga = vaga;
		this.valorBasico = valorBasico;
		this.valorPessoa = valorPessoa;	
		this.pedidos = pedidos;
		this.reservaSimNao = true;
	}
	
	public QuartoFamily(int numeroQuarto, String[] pedidos, int vaga) {
		this.numeroQuarto = numeroQuarto;
		this.vaga = vaga;
		this.pedidos = pedidos;
		this.vaga = vaga;
	}

	// metodo que calcula a diaria que está presente na interface
	@Override
	public int calcularDiaria() {
		return (int) (valorBasico + (valorPessoa * vaga));
	}
	
	@Override
	public int getVaga() {
		return vaga;
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
		
	// metodo que exibe os quartos com suas respectivas descrições dentro da caracteristica de Quarto Family
	@Override
	public String exibirQuarto() {
		return "[" + this.numeroQuarto + "] "  + "QuartoFamily " + "(" + "custo básico: " + "R$" + this.valorBasico + ", " + "adiciona por pessoa: " +
		"R$" + this.valorPessoa + " >>> " + "R$" + calcularDiaria() + " diária." + "). " + "Capacidade: " + this.vaga + " pessoa(s). " + "Pedidos: " + pedidosToString();
	}
	
	@Override
	public double getValorBasico() {
		return valorBasico;
	}
	
	@Override
	public double getValorPessoa() {
		return valorPessoa;
	}
	
	@Override
	public boolean isReservaSimNao() {
		return reservaSimNao;
	}
	
	@Override
	public void setReservaSimNao(boolean reservaSimNao) {
		this.reservaSimNao = reservaSimNao;
	}

	public int vaga() {
		return vaga;
	}

	public String[] getPedidos() {
		return pedidos;
	}
	
}
