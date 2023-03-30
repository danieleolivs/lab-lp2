/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Daniele de Oliveira Sousa - 122110667
 */

import java.util.Scanner;

public class Media{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float Y = sc.nextFloat();
        float Z = sc.nextFloat();
        float Media = (Y + Z)/2;
        if (Media >= 7.0){
            System.out.println("pass: True!");
        }else{
            System.out.println("pass: False!");
        }
        
    }
}
