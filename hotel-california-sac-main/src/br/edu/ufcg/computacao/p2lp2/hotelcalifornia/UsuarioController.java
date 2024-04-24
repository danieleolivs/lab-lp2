package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import br.edu.ufcg.computacao.p2lp2.Exception.HotelCaliforniaException;

import java.util.HashMap;

public class UsuarioController {
	// Hashmap que guarda todos os usuários cadastrados
	private HashMap <String, Usuario> mapaUsuarios;
	//Objeto usuário
	private Usuario usuario;
	private static UsuarioController usuarioController;
	
	public UsuarioController() {
		this.mapaUsuarios = new HashMap<>();
		this.usuario = new Usuario("ADM1", "Joao Costa", "ADM", 123456);
		mapaUsuarios.put("ADM1", usuario);
	}
	
	public String cadastraUsuario(String id, String nome, String tipo, long numeroDocumento) {

		String idUsuarioCadastrado = tipo + Integer.toString(mapaUsuarios.size() + 1);

		this.usuario = new Usuario(idUsuarioCadastrado, nome, tipo, numeroDocumento);
		mapaUsuarios.put(idUsuarioCadastrado, usuario);
		return "USUÁRIO CADASTRADO COM SUCESSO";
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

		if(!mapaUsuarios.containsKey(id)) {
			throw new HotelCaliforniaException("USUARIO NAO EXISTE");
		}

		if(!mapaUsuarios.get(id).getTipo().equals("ADM")) {
			throw new HotelCaliforniaException("APENAS O ADMINISTRADOR PODE ATUALIZAR OS USUARIOS");
		}

		if(novoTipoUsuario.equals("GER") && mapaUsuarios.containsKey("GER")) {
			for(String usuarios: mapaUsuarios.keySet()) {
				if(this.mapaUsuarios.get(usuarios).getTipo().equals("GER")) {
					this.mapaUsuarios.get(usuarios).setTipo("FUN");
				}
			}
		}

		this.mapaUsuarios.get(idUsuarioAlterado).setTipo(novoTipoUsuario);

		return "USUÁRIO ATUALIZADO COM SUCESSO";
	}
	
	/**
	 *  Exibe um determinado usuário cadastrado
	 * @param idUsuario id do usuário buscado
	 * @return toString do usuário cadastrado
	 */
	public String exibirUsuario(String idUsuario) {
		if(!mapaUsuarios.containsKey(idUsuario)) {
			throw new HotelCaliforniaException("USUARIO NAO EXISTE");
		}

		return mapaUsuarios.get(idUsuario).toString();
	}
	
	/**
	 * Lista todos os usuários cadastrados no sistema
	 * @return lista com o toString de todos os usuários cadastrados
	 */
	public String listarUsuarios() {
		String concatUsuarios = "";

		for(String usuarios: mapaUsuarios.keySet()) {
			concatUsuarios += this.mapaUsuarios.get(usuarios).toString() + "\n";
		}

		return concatUsuarios;
	}
	public static UsuarioController getInstance() {
		if (usuarioController == null){
			usuarioController = new UsuarioController();
		} return usuarioController;
	}
	public void init() {
		this.mapaUsuarios.clear();
		this.usuario = new Usuario("ADM1", "Joao Costa", "ADM", 123456);
		mapaUsuarios.put("ADM1", usuario);
	}
	public HashMap<String, Usuario> getMapaUsuarios() {
		return mapaUsuarios;
	}
}
