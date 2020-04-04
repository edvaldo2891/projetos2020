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
public class Confrontante {
    private int cod;
    private int protocolo;
    private String dataProtocolo;
    private String bairro;
    private String rua;
    private String inscCadastral;
    private String proprietario;
    private String proprietario1;
    private String proprietario2;
    private String proprietario3;
    private double fundos;
    private double direito;
    private double esquerdo;
    private String dataSistema;
    private int numero;
    private int exercicio;
    private int usuario;
    
    public void cadastrar(  Integer protocolo,
                            String dataProtocolo,
                            String bairro,
                            String rua,
                            String inscCadastral,
                            String proprietario,
                            String proprietario1,
                            String proprietario2,
                            String proprietario3,
                            Double fundos,
                            Double direito,
                            Double esquerdo,
                            String dataSistema,
                            Integer numero,
                            Integer exercicio,
                            Integer usuario
                           ){
                           setProtocolo(protocolo);
                           setDataProtocolo(formataData(dataProtocolo));
                           setBairro(bairro.toUpperCase());
                           setRua(rua.toUpperCase());
                           setInscCadastral(inscCadastral.toUpperCase());
                           setProprietario(proprietario.toUpperCase());
                           setProprietario1(proprietario1.toUpperCase());
                           setProprietario2(proprietario2.toUpperCase());
                           setProprietario3(proprietario3.toUpperCase());
                           setFundos(fundos);
                           setDireito(direito);
                           setEsquerdo(esquerdo);
                           setDataSistema(formataData(dataSistema));
                           setNumero(numero);
                           setExercicio(exercicio);
                           setUsuario(usuario);
        
    }
    public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),String.valueOf(getExercicio()),getProprietario(),getInscCadastral()};
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public double getFundos() {
        return fundos;
    }

    public void setFundos(double fundos) {
        this.fundos = fundos;
    }

    public double getDireito() {
        return direito;
    }

    public void setDireito(double direito) {
        this.direito = direito;
    }

    public double getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(double esquerdo) {
        this.esquerdo = esquerdo;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }
 
    
}
