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
import model.Cadastro;
import model.CadastroString;


/**
 *
 * @author EDVALDO ANTUNES
 */
public class CadastroBD {
    
    Conexao conexao;

    public CadastroBD() {
        conexao = new Conexao();
    }
    public void salvar(Cadastro cert)throws  SQLException{        
        String insert = "insert into certidao2(protocolo,dataprotocolo,proprietario,exercicio,datasistema,usuario)"
                 +"values(?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2,cert.getDataProtocolo());
            stmt.setString(3,cert.getProprietario());
            stmt.setInt(4,cert.getExercicio());
            stmt.setString(5,cert.getDataSistema());
            stmt.setInt(6,cert.getUsuario());
           
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Cadastro> listaCertidao() throws SQLException{
        List<Cadastro> lista = new ArrayList<>();
        String  select = "select * from certidao2 c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Cadastro c = new Cadastro();
           c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
           c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
           lista.add(c);
        } 
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
     public List<CadastroString> listaCertidaoString() throws SQLException{
        List<CadastroString> lista = new ArrayList<>();
        String  select = "select * from certidao2 c INNER JOIN areas a on c.cod=a.cod_cert order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           CadastroString c = new CadastroString();
           c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
           c.setProtocolo((rs.getString("c.protocolo")));  
           c.setDataProtocolo((rs.getString("c.dataprotocolo")));
           c.setProprietario((rs.getString("c.proprietario")));
           c.setExercicio((rs.getString("c.exercicio")));
           c.setDataSistema((rs.getString("c.datasistema")));
           
           lista.add(c);
        } 
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
public List<CadastroString> listaCertidaoString2(String procurar, int posCombo) throws SQLException{
        List<CadastroString> lista = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        
        switch (posCombo){
                case 1:
                    select = "select * from certidao2 c"
                     + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    CadastroString c = new CadastroString();
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setExercicio((rs.getString("c.exercicio")));
                                    c.setDataSistema((rs.getString("c.datasistema")));

                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
                 case 2:
                    select = "select * from certidao2 c "
                     + " where c.exercicio like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    CadastroString c = new CadastroString();
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setExercicio((rs.getString("c.exercicio")));
                                    c.setDataSistema((rs.getString("c.datasistema")));

                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
                 case 3:
                    select = "select * from certidao2 c "
                     + " where c.proprietario like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    CadastroString c = new CadastroString();
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setExercicio((rs.getString("c.exercicio")));
                                    c.setDataSistema((rs.getString("c.datasistema")));

                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
                 case 4:
                    select = "select * from certidao2 c "
                     + " where c.datasistema like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    CadastroString c = new CadastroString();
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setExercicio((rs.getString("c.exercicio")));
                                    c.setDataSistema((rs.getString("c.datasistema")));

                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
        }
        return  lista;
    }
}
