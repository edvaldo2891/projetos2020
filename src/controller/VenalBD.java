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
import model.Venal;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class VenalBD {
    
     Conexao conexao;

    public VenalBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Venal cert)throws  SQLException{        
        String insert = "insert into certidao(protocolo,dataprotocolo,rua,bairro,proprietario,numero,insccadastral,"
                 + "construcao,terreno,exercicio,valorvenal,datasistema,usuario)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2,cert.getData());
            stmt.setString(3,cert.getRua());
            stmt.setString(4,cert.getBairro());
            stmt.setString(5,cert.getProprietario());
            stmt.setInt(6,cert.getNumero());            
            stmt.setString(7,cert.getInscCadastral());
            stmt.setDouble(8,cert.getConstrucao());
            stmt.setDouble(9,cert.getTerreno());
            stmt.setInt(10,cert.getExercicio());          
            stmt.setDouble(11,cert.getValorVenal());
            stmt.setString(12,cert.getDataSistema());
            stmt.setInt(13, cert.getUsuario());
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Venal> listaCertidao1(Integer exe) throws SQLException{
        List<Venal> lista = new ArrayList<>();
        
        String  select = "select * from certidao c where c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Venal e = new Venal();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    
    public List<Venal> listaCertidao2(Integer protoc,Integer exe) throws SQLException{
        List<Venal> lista = new ArrayList<>();
        
        String  select = "select * from certidao c where c.protocolo= ? and c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, protoc);
        stmt.setInt(2, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Venal e = new Venal();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    
    public List<Venal> listaCertidao3() throws SQLException{
        List<Venal> lista = new ArrayList<>();
        
        String  select = "select * from certidao c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Venal e = new Venal();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    
    
    public List<Venal> listaTabela(String procurar, int posCombo) throws SQLException{
        List<Venal> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from certidao c"
                        + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
                        select = "select * from certidao c"
                        + " where c.exercicio like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
                       select = "select * from certidao c"
                        + " where c.proprietario like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
                        select = "select * from certidao c"
                        + " where c.insccadastral like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    //CERTIDÃO ESPELHO
    public void salvarEspelho(Venal cert)throws  SQLException{        
        String insert = "insert into certidao3(protocolo,dataprotocolo,rua,bairro,proprietario,numero,insccadastral,"
                 + "construcao,terreno,exercicio,valorvenal,datasistema,usuario)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2,cert.getData());
            stmt.setString(3,cert.getRua());
            stmt.setString(4,cert.getBairro());
            stmt.setString(5,cert.getProprietario());
            stmt.setInt(6,cert.getNumero());            
            stmt.setString(7,cert.getInscCadastral());
            stmt.setDouble(8,cert.getConstrucao());
            stmt.setDouble(9,cert.getTerreno());
            stmt.setInt(10,cert.getExercicio());          
            stmt.setDouble(11,cert.getValorVenal());
            stmt.setString(12,cert.getDataSistema());
            stmt.setInt(13, cert.getUsuario());
            
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Venal> listaCertidaoEsp1(Integer exe) throws SQLException{
        List<Venal> lista = new ArrayList<>();
        
        String  select = "select * from certidao3 c where c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Venal e = new Venal();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    
    public List<Venal> listaCertidaoEsp2(Integer protoc,Integer exe) throws SQLException{
        List<Venal> lista = new ArrayList<>();
        
        String  select = "select * from certidao3 c where c.protocolo= ? and c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, protoc);
        stmt.setInt(2, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Venal e = new Venal();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    
    public List<Venal> listaCertidaoEsp3() throws SQLException{
        List<Venal> lista = new ArrayList<>();
        
        String  select = "select * from certidao3 c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Venal e = new Venal();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
    
    
    public List<Venal> listaTabelaEsp(String procurar, int posCombo) throws SQLException{
        List<Venal> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from certidao3 c"
                        + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
                        select = "select * from certidao3 c"
                        + " where c.exercicio like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
                       select = "select * from certidao3 c"
                        + " where c.proprietario like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
                        select = "select * from certidao3 c"
                        + " where c.insccadastral like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Venal e = new Venal();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
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
}
