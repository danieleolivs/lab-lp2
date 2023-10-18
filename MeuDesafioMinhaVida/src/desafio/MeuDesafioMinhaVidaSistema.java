package desafio;

import java.util.HashMap;

public class MeuDesafioMinhaVidaSistema {
	
	private HashMap<Integer, Desafio> mapaDesafios;
	private HashMap<Integer, Acao> mapaAcao;
	
	Desafio desafio;
	Acao  acao;
	
	public MeuDesafioMinhaVidaSistema() {
		this.mapaDesafios = new HashMap<>();
		this.mapaAcao = new HashMap<>();
	}
	
	public String adicionaDesafioPessoal(String titulo, String descricao) {
		
		for(int idDesafio: mapaDesafios.keySet()) {
			if(mapaDesafios.get(idDesafio).getTitulo().equals(titulo)) {
				throw new IllegalArgumentException("TÍTULO JÁ CADASTRADO NO SISTEMA");
			}
		}
		
		int id = mapaDesafios.size() + 1;
		this.desafio = new DesafioPessoal(titulo, descricao);
		mapaDesafios.put(id, desafio);
		
		return "DESAFIO "+ id +" ADICIONADO COM SUCESSO";
	}
	
	public String adicionaDesafioMaterial(String titulo, int valor) {
		
		for(int idDesafio: mapaDesafios.keySet()) {
			if(mapaDesafios.get(idDesafio).getTitulo().equals(titulo)) {
				throw new IllegalArgumentException("TÍTULO JÁ CADASTRADO NO SISTEMA");
			}
		}
		
		int id = mapaDesafios.size() + 1;
		this.desafio = new DesafioMaterial(titulo, valor);
		mapaDesafios.put(id, desafio);
		
		return "DESAFIO "+ id +" ADICIONADO COM SUCESSO";
	}
	
	public String adicionaDesafioSocial(String titulo, int totalParticipantes) {
		
		for(int idDesafio: mapaDesafios.keySet()) {
			if(mapaDesafios.get(idDesafio).getTitulo().equals(titulo)) {
				throw new IllegalArgumentException("TÍTULO JÁ CADASTRADO NO SISTEMA");
			}
		}
		
		int id = mapaDesafios.size() + 1;
		this.desafio = new DesafioSocial(titulo, totalParticipantes);
		mapaDesafios.put(id, desafio);
		
		return "DESAFIO "+ id +" ADICIONADO COM SUCESSO";
	}
	
	public String exibirDesafio(int id) {
		
		if(!mapaDesafios.containsKey(id)) {
			throw new IllegalArgumentException("DESAFIO NÃO EXISTE NO SISTEMA");
		}
		
		return mapaDesafios.get(id).toString();
	}
	
	public String adicionaAcao(int id, String data, int codigo) {
		if(mapaAcao.containsKey(codigo)) {
			throw new IllegalArgumentException("CÓDIGO DE AÇÃO JÁ CADASTRADO");
		}
		
		this.acao = new Acao(id, data, codigo);
		mapaAcao.put(codigo, acao);
		return "AÇÃO ADICIONADA COM SUCESSO";
		
	}
	
	public void atualizaProgressoAcao(int codigo) {
		if(!mapaAcao.containsKey(codigo)) {
			throw new IllegalArgumentException("AÇÃO NÃO FOI CADASTRADA");
		}
		
		mapaAcao.get(codigo).atualizaAcao();
		
		if(mapaAcao.get(codigo).getTotalAcao() >= 100) {
			mapaDesafios.get(mapaAcao.get(codigo).getIdDesafio()).concluirDesafio();
		}
		
	}
	
	public void atualizaProgressoAcao(int codigo, int totalProgresso) {
		if(!mapaAcao.containsKey(codigo)) {
			throw new IllegalArgumentException("AÇÃO NÃO FOI CADASTRADA");
		}
		
		mapaAcao.get(codigo).atualizaAcao(totalProgresso);
		
		if(mapaAcao.get(codigo).getTotalAcao() >= 100) {
			mapaDesafios.get(mapaAcao.get(codigo).getIdDesafio()).concluirDesafio();
		}
		
	}
	
	public String listarAcoes() {
		String totalAcao = "";
		
		for(Integer chave: mapaAcao.keySet()) {
			totalAcao += mapaAcao.get(chave).toString() + mapaDesafios.get(mapaAcao.get(chave).getIdDesafio()).getTitulo() + " - Progresso " + mapaAcao.get(chave).getTotalAcao() + "\n";                         
		}
		
		return totalAcao;
	}
	
}
