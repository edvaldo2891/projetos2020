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
public class Cadastro {
   private int cod;
   private int protocolo;
   private String dataProtocolo;
   private String proprietario;
   private int exercicio;
   private String dataSistema;
   private int usuario;
    public void cadastrar(Integer protocolo,
                          String dataProtocolo,
                          String proprietario,
                          Integer exercicio,
                          String dataSistema,
                          Integer usuario
                         ){
                        setProtocolo(protocolo);
                        setDataProtocolo(formataData(dataProtocolo));
                        setProprietario(proprietario.toUpperCase());
                        setExercicio(exercicio);
                        setDataSistema(formataData(dataSistema));
                        setUsuario(usuario);
    }
    
    public String formataData(String data){
        String d =   data.substring(6,10) + data.substring(2,3)+data.substring(3,5)+data.substring(5,6)+data.substring(0,2);
        return d;
    }
    
     public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),getDataProtocolo(),getProprietario(),String.valueOf(getExercicio()),getDataSistema()};
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

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }

     
     
}
