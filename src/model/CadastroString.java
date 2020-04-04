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
public class CadastroString {
    
   private String protocolo;
   private String dataProtocolo;
   private String proprietario;
   private String exercicio;
   private String dataSistema;
   private String tabela;
   private int usuario;
   private int cod;

   public void cadastrar( Integer usuario,
                          String protocolo,
                          String dataProtocolo,
                          String proprietario,
                          String exercicio,
                          String dataSistema,
                          String tabela){
                          
                          setUsuario(usuario);
                          setProtocolo(protocolo);
                          setDataProtocolo(dataProtocolo);
                          setProprietario(proprietario);
                          setExercicio(exercicio);
                          setDataSistema(dataSistema);
                          setTabela(tabela);
                         
       
   }
   public String[] addTable(){
        return new String[]{String.valueOf(getProtocolo()),
                                        String.valueOf(getExercicio()),
                                        getProprietario(),
                                        converteData(getDataSistema())};
    } 
   
    public String converteData(String data){
        String d = data.substring(8,10) +"/"+data.substring(5,7)+"/"+ data.substring(0,4);        
        return d;
    } 

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getDataSistema() {
        return dataSistema;
    }

    public void setDataSistema(String dataSistema) {
        this.dataSistema = dataSistema;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

   
    
   
}
