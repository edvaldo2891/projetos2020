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
public class Areas {
    private int cod;
    private int cod_cert;
    private String inscCadastral;
    private String area;
    private String rua;
    private double terreno;

    public void cadastrar(  Integer cod_cert,
                            String inscCadastral,
                            String rua,
                            String area,
                            Double terreno
                           ){
                           setCod_cert(cod_cert);
                           setInscCadastral(inscCadastral.toUpperCase());
                           setArea(area.toUpperCase());
                           setRua(rua.toUpperCase());
                           setTerreno(terreno);        
    }
    
    public String[] addTable(){
        return new String[]{getInscCadastral(),getRua(),getArea(),String.valueOf(getTerreno()).replace(".",",")};
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

    public String getInscCadastral() {
        return inscCadastral;
    }

    public void setInscCadastral(String inscCadastral) {
        this.inscCadastral = inscCadastral;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public double getTerreno() {
        return terreno;
    }

    public void setTerreno(double terreno) {
        this.terreno = terreno;
    }
    
    
}
