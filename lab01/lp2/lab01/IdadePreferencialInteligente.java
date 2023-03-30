package lp2.lab01;

public class IdadePreferencialInteligente{
    public static void main(String[] args){
        int ano_de_nascimento = 2005;
        int ano_atual = 2023;
        int idade = ano_atual - ano_de_nascimento;
        
        if (idade >= 60) {
            System.out.println("Voce tem" + idade + "anos . Voce pode usar o atendimento especial");
        }
        else{
            System.out.println("Voce tem " + idade + " anos. Voce ainda nao pode usar o atendimento especial.");
        }
    }
}
