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
import model.Rural;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class RuralBD {
    
     Conexao conexao;

    public RuralBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Rural cert)throws  SQLException{        
        String insert = "insert into certidao4(protocolo,dataprotocolo,solicitante,bairro,descimovel, medida, proprietario,insccadastral,"
                 + "exercicio,valorvenal,datasistema,fracao,usuario)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2,cert.getDataprotocolo());
            stmt.setString(3,cert.getSolicitante());
            stmt.setString(4,cert.getBairro());
            stmt.setString(5,cert.getDescimovel());
            stmt.setString(6,cert.getMedida());            
            stmt.setString(7,cert.getProprietario());
            stmt.setString(8,cert.getInsccadastral());
            stmt.setDouble(9,cert.getExercicio());
            stmt.setDouble(10,cert.getValorvenal());          
            stmt.setString(11,cert.getDatasistema());
            stmt.setString(12,cert.getFracao());
            stmt.setInt(13, cert.getUsuario());
           
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Rural> listaTabela(String procurar, int posCombo) throws SQLException{
        List<Rural> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from certidao4 c"
                        + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Rural e = new Rural();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataprotocolo((rs.getString("c.dataprotocolo")));
                            e.setSolicitante((rs.getString("c.solicitante")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setDescimovel((rs.getString("c.descimovel")));
                            e.setMedida((rs.getString("c.medida")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setInsccadastral((rs.getString("c.insccadastral")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorvenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDatasistema((rs.getString("c.datasistema")));
                            e.setFracao((rs.getString("c.fracao")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 2:
                        select = "select * from certidao4 c"
                        + " where c.exercicio like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Rural e = new Rural();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataprotocolo((rs.getString("c.dataprotocolo")));
                            e.setSolicitante((rs.getString("c.solicitante")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setDescimovel((rs.getString("c.descimovel")));
                            e.setMedida((rs.getString("c.medida")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setInsccadastral((rs.getString("c.insccadastral")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorvenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDatasistema((rs.getString("c.datasistema")));
                            e.setFracao((rs.getString("c.fracao")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 3:
                       select = "select * from certidao4 c"
                        + " where c.proprietario like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Rural e = new Rural();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataprotocolo((rs.getString("c.dataprotocolo")));
                            e.setSolicitante((rs.getString("c.solicitante")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setDescimovel((rs.getString("c.descimovel")));
                            e.setMedida((rs.getString("c.medida")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setInsccadastral((rs.getString("c.insccadastral")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorvenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDatasistema((rs.getString("c.datasistema")));
                            e.setFracao((rs.getString("c.fracao")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 4:
                        select = "select * from certidao4 c"
                        + " where c.insccadastral like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Rural e = new Rural();
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataprotocolo((rs.getString("c.dataprotocolo")));
                            e.setSolicitante((rs.getString("c.solicitante")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setDescimovel((rs.getString("c.descimovel")));
                            e.setMedida((rs.getString("c.medida")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setInsccadastral((rs.getString("c.insccadastral")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setValorvenal(Double.parseDouble(rs.getString("c.valorvenal")));
                            e.setDatasistema((rs.getString("c.datasistema")));
                            e.setFracao((rs.getString("c.fracao")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
        }       
        return  listCertidao;
    }
    
     public List<Rural> listaCertidao1(Integer exe) throws SQLException{
        List<Rural> lista = new ArrayList<>();
        
        String  select = "select * from certidao4 c where c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
          Rural e = new Rural();
          e.setCod(Integer.parseInt(rs.getString("c.cod")));
          e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
          e.setDataprotocolo((rs.getString("c.dataprotocolo")));
          e.setSolicitante((rs.getString("c.solicitante")));
          e.setBairro((rs.getString("c.bairro")));
          e.setDescimovel((rs.getString("c.descimovel")));
          e.setMedida((rs.getString("c.medida")));
          e.setProprietario((rs.getString("c.proprietario")));
          e.setInsccadastral((rs.getString("c.insccadastral")));
          e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
          e.setValorvenal(Double.parseDouble(rs.getString("c.valorvenal")));
          e.setDatasistema((rs.getString("c.datasistema")));
          e.setFracao((rs.getString("c.fracao")));
          e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
          lista.add(e);
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
}
