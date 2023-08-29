package cronicas;

public class Cronica {
	
	private String titulo;
	private String texto;
	private String data;
	private String autor;
	
	public Cronica(String titulo, String texto, String data, String autor) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}
	
	public Cronica(String titulo, String texto, String data) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.autor = "Anônimo";
	}

	
}
