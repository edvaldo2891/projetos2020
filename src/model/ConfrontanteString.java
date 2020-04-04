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
public class ConfrontanteString {
    private String protocolo;
    private String dataProtocolo;
    private String bairro;
    private String rua;
    private String inscCadastral;
    private String proprietario;
    private String proprietario1;
    private String proprietario2;
    private String proprietario3;
    private String fundos;
    private String direito;
    private String esquerdo;
    private String dataSistema;
    private String numero;
    private String exercicio;
    
    public void cadastrar(  String protocolo,
                            String dataProtocolo,
                            String bairro,
                            String rua,
                            String inscCadastral,
                            String proprietario,
                            String proprietario1,
                            String proprietario2,
                            String proprietario3,
                            String fundos,
                            String direito,
                            String esquerdo,
                            String dataSistema,
                            String numero,
                            String exercicio
                           ){
                           setProtocolo(protocolo);
                           setDataProtocolo(dataProtocolo);
                           setBairro(bairro);
                           setRua(rua);
                           setInscCadastral(inscCadastral);
                           setProprietario(proprietario);
                           setProprietario1(proprietario1);
                           setProprietario2(proprietario2);
                           setProprietario3(proprietario3);
                           setFundos(fundos);
                           setDireito(direito);
                           setEsquerdo(esquerdo);
                           setDataSistema(dataSistema);
                           setNumero(numero);
                           setExercicio(exercicio);
        
    } 

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getInscCadastral() {
        return inscCadastral;
    }

    public void setInscCadastral(String inscCadastral) {
        this.inscCadastral = inscCadastral;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getProprietario1() {
        return proprietario1;
    }

    public void setProprietario1(String proprietario1) {
        this.proprietario1 = proprietario1;
    }

    public String getProprietario2() {
        return proprietario2;
    }

    public void setProprietario2(String proprietario2) {
        this.proprietario2 = proprietario2;
    }

    public String getProprietario3() {
        return proprietario3;
    }

    public void setProprietario3(String proprietario3) {
        this.proprietario3 = proprietario3;
    }

    public String getFundos() {
        return fundos;
    }

    public void setFundos(String fundos) {
        this.fundos = fundos;
    }

    public String getDireito() {
        return direito;
    }

    public void setDireito(String direito) {
        this.direito = direito;
    }

    public String getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(String esquerdo) {
        this.esquerdo = esquerdo;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }
    
}
