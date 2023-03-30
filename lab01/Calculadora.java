/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Daniele de Oliveira Sousa - 122110667
 */

import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String operacao = sc.nextLine();
        float valor1 = sc.nextFloat();
        float valor2 = sc.nextFloat();
        
        if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/"){  
            System.out.println("ENTRADA INVALIDA");
        }else{
            if(operacao == "+"){
                System.out.println("RESULTADO:" + (valor1 + valor2));
            }
            else if(operacao == "-"){
                System.out.println("RESULTADO:" + (valor1 - valor2));
            }
            else if(operacao == "*"){
                System.out.println("RESULTADO:" + (valor1 * valor2));
            }
            else{
                if (valor2 == 0){
                    System.out.println("ERRO");
                }
                else{
                    System.out.println("RESULTADO:" + (valor1 / valor2));
                }
            }
        }
        
    }
}
