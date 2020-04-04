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
public class Interdicao {
    private int cod;
    private int protocolo;
    private String dataProtocolo;
    private String processo;
    private String assunto;
    private String proprietario;
    private String dataSistema;
    private int exercicio;
    private int usuario;

    public void cadastrar(  Integer protocolo,
                            String dataProtocolo,
                            String processo,
                            String assunto,
                            String proprietario,
                            String dataSistema,
                            Integer exercicio,
                            Integer usuario){
                            
                            setProtocolo(protocolo);
                            setDataProtocolo(formataData(dataProtocolo));
                            setAssunto(assunto.toUpperCase());
                            setProcesso(processo.toUpperCase());
                            setProprietario(proprietario.toUpperCase());
                            setDataSistema(formataData(dataSistema));
                            setExercicio(exercicio);
                            setUsuario(usuario);
    }
    
     public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),String.valueOf(getExercicio()),getProprietario(),converteData(getDataProtocolo())};
    }  
    
    public String formataData(String data){
        String d =   data.substring(6,10) + data.substring(2,3)+data.substring(3,5)+data.substring(5,6)+data.substring(0,2);
        return d;
    }
     public String converteData(String data){
        String d = data.substring(8,10) +"/"+data.substring(5,7)+"/"+ data.substring(0,4);        
        return d;
    } 

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

   
    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }
    
    
}
