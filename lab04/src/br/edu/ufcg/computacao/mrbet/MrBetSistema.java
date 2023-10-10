package br.edu.ufcg.computacao.mrbet;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Classe sistema, que gerencia as informações passadas pelo usuário.
 * @author Daniele de Oliveira Sousa
 *
 */
public class MrBetSistema {
	// guarda os times do sistema
	private HashMap <String, Time> mapaTimes;
	// guarda os campeonatos do sistema
	private HashMap <String, Campeonato> mapaCampeonatos;
	// guarda as apostas feitas no sistema
	private ArrayList<Aposta> apostas;
	
	// cria o objeto time
	Time time;
	// cria o objeto campeonato
	Campeonato campeonato;
	// cria o objeto aposta
	Aposta aposta;
	
	/**
	 * Construtor do sistema, que inicializa o hashmap de times e campeonatos e o arrayList de apostas
	 */
	public MrBetSistema() {
		this.mapaTimes = new HashMap<>();
		this.mapaCampeonatos = new HashMap<>();
		this.apostas = new ArrayList();
	}
	
	/**
	 * Método que cadastra um novo time no sistema
	 * @param codigo código do time
	 * @param nome nome do time
	 * @param mascote mascote do time
	 * @return se inclusão feita com sucesso, retorna INCLUSÃO REALIZADA!, se não, retorna TIME JÁ EXISTE! se o
	 * time cadastrado já existir
	 */
	public String cadastraTime(String codigo, String nome, String mascote) {
		if (this.mapaTimes.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME JÁ EXISTE!");
		}
			
		this.time = new Time(codigo, nome, mascote);
		mapaTimes.put(codigo, time);
		return "INCLUSÃO REALIZADA!";
	}
		
	/**
	 * Método que retorna o toString a partir do código do time
	 * @param codigo código do time
	 * @return retorna o toString de um time, caso ele esteja cadastrado, se não existir retorna TIME NÃO EXISTE!
	 */
	public String recuperaTimes(String codigo) {
		if(!this.mapaTimes.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO EXISTE!");
		}
		
		return this.mapaTimes.get(codigo).toString();
	}
	
	/**
	 * Método que cadastra um campeonato no sistema
	 * @param nomeCampeonato nome do campeonato
	 * @param totalParticipantes total de participantes de um campeonato
	 * @return retorna CAMPEONATO ADICIONADO! se feito com sucesso e CAMPEONATO JÁ EXISTE! se o campeonato já
	 * estiver cadastrado
	 */
	public  String cadastraCampeonato(String nomeCampeonato, int totalParticipantes) {
		if(this.mapaTimes.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE!");
		}
		
		this.campeonato = new Campeonato(nomeCampeonato, totalParticipantes);
		mapaCampeonatos.put(nomeCampeonato, campeonato);
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * Inclui um time em um campeonato existente
	 * @param codigo código do time
	 * @param nomeCampeonato nome do campeonato
	 * @return retorna TIME INCLUÍDO NO CAMPEONATO! se feito com sucesso, TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS! 
	 * se o campeonato estiver lotado, TIME NÃO EXISTE! se o time não existir e CAMPEONATO NÃO EXISTE! se o campeonato
	 * não estiver cadastrado.
	 */
	public String incluirTimeCampeonato(String codigo, String nomeCampeonato) {
		if(!this.mapaTimes.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO EXISTE!");
		}
		
		if(!this.mapaCampeonatos.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
		}
		
		return this.mapaCampeonatos.get(nomeCampeonato).adicionarTime(this.mapaTimes.get(codigo));
		
	}
	
	/**
	 * Verifica se o time está incluido em um campeonato
	 * @param codigo código do time
	 * @param nomeCampeonato nome do campeonato
	 * @return retorna TIME ESTÁ NO CAMPEONATO se o time existir, TIME NÃO ESTÁ NO CAMPEONATO se o time não existir,
	 * CAMPEONATO NÃO EXISTE! se o campeonato não existir e TIME NÃO EXISTE! se o time não existir.
	 */
	public String verificarTimeCampeonato(String codigo, String nomeCampeonato) {
		if(!this.mapaTimes.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO EXISTE!");
		}
		
		if(!this.mapaCampeonatos.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
		}
		
		if(this.mapaCampeonatos.get(nomeCampeonato).verificaTimeExiste(this.mapaTimes.get(codigo))) {
			return "TIME ESTÁ NO CAMPEONATO";
		}
		
		return "TIME NÃO ESTÁ NO CAMPEONATO";
	}
	
	/**
	 * Método que exibe os campeonatos que um time participa
	 * @param nomeTime nome do time buscado
	 * @return todos os campeonatos que um time participa
	 */
	public String exibeCampeonato(String nomeTime) {
		String campeonatos = "";
		
		if(!this.mapaTimes.containsKey(nomeTime)) {
			throw new IllegalArgumentException("TIME NÃO EXISTE!");
		}
		
		for(String campeonato: mapaCampeonatos.keySet()) {
			if(this.campeonato.verificaTimeExiste(this.mapaTimes.get(nomeTime))) {
				campeonato += this.campeonato.toString() + "\n";
			}
		}
		
		return "Campeonatos do " + nomeTime + "/n" + campeonatos;
		
	}

	/**
	 * Método que adiciona apostas em um sistema
	 * @param codigo código do time
	 * @param nomeCampeonato nome do campeonato
	 * @param colocacao colocação do time
	 * @param valor valor da aposta
	 * @return retorna APOSTA REGISTRADA! se feita com sucesso, APOSTA NÃO REGISTRADA! se a colocação for maior
	 * que o total de participantes, CAMPEONATO NÃO EXISTE! se o campeonato não estiver cadastrado e TIME NÃO EXISTE!
	 * se o time não for cadastrado
	 */
	public String adicionarAposta(String codigo, String nomeCampeonato, int colocacao, String valor) {
		if(!this.mapaTimes.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO EXISTE!");
		}
		
		if(!this.mapaCampeonatos.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
		}
		
		if(colocacao > this.mapaCampeonatos.get(nomeCampeonato).getTotalParticipantes()) {
			throw new IllegalArgumentException("APOSTA NÃO REGISTRADA!");
		}
		
		this.aposta = new Aposta(codigo, nomeCampeonato, colocacao, valor);
		apostas.add(aposta);
		
		return "APOSTA REGISTRADA!";
	}

	/**
	 * Exibe todas as apostas que foram cadastradas no sistema
	 * @return retorna o toString das apostas
	 */
	public String exibeAposta() {
		String totalApostas = "";
		
		for(int i = 0;  i < apostas.size(); i++) {
			totalApostas = (i+1) + ". " + this.mapaTimes.get(this.apostas.get(i).getCodigo()).toString() + 
						   "\n" + this.apostas.get(i).getCampeonato() +
						   "\n" + this.apostas.get(i).getColocacao() + "/" + this.mapaCampeonatos.get(this.apostas.get(i).getCampeonato()).getTotalParticipantes() +
						   "\n" + this.apostas.get(i).getValorAposta() + "\n";
		}
		
		return "Apostas:\n" + totalApostas;
	}
	
}

