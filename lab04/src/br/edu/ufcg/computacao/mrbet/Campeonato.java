package br.edu.ufcg.computacao.mrbet;

import java.util.Objects;

/**
 * Classe que inicializa um novo campeonato no sistema.
 * @author Daniele de Oliveira Sousa
 *
 */
public class Campeonato {
	// nome do campeonato
	private String nomeCampeonato;
	// total de participantes cadastrados
	private int totalParticipantes;
	// times que participam do campeonato
	private Time[] times;
	// total dos times cadastrados
	private int totalTimesCadastrados;
	
	/**
	 * Construtor que inicializa um novo campeonato no sistema.
	 * @param nomeCampeonato nome do campeonato cadastrado
	 * @param totalParticipantes total dos participantes do campeonato
	 */
	public Campeonato (String nomeCampeonato, int totalParticipantes) {
		this.nomeCampeonato = nomeCampeonato;
		this.totalParticipantes = totalParticipantes;
		
		this.times = new Time[totalParticipantes];
		this.totalTimesCadastrados = 0;
	}
	
	/**
	 * Método que adiciona um time em um campeonato já existente.
	 * @param time objeto time que será cadastrado
	 * @return caso seja adicionado com sucesso, retorna TIME INCLUÍDO NO CAMPEONATO!, se não, TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!
	 */
	public String adicionarTime(Time time) {
		if(times.length == totalTimesCadastrados) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
		
		if(verificaTimeExiste(time)) {
			return "TIME INCLUÍDO NO CAMPEONATO!";
		}
		
		times[ totalTimesCadastrados] = time;
		totalTimesCadastrados++;
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	
	/**
	 * Método que verifica se um time já está cadastrado em um campeonato
	 * @param time objeto time que será verificado
	 * @return true se o objeto existe, false se não existe
	 */
	public boolean verificaTimeExiste(Time time) {
		for(Time t: times) {
			if(t != null) {
				if(t.equals(time)) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeCampeonato, totalParticipantes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nomeCampeonato, other.nomeCampeonato) && totalParticipantes == other.totalParticipantes;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public int getTotalParticipantes() {
		return totalParticipantes;
	}

	@Override
	public String toString() {
		return "* " + this.getNomeCampeonato() + " - " + this.totalTimesCadastrados + "/" + this.times.length;
	}
	
	
}
