package br.edu.ufcg.computacao.mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.MrBetSistema;
import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;

class MrBetSistemaTest {
	
	private MrBetSistema sistema;
	private Campeonato campeonato;
	private Time time;

	@BeforeEach
	void preparaSistema() {
		this.sistema = new MrBetSistema();
	}
	
	@Test
	void cadastrarTimeComSucesso() {
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
	}
	
	@Test
	void cadastrarTimeSemSucesso() {
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		
		try {
			this.sistema.cadastraTime("250_PB", "Sport Lagoa Seca", "Carneiro");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "TIME JÁ EXISTE!" );
		}
	}
	
	@Test
	void recuperaTimes() {
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		assertEquals("[250_PB] Nacional de Patos / Canário", this.sistema.recuperaTimes("250_PB"));
	}
	
	@Test
	void cadastrarCampeonatoComSucesso() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 10));
	}
	
	@Test
	void cadastrarCampeonatoSemSucesso() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 10));
		
		try {
			this.sistema.cadastraCampeonato("Brasileirão série A 2023", 20);
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "CAMPEONATO JÁ EXISTE!" );
		}
	}
	
	@Test
	void incluirTimeEmCampeonato() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 10));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("252_PB", "Sport Lagoa Seca", "Carneiro"));
		
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void incluirTimeJaIncluidoNoCampeonato() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 10));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("252_PB", "Sport Lagoa Seca", "Carneiro"));
		
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void incluirTimeInexistente() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 10));
		
		try {
			this.sistema.incluirTimeCampeonato("005_PB", "Brasileirão série A 2023");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "TIME NÃO EXISTE!" );
		}
	}
	
	@Test
	void incluirCampeonatoInexistente() {
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 10));
		
		try {
			this.sistema.incluirTimeCampeonato("250_PB", "Brasileirão série A");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "CAMPEONATO NÃO EXISTE!" );
		}
	}
	
	@Test
	void incluirTimeEmCampeonatoQueExcedeParticipantes() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Brasileirão série A 2023", 1));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("252_PB", "Sport Lagoa Seca", "Carneiro"));
		
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", this.sistema.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void verificaTimeEmCampeonato() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Copa do Nordeste 2023", 5));
		
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("252_PB", "Sport Lagoa Seca", "Carneiro"));
		
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.sistema.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023"));
		
		assertEquals("TIME ESTÁ NO CAMPEONATO", this.sistema.verificarTimeCampeonato("250_PB", "Copa do Nordeste 2023"));
		assertEquals("TIME NÃO ESTÁ NO CAMPEONATO", this.sistema.verificarTimeCampeonato("252_PB", "Copa do Nordeste 2023"));
		
		try {
			this.sistema.verificarTimeCampeonato("250_PB", "Brasileirão série D 2023");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "CAMPEONATO NÃO EXISTE!" );
		}
		
		try {
			this.sistema.verificarTimeCampeonato("005_PB", "Copa do Nordeste 2023");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "TIME NÃO EXISTE!" );
		}
		
	}
	
	@Test
	void criaApostaComSucesso() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Copa do Nordeste 2023", 5));
		
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		
		assertEquals("APOSTA REGISTRADA!", this.sistema.adicionarAposta("250_PB", "Copa do Nordeste 2023", 2, "R$ 30,00"));
	}
	
	@Test
	void criaApostaSemSucesso() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Copa do Nordeste 2023", 5));
		
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		
		try {
			this.sistema.adicionarAposta("005_PB", "Copa do Nordeste 2023", 2, "R$ 30,00");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "TIME NÃO EXISTE!");
		}
		
		try {
			this.sistema.adicionarAposta("250_PB", "Brasileirão série D 2023", 2, "R$ 30,00");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "CAMPEONATO NÃO EXISTE!");
		}
		
		try {
			this.sistema.adicionarAposta("250_PB", "Copa do Nordeste 2023", 10, "R$ 30,00");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "APOSTA NÃO REGISTRADA!");
		}
	}
	
	@Test
	void exibeAposta() {
		assertEquals("CAMPEONATO ADICIONADO!", this.sistema.cadastraCampeonato("Campeonato Paraibano 2023", 14));
		
		assertEquals("INCLUSÃO REALIZADA!", this.sistema.cadastraTime("250_PB", "Nacional de Patos", "Canário"));
		
		assertEquals("APOSTA REGISTRADA!", this.sistema.adicionarAposta("250_PB", "Campeonato Paraibano 2023", 2, "R$ 50.00"));
		
		assertEquals("Apostas:\n1. [250_PB] Nacional de Patos / Canário\n"
				+ "Campeonato Paraibano 2023\n"
				+ "2/14\n"
				+ "R$ 50.00\n", this.sistema.exibeAposta());
	}
	
	@Test
	void testaCampeonato() {
		this.campeonato = new Campeonato("Campeonato Paraibano 2023", 2);
		
		this.time = new Time("250_PB", "Nacional de Patos", "Canário");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.campeonato.adicionarTime(time));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.campeonato.adicionarTime(time));
		assertTrue(this.campeonato.verificaTimeExiste(time));
		assertEquals("* Campeonato Paraibano 2023 - 1/2", this.campeonato.toString());
		
		this.time = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", this.campeonato.adicionarTime(time));
		
		this.time = new Time("005_PB", "Sport Lagoa Seca", "Carneiro");
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", this.campeonato.adicionarTime(time));
		assertFalse(this.campeonato.verificaTimeExiste(time));
	}

}
