package model;
import java.text.NumberFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDVALDO ANTUNES
 */
public class Calculo {
    private double terreno;
    private double construcao;
    private int padrao;
    private int tipo;
    private int setor;
    
    private double ipu;
    private double itu;
    private double sinistro;
    private double colLixo;
    private double iptu;

    public void cadastrar(Double terreno,Double construcao, Integer padrao,Integer tipo, Integer setor,Double sinistro){
        setTerreno(terreno);
        setConstrucao(construcao);
        setPadrao(padrao);
        setTipo(tipo);
        setSetor(setor);
        setSinistro(sinistro);
    }
    public String[] addTable(){
        return new String[]{NumberFormat.getCurrencyInstance().format(getItu()),NumberFormat.getCurrencyInstance().format(getIpu()),NumberFormat.getCurrencyInstance().format(getColLixo()),
                NumberFormat.getCurrencyInstance().format(getSinistro()),NumberFormat.getCurrencyInstance().format(getIpu()+getItu()+getColLixo()+getSinistro())};
    }    
       
    public double getIptu() {
        return iptu;
    }

    public void setIptu(double iptu) {
        this.iptu = iptu;
    }

    public double getIpu() {
        return ipu;
    }

    public void setIpu(double ipu) {
        this.ipu = ipu;
    }

    public double getItu() {
        return itu;
    }

    public void setItu(double itu) {
        this.itu = itu;
    }

    public double getSinistro() {
        return sinistro;
    }

    public void setSinistro(double sinistro) {
        this.sinistro = sinistro;
    }

    public double getColLixo() {
        return colLixo;
    }

    public void setColLixo(double colLixo) {
        this.colLixo = colLixo;
    }
    
    public double getTerreno() {
        return terreno;
    }

    public void setTerreno(double terreno) {
        this.terreno = terreno;
    }

    public double getConstrucao() {
        return construcao;
    }

    public void setConstrucao(double construcao) {
        this.construcao = construcao;
    }

    public int getPadrao() {
        return padrao;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSetor() {
        return setor;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }
    
    
}
