package teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import agenda.Agenda;
import agenda.Contato;

class AgendaTest {
	
	private Agenda agenda;
	private Contato contato;

	@BeforeEach
	void preparaSistema() {
		this.agenda = new Agenda();
	}
	
	@Test
	void testCadastraContato() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
	}
	
	@Test
	void testCadastraContatoPosicaoExistente() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111"));
	}
	
	@Test
	void testCadastraMesmoContato() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
		try {
			this.agenda.cadastraContato(3, "Daniele", "Oliveira", "(83) 999999999");
		}catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "CONTATO INVALIDO" );
		}
	}
	
	@Test
	void testPosicaoLimite() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(100, "Daniele", "Oliveira", "(83) 999999999"));
	}
	
	@Test
	void testPosicaoAcimaDoLimite() {
		try {
			this.agenda.cadastraContato(120, "Daniele", "Oliveira", "(83) 999999999");
		}catch(IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "POSICAO INVÁLIDA");
		}
	}
	
	@Test
	void testPosicaoAbaixoDoLimite() {
		try {
			this.agenda.cadastraContato(0, "Daniele", "Oliveira", "(83) 999999999");
		}catch(IndexOutOfBoundsException e) {
			assertEquals(e.getMessage(), "POSICAO INVÁLIDA");
		}
	}
	
	@Test
	void testTelefoneVazio() {
		try {
			this.agenda.cadastraContato(1, "Daniele", "Oliveira", "");
		}catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "CONTATO INVALIDO" );
		}
	}
	
	@Test
	void testNomeVazio() {
		try {
			this.agenda.cadastraContato(1, "", "Oliveira", "83) 999999999");
		}catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "CONTATO INVALIDO" );
		}
	}
	
	@Test
	void exibirContatoTodosOsDados() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
		assertEquals("Daniele Oliveira\n(83) 999999999", this.agenda.getContato(1));
	}
	
	@Test
	void cadastrarContatoSemTelefone() {
		try {
			this.agenda.cadastraContato(1, "Daniele", "Oliveira", "");
		}catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "CONTATO INVALIDO" );
		}

	}
	
	@Test
	void exibirContatoInexistente() {
		try {
			this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999");
			this.agenda.getContato(99);
		}catch(IllegalArgumentException e){
			assertEquals(e.getMessage(), "CONTATO NÃO EXISTE");
		}
	}
	
	@Test
	void exibirContatoLimiteInferior() {
		try {
			this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999");
			this.agenda.getContato(0);
		}catch(IndexOutOfBoundsException e){
			assertEquals(e.getMessage(), "POSICAO INVÁLIDA");
		}
	}
	
	@Test
	void exibirContatoLimiteSuperior() {
		try {
			this.agenda.cadastraContato(110, "Daniele", "Oliveira", "(83) 999999999");
			this.agenda.getContato(0);
		}catch(IndexOutOfBoundsException e){
			assertEquals(e.getMessage(), "POSICAO INVÁLIDA");
		}
	}
	
	@Test
	void adicionaFavorito() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
		assertEquals("CONTATO FAVORITADO COM SUCESSO", this.agenda.adicionaFavoritos(1, 1));
		
	}
	
	@Test
	void exibeFavorito() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
		assertEquals("CONTATO FAVORITADO COM SUCESSO", this.agenda.adicionaFavoritos(1, 1));
		assertEquals("\u2764\uFE0F Daniele Oliveira\n(83) 999999999", this.agenda.getContato(1));
		
	}
	
	@Test
	void removeFavoritos() {
		assertEquals("CONTATO CADASTRADO COM SUCESSO", this.agenda.cadastraContato(1, "Daniele", "Oliveira", "(83) 999999999"));
		assertEquals("CONTATO FAVORITADO COM SUCESSO", this.agenda.adicionaFavoritos(1, 1));
		assertEquals("CONTATO FREMOVIDO DOS FAVORITOS COM SUCESSO", this.agenda.removeFavoritos(1));
	}
	
	@Test
	void toStringContato() {
		this.contato = new Contato("Daniele", "Oliveira", "(83) 999999999");
		assertEquals("Daniele Oliveira", this.contato.toString());
	}
	
}


