package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import org.junit.Test;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HotelCaliforniaSistemaS1S2MinTest {

	HotelCaliforniaSistema driver;

	String idClienteA, idClienteB, idGerente, idFuncionario, numQuartoSingle, numQuartoDouble, numQuartoFamily;
	LocalDateTime dataInicio;
	LocalDateTime dataFim;
	String idRefCafeMatinal, idRefAlmoco, idRefJantar;
	String idReservaQuartoSingle, idReservaQuartoDouble, idReservaQuartoFamily;
	String idAuditorio;
	String idReservaAuditorio;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		driver = new HotelCaliforniaSistema();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver = null;
	}

	@Nested
	@DisplayName("US01: Gerenciar Usuarios")
	class US01Validations {

		@Test
		@DisplayName("CA.01.1: Cadastrar Administrador")
		void testCadastrarAdministrador() {
			String resultado = driver.cadastrarUsuario("ADM1", "Novo Administrador", "ADM", 123456L);
			assertTrue(resultado.contains("ADM"));
		}

		@Test
		@DisplayName("CA.01.1: Cadastrar Gerente")
		void testCadastrarGerente() {
			String resultado = driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L);
			assertTrue(resultado.contains("GER"));
		}

		@Test
		@DisplayName("CA.01.1: Usuario Autenticacao nao existe ao cadastrar")
		void testUsuarioAutenticacaoNaoExisteAoCadastrar() {
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.cadastrarUsuario("ADM2", "Novo Gerente", "GER", 123456L);
			});
			assertTrue(hce.getMessage().toUpperCase().contains("USUARIO NAO EXISTE"));
		}

		@Test
		@DisplayName("CA.01.1: Cadastrar Funcionario")
		void testCadastrarFuncionario() {
			String resultado = driver.cadastrarUsuario("ADM1", "Novo Funcionario", "FUN", 123456L);
			assertTrue(resultado.contains("FUN"));
		}

		@Test
		@DisplayName("CA.01.1: Cadastrar Cliente")
		void testCadastrarCliente() {
			String resultado = driver.cadastrarUsuario("ADM1", "Novo Cliente", "CLI", 123456L);
			assertTrue(resultado.contains("CLI"));
		}

		@Test
		@DisplayName("CA.01.2: So deve haver um gerente no hotel")
		void testCadastrarGerenteSohDeveHaverUm() {
			String resultado = driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L);
			assertTrue(resultado.contains("GER"));
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.cadastrarUsuario("ADM1", "Novo Gerente 2", "GER", 123456L);
			});
			assertTrue(hce.getMessage().toUpperCase().contains("SO DEVE HAVER UM GERENTE NO HOTEL"));
		}

		@Test
		@DisplayName("CA.01.2: Cliente nao pode cadastrar usuario")
		void testClienteNaoPodeCadastrarUsuario() {
			String cliente = extrairId(driver.cadastrarUsuario("ADM1", "Novo Cliente", "CLI", 123456L));
			assertTrue(cliente.contains("CLI"));
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.cadastrarUsuario(cliente, "Novo Funcionario", "FUN", 123456L);
			});
			assertTrue(hce.getMessage().toUpperCase().contains("NAO E POSSIVEL PARA USUARIO"));
			assertTrue(hce.getMessage().toUpperCase().contains("CADASTRAR UM NOVO USUARIO DO TIPO"));
		}

		@Test
		@DisplayName("CA.01.2: Funcionario nao pode cadastrar gerente ou administrador")
		void testFuncionarioNaoPodeCadastrarGerenteOuAdministrador() {
			String funcionario = extrairId(driver.cadastrarUsuario("ADM1", "Novo Funcionario", "FUN", 123456L));
			assertTrue(funcionario.contains("FUN"));
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.cadastrarUsuario(funcionario, "Novo Gerente", "GER", 123456L);
			});
			assertTrue(hce.getMessage().toUpperCase().contains("NAO E POSSIVEL PARA USUARIO"));
			assertTrue(hce.getMessage().toUpperCase().contains("CADASTRAR UM NOVO USUARIO DO TIPO"));
		}

		@Test
		@DisplayName("CA.01.2: Gerente nao pode cadastrar administrador")
		void testGerenteNaoPodeCadastrarGerenteOuAdministrador() {
			String gerente = extrairId(driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L));
			assertTrue(gerente.contains("GER"));
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.cadastrarUsuario(gerente, "Novo Gerente", "ADM", 123456L);
			});
			assertTrue(hce.getMessage().toUpperCase().contains("NAO E POSSIVEL PARA USUARIO"));
			assertTrue(hce.getMessage().toUpperCase().contains("CADASTRAR UM NOVO USUARIO DO TIPO"));
		}

		@Test
		@DisplayName("CA.01.3: Identificador Unico")
		void testIdentificadorUnico() {
			String adm2 = driver.cadastrarUsuario("ADM1", "Novo Admin 2", "ADM", 123456L);
			String adm3 = driver.cadastrarUsuario("ADM1", "Novo Admin 3", "ADM", 123456L);
			String adm4 = driver.cadastrarUsuario("ADM1", "Novo Admin 4", "ADM", 123456L);
			assertAll(
					() -> assertTrue(adm2.contains("ADM")),
					() -> assertTrue(adm3.contains("ADM")),
					() -> assertTrue(adm4.contains("ADM")),
					() -> assertNotEquals(adm2, adm3),
					() -> assertNotEquals(adm3, adm4),
					() -> assertNotEquals(adm4, adm2)
			);
		}

		@Test
		@DisplayName("CA.01.4: Atualizar Usuario")
		void testAtualizarUsuario() {
			String funcionario = extrairId(driver.cadastrarUsuario("ADM1", "Novo Funcionario", "FUN", 123456L));
			String resultado = driver.atualizarUsuario("ADM1", funcionario, "CLI");
			assertTrue(resultado.contains("CLI"));
		}

		@Test
		@DisplayName("CA.01.4: Somente Administrador pode atualizar Usuario")
		void testSomenteAdministradorPodeAtualizarUsuario() {
			String funcionario = extrairId(driver.cadastrarUsuario("ADM1", "Novo Funcionario", "FUN", 123456L));
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.atualizarUsuario(funcionario, "ADM1", "CLI");
			});
			assertTrue(hce.getMessage().toUpperCase().contains("APENAS O ADMINISTRADOR PODE ATUALIZAR OS USUARIOS"));
		}

		@Test
		@DisplayName("CA.01.4: Atualiza Usuario para cargo de gerente")
		void testAtualizaUsuarioCargoGerente() {
			String gerente = extrairId(driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L));
			String funcionario = extrairId(driver.cadastrarUsuario("ADM1", "Novo Funcionario", "FUN", 123456L));
			String resultado = driver.atualizarUsuario("ADM1", funcionario, "GER");
			assertAll(
					() -> assertTrue(resultado.contains("GER")),
					() -> assertNotEquals(gerente, resultado)
			);
		}

		@Test
		@DisplayName("CA.01.4: Administrador nao encontrado durante processo de atualizacao de usuario")
		void testAdminNaoEncontradoDuranteAtualizacao() {
			String funcionario = extrairId(driver.cadastrarUsuario("ADM1", "Novo Funcionario", "FUN", 123456L));
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.atualizarUsuario("ADM2", funcionario, "GER");
			});
			assertTrue(hce.getMessage().toUpperCase().contains("USUARIO NAO EXISTE"));
		}

		@Test
		@DisplayName("CA.01.4: Usuario a ser alterado nao encontrado durante processo de atualizacao de usuario")
		void testUsuarioSerAlteradoNaoEncontradoDuranteAtualizacao() {
			HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
				driver.atualizarUsuario("ADM1", "FUN1", "GER");
			});
			assertTrue(hce.getMessage().toUpperCase().contains("USUARIO NAO EXISTE"));
		}

		@Test
		@DisplayName("CA.01.5: Exibir Usuario")
		void testExibir() {
			String gerente = extrairId(driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L));
			String resultado = driver.exibirUsuario(gerente);
			assertAll(
					()-> assertTrue(resultado.contains("GER")),
					()-> assertTrue(resultado.contains("Novo Gerente")),
					()-> assertTrue(resultado.contains("123456"))
			);
		}

		@Test
		@DisplayName("CA.01.5: Listar Usuarios")
		void testListar() {
			String gerente = driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L);
			String[] resultado = driver.listarUsuarios();
			assertAll(
					()-> assertEquals(2, resultado.length),
					()-> assertTrue(resultado[0].contains("ADM1")),
					()-> assertTrue(resultado[1].contains(gerente))
			);
		}

	}

}
