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
import model.Protocolo;


/**
 *
 * @author EDVALDO ANTUNES
 */
public class ProtocoloBD {
    
     Conexao conexao;

    public ProtocoloBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Protocolo pr)throws  SQLException{        
        String insert = "insert into protocolo(protocolo,dataprotocolo,datasistema,solicitante, servico,laudo,exercicio,usuario,fiscal)"
                 +"values(?,?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, pr.getProtocolo());
            stmt.setString(2,pr.getDataProtocolo());
            stmt.setString(3,pr.getDataSistema());
            stmt.setString(4,pr.getSolicitante());
            stmt.setString(5,pr.getServico());
            stmt.setString(6,pr.getLaudo());
            stmt.setInt(7,pr.getExercicio());          
            stmt.setInt(8, pr.getUsuario());
            stmt.setInt(9, pr.getFiscal());
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public void alterar(Protocolo pr)throws SQLException{
        //String update = "update paciente set nome = ?,telefone = ?, cpf = ?, funcao_id = ?  where id = ?" ;
        String update = "update protocolo set protocolo = ?, dataProtocolo = ?, dataSistema = ?, solicitante = ?,"
                      + "servico = ?,laudo = ?, exercicio = ?, usuario = ?, fiscal = ? where cod = ?";

        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
        
            stmt.setInt(1, pr.getProtocolo());
            stmt.setString(2,pr.getDataProtocolo());
            stmt.setString(3,pr.getDataSistema());
            stmt.setString(4,pr.getSolicitante());
            stmt.setString(5,pr.getServico());
            stmt.setString(6,pr.getLaudo());
            stmt.setInt(7,pr.getExercicio());          
            stmt.setInt(8,pr.getUsuario());
            stmt.setInt(9,pr.getFiscal());
            stmt.setInt(10,pr.getCod());
            
          stmt.execute();
          stmt.close();
          conexao.desconectar();
   }
    
    
    public List<Protocolo> listaProtocolo(Integer exe) throws SQLException{
        List<Protocolo> lista = new ArrayList<>();
        
        String  select = "select * from protocolo p where c.exercicio = ?  order by p.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Protocolo e = new Protocolo();  
           e.setCod(Integer.parseInt(rs.getString("p.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
           e.setDataProtocolo((rs.getString("p.dataprotocolo")));
           e.setDataSistema((rs.getString("p.datasistema")));
           e.setSolicitante((rs.getString("p.solicitante")));
           e.setServico((rs.getString("p.servico")));
           e.setLaudo((rs.getString("p.laudo")));
           e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
           e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Protocolo> listaCertidao2(Integer protoc,Integer exe) throws SQLException{
        List<Protocolo> lista = new ArrayList<>();
        
        String  select = "select * from protocolo p where p.protocolo= ? and p.exercicio = ?  order by p.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, protoc);
        stmt.setInt(2, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Protocolo e = new Protocolo();  
           e.setCod(Integer.parseInt(rs.getString("p.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
           e.setDataProtocolo((rs.getString("p.dataprotocolo")));
           e.setDataSistema((rs.getString("p.datasistema")));
           e.setSolicitante((rs.getString("p.solicitante")));
           e.setServico((rs.getString("p.servico")));
           e.setLaudo((rs.getString("p.laudo")));
           e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
           e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Protocolo> listaCertidao3(Integer exercicio) throws SQLException{
        List<Protocolo> lista = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        
        select = "select * from protocolo p where p.exercicio like ? order by p.cod desc";
        conexao.conectar();
        stmt = conexao.getCon().prepareStatement(select);
        stmt.setString(1, "%"+exercicio+"%");                       

        rs = stmt.executeQuery();
        
        while(rs.next()){
           Protocolo e = new Protocolo();  
           e.setCod(Integer.parseInt(rs.getString("p.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
           e.setDataProtocolo((rs.getString("p.dataprotocolo")));
           e.setDataSistema((rs.getString("p.datasistema")));
           e.setSolicitante((rs.getString("p.solicitante")));
           e.setServico((rs.getString("p.servico")));
           e.setLaudo((rs.getString("p.laudo")));
           e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
           e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    
    public List<Protocolo> listaTabela(String procurar, int posCombo) throws SQLException{
        List<Protocolo> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from protocolo p"
                        + " where p.protocolo like ? order by p.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Protocolo e = new Protocolo();  
                            e.setCod(Integer.parseInt(rs.getString("p.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
                            e.setDataProtocolo((rs.getString("p.dataprotocolo")));
                            e.setDataSistema((rs.getString("p.datasistema")));
                            e.setSolicitante((rs.getString("p.solicitante")));
                            e.setServico((rs.getString("p.servico")));
                            e.setLaudo((rs.getString("p.laudo")));
                            e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
                            e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 2:
                        select = "select * from protocolo p"
                        + " where p.exercicio like ?  order by p.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Protocolo e = new Protocolo();  
                            e.setCod(Integer.parseInt(rs.getString("p.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
                            e.setDataProtocolo((rs.getString("p.dataprotocolo")));
                            e.setDataSistema((rs.getString("p.datasistema")));
                            e.setSolicitante((rs.getString("p.solicitante")));
                            e.setServico((rs.getString("p.servico")));
                            e.setLaudo((rs.getString("p.laudo")));
                            e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
                            e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 3:
                       select = "select * from protocolo p"
                        + " where p.solicitante like ?  order by p.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Protocolo e = new Protocolo();  
                            e.setCod(Integer.parseInt(rs.getString("p.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
                            e.setDataProtocolo((rs.getString("p.dataprotocolo")));
                            e.setDataSistema((rs.getString("p.datasistema")));
                            e.setSolicitante((rs.getString("p.solicitante")));
                            e.setServico((rs.getString("p.servico")));
                            e.setLaudo((rs.getString("p.laudo")));
                            e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
                            e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 4:
                        select = "select * from protocolo p"
                        + " where p.dataProtocolo like ?  order by p.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Protocolo e = new Protocolo();  
                            e.setCod(Integer.parseInt(rs.getString("p.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("p.protocolo")));
                            e.setDataProtocolo((rs.getString("p.dataprotocolo")));
                            e.setDataSistema((rs.getString("p.datasistema")));
                            e.setSolicitante((rs.getString("p.solicitante")));
                            e.setServico((rs.getString("p.servico")));
                            e.setLaudo((rs.getString("p.laudo")));
                            e.setExercicio(Integer.parseInt(rs.getString("p.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("p.usuario")));
                            e.setFiscal(Integer.parseInt(rs.getString("p.fiscal")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
        }       
        return  listCertidao;
    }
     public String converteData(String data){
        
        String d = data.substring(8,10) +"/"+data.substring(5,7)+"/"+ data.substring(0,4);        
        return d;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
