import java.util.Scanner;

public class cores{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int R = sc.nextInt();
        int G = sc.nextInt();
        int B = sc.nextInt();
        
        if(R >= 128 && G >= 128 && B >= 128){
        	System.out.println("BRANCO");
        }else{
        	System.out.println("PRETO");
        }
    }
}
