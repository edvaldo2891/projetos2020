/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class RuralString {
    private String protocolo; 
    private String dataprotocolo;
    private String solicitante;
    private String bairro;
    private String descimovel;
    private String medida; 
    private String proprietario; 
    private String insccadastral;
    private String exercicio;
    private String valorvenal;
    private String datasistema;
    private String fracao;

    public void cadastrar(String protocolo, 
                          String dataprotocolo,
                          String solicitante,
                          String bairro,
                          String descimovel,
                          String medida, 
                          String proprietario, 
                          String insccadastral,
                          String exercicio,
                          String valorvenal,
                          String datasistema,
                          String fracao){
                          
                          setProtocolo(protocolo);
                          setDataprotocolo(dataprotocolo);
                          setSolicitante(solicitante);
                          setBairro(bairro);
                          setDescimovel(descimovel);
                          setMedida(medida);
                          setProprietario(proprietario);
                          setInsccadastral(insccadastral);
                          setExercicio(exercicio);
                          setValorvenal(valorvenal);
                          setDatasistema(datasistema);
                          setFracao(fracao);
        
    }

    public String getFracao() {
        return fracao;
    }

    public void setFracao(String fracao) {
        this.fracao = fracao;
    }
    
    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getDataprotocolo() {
        return dataprotocolo;
    }

    public void setDataprotocolo(String dataprotocolo) {
        this.dataprotocolo = dataprotocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDescimovel() {
        return descimovel;
    }

    public void setDescimovel(String descimovel) {
        this.descimovel = descimovel;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getInsccadastral() {
        return insccadastral;
    }

    public void setInsccadastral(String insccadastral) {
        this.insccadastral = insccadastral;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getValorvenal() {
        return valorvenal;
    }

    public void setValorvenal(String valorvenal) {
        this.valorvenal = valorvenal;
    }

    public String getDatasistema() {
        return datasistema;
    }

    public void setDatasistema(String datasistema) {
        this.datasistema = datasistema;
    }
    
    
}
