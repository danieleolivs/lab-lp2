package br.edu.ufcg.computacao.lp2.coisa;

/**
 * Classe que registra o tempo online do estudante.
 * @author Daniele de Oliveira Sousa
 *
 */
public class RegistroTempoOnline {
	
	// guarda o nome da disciplina.
	private String nomeDisciplina;
	// guarda o tempo online esperado.
	private int tempoOnlineEsperado;
	// guarda o tempo estudado.
	private int tempo;
	
	/**
	 * Construtor que inicializa a classe recebendo como parâmetro o nome da disciplina. Tem como tempo online da disciplina o
	 * padrão, que é 120 horas.
	 * @param nomeDisciplina nome da disciplina cadastrada.
	 */
	public RegistroTempoOnline (String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}
	
	/**
	 * Construtor que inicializa a classe recebendo como parâmetro o nome da disciplina e o tempo online esperado.
	 * @param nomeDisciplina
	 * @param tempoOnlineEsperado
	 */
	public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
		
	}
	
	/**
	 * Adiciona um novo total de tempo estudado a variável local, que é incrementada com o novo valore recebido.
	 * @param tempo tempo estudado.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempo += tempo;
	}
	
	/**
	 * Método que verifica se o tempo online esperado da disciplina foi atingido a depender do tempo que foi cadastrado no sistema.
	 * @return True se o tempo foi atingido e false se não.
	 */
	public boolean atingiuMetaTempoOnline() {
		if(tempo >= tempoOnlineEsperado) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Retorna uma representação em string da classe, com o nome da discilina, tempo estudado e o tempo online esperado da disciplina.
	 */
	@Override
	public String toString() {
		return nomeDisciplina + " " + tempo + "/" + tempoOnlineEsperado;
	}

}
