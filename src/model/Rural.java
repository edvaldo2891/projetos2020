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
public class Rural {
    private int cod; 
    private int protocolo; 
    private String dataprotocolo;
    private String solicitante;
    private String bairro;
    private String descimovel;
    private String medida; 
    private String proprietario; 
    private String insccadastral;
    private int exercicio;
    private double valorvenal;
    private String datasistema;
    private String fracao;
    private int usuario;

    public void cadastrar(Integer protocolo, 
                          String dataprotocolo,
                          String solicitante,
                          String bairro,
                          String descimovel,
                          String medida, 
                          String proprietario, 
                          String insccadastral,
                          Integer exercicio,
                          Double valorvenal,
                          String datasistema,
                          String fracao,
                          Integer usuario){
                          
                          setProtocolo(protocolo);
                          setDataprotocolo(formataData(dataprotocolo));
                          setSolicitante(solicitante.toUpperCase());
                          setBairro(bairro.toUpperCase());
                          setDescimovel(descimovel.toUpperCase());
                          setMedida(medida);
                          setProprietario(proprietario.toUpperCase());
                          setInsccadastral(insccadastral.toUpperCase());
                          setExercicio(exercicio);
                          setValorvenal(valorvenal);
                          setDatasistema(formataData(datasistema));
                          setFracao(fracao);
                          setUsuario(usuario);
        
    }
    
     public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),String.valueOf(getExercicio()),getProprietario(),getInsccadastral()};
    }  
     
      public String formataData(String data){
        String d =   data.substring(6,10) + data.substring(2,3)+data.substring(3,5)+data.substring(5,6)+data.substring(0,2);
        return d;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getFracao() {
        return fracao;
    }

    public void setFracao(String fracao) {
        this.fracao = fracao;
    }

     
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
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

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public double getValorvenal() {
        return valorvenal;
    }

    public void setValorvenal(double valorvenal) {
        this.valorvenal = valorvenal;
    }

    public String getDatasistema() {
        return datasistema;
    }

    public void setDatasistema(String datasistema) {
        this.datasistema = datasistema;
    }
    
        
}
