package agenda;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Classe Agenda em que organiza uma lista de contatos, permitindo no máximo 100 cadastros.
 * 
 * @author nazareno e Daniele de Oliveirs Sousa
 *
 */
public class Agenda {
	
	// variáveis estáticas que guardam os valores de tamanho da agenda e tamanho do total de favoritos
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITO = 10;
	
	//Criação do array de objetos contatos a partir da classe Contato.
	private Contato[] contatos; 
	
	//Criação do array de string dos contatos favoritos.
	private String[] favoritos;

	/**
	 * Cria e inicializa uma agenda e também o array de favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new String[TAMANHO_FAVORITO];
	}
	
	/**
	 * Acessa a lista de todos os contatos cadastrados.
	 * @return O array contendo todos os contatos.
	 */
	public String[] getContatos() {
		String[] mostraAgenda = new String[TAMANHO_AGENDA];
		
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				mostraAgenda[i] = contatos[i].toString();
			}
		}
		
		return mostraAgenda;
	}

	/**
	 * Retorna apenas um dos contatos da lista, sendo esse contato escolhido pelo usuário.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. 
	 */
	public String getContato(int posicao) {
		if (posicao <= 0 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSICAO INVÁLIDA");
		}
		
		if(contatos[posicao-1] == null) {
			throw new IllegalArgumentException("CONTATO NÃO EXISTE");
		}
		
		for(int i = 0; i < favoritos.length; i++) {
			if(favoritos[i] != null) {
				if( favoritos[i].equals(contatos[posicao-1].toString()) ) {
						return "\u2764\uFE0F " + contatos[posicao-1].getNome() + " " + contatos[posicao-1].getSobrenome() + "\n" + contatos[posicao-1].getTelefone();
				}
			}
		}
		
		return contatos[posicao-1].getNome() + " " +contatos[posicao-1].getSobrenome() + "\n" + contatos[posicao-1].getTelefone();
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {

		if (posicao <= 0 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSICAO INVÁLIDA");
		}
		
		if(nome.isEmpty() || nome == null || telefone.isEmpty() || telefone == null) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
		
		if(verificaNomeSobrenome(nome, sobrenome)) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
			
		this.contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
		return "CONTATO CADASTRADO COM SUCESSO";
		
	}
	
	/**
	 * Adiciona um contato já cadastrado como favorito.
	 * @param contato posição do contato cadastrado
	 * @param posicao posição que deseja cadastrar o contato como favoritos no array
	 * @return
	 */
	public String adicionaFavoritos(int contato, int posicao) {
		if (posicao < 0 || posicao > 10) {
			throw new IndexOutOfBoundsException("POSICAO INVÁLIDA");
		}
		
		if(verificaFavorito(contato)) {
			throw new IndexOutOfBoundsException("CONTATO JÁ É FAVORITO");
		}
		
		this.favoritos[posicao-1] = contatos[contato-1].toString();
		return "CONTATO FAVORITADO COM SUCESSO";
		
	}
	
	/**
	 * Remove um contato dos favoritos
	 * @param posicao posição do contato favoritado que vai ser excluído.
	 * @return
	 */
	public String removeFavoritos(int posicao) {
		if (posicao < 0 || posicao > 10) {
			throw new IndexOutOfBoundsException("POSICAO INVÁLIDA");
		}
		
		this.favoritos[posicao-1] = null;
		return "CONTATO FREMOVIDO DOS FAVORITOS COM SUCESSO";
		
	}
	
	/**
	 * Retorna todos os contatos favoritos cadastrados no sistema.
	 * @return Array contendo os favoritos.
	 */
	public String[] getFavoritos() {
	
		return this.favoritos.clone();
		
	}
	
	/**
	 * Método que verifica se um nome ou sobrenome já estão cadastrados em algum contato
	 * @param nome nome que vai ser verificado
	 * @param sobrenome sobrenome que vai ser verificado
	 * @return true se nome/sobrenome existir e false caso não
	 */
	private boolean verificaNomeSobrenome(String nome, String sobrenome) {
		
		for(Contato contato: contatos) {
			if (contato != null) {
				if(contato.getNome().equals(nome) || contato.getSobrenome().equals(sobrenome)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	/**
	 * Verifica se um contato já é favoritado na agenda a partir do toString() de cada objeto Contato
	 * @param contato contato(objeto) que deseja ser verificado
	 * @return true caso o contato seja favorito, false se não
	 */
	private boolean verificaFavorito(int contato) {
		
		for(String favorito: favoritos) {
			if (favorito != null) {
				if(favorito.equals(contatos[contato-1].toString())) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	

}
