package anotacao;

public abstract class Questao {
	String enunciado;
	String gabarito;
	int prioridade;
	double peso;
	
	public Questao(String enunciado, String gabarito, int prioridade) {
		this.enunciado = enunciado;
		this.gabarito = gabarito;
		this.prioridade = prioridade;
		this.peso = 0;
		
	}
	
	protected abstract void calculaPesoQuestao(int prioridade);
	
	protected abstract boolean verificaGabarito(String resposta);
	
	@Override
	public abstract String toString();

}