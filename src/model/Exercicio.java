package model;


import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDVALDO ANTUNES
 */
public class Exercicio {
    DecimalFormat df = new DecimalFormat("0.00");
    private int Id;
    private int exercicio;
    private double a_1_0;
    private double a_1_1;
    private double a_1_2;
    private double a_1_3;
    private double a_2_0;
    private double a_2_1;
    private double a_2_2;
    private double a_2_3;
    private double a_3_0;
    private double a_3_1;
    private double a_3_2;
    private double a_3_3;
    private double a_terreno;
    
    private double b_1_0;
    private double b_1_1;
    private double b_1_2;
    private double b_1_3;
    private double b_2_0;
    private double b_2_1;
    private double b_2_2;
    private double b_2_3;
    private double b_3_0;
    private double b_3_1;
    private double b_3_2;
    private double b_3_3;
    private double b_terreno;
    
    private double c_1_0;
    private double c_1_1;
    private double c_1_2;
    private double c_1_3;
    private double c_2_0;
    private double c_2_1;
    private double c_2_2;
    private double c_2_3;
    private double c_3_0;
    private double c_3_1;
    private double c_3_2;
    private double c_3_3;
    private double c_terreno;
    
    private double d_1_0;
    private double d_1_1;
    private double d_1_2;
    private double d_1_3;
    private double d_2_0;
    private double d_2_1;
    private double d_2_2;
    private double d_2_3;
    private double d_3_0;
    private double d_3_1;
    private double d_3_2;
    private double d_3_3;
    private double d_terreno;
    
    private double e_1_0;
    private double e_1_1;
    private double e_1_2;
    private double e_1_3;
    private double e_2_0;
    private double e_2_1;
    private double e_2_2;
    private double e_2_3;
    private double e_3_0;
    private double e_3_1;
    private double e_3_2;
    private double e_3_3;
    private double e_terreno;

    public void cadastrar(Integer exercicio,Double a_1_0,Double a_1_1,Double a_1_2,Double a_1_3,Double a_2_0,Double a_2_1,Double a_2_2,Double a_2_3,
                                            Double a_3_0,Double a_3_1,Double a_3_2,Double a_3_3,Double a_terreno,
                                            Double b_1_0,Double b_1_1,Double b_1_2,Double b_1_3,Double b_2_0,Double b_2_1,Double b_2_2,Double b_2_3,
                                            Double b_3_0,Double b_3_1,Double b_3_2,Double b_3_3,Double b_terreno,                         
                                            Double c_1_0,Double c_1_1,Double c_1_2,Double c_1_3,Double c_2_0,Double c_2_1,Double c_2_2,Double c_2_3,
                                            Double c_3_0,Double c_3_1,Double c_3_2,Double c_3_3,Double c_terreno,                        
                                            Double d_1_0,Double d_1_1,Double d_1_2,Double d_1_3,Double d_2_0,Double d_2_1,Double d_2_2,Double d_2_3,
                                            Double d_3_0,Double d_3_1,Double d_3_2,Double d_3_3,Double d_terreno,                          
                                            Double e_1_0,Double e_1_1,Double e_1_2,Double e_1_3,Double e_2_0,Double e_2_1,Double e_2_2,Double e_2_3,
                                            Double e_3_0,Double e_3_1,Double e_3_2,Double e_3_3,Double e_terreno
                          ){
        setExercicio(exercicio);
        setA_1_0(a_1_0);
        setA_1_1(a_1_1);
        setA_1_2(a_1_2);
        setA_1_3(a_1_3);
        setA_2_0(a_2_0);
        setA_2_1(a_2_1);
        setA_2_2(a_2_2);
        setA_2_3(a_2_3);
        setA_3_0(a_3_0);
        setA_3_1(a_3_1);
        setA_3_2(a_3_2);
        setA_3_3(a_3_3);
        setA_terreno(a_terreno);
        setB_1_0(b_1_0);
        setB_1_1(b_1_1);
        setB_1_2(b_1_2);
        setB_1_3(b_1_3);
        setB_2_0(b_2_0);
        setB_2_1(b_2_1);
        setB_2_2(b_2_2);
        setB_2_3(b_2_3);
        setB_3_0(b_3_0);
        setB_3_1(b_3_1);
        setB_3_2(b_3_2);
        setB_3_3(b_3_3);
        setB_terreno(b_terreno);
        setC_1_0(c_1_0);
        setC_1_1(c_1_1);
        setC_1_2(c_1_2);
        setC_1_3(c_1_3);
        setC_2_0(c_2_0);
        setC_2_1(c_2_1);
        setC_2_2(c_2_2);
        setC_2_3(c_2_3);
        setC_3_0(c_3_0);
        setC_3_1(c_3_1);
        setC_3_2(c_3_2);
        setC_3_3(c_3_3);
        setC_terreno(c_terreno);
        setD_1_0(d_1_0);
        setD_1_1(d_1_1);
        setD_1_2(d_1_2);
        setD_1_3(d_1_3);
        setD_2_0(d_2_0);
        setD_2_1(d_2_1);
        setD_2_2(d_2_2);
        setD_2_3(d_2_3);
        setD_3_0(d_3_0);
        setD_3_1(d_3_1);
        setD_3_2(d_3_2);
        setD_3_3(d_3_3);
        setD_terreno(d_terreno);
        setE_1_0(e_1_0);
        setE_1_1(e_1_1);
        setE_1_2(e_1_2);
        setE_1_3(e_1_3);
        setE_2_0(e_2_0);
        setE_2_1(e_2_1);
        setE_2_2(e_2_2);
        setE_2_3(e_2_3);
        setE_3_0(e_3_0);
        setE_3_1(e_3_1);
        setE_3_2(e_3_2);
        setE_3_3(e_3_3);
        setE_terreno(e_terreno);
        
        
   
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public double getA_1_0() {
        return a_1_0;
    }

    public void setA_1_0(double a_1_0) {
        this.a_1_0 = a_1_0;
    }

    public double getA_1_1() {
        return a_1_1;
    }

    public void setA_1_1(double a_1_1) {
        this.a_1_1 = a_1_1;
    }

    public double getA_1_2() {
        return a_1_2;
    }

    public void setA_1_2(double a_1_2) {
        this.a_1_2 = a_1_2;
    }

    public double getA_1_3() {
        return a_1_3;
    }

    public void setA_1_3(double a_1_3) {
        this.a_1_3 = a_1_3;
    }

    public double getA_2_0() {
        return a_2_0;
    }

    public void setA_2_0(double a_2_0) {
        this.a_2_0 = a_2_0;
    }

    public double getA_2_1() {
        return a_2_1;
    }

    public void setA_2_1(double a_2_1) {
        this.a_2_1 = a_2_1;
    }

    public double getA_2_2() {
        return a_2_2;
    }

    public void setA_2_2(double a_2_2) {
        this.a_2_2 = a_2_2;
    }

    public double getA_2_3() {
        return a_2_3;
    }

    public void setA_2_3(double a_2_3) {
        this.a_2_3 = a_2_3;
    }

    public double getA_3_0() {
        return a_3_0;
    }

    public void setA_3_0(double a_3_0) {
        this.a_3_0 = a_3_0;
    }

    public double getA_3_1() {
        return a_3_1;
    }

    public void setA_3_1(double a_3_1) {
        this.a_3_1 = a_3_1;
    }

    public double getA_3_2() {
        return a_3_2;
    }

    public void setA_3_2(double a_3_2) {
        this.a_3_2 = a_3_2;
    }

    public double getA_3_3() {
        return a_3_3;
    }

    public void setA_3_3(double a_3_3) {
        this.a_3_3 = a_3_3;
    }

    public double getB_1_0() {
        return b_1_0;
    }

    public void setB_1_0(double b_1_0) {
        this.b_1_0 = b_1_0;
    }

    public double getB_1_1() {
        return b_1_1;
    }

    public void setB_1_1(double b_1_1) {
        this.b_1_1 = b_1_1;
    }

    public double getB_1_2() {
        return b_1_2;
    }

    public void setB_1_2(double b_1_2) {
        this.b_1_2 = b_1_2;
    }

    public double getB_1_3() {
        return b_1_3;
    }

    public void setB_1_3(double b_1_3) {
        this.b_1_3 = b_1_3;
    }

    public double getB_2_0() {
        return b_2_0;
    }

    public void setB_2_0(double b_2_0) {
        this.b_2_0 = b_2_0;
    }

    public double getB_2_1() {
        return b_2_1;
    }

    public void setB_2_1(double b_2_1) {
        this.b_2_1 = b_2_1;
    }

    public double getB_2_2() {
        return b_2_2;
    }

    public void setB_2_2(double b_2_2) {
        this.b_2_2 = b_2_2;
    }

    public double getB_2_3() {
        return b_2_3;
    }

    public void setB_2_3(double b_2_3) {
        this.b_2_3 = b_2_3;
    }

    public double getB_3_0() {
        return b_3_0;
    }

    public void setB_3_0(double b_3_0) {
        this.b_3_0 = b_3_0;
    }

    public double getB_3_1() {
        return b_3_1;
    }

    public void setB_3_1(double b_3_1) {
        this.b_3_1 = b_3_1;
    }

    public double getB_3_2() {
        return b_3_2;
    }

    public void setB_3_2(double b_3_2) {
        this.b_3_2 = b_3_2;
    }

    public double getB_3_3() {
        return b_3_3;
    }

    public void setB_3_3(double b_3_3) {
        this.b_3_3 = b_3_3;
    }

    public double getC_1_0() {
        return c_1_0;
    }

    public void setC_1_0(double c_1_0) {
        this.c_1_0 = c_1_0;
    }

    public double getC_1_1() {
        return c_1_1;
    }

    public void setC_1_1(double c_1_1) {
        this.c_1_1 = c_1_1;
    }

    public double getC_1_2() {
        return c_1_2;
    }

    public void setC_1_2(double c_1_2) {
        this.c_1_2 = c_1_2;
    }

    public double getC_1_3() {
        return c_1_3;
    }

    public void setC_1_3(double c_1_3) {
        this.c_1_3 = c_1_3;
    }

    public double getC_2_0() {
        return c_2_0;
    }

    public void setC_2_0(double c_2_0) {
        this.c_2_0 = c_2_0;
    }

    public double getC_2_1() {
        return c_2_1;
    }

    public void setC_2_1(double c_2_1) {
        this.c_2_1 = c_2_1;
    }

    public double getC_2_2() {
        return c_2_2;
    }

    public void setC_2_2(double c_2_2) {
        this.c_2_2 = c_2_2;
    }

    public double getC_2_3() {
        return c_2_3;
    }

    public void setC_2_3(double c_2_3) {
        this.c_2_3 = c_2_3;
    }

    public double getC_3_0() {
        return c_3_0;
    }

    public void setC_3_0(double c_3_0) {
        this.c_3_0 = c_3_0;
    }

    public double getC_3_1() {
        return c_3_1;
    }

    public void setC_3_1(double c_3_1) {
        this.c_3_1 = c_3_1;
    }

    public double getC_3_2() {
        return c_3_2;
    }

    public void setC_3_2(double c_3_2) {
        this.c_3_2 = c_3_2;
    }

    public double getC_3_3() {
        return c_3_3;
    }

    public void setC_3_3(double c_3_3) {
        this.c_3_3 = c_3_3;
    }

    public double getD_1_0() {
        return d_1_0;
    }

    public void setD_1_0(double d_1_0) {
        this.d_1_0 = d_1_0;
    }

    public double getD_1_1() {
        return d_1_1;
    }

    public void setD_1_1(double d_1_1) {
        this.d_1_1 = d_1_1;
    }

    public double getD_1_2() {
        return d_1_2;
    }

    public void setD_1_2(double d_1_2) {
        this.d_1_2 = d_1_2;
    }

    public double getD_1_3() {
        return d_1_3;
    }

    public void setD_1_3(double d_1_3) {
        this.d_1_3 = d_1_3;
    }

    public double getD_2_0() {
        return d_2_0;
    }

    public void setD_2_0(double d_2_0) {
        this.d_2_0 = d_2_0;
    }

    public double getD_2_1() {
        return d_2_1;
    }

    public void setD_2_1(double d_2_1) {
        this.d_2_1 = d_2_1;
    }

    public double getD_2_2() {
        return d_2_2;
    }

    public void setD_2_2(double d_2_2) {
        this.d_2_2 = d_2_2;
    }

    public double getD_2_3() {
        return d_2_3;
    }

    public void setD_2_3(double d_2_3) {
        this.d_2_3 = d_2_3;
    }

    public double getD_3_0() {
        return d_3_0;
    }

    public void setD_3_0(double d_3_0) {
        this.d_3_0 = d_3_0;
    }

    public double getD_3_1() {
        return d_3_1;
    }

    public void setD_3_1(double d_3_1) {
        this.d_3_1 = d_3_1;
    }

    public double getD_3_2() {
        return d_3_2;
    }

    public void setD_3_2(double d_3_2) {
        this.d_3_2 = d_3_2;
    }

    public double getD_3_3() {
        return d_3_3;
    }

    public void setD_3_3(double d_3_3) {
        this.d_3_3 = d_3_3;
    }

    public double getE_1_0() {
        return e_1_0;
    }

    public void setE_1_0(double e_1_0) {
        this.e_1_0 = e_1_0;
    }

    public double getE_1_1() {
        return e_1_1;
    }

    public void setE_1_1(double e_1_1) {
        this.e_1_1 = e_1_1;
    }

    public double getE_1_2() {
        return e_1_2;
    }

    public void setE_1_2(double e_1_2) {
        this.e_1_2 = e_1_2;
    }

    public double getE_1_3() {
        return e_1_3;
    }

    public void setE_1_3(double e_1_3) {
        this.e_1_3 = e_1_3;
    }

    public double getE_2_0() {
        return e_2_0;
    }

    public void setE_2_0(double e_2_0) {
        this.e_2_0 = e_2_0;
    }

    public double getE_2_1() {
        return e_2_1;
    }

    public void setE_2_1(double e_2_1) {
        this.e_2_1 = e_2_1;
    }

    public double getE_2_2() {
        return e_2_2;
    }

    public void setE_2_2(double e_2_2) {
        this.e_2_2 = e_2_2;
    }

    public double getE_2_3() {
        return e_2_3;
    }

    public void setE_2_3(double e_2_3) {
        this.e_2_3 = e_2_3;
    }

    public double getE_3_0() {
        return e_3_0;
    }

    public void setE_3_0(double e_3_0) {
        this.e_3_0 = e_3_0;
    }

    public double getE_3_1() {
        return e_3_1;
    }

    public void setE_3_1(double e_3_1) {
        this.e_3_1 = e_3_1;
    }

    public double getE_3_2() {
        return e_3_2;
    }

    public void setE_3_2(double e_3_2) {
        this.e_3_2 = e_3_2;
    }

    public double getE_3_3() {
        return e_3_3;
    }

    public void setE_3_3(double e_3_3) {
        this.e_3_3 = e_3_3;
    }

    public double getA_terreno() {
        return a_terreno;
    }

    public void setA_terreno(double a_terreno) {
        this.a_terreno = a_terreno;
    }

    public double getB_terreno() {
        return b_terreno;
    }

    public void setB_terreno(double b_terreno) {
        this.b_terreno = b_terreno;
    }

    public double getC_terreno() {
        return c_terreno;
    }

    public void setC_terreno(double c_terreno) {
        this.c_terreno = c_terreno;
    }

    public double getD_terreno() {
        return d_terreno;
    }

    public void setD_terreno(double d_terreno) {
        this.d_terreno = d_terreno;
    }

    public double getE_terreno() {
        return e_terreno;
    }

    public void setE_terreno(double e_terreno) {
        this.e_terreno = e_terreno;
    }
    
    
    
}
