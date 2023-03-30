/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Daniele de Oliveira Sousa - 122110667
 */

import java.util.Scanner;

public class Estritamente{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        
        if ((A != B && A != B && A != C && A != D && B != D && B != C && C != D) && (A < D && B < C)){
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        }else if ((A != B && A != B && A != C && A != D && B != D && B != C && C != D) && (A > D && B > C)){
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        }else{
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
}
