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
public class VenalString {
    private String protocolo;
    private String data;
    private String rua;
    private String bairro;
    private String proprietario;
    private String numero;
    private String inscCadastral;
    private String construcao;
    private String terreno;
    private String exercicio;
    private String valorVenal;
    private String dataSistema;

    public void cadastrar(  String protocolo,
                            String data,
                            String rua,
                            String bairro,
                            String proprietario,
                            String numero,
                            String inscCadastral,
                            String construcao,
                            String terreno,
                            String exercicio,
                            String valorVenal,
                            String dataSistema){
                            
                            setProtocolo(protocolo);
                            setData(data);
                            setRua(rua);
                            setBairro(bairro);
                            setProprietario(proprietario);
                            setNumero(numero);
                            setInscCadastral(inscCadastral);
                            setConstrucao(construcao);
                            setTerreno(terreno);
                            setExercicio(exercicio);
                            setValorVenal(valorVenal);
                            setDataSistema(dataSistema);
        
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getInscCadastral() {
        return inscCadastral;
    }

    public void setInscCadastral(String inscCadastral) {
        this.inscCadastral = inscCadastral;
    }

    public String getConstrucao() {
        return construcao;
    }

    public void setConstrucao(String construcao) {
        this.construcao = construcao;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getValorVenal() {
        return valorVenal;
    }

    public void setValorVenal(String valorVenal) {
        this.valorVenal = valorVenal;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }
    
    
    
}
