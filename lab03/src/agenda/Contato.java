package agenda;

/**
 * Classe contato que cria um objeto contato para ser usado na agenda.
 * @author Daniele de Oliveira Sousa
 *
 */
public class Contato {
	// nome do contato
	private String nome;
	//sobrenome do contato
	private String sobrenome;
	//telefone do contato
	private String telefone;
	
	/**
	 * Construtor da classe Contato, em que inicializa as variáveis de acordo com o passado para o sistema.
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	// retorna o nome do usuário
	public String getNome() {
		return this.nome;
	}
	
	// retorna o sobrenome do usuário
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	// retorna o telefone do usuário
	public String getTelefone() {
		return this.telefone;
	}
	
	// retorna a representação do contato
	@Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome();
	}
	
}
