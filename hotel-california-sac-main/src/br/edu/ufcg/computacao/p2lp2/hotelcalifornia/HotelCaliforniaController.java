package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import br.edu.ufcg.computacao.p2lp2.Exception.HotelCaliforniaException;
import br.edu.ufcg.computacao.p2lp2.areasComuns.AreasComunsController;
import br.edu.ufcg.computacao.p2lp2.formaPagamento.FormasDePagamentoController;
import br.edu.ufcg.computacao.p2lp2.formaPagamento.PagamentoController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Classe que controla as principais funcionalidades do Hotel California
 * @author Daniele Oliveira, Fernando Gentil e Maria Clara Guedes
 *
 */
public class HotelCaliforniaController {

	private ArrayList<QuartoGeralController> quartos;

	//Objeto usuário
	UsuarioController usuarioController;
	//Objeto refeicao;
	RefeicaoController refeicaoController;
	ReservaController reservaController;
	AreasComunsController areaComum;
	FormasDePagamentoController formasPagamento;
	PagamentoController pagamento;
	QuartoGeralController quarto;

	//Construtor que inicializa as principais funcionalidades do sistema: hashmap e administrador padrão
	public HotelCaliforniaController() {
		this.usuarioController = UsuarioController.getInstance();
		this.refeicaoController = RefeicaoController.getInstance();
		this.reservaController = ReservaController.getInstance();
		this.refeicaoController = new RefeicaoController();
		this.formasPagamento = new FormasDePagamentoController();
		this.areaComum = new AreasComunsController();
		this.pagamento = new PagamentoController();
	}

	/**
	 * Método que cadastra um novo usuário no sistema, seguindo as principais restrições encontradas.
	 * @param id id do usuário que está cadastrando um novo
	 * @param nome nome do novo usuário
	 * @param tipo tipo do novo usuário
	 * @param numeroDocumento número do documento do usuário
	 * @return Caso não tenha sucesso, retorna a exceção a depender do caso, se não, retorna  cadastrado com sucesso
	 */
	public String cadastraUsuario(String id, String nome, String tipo, long numeroDocumento) {
		if(tipo.equals("CLI") && usuarioController.getMapaUsuarios().get(id).getTipo().equals("CLI")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(tipo.equals("FUN") && (!usuarioController.getMapaUsuarios().get(id).getTipo().equals("ADM") && !usuarioController.getMapaUsuarios().get(id).getTipo().equals("GER"))){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(tipo.equals("GER") && !usuarioController.getMapaUsuarios().get(id).getTipo().equals("ADM")) {
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(tipo.equals("ADM") && !usuarioController.getMapaUsuarios().get(id).getTipo().equals("ADM")) {
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(verificaUsuario() && tipo.equals("GER")) {
			throw new HotelCaliforniaException("SO DEVE HAVER UM GERENTE NO HOTEL");
		}

		return this.usuarioController.cadastraUsuario(id, nome, tipo, numeroDocumento);
	
	}

	/**
	 * Verifica se um usuário do tipo gerente está cadastrado no sistema
	 * @return
	 */
	private boolean verificaUsuario() {
		for(String usuarios: usuarioController.getMapaUsuarios().keySet()) {
			if(usuarioController.getMapaUsuarios().get(usuarios).getTipo().equals("GER")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Atualiza um usuário já cadastrado
	 * @param id id do usuário que está realizando a operação
	 * @param idUsuarioAlterado id do usuário que será modificado
	 * @param novoTipoUsuario novo tipo que o usuário vai receber
	 * @return APENAS ADMINITRADOR PODE ATUALIZAR UM USUÁRIO! caso não seja um administrador realizando a operação
	 * e USUÁRIO ATUALIZADO COM SUCESSO caso tenha sucesso
	 */
	public String atualizarUsuario(String id, String idUsuarioAlterado, String novoTipoUsuario) {

		return this.usuarioController.atualizarUsuario(id, idUsuarioAlterado, novoTipoUsuario);
	}

	/**
	 *  Exibe um determinado usuário cadastrado
	 * @param idUsuario id do usuário buscado
	 * @return toString do usuário cadastrado
	 */
	public String exibirUsuario(String idUsuario) {
		return this.usuarioController.exibirUsuario(idUsuario);
	}

	/**
	 * Lista todos os usuários cadastrados no sistema
	 * @return lista com o toString de todos os usuários cadastrados
	 */
	public String listarUsuarios() {
		return this.usuarioController.listarUsuarios();
	}

	/**
	 * (COMEÇO DA US02)
	 * @author Fernando Gentil 122110631
	 * (Começo da US02). Esse método faz com que o quarto seja disponibilizado de acordo com o numero do quarto e o tipo da hospedagem.
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param numeroQuarto parametro para o numero do quarto
	 * @param precoPessoa preco por pessoa
	 * @param precoBase preco base
	 * @return ele retorna um erro caso o tipo do usuario esteja errado, e retorna uma mensagem para cada tipo de hospedagem.
	 **/
	public String disponibilizarQuartoSingle1(String idAutenticacao, int numeroQuarto, double precoPessoa, double precoBase) {
		return quarto.disponibilizarQuartoSingle(idAutenticacao, numeroQuarto, precoPessoa, precoBase);
	}

	/**
	 * @author Fernando Gentil
	 * Esse método faz com que o quarto seja disponibilizado de acordo com o numero do quarto e o tipo da hospedagem.
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param numQuarto parametro para o numero do quarto
	 * @param precoPessoa preco por pessoa
	 * @param precoBase preco base
	 * @param pedidos pedidos do cliente
	 * @return ele retorna um erro caso o tipo do usuario esteja errado, e retorna uma mensagem para cada tipo de hospedagem.
	 **/
	public String disponibilizarQuartoDouble1(String idAutenticacao, int numQuarto, double precoPessoa, double precoBase, String[] pedidos) {
		return quarto.disponibilizarQuartoDouble(idAutenticacao, numQuarto, precoPessoa, precoBase, pedidos);
	}

	/**
	 * Esse método faz com que o quarto seja disponibilizado de acordo com o numero do quarto e o tipo da hospedagem.
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param numQuarto parametro para o numero do quarto
	 * @param precoPessoa preco por pessoa
	 * @param precoBase preco base
	 * @param pedidos pedidos do cliente
	 * @param qtdMaximaPessoa quantidade maxima de pessoa que um quarto family irá receber
	 * @return ele retorna um erro caso o tipo do usuario esteja errado, e retorna uma mensagem para cada tipo de hospedagem.
	 **/
	public String disponibilizarQuartoFamily1(String idAutenticacao, int numQuarto, double precoPessoa, double precoBase, String[] pedidos, int qtdMaximaPessoa) {
		return quarto.disponibilizarQuartoFamily(idAutenticacao, numQuarto, precoPessoa, precoBase, pedidos, qtdMaximaPessoa);
	}

	/**
	 * Esse método faz o uso da interface QuartosInteface, e chama o método de exibir Quarto que está presente em cada classe de
	 * quartos.
	 * @return ele retorna o método da interface que sobescreve todos os métodos iguais das classes de quartos.
	 */
	public String exibirQuartos(int numQuarto) {
		return quarto.exibirQuartos(numQuarto);
	}

	/**
	 * (FINAL DA US02)
	 * @author Fernando Gentil 122110631
	 * Esse método lista os quartos
	 * @param numQuarto numero do quarto
	 * @return ele retorna o método que lista os quartos
	 */
	public String listarQuartos(int numQuarto) {
		return quarto.listarQuartos(numQuarto);
	}

	/**
	 * (INÍCIO DA US03)
     * @author Fernando Gentil 122110631
	 * Método que reserva o quarto single
	 * @param idAutenticacao id de autenticação do usuario
	 * @param idCliente id do cliente
	 * @param quartoAlocado numero do quarto
	 * @param dataInicio data de inicio
	 * @param dataFim data de fim
	 * @param idRefeicoes id das refeiçoes
	 * @return retorna erros caso não atenda os requisitos e retorna uma mensagem caso atenta o requisito.
	 */
	public String reservarQuartoSingle(String idAutenticacao, Usuario idCliente, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes) {
		return reservaController.reservarQuartoSingle(idAutenticacao, idCliente, quartoAlocado, dataInicio, dataFim, idRefeicoes);
	}

	/**
	 * Método que reserva o quarto double
	 * @param idAutenticacao id de autenticação do usuario
	 * @param idCliente id do cliente
	 * @param quartoAlocado numero do quarto
	 * @param dataInicio data de inicio
	 * @param dataFim data de fim
	 * @param idRefeicoes id das refeiçoes
	 * @param pedidos pedidos dos clientes
	 * @return retorna erros caso não atenda os requisitos e retorna uma mensagem caso atenta o requisito.
	 */
	public String reservarQuartoDouble(Usuario idCliente, String idAutenticacao, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes, String[] pedidos) {
		return reservaController.reservarQuartoDouble(idCliente, idAutenticacao, quartoAlocado, dataInicio, dataFim, idRefeicoes, pedidos);
	}

	/**
	 * Método que reserva o quarto family
	 * @param idAutenticacao id de autenticação do usuario
	 * @param idCliente id do cliente
	 * @param quartoAlocado numero do quarto
	 * @param dataInicio data de inicio
	 * @param dataFim data de fim
	 * @param idRefeicoes id das refeiçoes
	 * @param pedidos pedidos dos clientes
	 * @param numPessoas numero de pessoas que irão acomodar o quarto family
	 * @return retorna erros caso não atenda os requisitos e retorna uma mensagem caso atenta o requisito.
	 */
	public String reservarQuartoFamily(Usuario idCliente, String idAutenticacao, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes, String[] pedidos, int numPessoas) {
		return reservaController.reservarQuartoFamily(idCliente, idAutenticacao, quartoAlocado, dataInicio, dataFim, idRefeicoes, pedidos, numPessoas);
	}

	/**
	 * @author Fernando Gentil 122110631
	 * @param idAutenticacao id de autenticacao do usuario
	 * @param idReserva id de reserva do quarto
	 * @return retorna uma string formatada
	 */
	public String exibeReservaQuarto(String idAutenticacao, long idReserva) {
		return reservaController.exibeReservaQuarto(idAutenticacao, idReserva);
	}

	/**
	 * Disponibiliza refeições no sistema
	 * @param id do usuario
	 * @param tipoRefeicao o tipo da refeicao (cafe da manha, almoco e jantar)
	 * @param tituloRefeicao o titulo da refeicao
	 * @param horarioInicio o horario em que a refeicao comecara a estar disponivel
	 * @param horarioFinal o horario em que a refeicao nao estara mais disponivel
	 * @param valorRefeicao preco da refeicao por pessoa
	 * @param disponivel se esta disponivel ou nao
	 * @return "REFEIÇÃO DISPONIBILIZADA COM SUCESSO!" se a disponibilizacao foi bem sucedida
	 */
	public String disponibilizarRefeicao(String id, String tipoRefeicao, String tituloRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorRefeicao, boolean disponivel){
		if (this.usuarioController.getMapaUsuarios().containsKey(id)) {
			if (this.usuarioController.getMapaUsuarios().get(id).getTipo().equals("FUN") || this.usuarioController.getMapaUsuarios().get(id).getTipo().equals("GER")) {
				return this.refeicaoController.disponibilizarRefeicao(id, tipoRefeicao, tituloRefeicao, horarioInicio, horarioFinal, valorRefeicao, disponivel);
			} throw new HotelCaliforniaException("USUÁRIO NÃO AUTORIZADO!");
		} throw new HotelCaliforniaException("USUÁRIO NÃO CADASTRADO!");
	}

	/**
	 * Permite alterar a disponibilidade de horarios da refeicao, se esta disponivel e o preco refeicao no sistema
	 * @param idRefeicao a identificacao da refeicao
	 * @param horarioInicio o horario em que a refeicao comecara a estar disponivel
	 * @param horarioFinal o horario em que a refeicao nao estara mais disponivel
	 * @param valorPessoa preco da refeicao por pessoa
	 * @param disponivel se esta disponivel ou nao
	 * @return "REFEIÇÃO ATUALIZADA COM SUCESSO!"g se a alteracao foi realizada com sucesso
	 */
	public String alterarRefeicao(long idRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel){
		return refeicaoController.alterarRefeicao(idRefeicao, horarioInicio, horarioFinal, valorPessoa, disponivel);
	}

	/**
	 * Permite alterar a disponibilidade de horarios da refeicao, se esta disponivel e o preco refeicao no sistema
	 * @param idRefeicao a identificacao da refeicao
	 * @return toString da refeicao
	 */
	public String exibirRefeicao(long idRefeicao){
		return refeicaoController.exibirRefeicao(idRefeicao);
	}

	/**
	 * Lista todos os usuários cadastrados no sistema
	 * @return lista com o toString de todos as refeicoes cadastradas
	 */
	public String listarRefeicoes() {
		return refeicaoController.listarRefeicoes();
	}

		/**
		 * @author Fernando Gentil 122110631
         * Disponibiliza um quarto single
         * @param idAutenticacao id de autenticação
         * @param idQuartoNum numero do quarto
         * @param precoPorPessoa preço por pessoa
         * @param precoBase preço base
         * @return retorna o método que disponibiliza quarto da classe QuartoGeral
         */
	public String disponibilizarQuartoSingle(String idAutenticacao, int idQuartoNum, double precoPorPessoa, double precoBase) {
		return quarto.disponibilizarQuartoSingle(idAutenticacao, idQuartoNum, precoPorPessoa, precoBase);
	}
	/**
	 * @author Fernando Gentil 122110631
	 * Disponibiliza um quarto Double
	 * @param idAutenticacao id de autenticação
	 * @param idQuartoNum numero do quarto
	 * @param precoPorPessoa preço por pessoa
	 * @param precoBase preço base
	 * @param pedidos pedidos do cliente
	 * @return retorna o método que disponibiliza quarto da classe QuartoGeral
	 */
	public String disponibilizarQuartoDouble(String idAutenticacao, int idQuartoNum, double precoPorPessoa, double precoBase, String[] pedidos ) {
		return quarto.disponibilizarQuartoDouble(idAutenticacao, idQuartoNum, precoPorPessoa, precoBase, pedidos);
	}
	/**
	 * @author Fernando Gentil 122110631
	 * Disponibiliza um quarto Family
	 * @param idAutenticacao id de autenticação
	 * @param idQuartoNum numero do quarto
	 * @param precoPorPessoa preço por pessoa
	 * @param precoBase preço base
	 * @param pedidos pedidos do cliente
	 * @param qtdMaxPessoa quantidade de pessoas
	 * @return retorna o método que disponibiliza quarto da classe QuartoGeral
	 */
	public String disponibilizarQuartoFamily(String idAutenticacao, int idQuartoNum, double precoPorPessoa, double precoBase, String[] pedidos, int qtdMaxPessoa) {
		return quarto.disponibilizarQuartoFamily(idAutenticacao, idQuartoNum, precoPorPessoa, precoBase, pedidos, qtdMaxPessoa);
	}

	/**
	 * @author Fernando Gentil 122110631
	 * Método que exibe o quarto disponibilizado
	 * @param idQuartoNum numero do quarto
	 * @return retorna o metodo da classe QuartoGeral que exibe o quarto
	 */
	public String exibirQuarto(int idQuartoNum) {
		return quarto.exibirQuartos(idQuartoNum);
	}
	/**
	 * @author Fernando Gentil 122110631
	 * Método que lista quartos
	 * @param numQuarto numero do quarto
	 * @return os quartos listados
	 */
	public String listarQuartos1(int numQuarto) {
		return quarto.listarQuartos(numQuarto);
	}

	/**
	 * Exibe uma única reserva identificada por um id já cadastrado
	 * @param idAutenticacao id de autenticação do usuário
	 * @param idReserva id da reserva cadastrada
	 * @return toString da reserva
	 */
	public String exibirReserva(String idAutenticacao, long idReserva){
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("CLI") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(!this.reservaController.getMapaReservas().containsKey(idReserva)){
			throw new HotelCaliforniaException("RESERVA NAO ENCONTRADA");
		}

		return "Visualizar Reserva de: [" + this.reservaController.getMapaReservas().get(idReserva).getCliente().id + "] " + this.reservaController.getMapaReservas().get(idReserva).getCliente().getNome() + "(No. Doc " + this.reservaController.getMapaReservas().get(idReserva).getCliente().getNumeroDocumento() + ")\n ==========" +
				this.reservaController.getMapaReservas().get(idReserva).toString() + "==========";
	}

	/**
	 * Lista todas as reservas ativas do cliente
	 * @param idAutenticacao id de autenticação do usuário
	 * @param idCliente id do cliente
	 * @return toString da reserva
	 */
	public String listarReservasAtivasDoCliente(String idAutenticacao, String idCliente){
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("CLI") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(!this.usuarioController.getMapaUsuarios().containsKey(idCliente)){
			throw new HotelCaliforniaException("USUARIO NAO EXISTE");
		}

		String reservasAtivas = "Visualizar Reserva de: [ " + this.usuarioController.getMapaUsuarios().get(idCliente).getId()+ "] " + this.usuarioController.getMapaUsuarios().get(idCliente).getNome() + "(No. Doc " + this.usuarioController.getMapaUsuarios().get(idCliente).getNumeroDocumento() + ") \n ==========";

		for(Long chave: this.reservaController.getMapaReservas().keySet()){
			if(this.reservaController.getMapaReservas().get(chave).getCliente().getId().equals(idCliente) && !LocalDateTime.now().isAfter(this.reservaController.getMapaReservas().get(chave).getDataFim())){
				reservasAtivas += this.reservaController.getMapaReservas().get(chave).toString() + "\n----------";
			}
		}

		return reservasAtivas;
	}

	/**
	 * Lista todas as reservas do cliente por tipo da reserva
	 * @param idAutenticacao id de autenticação do usuário
	 * @param idCliente id do cliente
	 * @param tipo tipo da reserva buscada
	 * @return toString da reserva
	 */
	public String listarReservasAtivasDoClientePorTipo(String idAutenticacao, String idCliente, String tipo){
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("CLI") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		if(!this.usuarioController.getMapaUsuarios().containsKey(idCliente)){
			throw new HotelCaliforniaException("USUARIO NAO EXISTE");
		}

		String reservasAtivas = "Visualizar Reserva de: [" + this.usuarioController.getMapaUsuarios().get(idCliente).getId()+ "] " + this.usuarioController.getMapaUsuarios().get(idCliente).getNome() + "(No. Doc " + this.usuarioController.getMapaUsuarios().get(idCliente).getNumeroDocumento() + ")\n ==========";

		for(Long chave: this.reservaController.getMapaReservas().keySet()){
			if(this.reservaController.getMapaReservas().get(chave).getCliente().getId().equals(idCliente) && !LocalDateTime.now().isAfter(this.reservaController.getMapaReservas().get(chave).getDataFim()) && this.reservaController.getMapaReservas().get(chave).getTipoReserva().equals(tipo)){
				reservasAtivas += this.reservaController.getMapaReservas().get(chave).toString() + "\n----------";
			}
		}

		return reservasAtivas;
	}

	/**
	 * Lista todas as reservas com base em um tipo específico
	 * @param idAutenticacao id de autenticação do usuário
	 * @param tipo tipo da reserva cadatrada
	 * @return toString da reserva
	 */
	public String listarReservasAtivasPorTipo(String idAutenticacao, String tipo){
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("CLI") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		String reservasAtivas = "";

		for(Long chave: this.reservaController.getMapaReservas().keySet()){
			if(!LocalDateTime.now().isAfter(this.reservaController.getMapaReservas().get(chave).getDataFim()) && this.reservaController.getMapaReservas().get(chave).getTipoReserva().equals(tipo)){
				reservasAtivas += this.reservaController.getMapaReservas().get(chave).toString() + "\n----------";
			}
		}

		return reservasAtivas;
	}

	/**
	 * Lista todas as reservas ativas
	 * @param idAutenticacao id de autenticação do usuário
	 * @return toString da reserva
	 */
	public String listarReservasAtivas(String idAutenticacao){
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("CLI") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		String reservasAtivas = "";

		for(Long chave: this.reservaController.getMapaReservas().keySet()){
			if(!LocalDateTime.now().isAfter(this.reservaController.getMapaReservas().get(chave).getDataFim())){
				reservasAtivas += this.reservaController.getMapaReservas().get(chave).toString() + "\n----------";
			}
		}

		return reservasAtivas;
	}

	/**
	 * Lista todas as reservas cadastradas
	 * @param idAutenticacao id de autenticação do usuário
	 * @return toString da reserva
	 */
	public String listarReservasTodas(String idAutenticacao){
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("CLI") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER") && !this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		String reservasAtivas = "";

		for(Long chave: this.reservaController.getMapaReservas().keySet()){
			reservasAtivas += this.reservaController.getMapaReservas().get(chave).toString() + "\n----------";
		}

		return reservasAtivas;
	}

	/**
	 * Cria uma nova forma de pagamento
	 * @param idAutenticacao id de autenticação do usuário
	 * @param formaPagamento forma de pagamento cadatrada
	 * @param percentualDesconto percentual de desconto usado
	 * @return adicionado com sucesso se todos os parâmetros estão certos e exceção caso a forma de pagamento
	 * esteja errada
	 */
	public String disponibilizarFormaPagamento(String idAutenticacao, String formaPagamento, double percentualDesconto) {
		if(!this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("ADM")) {
			throw new HotelCaliforniaException("APENAS ADMINISTRADORES PODEM CADASTRAR UMA FORMA DE PAGAMENTO");
		}

		return this.formasPagamento.disponibilizarFormaDePagamento(idAutenticacao, formaPagamento, percentualDesconto);
	}

	/**
	 * Altera o total de desconto de um pagamento já cadastrado
	 * @param idAutenticacao id de autentiArrayListcação do usuário
	 * @param idFormaPagamento id da forma de pagamento cadastrada
	 * @param formaPagamento forma de pagamento escolhida
	 * @param percentualDesconto novo percentual de desconto
	 * @return DESCONTO ATUALIZADO COM SUCESSO caso os parâmetros estejam certos ou exceção caso não
	 */
	public String alterarFormaDePagamento(String idAutenticacao, int idFormaPagamento, String formaPagamento, double percentualDesconto) {

		if(this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("ADM")) {
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		return this.formasPagamento.alterarFormaDePagamento(idAutenticacao, idFormaPagamento, formaPagamento, percentualDesconto);
	}

	/**
	 * Exibe uma forma de pagamento específica
	 * @param idFormaPagamento id da forma de pagamento cadastrada
	 * @return um único toString
	 */
	public String exibirFormaPagamento(int idFormaPagamento) {
		return this.formasPagamento.exibirFormaPagamento(idFormaPagamento);

	}

	/**
	 * Retorna todas as formas de pagamento cadastradas no sistema
	 * @return toString das formas de pagamento armazenadas
	 */
	public String listarFormasPagamento() {
		return this.formasPagamento.listarFormasPagamento();
	}

	/**
	 * Pagar uma reserva com dinheiro
	 * @param idCliente id do cliente
	 * @param idReserva id da reserva
	 * @param nomeTitular nome do cliente cadastrado
	 * @return Pago com sucesso ou exceção
	 */
	public String pagarReservaComDinheiro(String idCliente, int idReserva, String nomeTitular ) {

		if(!this.usuarioController.getMapaUsuarios().containsKey(idCliente)) {
			throw new HotelCaliforniaException("CLIENTE NÃO ESTÁ REGISTRADO");
		}

		this.reservaController.getMapaReservas().get(idReserva).setPago(true);
		return this.pagamento.pagarReservaComDinheiro(idCliente, idReserva, nomeTitular);
	}

	/**
	 * Pagar uma reserva usando o cartão de crédito
	 * @param idCliente id do cliente
	 * @param idReserva id da reserva
	 * @param nomeTitular nome do titular do cartão
	 * @param numCartao número do cartão
	 * @param validade validade do cartão
	 * @param codigoDeSeguranca código de segurança do cartão
	 * @param qtdeParcelas quantidade de parcelas usadas
	 * @return Pago com sucesso ou exceção
	 */
	public String pagarReservaComCartao(String idCliente, int idReserva, String nomeTitular, String numCartao, String validade, String codigoDeSeguranca, int qtdeParcelas) {
		if(numCartao.length() < 12 || numCartao.length() > 12) {
			throw new HotelCaliforniaException("NÚMERO DE CARTÃO INVÁLIDO");
		}

		if(codigoDeSeguranca.length() < 3 || codigoDeSeguranca.length() > 3) {
			throw new HotelCaliforniaException("CÓDIGO DE SEGURANÇA INVÁLIDO");
		}

		if(qtdeParcelas > 12) {
			throw new HotelCaliforniaException("PARCELAMENTO MÁXIMO EM ATÉ 12X");
		}

		if(!this.usuarioController.getMapaUsuarios().containsKey(idCliente)) {
			throw new HotelCaliforniaException("CLIENTE NÃO ESTÁ REGISTRADO");
		}

		this.reservaController.getMapaReservas().get(idReserva).setPago(true);
		return this.pagamento.pagarReservaComCartao(idCliente, idReserva, nomeTitular, numCartao, validade, codigoDeSeguranca, qtdeParcelas);
	}

	/**
	 * Pagar reserva usando o pix
	 *
	 * @param idCliente id do cliente
	 * @param idReserva id da reserva
	 * @param nomeTitular nome do titular
	 * @param cpf cpf usado
	 * @param banco banco usado
	 * @return Pago com sucesso ou exceção
	 */
	public String pagarReservaComPix(String idCliente, int idReserva, String nomeTitular, String cpf, String banco) {

		if(!this.usuarioController.getMapaUsuarios().containsKey(idCliente)) {
			throw new HotelCaliforniaException("CLIENTE NÃO ESTÁ REGISTRADO");
		}

		if(cpf.length() > 11 || cpf.length() < 11) {
			throw new HotelCaliforniaException("PARCELAMENTO MÁXIMO EM ATÉ 12X");
		}

		this.reservaController.getMapaReservas().get(idReserva).setPago(true);
		return this.pagamento.pagarReservaComPix(idCliente, idReserva, nomeTitular, cpf, banco);
	}

	public String reservarRestaurante(String idAutenticacao, String idCliente, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas, String idRefeicao){
		if (this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN") || this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER")){
			return this.reservaController.reservarRestaurante(this.usuarioController.getMapaUsuarios().get(idCliente), dataInicio, dataFim, quantidadePessoas, this.refeicaoController.getMapaRefeicoes().get(idRefeicao));
		}
		throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO CADASTRAR UMA RESERVA");
	}

	public String reservarAuditorio(String idAutenticacao, String idCliente, long idAuditorio, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas){
		if (this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("FUN") || this.usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("GER")){
			return this.reservaController.reservarAuditorio(this.usuarioController.getMapaUsuarios().get(idCliente), this.areaComum.getMapaAreasComuns().get(idAuditorio), dataInicio, dataFim, quantidadePessoas);
		}
		throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO CADASTRAR UMA RESERVA");
	}

	public String cancelarReserva(String idCliente, String idReserva){
		if (this.usuarioController.getMapaUsuarios().get(idCliente).getTipo().equals("CLI")){
			this.reservaController.cancelarReserva(this.usuarioController.getMapaUsuarios().get(idCliente), idReserva);
			return this.reservaController.getReservaCancelada().toString();
		}
		throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO CADASTRAR UMA RESERVA");
	}

	/**
	 * Disponibiliza uma área comum para ser reservada no hotel
	 * @param idAutenticacao id de autenticação do usuário
	 * @param tipoAreaComum tipo da área comum
	 * @param titulo titulo da área
	 * @param horarioInicio horário de início
	 * @param horarioFinal horário final
	 * @param valorPessoa valor por pessoa
	 * @param disponivel se a área está disponível para uso
	 * @param qtMaxPessoas quantidade máxima de pessoas permitidas
	 * @return
	 */
	public String disponibilizarAreaComum(String idAutenticacao, String tipoAreaComum, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel, int qtMaxPessoas){
		if(!usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("ADM")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}
		return this.areaComum.disponibilizarAreaComum(tipoAreaComum, titulo, horarioInicio, horarioFinal, valorPessoa, disponivel, qtMaxPessoas);
	}

	/**
	 * Altera uma área comum já cadastrada
	 * @param idAutenticacao id de autenticação do usuário
	 * @param idAreaComum id da área comum
	 * @param novoHorarioInicio novo horário de início cadastrado
	 * @param novoHorarioFinal novo horário de término
	 * @param novoPreco novo preço usado
	 * @param capacidadeMax capacidade máxima de pessoas
	 * @param ativa se a área está disponível para uso
	 * @return
	 */
	public String alterarAreaComum(String idAutenticacao, long idAreaComum, LocalTime novoHorarioInicio, LocalTime novoHorarioFinal, double novoPreco, int capacidadeMax, boolean ativa){
		if(!usuarioController.getMapaUsuarios().get(idAutenticacao).getTipo().equals("ADM")){
			throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO");
		}

		return this.areaComum.alterarAreaComum(idAreaComum, novoHorarioInicio, novoHorarioFinal, novoPreco, capacidadeMax, ativa);
	}

	/**
	 * Exibe uma única área comum
	 * @param idAreaComum id da área comum buscada
	 * @return toString da área comum
	 */
	public String exibirAreaComum(long idAreaComum){
		return this.areaComum.exibirAreaComum(idAreaComum);
	}

	/**
	 * Listar todas as áreas comuns cadastradas
	 * @return toString
	 */
	public String listarAreasComuns(){
		return this.areaComum.listarAreasComuns();
	}

}