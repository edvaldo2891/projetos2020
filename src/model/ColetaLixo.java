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
public class ColetaLixo {
    private int id;
    private int exercicio;
    private double a_residencial;
    private double a_comercial;
    private double b_residencial;
    private double b_comercial;
    private double c_residencial;
    private double c_comercial;
    private double d_residencial;
    private double d_comercial;
    private double e_residencial;
    private double e_comercial;
    
    public void cadastrar(Integer exercicio,
                          Double a_residencial,Double a_comercial,
                          Double b_residencial,Double b_comercial,
                          Double c_residencial,Double c_comercial,
                          Double d_residencial,Double d_comercial,
                          Double e_residencial,Double e_comercial)
                          {
                              setExercicio(exercicio);
                              setA_comercial(a_comercial);
                              setA_residencial(a_residencial);
                              setB_comercial(b_comercial);
                              setB_residencial(b_residencial);
                              setC_comercial(c_comercial);
                              setC_residencial(c_residencial);
                              setD_comercial(d_comercial);
                              setD_residencial(d_residencial);
                              setE_comercial(e_comercial);
                              setE_residencial(e_residencial);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public double getA_residencial() {
        return a_residencial;
    }

    public void setA_residencial(double a_residencial) {
        this.a_residencial = a_residencial;
    }

    public double getA_comercial() {
        return a_comercial;
    }

    public void setA_comercial(double a_comercial) {
        this.a_comercial = a_comercial;
    }

    public double getB_residencial() {
        return b_residencial;
    }

    public void setB_residencial(double b_residencial) {
        this.b_residencial = b_residencial;
    }

    public double getB_comercial() {
        return b_comercial;
    }

    public void setB_comercial(double b_comercial) {
        this.b_comercial = b_comercial;
    }

    public double getC_residencial() {
        return c_residencial;
    }

    public void setC_residencial(double c_residencial) {
        this.c_residencial = c_residencial;
    }

    public double getC_comercial() {
        return c_comercial;
    }

    public void setC_comercial(double c_comercial) {
        this.c_comercial = c_comercial;
    }

    public double getD_residencial() {
        return d_residencial;
    }

    public void setD_residencial(double d_residencial) {
        this.d_residencial = d_residencial;
    }

    public double getD_comercial() {
        return d_comercial;
    }

    public void setD_comercial(double d_comercial) {
        this.d_comercial = d_comercial;
    }

    public double getE_residencial() {
        return e_residencial;
    }

    public void setE_residencial(double e_residencial) {
        this.e_residencial = e_residencial;
    }

    public double getE_comercial() {
        return e_comercial;
    }

    public void setE_comercial(double e_comercial) {
        this.e_comercial = e_comercial;
    }
    
    
    
    
    
}
