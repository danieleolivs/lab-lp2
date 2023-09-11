package cronicas;

public class CronicasDoEstudanteSistema {
	
	private Cronica[] cronicas;
	private int totalAdicionado;
	private int[] totalLidos;
	private static final int TOTAL_CRONICAS = 1000;
	private static final int TOTAL_CRONICAS_LIDAS = 1000;


	public static void main(String args[]) {
		
	}
	
	public CronicasDoEstudanteSistema() {
		this.cronicas = new Cronica[TOTAL_CRONICAS];
		this.totalLidos = new int[TOTAL_CRONICAS_LIDAS];
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
    		cronicasCadastradas += "Cronica #" + i+1 + "\n" + cronicas[i].toString();
    	}
    	
    	return cronicasCadastradas;
    }
    
    public String lerCronica(int posicao) {
    	totalLidos[posicao-1] = totalCronicasLidas(totalLidos[posicao-1]);
    	return cronicas[posicao-1].getTexto();
    }
    
    private int totalCronicasLidas(int total) {
    	return total++;
    }
    
    public String exibirCronicaMaisLida() {
    	int maior = 0;
    	int indice = 0;
    	
    	for(int i = 0; i < totalLidos.length; i++) {
    		if(totalLidos[i] > maior) {
    			maior = totalLidos[i];
    			indice = i;
    		}
    	}
    	
    	return cronicas[indice].getTitulo() + " - lida " + maior + " vezes";
    }
}
