/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Sinistro;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class SinistroBD {
    
    Conexao conexao;

    public SinistroBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Sinistro s)throws  SQLException{        
        String insert = "insert into sinistro(exercicio,ufesp) values(?,?)";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, s.getExercicio());
            stmt.setDouble(2,s.getUfesp());
                    
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Sinistro> listaExercicios() throws SQLException{
        List<Sinistro> lista = new ArrayList<>();
        String  select = "select * from sinistro s order by s.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Sinistro s = new Sinistro();
           s.setCod(Integer.parseInt(rs.getString("e.cod")));
           s.setExercicio(Integer.parseInt(rs.getString("e.exercicio")));           
           lista.add(s);
        } 
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
     public List<Sinistro> listaSinistro(Integer ex) throws SQLException{
        List<Sinistro> lista = new ArrayList<>();
        
        String  select = "select * from sinistro s  where s.exercicio = ? order by s.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, ex);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Sinistro s = new Sinistro();
           s.setCod(Integer.parseInt(rs.getString("s.cod")));
           s.setExercicio(Integer.parseInt(rs.getString("s.exercicio")));
           s.setUfesp(Double.parseDouble(rs.getString("s.ufesp")));
                        
           lista.add(s);
        }          
        stmt.close();
        conexao.desconectar();
             
        return  lista;
    }
}
