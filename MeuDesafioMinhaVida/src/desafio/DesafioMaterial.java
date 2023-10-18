package desafio;

public class DesafioMaterial extends Desafio{
	
	private int totalSatisfacao;

	public DesafioMaterial(String titulo, int valor) {
		super(titulo, "material");
		
		this.totalSatisfacao += (valor/100) * 10;
		
	}
	
	public DesafioMaterial(String titulo, String descricao, int valor) {
		super(titulo, descricao, "material");
		this.totalSatisfacao += (valor/100) * 10;
	}
	
	@Override
	public void concluirDesafio() {
		super.concluirDesafio();
		this.satisfacao += totalSatisfacao;
	}

}
