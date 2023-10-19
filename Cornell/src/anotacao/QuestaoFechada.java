package anotacao;

public class QuestaoFechada extends Questao {
	
	private String[] ArrayAlternativas;

	public QuestaoFechada(String enunciado, String gabarito, int prioridade, String[] alternativas) {
		super(enunciado, gabarito, prioridade);
		
		this.ArrayAlternativas = new String[alternativas.length];
		
		for(int i = 0; i < ArrayAlternativas.length; i++) {
			ArrayAlternativas[i] = alternativas[i];
		}
		
	}

	@Override
	protected void calculaPesoQuestao(int prioridade) {
		this.prioridade = (ArrayAlternativas.length/5);
	}

	@Override
	public String toString() {
		
		String alternativa = "";
		
		for(int i = 0; i < ArrayAlternativas.length; i++) {
			alternativa += ArrayAlternativas[i] + "\n";
		}
		
		return this.enunciado + "(" + this.peso + ")" + "\n" + alternativa;
	}

	@Override
	protected boolean verificaGabarito(String resposta) {
		if(resposta.equals(gabarito)) {
			return true;
		}
		return false;
	}

}
