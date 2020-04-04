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
public class InterdicaoString {
    private int cod;
    private int usuario;
    private String protocolo;
    private String dataProtocolo;
    private String processo;
    private String assunto;
    private String proprietario;
    private String dataSistema;
    private String exercicio;
    private String tabela;

    public void cadastrar(  Integer usuario,
                            String protocolo,
                            String dataProtocolo,
                            String processo,
                            String assunto,
                            String proprietario,
                            String dataSistema,
                            String exercicio,
                            String tabela){
                            
                            setUsuario(usuario);
                            setProtocolo(protocolo);
                            setDataProtocolo(dataProtocolo);
                            setProcesso(processo);
                            setAssunto(assunto);
                            setProprietario(proprietario.toString());
                            setDataSistema(dataSistema);
                            setExercicio(exercicio);
                            setTabela(tabela);
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
 
    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
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

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }
   
    
}
