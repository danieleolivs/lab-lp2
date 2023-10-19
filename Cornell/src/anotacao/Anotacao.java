package anotacao;

import java.util.ArrayList;
import java.util.Objects;

public class Anotacao {
	private String  nomeDisciplina;
	private String texto;
	private String data;
	
	private String textoSumario;
	private ArrayList<Questao> arrayListQuestoes;
	private int idQuestoes;
	
	public Anotacao(String nomeDisciplina, String data, String texto) {
		this.nomeDisciplina = nomeDisciplina;
		this.data = data;
		this.texto = texto;
		
		this.arrayListQuestoes = new ArrayList<>();
		this.idQuestoes = 0;
	}
	
	public void definirSumario(String texto) {
		this.textoSumario = texto;
	}
	
	public void adicionaQuestão(Questao questao) {
		this.arrayListQuestoes.add(questao);
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public String getTexto() {
		return texto;
	}

	public String getData() {
		return data;
	}

	public String getTextoSumario() {
		return textoSumario;
	}

	public Questao getQuestao(int idQuestao) {
		return arrayListQuestoes.get(idQuestao - 1);
	}

	@Override
	public String toString() {
		return "Disciplina: "+ this.nomeDisciplina + "\nData: " + this.data + "\nTexto: " + this.texto + existeSumario();
	}
	
	private String existeSumario() {
		if(textoSumario.isBlank() || textoSumario.isEmpty()) {
			return "";
		}
		
		return "\nSumário: " + this.textoSumario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, nomeDisciplina, texto, textoSumario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anotacao other = (Anotacao) obj;
		return Objects.equals(data, other.data) && Objects.equals(nomeDisciplina, other.nomeDisciplina)
				&& Objects.equals(texto, other.texto) && Objects.equals(textoSumario, other.textoSumario);
	}
	
	
}
