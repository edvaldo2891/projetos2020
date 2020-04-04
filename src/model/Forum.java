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
public class Forum {
    private int cod;
    private int protocolo;
    private String processo;
    private String assunto;
    private String data;
    private String rua;
    private String bairro;
    private String proprietario;
    private int numero;
    private String inscCadastral;
    private double construcao;
    private double terreno;
    private int exercicio;
    private double valorVenal;
    private String dataSistema;
    private int usuario;

    public void cadastrar(  Integer protocolo,
                            String processo,
                            String assunto,
                            String data,
                            String rua,
                            String bairro,
                            String proprietario,
                            Integer numero,
                            String inscCadastral,
                            Double construcao,
                            Double terreno,
                            Integer exercicio,
                            Double valorVenal,
                            String dataSistema,
                            Integer usuario){
                            
                            setProtocolo(protocolo);
                            setProcesso(processo.toUpperCase());
                            setAssunto(assunto.toUpperCase());
                            setData(formataData(data));
                            setBairro(bairro.toUpperCase());
                            setRua(rua.toUpperCase());
                            setProprietario(proprietario.toUpperCase());
                            setNumero(numero);
                            setInscCadastral(inscCadastral.toUpperCase());
                            setConstrucao(construcao);
                            setTerreno(terreno);
                            setExercicio(exercicio);
                            setValorVenal(valorVenal);
                            setDataSistema(formataData(dataSistema));
                            setUsuario(usuario);
        
    }
    
    
    public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),String.valueOf(getExercicio()),getProprietario(),getInscCadastral()};
    }  
    
    public String formataData(String data){
        String d =   data.substring(6,10) + data.substring(2,3)+data.substring(3,5)+data.substring(5,6)+data.substring(0,2);
        return d;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getInscCadastral() {
        return inscCadastral;
    }

    public void setInscCadastral(String inscCadastral) {
        this.inscCadastral = inscCadastral;
    }

    public double getConstrucao() {
        return construcao;
    }

    public void setConstrucao(double construcao) {
        this.construcao = construcao;
    }

    public double getTerreno() {
        return terreno;
    }

    public void setTerreno(double terreno) {
        this.terreno = terreno;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public double getValorVenal() {
        return valorVenal;
    }

    public void setValorVenal(double valorVenal) {
        this.valorVenal = valorVenal;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    } 
}