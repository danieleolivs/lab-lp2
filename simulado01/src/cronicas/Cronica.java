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
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public String getData() {
		return this.data;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	@Override
	public String toString() {
		return this.titulo + "\nData: " + this.data + "/nAutor: " + this.autor + "\n " + this.texto ;
	}
	
}
