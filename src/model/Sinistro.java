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
public class Sinistro {
    
    private int cod;
    private int exercicio;
    private double ufesp;

    public void cadastrar(Integer exercicio, Double ufesp){
        setExercicio(exercicio);
        setUfesp(ufesp);
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getExercicio() {
        return exercicio;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }

    public double getUfesp() {
        return ufesp;
    }

    public void setUfesp(double ufesp) {
        this.ufesp = ufesp;
    }
    
    
    
}
