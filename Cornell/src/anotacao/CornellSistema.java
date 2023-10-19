package anotacao;

import java.util.HashMap;

public class CornellSistema {
	
	private HashMap <Integer, Anotacao> mapaAnotacoes;
	
	Anotacao anotacao;
	Questao questao;
	
	public CornellSistema() {
		this.mapaAnotacoes = new HashMap<>();
	}
	
	public String cadastrarAnotacao(String nomeDisciplina, String data, String texto) {
		
		if(nomeDisciplina.isEmpty()	|| nomeDisciplina.isBlank()) {
			throw new IllegalArgumentException("NOME DE DISCIPLINA NÃO PODE SER VAZIO");
		}
		
		this.anotacao = new Anotacao(nomeDisciplina, data, texto);
		mapaAnotacoes.put(calculaIdAnotacao(), anotacao);
		return "ANOTAÇÃO CADASTRADA COM SUCESSO";
	}
	
	private int calculaIdAnotacao() {
		return mapaAnotacoes.size() + 1;
	}
	
	public String definirSumario(int idAnotacao, String texto) {
		if(!mapaAnotacoes.containsKey(idAnotacao)) {
			throw new IllegalArgumentException("ANOTAÇÃO NÃO EXISTE");
		}
		
		mapaAnotacoes.get(idAnotacao).definirSumario(texto);
		return "SUMÁRIO DEFINIDO COM SUCESSO";
	}
	
	public String exibirAnotacao(int idAnotacao) {
		return mapaAnotacoes.get(idAnotacao).toString();
	}
	
	public void cadastrarQuestaoMultiplaEscolha(int idAnotacao, String enunciado, String[] alternativas, int prioridade, String gabarito) {
		if(!mapaAnotacoes.containsKey(idAnotacao)) {
			throw new IllegalArgumentException("ANOTAÇÃO NÃO EXISTE");
		}
		
		this.questao = new QuestaoFechada(enunciado, gabarito, prioridade, alternativas);
		
	}
	
	public void cadastrarQuestaoAberta(int idAnotacao, String enunciado, int prioridade, String gabarito) {
		if(!mapaAnotacoes.containsKey(idAnotacao)) {
			throw new IllegalArgumentException("ANOTAÇÃO NÃO EXISTE");
		}
		
		this.questao = new QuestaoAberta(enunciado, gabarito, prioridade);
		
	}
	
	public String exibirQuestao(int idAnotacao, int ordemQuestao) {
		if(!mapaAnotacoes.containsKey(idAnotacao)) {
			throw new IllegalArgumentException("ANOTAÇÃO NÃO EXISTE");
		}
		
		return mapaAnotacoes.get(idAnotacao).getQuestao(ordemQuestao).toString();
		
	}
	
	public boolean responderQuestao(int idAnotacao, int ordemQuestao, String resposta) {
		if(!mapaAnotacoes.containsKey(idAnotacao)) {
			throw new IllegalArgumentException("ANOTAÇÃO NÃO EXISTE");
		}
		
		return mapaAnotacoes.get(idAnotacao).getQuestao(ordemQuestao).verificaGabarito(resposta);
	}
}


