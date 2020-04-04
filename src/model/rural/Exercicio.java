package model.rural;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDVALDO ANTUNES
 */
public class Exercicio {
    private int Id;
    private int exercicio;
    private double aparecida_salto;
    private double barreirinho;
    private double cacador;
    private double cerrado;
    private double furnas;
    private double herval;
    private double itopava;
    private double quadro_seda;
    private double lajeado;
    private double matao;
    private double morro_chato;
    private double morro_vermelho;
    private double morro_azul;
    private double pedra_branca;
    private double ponte_alta;
    private double sta_barbara;
    private double santa_cruz;
    private double demais_bairros;
    
    public void cadastrar(Integer exercicio,
                          Double aparecida_salto,
                          Double barreirinho,
                          Double cacador,
                          Double cerrado,
                          Double furnas,
                          Double herval,
                          Double itopava,
                          Double quadro_seda,
                          Double lajeado,
                          Double matao,
                          Double morro_chato,
                          Double morro_vermelho,
                          Double morro_azul,
                          Double pedra_branca,
                          Double ponte_alta,
                          Double sta_barbara,
                          Double santa_cruz,
                          Double demais_bairros){
        setAparecida_salto(aparecida_salto);
        setBarreirinho(barreirinho);
        setCacador(cacador);
        setCerrado(cerrado);
        setDemais_bairros(demais_bairros);
        setExercicio(exercicio);
        setFurnas(furnas);
        setHerval(herval);
        setItopava(itopava);
        setLajeado(lajeado);
        setMatao(matao);
        setMorro_azul(morro_azul);
        setMorro_chato(morro_chato);
        setMorro_vermelho(morro_vermelho);
        setQuadro_seda(quadro_seda);
        setSanta_cruz(santa_cruz);
        setSta_barbara(sta_barbara);
        setPedra_branca(pedra_branca);
        setPonte_alta(ponte_alta);
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public double getAparecida_salto() {
        return aparecida_salto;
    }

    public void setAparecida_salto(double aparecida_salto) {
        this.aparecida_salto = aparecida_salto;
    }

    public double getBarreirinho() {
        return barreirinho;
    }

    public void setBarreirinho(double barreirinho) {
        this.barreirinho = barreirinho;
    }

    public double getCacador() {
        return cacador;
    }

    public void setCacador(double cacador) {
        this.cacador = cacador;
    }

    public double getCerrado() {
        return cerrado;
    }

    public void setCerrado(double cerrado) {
        this.cerrado = cerrado;
    }

    public double getFurnas() {
        return furnas;
    }

    public void setFurnas(double furnas) {
        this.furnas = furnas;
    }

    public double getHerval() {
        return herval;
    }

    public void setHerval(double herval) {
        this.herval = herval;
    }

    public double getItopava() {
        return itopava;
    }

    public void setItopava(double itopava) {
        this.itopava = itopava;
    }

    public double getQuadro_seda() {
        return quadro_seda;
    }

    public void setQuadro_seda(double quadro_seda) {
        this.quadro_seda = quadro_seda;
    }

    public double getLajeado() {
        return lajeado;
    }

    public void setLajeado(double lajeado) {
        this.lajeado = lajeado;
    }

    public double getMatao() {
        return matao;
    }

    public void setMatao(double matao) {
        this.matao = matao;
    }

    public double getMorro_chato() {
        return morro_chato;
    }

    public void setMorro_chato(double morro_chato) {
        this.morro_chato = morro_chato;
    }

    public double getMorro_vermelho() {
        return morro_vermelho;
    }

    public void setMorro_vermelho(double morro_vermelho) {
        this.morro_vermelho = morro_vermelho;
    }

    public double getMorro_azul() {
        return morro_azul;
    }

    public void setMorro_azul(double morro_azul) {
        this.morro_azul = morro_azul;
    }

    public double getPedra_branca() {
        return pedra_branca;
    }

    public void setPedra_branca(double pedra_branca) {
        this.pedra_branca = pedra_branca;
    }

    public double getPonte_alta() {
        return ponte_alta;
    }

    public void setPonte_alta(double ponte_alta) {
        this.ponte_alta = ponte_alta;
    }

    public double getSta_barbara() {
        return sta_barbara;
    }

    public void setSta_barbara(double sta_barbara) {
        this.sta_barbara = sta_barbara;
    }

    public double getSanta_cruz() {
        return santa_cruz;
    }

    public void setSanta_cruz(double santa_cruz) {
        this.santa_cruz = santa_cruz;
    }

    public double getDemais_bairros() {
        return demais_bairros;
    }

    public void setDemais_bairros(double demais_bairros) {
        this.demais_bairros = demais_bairros;
    }
    
    
    
}
