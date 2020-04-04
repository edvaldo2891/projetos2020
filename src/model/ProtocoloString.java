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
public class ProtocoloString {
    private String cod;
    private String protocolo;
    private String dataProtocolo;
    private String dataSistema;
    private String solicitante;
    private String servico;
    private String exercicio;
    private String usuario;

    public void cadastrar( String protocolo,
                           String dataProtocolo,
                           String dataSistema,
                           String solicitante,
                           String servico,
                           String exercicio,
                           String usuario){
                           
                           setProtocolo(protocolo);
                           setDataProtocolo(dataProtocolo);
                           setDataSistema(dataSistema);
                           setSolicitante(solicitante);
                           setServico(servico);
                           setExercicio(exercicio);
                           setUsuario(usuario);    
    }
    
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
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

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
