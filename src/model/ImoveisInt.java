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
public class ImoveisInt {
    private int cod;
    private int cod_cert;
    private String bairro;
    private String rua;
    private int numero;
    private String inscCadastral;

    public void cadastrar(  Integer cod_cert,
                            String rua,
                            Integer numero,
                            String bairro,
                            String inscCadastral
                         ){
                         setCod_cert(cod_cert);
                         setRua(rua.toUpperCase());
                         setNumero(numero);
                         setBairro(bairro.toUpperCase());
                         setInscCadastral(inscCadastral.toUpperCase());
    }
    
     public String[] addTable(){
        return new String[]{getRua(),String.valueOf(getNumero()),getBairro(),getInscCadastral()};
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod_cert() {
        return cod_cert;
    }

    public void setCod_cert(int cod_cert) {
        this.cod_cert = cod_cert;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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
    
    
}
