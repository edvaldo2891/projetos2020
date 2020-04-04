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
import model.Forum;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class ForumBD {
    
     Conexao conexao;

    public ForumBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Forum cert)throws  SQLException{        
        String insert = "insert into certidao7(protocolo,processo,assunto,dataprotocolo,rua,bairro,proprietario,numero,insccadastral,"
                 + "construcao,terreno,exercicio,valorvenal,datasistema,usuario)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2, cert.getProcesso());
            stmt.setString(3, cert.getAssunto());
            stmt.setString(4,cert.getData());
            stmt.setString(5,cert.getRua());
            stmt.setString(6,cert.getBairro());
            stmt.setString(7,cert.getProprietario());
            stmt.setInt(8,cert.getNumero());            
            stmt.setString(9,cert.getInscCadastral());
            stmt.setDouble(10,cert.getConstrucao());
            stmt.setDouble(11,cert.getTerreno());
            stmt.setInt(12,cert.getExercicio());          
            stmt.setDouble(13,cert.getValorVenal());
            stmt.setString(14,cert.getDataSistema());
            stmt.setInt(15, cert.getUsuario());
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Forum> listaCertidao1(Integer exe) throws SQLException{
        List<Forum> lista = new ArrayList<>();
        
        String  select = "select * from certidao7 c where c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Forum e = new Forum();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setProcesso(rs.getString("c.processo"));
           e.setAssunto(rs.getString("c.assunto"));
           e.setData((rs.getString("c.dataprotocolo")));
           e.setRua((rs.getString("c.rua")));
           e.setBairro((rs.getString("c.bairro")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setNumero(Integer.parseInt(rs.getString("c.numero")));
           e.setInscCadastral((rs.getString("c.insccadastral")));
           e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
           e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Forum> listaCertidao2(Integer protoc,Integer exe) throws SQLException{
        List<Forum> lista = new ArrayList<>();
        
        String  select = "select * from certidao7 c where c.protocolo= ? and c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, protoc);
        stmt.setInt(2, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Forum e = new Forum();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setProcesso(rs.getString("c.processo"));
           e.setAssunto(rs.getString("c.assunto"));
           e.setData((rs.getString("c.dataprotocolo")));
           e.setRua((rs.getString("c.rua")));
           e.setBairro((rs.getString("c.bairro")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setNumero(Integer.parseInt(rs.getString("c.numero")));
           e.setInscCadastral((rs.getString("c.insccadastral")));
           e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
           e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Forum> listaCertidao3() throws SQLException{
        List<Forum> lista = new ArrayList<>();
        
        String  select = "select * from certidao7 c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Forum e = new Forum();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setProcesso(rs.getString("c.processo"));
           e.setAssunto(rs.getString("c.assunto"));
           e.setData((rs.getString("c.dataprotocolo")));
           e.setRua((rs.getString("c.rua")));
           e.setBairro((rs.getString("c.bairro")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setNumero(Integer.parseInt(rs.getString("c.numero")));
           e.setInscCadastral((rs.getString("c.insccadastral")));
           e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
           e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    
    public List<Forum> listaTabela(String procurar, int posCombo) throws SQLException{
        List<Forum> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from certidao7 c"
                        + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Forum e = new Forum();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setProcesso(rs.getString("c.processo"));
                            e.setAssunto(rs.getString("c.assunto"));
                            e.setData((rs.getString("c.dataprotocolo")));
                            e.setRua((rs.getString("c.rua")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
                            e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 2:
                        select = "select * from certidao7 c"
                        + " where c.exercicio like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Forum e = new Forum();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setProcesso(rs.getString("c.processo"));
                            e.setAssunto(rs.getString("c.assunto"));
                            e.setData((rs.getString("c.dataprotocolo")));
                            e.setRua((rs.getString("c.rua")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
                            e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 3:
                       select = "select * from certidao7 c"
                        + " where c.proprietario like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Forum e = new Forum();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setProcesso(rs.getString("c.processo"));
                            e.setAssunto(rs.getString("c.assunto"));
                            e.setData((rs.getString("c.dataprotocolo")));
                            e.setRua((rs.getString("c.rua")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
                            e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 4:
                        select = "select * from certidao7 c"
                        + " where c.insccadastral like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Forum e = new Forum();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setProcesso(rs.getString("c.processo"));
                            e.setAssunto(rs.getString("c.assunto"));
                            e.setData((rs.getString("c.dataprotocolo")));
                            e.setRua((rs.getString("c.rua")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setConstrucao(Double.parseDouble(rs.getString("c.construcao")));
                            e.setTerreno(Double.parseDouble(rs.getString("c.terreno")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorVenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
        }       
        return  listCertidao;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
}
