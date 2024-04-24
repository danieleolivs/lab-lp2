package br.edu.ufcg.computacao.p2lp2.areasComuns;

import java.time.LocalTime;

public class Piscina extends AreasComuns{

    public Piscina(String tipoAreaComum, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel, int qtMaxPessoas) {
        super(tipoAreaComum, titulo, horarioInicio, horarioFinal, valorPessoa, disponivel, qtMaxPessoas);
        this.idAreaComum = random.nextLong();
    }
}
