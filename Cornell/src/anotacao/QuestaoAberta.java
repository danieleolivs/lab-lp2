package anotacao;

public class QuestaoAberta extends Questao{

	public QuestaoAberta(String enunciado, String gabarito, int prioridade) {
		super(enunciado, gabarito, prioridade);
	}

	@Override
	protected void calculaPesoQuestao(int prioridade) {
		this.peso = this.prioridade * 1.2;
	}

	@Override
	public String toString() {
		
		return this.enunciado + "(" + this.peso + ")";
	}

	@Override
	protected boolean verificaGabarito(String resposta) {
		
		return true;
	}

}
