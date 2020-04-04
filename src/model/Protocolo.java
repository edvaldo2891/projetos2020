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
public class Protocolo {
    private int cod;
    private int protocolo;
    private String dataProtocolo;
    private String dataSistema;
    private String solicitante;
    private String servico;
    private String laudo;
    private int exercicio;
    private int usuario;
    private int fiscal;
    
    public void cadastrar( Integer protocolo,
                           String dataProtocolo,
                           String dataSistema,
                           String solicitante,
                           String servico,
                           String laudo,
                           Integer exercicio,
                           Integer usuario,
                           Integer fiscal){
                           
                           setProtocolo(protocolo);
                           setDataProtocolo(formataData(dataProtocolo));
                           setDataSistema(formataData(dataSistema));
                           setSolicitante(solicitante.toUpperCase());
                           setServico(servico.toUpperCase());
                           setLaudo(laudo.toUpperCase());
                           setExercicio(exercicio);
                           setUsuario(usuario);
                           setFiscal(fiscal);
        
        
    }
    public void alterar(   Integer cod,
                           Integer protocolo,
                           String dataProtocolo,
                           String dataSistema,
                           String solicitante,
                           String servico,
                           String laudo,
                           Integer exercicio,
                           Integer usuario,
                           Integer fiscal){
                           
                           setCod(cod);
                           setProtocolo(protocolo);
                           setDataProtocolo(formataData(dataProtocolo));
                           setDataSistema(formataData(dataSistema));
                           setSolicitante(solicitante.toUpperCase());
                           setServico(servico.toUpperCase());
                           setLaudo(laudo.toUpperCase());
                           setExercicio(exercicio);
                           setUsuario(usuario);
                           setFiscal(fiscal);
        
        
    }
public String formataData(String data){
        String d =   data.substring(6,10) + data.substring(2,3)+data.substring(3,5)+data.substring(5,6)+data.substring(0,2);
        return d;
}
public String converteData(String data){ 
       String d = data.substring(8,10) +"/"+data.substring(5,7)+"/"+ data.substring(0,4);        
        return d;
    }
    
public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),String.valueOf(getExercicio()),getSolicitante(),converteData(getDataProtocolo())};
    } 


    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }


    public int getFiscal() {
        return fiscal;
    }

    public void setFiscal(int fiscal) {
        this.fiscal = fiscal;
    }


    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
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

    public String getDataProtocolo() {
        return dataProtocolo;
    }

    public void setDataProtocolo(String dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
}
