/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @Daniele de Oliveira Sousa - 122110667
 */

import java.util.Scanner;

public class Notas{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int soma = 0;
		int total = 0;
		int maior = 0;
		int menor = 1000;
		int acima = 0;
		int abaixo = 0;
		int media = 0;
		String notas = "";
		
		while(true){
			String aluno = sc.nextLine();
			
			if(aluno.equals("-")){
				break;
			}
			
			String[] alunoSplit = aluno.split(" ");
			int nota = Integer.parseInt(alunoSplit[1]);
			notas += nota + " ";
			
			total++;
			soma += nota;
				
			if (nota > maior){
				maior = nota;
			}
			
			if (nota < menor){
				menor  = nota;
			}
		}
		
		media = soma/total;
		for(String nota1: notas.split(" ")){
			int nota2 = Integer.parseInt(nota1);
			if (nota2 >= 700){
				acima++;
			}else{
				abaixo++;
			}
		}
		
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
		
	}
}

