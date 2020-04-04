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
import javax.swing.JOptionPane;
import model.ColetaLixo;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class ColetaLixoBD {
    
    Conexao conexao;

    public ColetaLixoBD() {
        conexao = new Conexao();
    }
    
     public void salvar(ColetaLixo cl)throws  SQLException{        
        String insert = "insert into coletalixo(exercicio,a_residencial,a_comercial,"
                 + "                                      b_residencial,b_comercial,"
                 + "                                      c_residencial,c_comercial,"
                 + "                                      d_residencial,d_comercial,"
                 + "                                      e_residencial,e_comercial)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?)";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cl.getExercicio());
            stmt.setDouble(2,cl.getA_residencial());
            stmt.setDouble(3,cl.getA_comercial());
            stmt.setDouble(4,cl.getB_residencial());
            stmt.setDouble(5,cl.getB_comercial());
            stmt.setDouble(6,cl.getC_residencial());
            stmt.setDouble(7,cl.getC_comercial());
            stmt.setDouble(8,cl.getD_residencial());
            stmt.setDouble(9,cl.getD_comercial());
            stmt.setDouble(10,cl.getE_residencial());
            stmt.setDouble(11,cl.getE_comercial());
                    
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
     
    public List<ColetaLixo> listaExercicios() throws SQLException{
        List<ColetaLixo> lista = new ArrayList<>();
        String  select = "select * from coletalixo c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           ColetaLixo c = new ColetaLixo();
           c.setId(Integer.parseInt(rs.getString("e.cod")));
           c.setExercicio(Integer.parseInt(rs.getString("e.exercicio")));           
           lista.add(c);
        } 
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
     public List<ColetaLixo> listaColetaLixo(Integer ex) throws SQLException{
        List<ColetaLixo> lista = new ArrayList<>();
        List<ColetaLixo> listaVazia = new ArrayList<>();
        
        String  select = "select * from coletalixo c  where c.exercicio = ? order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, ex);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           ColetaLixo cl = new ColetaLixo();
           cl.setId(Integer.parseInt(rs.getString("c.cod")));
           cl.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           cl.setA_residencial(Double.parseDouble(rs.getString("c.a_residencial")));
           cl.setA_comercial(Double.parseDouble(rs.getString("c.a_comercial")));
           cl.setB_residencial(Double.parseDouble(rs.getString("c.b_residencial")));
           cl.setB_comercial(Double.parseDouble(rs.getString("c.b_comercial")));
           cl.setC_residencial(Double.parseDouble(rs.getString("c.c_residencial")));
           cl.setC_comercial(Double.parseDouble(rs.getString("c.c_comercial")));
           cl.setD_residencial(Double.parseDouble(rs.getString("c.d_residencial")));
           cl.setD_comercial(Double.parseDouble(rs.getString("c.d_comercial")));
           cl.setE_residencial(Double.parseDouble(rs.getString("c.e_residencial")));
           cl.setE_comercial(Double.parseDouble(rs.getString("c.e_comercial")));                    
           lista.add(cl);
        }          
        stmt.close();
        conexao.desconectar();
        
        if(lista.size()==0){
           ColetaLixo cl = new ColetaLixo();
           cl.setId(0);
           cl.setExercicio(0);
           cl.setA_residencial(0.00);
           cl.setA_comercial(0.00);
           cl.setB_residencial(0.00);
           cl.setB_comercial(0.00);
           cl.setC_residencial(0.00);
           cl.setC_comercial(0.00);
           cl.setD_residencial(0.00);
           cl.setD_comercial(0.00);
           cl.setE_residencial(0.00);
           cl.setE_comercial(0.00);                    
           lista.add(cl);
        }
        
        return  lista;
    }
    
}
