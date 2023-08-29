package br.edu.ufcg.computacao.lp2.coisa;

/**
 * Classe que integra as funcionalidades criadas como bônus para o sistema.
 * @author Daniele de Oliveira Sousa
 *
 */
public class CoisaBonus {
	
	/**
	 * Chama as principais funcionalidades da classe.
	 * @param args
	 */
	public static void main(String[] args) {
		maisNotas();
	}
	
	/**
	 * testa as funcionalidades mais notas adicionadas a classe existente disciplina.
	 */
	public static void maisNotas() {
		
		int[] pesos = {6, 4};
				
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 3);
		Disciplina prog1 = new Disciplina("PROGRAMACAO 1", 4);
		Disciplina prog3 = new Disciplina("PROGRAMACAO 3", 2, pesos );
		
		prog2.cadastraHoras(4);
		prog2.cadastraNota(1, 8.0);
		prog2.cadastraNota(2, 7.0);
		prog2.cadastraNota(3, 7.0);
		System.out.println(prog2.aprovadoBonus());
		System.out.println(prog2.toString());
		
		System.out.println("-----");
		
		prog1.cadastraHoras(4);
		prog1.cadastraNota(1, 8.0);
		prog1.cadastraNota(3, 6.0);
		System.out.println(prog1.aprovadoBonus());
		System.out.println(prog1.toString());
		
		System.out.println("-----");
		
		prog3.cadastraHoras(4);
		prog3.cadastraNota(1, 8.0);
		prog3.cadastraNota(2, 6.0);
		System.out.println(prog3.aprovadoBonus());
		System.out.println(prog3.toString());
		
	}
}
