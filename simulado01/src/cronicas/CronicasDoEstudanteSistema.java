package cronicas;

public class CronicasDoEstudanteSistema {
	
	private Cronica[] cronicas;
	private int totalAdicionado;


	public static void main(String args[]) {
		
	}
	
	public CronicasDoEstudanteSistema() {
		this.cronicas = new Cronica[1000];
		this.totalAdicionado = 0;
	}
	
    public void cadastrarCronica(String titulo, String texto, String data, String autor) {
    	cronicas[totalAdicionado] = new Cronica(titulo, texto, data, autor);
    	totalAdicionado++;
    }
    
    public void cadastrarCronica(String titulo, String texto, String data) {
    	cronicas[totalAdicionado] = new Cronica(titulo, texto, data);
    	totalAdicionado++;
    }
    
    public String listarCronicas() {
    	String cronicasCadastradas = "";
    	
    	for(int i = 0; i < cronicas.length; i++) {
    		cronicasCadastradas += "Cronica #" + i+1 + "\n" + cronicas[i];
    	}
    	
    	return cronicasCadastradas;
    }
}
