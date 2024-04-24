package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

public interface QuartosInterface {
	public int calcularDiaria();
	public String exibirQuarto();
	public int getVaga();
	public boolean isReservaSimNao();
	public void setReservaSimNao(boolean reservaSimNao);
	public double getValorBasico();
	public double getValorPessoa();
}
