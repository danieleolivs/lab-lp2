package desafio;

public class DesafioSocial extends Desafio{
	
	private int totalParticipantes;

	public DesafioSocial(String titulo, int totalParticipantes) {
		super(titulo, "social");
		this.totalParticipantes = totalParticipantes;
	}
	
	public DesafioSocial(String titulo, String descricao, int totalParticipantes) {
		super(titulo, descricao, "social");
		this.totalParticipantes = totalParticipantes;
	}
	
	@Override
	public void concluirDesafio() {
		super.concluirDesafio();
		if(totalParticipantes >= 10 && totalParticipantes <=50) {
			this.satisfacao += 10;
		}else if(totalParticipantes >100) {
			this.satisfacao +=50;
		}else {
			this.satisfacao += 20;
		}
	}
	

}
