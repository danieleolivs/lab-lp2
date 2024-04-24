package br.edu.ufcg.computacao.p2lp2.areasComuns;

import java.time.LocalTime;
import java.util.HashMap;

public class AreasComunsController {
    private HashMap<Long, AreasComuns> mapaAreasComuns;

    AreasComuns areas;
    private static AreasComunsController areasComunsController;
    public AreasComunsController(){

        this.mapaAreasComuns = new HashMap<>();
    }

    public String disponibilizarAreaComum(String tipoAreaComum, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, double valorPessoa, boolean disponivel, int tMaxPessoas){
        if(tipoAreaComum.equals("Auditório")){
            this.areas = new Auditorio(tipoAreaComum, titulo, horarioInicio, horarioInicio, valorPessoa, disponivel, tMaxPessoas);
        }else if(tipoAreaComum.equals("Cinema")){
            this.areas = new Cinema(tipoAreaComum, titulo, horarioInicio, horarioInicio, valorPessoa, disponivel, tMaxPessoas);
        }else if(tipoAreaComum.equals("Piscina")){
            this.areas = new Piscina(tipoAreaComum, titulo, horarioInicio, horarioInicio, valorPessoa, disponivel, tMaxPessoas);
        }else{
            this.areas = new SalaoDeFesta(tipoAreaComum, titulo, horarioInicio, horarioInicio, valorPessoa, disponivel, tMaxPessoas);
        }

        this.mapaAreasComuns.put(this.areas.getIdAreaComum(), areas);
        return "AREA DISPONIBILIZADA COM SUCESSO";
    }

    public String alterarAreaComum(long idAreaComum, LocalTime novoHorarioInicio, LocalTime novoHorarioFinal, double novoPreco, int capacidadeMax, boolean ativa){
        this.mapaAreasComuns.get(idAreaComum).setDisponivel(ativa);
        this.mapaAreasComuns.get(idAreaComum).setValorPessoa(novoPreco);
        this.mapaAreasComuns.get(idAreaComum).setHorarioFim(novoHorarioFinal);
        this.mapaAreasComuns.get(idAreaComum).setHorarioInicio(novoHorarioInicio);
        this.mapaAreasComuns.get(idAreaComum).setQtMaxPessoas(capacidadeMax);

        return "ÁREA ALTERADA COM SUCESSO";
    }

    public String exibirAreaComum(long idAreaComum){

        if(this.mapaAreasComuns.size() == 0){
            return "NENHUMA ÁREA COMUM CADASTRADA";
        }

        if(this.mapaAreasComuns.containsKey(idAreaComum)){
            return "ÁREA NÃO EXISTE";
        }

        return this.mapaAreasComuns.get(idAreaComum).toString();
    }

    public String listarAreasComuns(){
        if(this.mapaAreasComuns.size() == 0){
            return "NENHUMA ÁREA COMUM CADASTRADA";
        }

        String concatAreasComuns = "";

        for(long area: mapaAreasComuns.keySet()) {
            concatAreasComuns += this.mapaAreasComuns.get(area).toString() + "\n";
        }

        return concatAreasComuns;
    }

    public static AreasComunsController getInstance() {
        if (areasComunsController == null){
            areasComunsController = new AreasComunsController();
        } return areasComunsController;
    }
    public void init() {
        this.mapaAreasComuns.clear();
    }

    public HashMap<Long, AreasComuns> getMapaAreasComuns() {
        return mapaAreasComuns;
    }
}
