package controller;




import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    private  String URL_MYSQL= "";
    private  String DRIVER_CLASS= "";
    private  String USER="";
    private  String PASS="";
    private Connection con = null;

   public Conexao() {
       
       URL_MYSQL= "jdbc:mysql://20.20.7.82/planta_generica";
       DRIVER_CLASS= "com.mysql.jdbc.Driver";
       USER="root";
       PASS="";
       con = null;
       /*
       URL_MYSQL= "jdbc:mysql://localhost/planta_generica";
       DRIVER_CLASS= "com.mysql.jdbc.Driver";
       USER="root";
       PASS="";
       con = null*/
    }
   
   public void conectar(){
       
        try{
             
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(URL_MYSQL,USER,PASS);
            
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
   public void desconectar(){
        try{
            if(!con.isClosed()){
                con.close();
            }
        }catch(SQLException se){
              se.printStackTrace();
        }        
    }
   public Connection getCon() {
        return con;
    }
   
}
