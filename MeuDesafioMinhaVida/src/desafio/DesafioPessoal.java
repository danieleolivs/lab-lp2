package desafio;

public class DesafioPessoal extends Desafio{

	public DesafioPessoal(String titulo, String tipo) {
		super(titulo, "pessoal");
		
	}
	
	public DesafioPessoal(String titulo, String descricao, String tipo) {
		super(titulo, descricao, "pessoal");
	}
	
	@Override
	public void concluirDesafio() {
		super.concluirDesafio();
		this.satisfacao += 10;
	}
	

}
