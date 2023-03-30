/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @Daniele de Oliveira Sousa - 122110667
 */

import java.util.Scanner;

public class Wally{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			String res = "?";
			String listaNomes = sc.nextLine();
			
			if(listaNomes.equals("wally")){
				break;
			}
				
			for(String nome: listaNomes.split(" ")){
				if(nome.length() == 5){
					res = nome;
				}
			}
				
			System.out.println(res);
		}
	}
}

