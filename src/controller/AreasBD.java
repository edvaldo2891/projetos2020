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
import model.Areas;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class AreasBD {
    
    Conexao conexao;

    public AreasBD() {
        conexao = new Conexao();
    }
    public void salvar(Areas cert)throws  SQLException{        
        String insert = "insert into areas(cod_cert,insccadastral,area,rua,terreno)"
                 +"values(?,?,?,?,?)";
        
            conexao.conectar();
            PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getCod_cert());
            stmt.setString(2,cert.getInscCadastral());
            stmt.setString(3,cert.getArea());
            stmt.setString(4,cert.getRua());
            stmt.setDouble(5,cert.getTerreno());
           
            stmt.execute();
            stmt.close();
            conexao.desconectar();
    }
    
    public List<Areas> listaAreas(Integer exe) throws SQLException{
        List<Areas> lista = new ArrayList<>();
        
        String  select = "select * from certidao2 c INNER JOIN areas a on c.cod=a.cod_cert where c.cod= ? order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Areas a = new Areas();  
 
           a.setInscCadastral(rs.getString("a.insccadastral"));
           a.setArea(rs.getString("a.area"));
           a.setRua(rs.getString("a.rua"));
           a.setTerreno(Double.parseDouble(rs.getString("a.terreno")));
           
          
           lista.add(a);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
   
}
