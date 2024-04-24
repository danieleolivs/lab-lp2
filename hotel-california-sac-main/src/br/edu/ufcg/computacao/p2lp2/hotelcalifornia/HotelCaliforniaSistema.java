package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import br.edu.ufcg.computacao.p2lp2.formaPagamento.FormasDePagamentoController;
import br.edu.ufcg.computacao.p2lp2.formaPagamento.PagamentoController;
import br.edu.ufcg.computacao.p2lp2.areasComuns.AreasComunsController;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HotelCaliforniaSistema {
	HotelCaliforniaController hotel;
	UsuarioController usuario;
	RefeicaoController refeicao;

	ReservaController reserva;

	FormasDePagamentoController formasPagamento;

	PagamentoController pagamento;

	AreasComunsController areasComuns;

	//Construtor que inicializa as principais funcionalidades do sistema: hashmap e administrador padrão
	public HotelCaliforniaSistema() {
		this.hotel = new HotelCaliforniaController();
		usuario = UsuarioController.getInstance();
		usuario.init();
		refeicao = RefeicaoController.getInstance();
		areasComuns = AreasComunsController.getInstance();
		areasComuns.init();
	}

	public String cadastrarUsuario(String id, String nome, String tipo, long numeroDocumento) {
		return this.hotel.cadastraUsuario(id, nome, tipo, numeroDocumento);
	}
	
	public String atualizaUsuário(String id, String idUsuarioAlterado, String novoTipoUsuario) {
		return this.hotel.atualizarUsuario(id, idUsuarioAlterado, novoTipoUsuario);
	}
	
	public String exibirUsuario(String idUsuario) {
		return this.hotel.exibirUsuario(idUsuario);
	}

	public String listarUsuarios() {
		return this.hotel.listarUsuarios();
	}
	public String disponibilizarRefeicao(String id, String tipoRefeicao, String tituloRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorRefeicao, boolean disponivel) {
		return this.hotel.disponibilizarRefeicao(id, tipoRefeicao, tituloRefeicao, horarioInicio, horarioFinal, valorRefeicao, disponivel);
	}
	
	public String alterarRefeicao(long idRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel) {
		return this.hotel.alterarRefeicao(idRefeicao, horarioInicio, horarioFinal, valorPessoa, disponivel);
	}
	
	public String exibirRefeicao(long idRefeicao) {
		return this.hotel.exibirRefeicao(idRefeicao);
	}
	
	public String listarRefeicao() {
		return this.hotel.listarRefeicoes();
	}
	
	public String disponibilizarQuartoSingle(String idAutenticacao, int idQuartoNum, double precoPorPessoa, double precoBase) {
		return this.hotel.disponibilizarQuartoSingle(idAutenticacao, idQuartoNum, precoPorPessoa, precoBase);
	}
	
	public String disponibilizarQuartoDouble(String idAutenticacao, int idQuartoNum, double precoPorPessoa, double precoBase, String[] pedidos) {
		return this.hotel.disponibilizarQuartoDouble(idAutenticacao, idQuartoNum, precoPorPessoa, precoBase, pedidos);
	}
	
	public String disponibilizarQuartoFamily(String idAutenticacao, int idQuartoNum, double precoPorPessoa, double precoBase, String[] pedidos, int qtdMaxPessoa) {
		return this.hotel.disponibilizarQuartoFamily(idAutenticacao, idQuartoNum, precoPorPessoa, precoBase, pedidos, qtdMaxPessoa);
	}
	
	public String exibirQuarto(int idQuartoNum) {
		return this.hotel.exibirQuarto(idQuartoNum);
	}

	public String listarQuartos(int numQuarto) {
		return this.hotel.listarQuartos(numQuarto);
	}

	public String reservarQuartoSingle(String idAutenticacao, Usuario idCliente, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes) {
		return this.hotel.reservarQuartoSingle(idAutenticacao, idCliente, quartoAlocado, dataInicio, dataFim, idRefeicoes);
	}

	public String reservarQuartoDouble(Usuario idCliente, String idAutenticacao, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes, String[] pedidos) {
		return this.hotel.reservarQuartoDouble(idCliente, idAutenticacao, quartoAlocado, dataInicio, dataFim, idRefeicoes, pedidos);
	}

	public String reservarQuartoFamily(Usuario idCliente, String idAutenticacao, int quartoAlocado, LocalDateTime dataInicio, LocalDateTime dataFim, Refeicao idRefeicoes, String[] pedidos, int numPessoas) {
		return this.hotel.reservarQuartoFamily(idCliente, idAutenticacao, quartoAlocado, dataInicio, dataFim, idRefeicoes, pedidos, numPessoas);
	}

	public String exibeReservaQuarto(String idAutenticacao, long idReserva) {
		return this.hotel.exibeReservaQuarto(idAutenticacao, idReserva);
	}
	
	public String disponibilizarFormaDePagamento(String idAutenticacao, String formaPagamento, double percentualDesconto) {
		return this.hotel.disponibilizarFormaPagamento(idAutenticacao, formaPagamento, percentualDesconto);
	}
	
	public String alterarFormaDePagamento(String idAutenticacao, int idFormaPagamento, String formaPagamento, double percentualDesconto) {
		return this.hotel.alterarFormaDePagamento(idAutenticacao, idFormaPagamento, formaPagamento, percentualDesconto);
	}
	
	public String exibirFormaPagamento(int idFormaPagamento) {
		return this.hotel.exibirFormaPagamento(idFormaPagamento);
	}
	
	public String listarFormasPagamento() {
		return this.hotel.listarFormasPagamento();
	}
	
	public String pagarReservaComDinheiro(String idCliente, int idReserva, String nomeTitular) {
		return this.hotel.pagarReservaComDinheiro(idCliente, idReserva, nomeTitular);
	}
	
	public String pagarReservaComCartao(String idCliente, int idReserva, String nomeTitular, String numCartao, String validade, String codigoDeSeguranca, int qtdeParcelas) {
		return this.hotel.pagarReservaComCartao(idCliente, idReserva, nomeTitular, numCartao, validade, codigoDeSeguranca, qtdeParcelas);
	}
	
	public String pagarReservaComPix(String idCliente, int idReserva, String nomeTitular, String cpf, String banco) {
		return this.hotel.pagarReservaComPix(idCliente, idReserva, nomeTitular, cpf, banco);
	}

	public String reservarRestaurante(String idAutenticacao, String idCliente, LocalDateTime dataInicio, LocalDateTime dataFim, int quantidadePessoas, String idRefeicao){
		return this.hotel.reservarRestaurante(idAutenticacao, idCliente, dataInicio, dataFim, quantidadePessoas, idRefeicao);
	}

	public String cancelarReserva(String idCliente, String idReserva){
		return this.hotel.cancelarReserva(idCliente, idReserva);
	}

	public String reservarAuditorio(String idAutenticacao, String idCliente, long idAuditorio, LocalDateTime dataInicio, LocalDateTime dataFim, int qtdMaxPessoas){
		return this.hotel.reservarAuditorio(idAutenticacao, idCliente, idAuditorio, dataInicio, dataFim, qtdMaxPessoas);
	}

	public String disponibilizarAreaComum(String idAutenticacao, String tipoAreaComum, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel, int qtMaxPessoas){
		return this.hotel.disponibilizarAreaComum(idAutenticacao, tipoAreaComum, titulo, horarioInicio, horarioFinal, valorPessoa, disponivel, qtMaxPessoas);
	}

	public String alterarAreaComum(String idAutenticacao, long idAreaComum, LocalTime novoHorarioInicio, LocalTime novoHorarioFim, double novoPreco, int capacidadeMax, boolean ativa){
		return this.hotel.alterarAreaComum(idAutenticacao, idAreaComum, novoHorarioInicio, novoHorarioFim, novoPreco, capacidadeMax, ativa);
	}

	public String exibirAreaComum(long idAreaComum){
		return this.hotel.exibirAreaComum(idAreaComum);
	}

	public String listarAreasComum(){
		return this.hotel.listarAreasComuns();
	}

	public String exibirReserva(String idAutenticacao, long idReserva){
		return this.hotel.exibirReserva(idAutenticacao, idReserva);
	}

	public String listarReservasAtivasDoCliente(String idAutenticacao, String idCliente){
		return this.hotel.listarReservasAtivasDoCliente(idAutenticacao, idCliente);
	}

	public String listarReservasAtivasDoClientePorTipo(String idAutenticacao, String idCliente, String tipo){
		return this.hotel.listarReservasAtivasDoClientePorTipo(idAutenticacao, idCliente, tipo);
	}

	public String listarReservasAtivasPorTipo(String idAutenticacao, String tipo){
		return this.hotel.listarReservasAtivasPorTipo(idAutenticacao, tipo);
	}

	public String listarReservasAtivas(String idAutenticacao){
		return this.hotel.listarReservasAtivas(idAutenticacao);
	}

	public String listarReservasTodas(String idAutenticacao){
		return this.hotel.listarReservasTodas(idAutenticacao);
	}
}
