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
import model.ImoveisInt;


/**
 *
 * @author EDVALDO ANTUNES
 */
public class ImoveisIntBD {
    
    Conexao conexao;

    public ImoveisIntBD() {
        conexao = new Conexao();
    }
    public void salvar(ImoveisInt cert)throws  SQLException{        
        String insert = "insert into imoveisint(cod_cert,rua,numero,bairro,insccadastral)"
                 +"values(?,?,?,?,?)";
        
            conexao.conectar();
            PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getCod_cert());
            stmt.setString(2,cert.getRua());
            stmt.setDouble(3,cert.getNumero());
            stmt.setString(4,cert.getBairro());
            stmt.setString(5,cert.getInscCadastral());
           
            stmt.execute();
            stmt.close();
            conexao.desconectar();
    }
    
    public List<ImoveisInt> listaImoveis(Integer exe) throws SQLException{
        List<ImoveisInt> lista = new ArrayList<>();
        
        String  select = "select * from certidao6 c INNER JOIN imoveisint a on c.cod=a.cod_cert where c.cod= ? order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           ImoveisInt a = new ImoveisInt();  
 
           a.setInscCadastral(rs.getString("a.insccadastral"));
           a.setBairro(rs.getString("a.bairro"));
           a.setRua(rs.getString("a.rua"));
           a.setNumero(Integer.parseInt(rs.getString("a.numero")));
           
          
           lista.add(a);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
   
}
